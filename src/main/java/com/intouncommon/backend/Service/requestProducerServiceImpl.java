package com.intouncommon.backend.Service;


import com.intouncommon.backend.Entity.pendingProducers;
import com.intouncommon.backend.Entity.producers;
import com.intouncommon.backend.Entity.requestedProducers;
import com.intouncommon.backend.Repository.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intouncommon.backend.Repository.*;
import com.intouncommon.backend.Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class requestProducerServiceImpl implements requestProducerService{
    
    @Autowired
    private pendingProducerRepository pendingProducerRepository;
    
    @Autowired
    private requestProducerRepository requestProducerRepository;

    @Autowired
    private commonMethodService commonMethodService;

    @Autowired
    private producerRepository producerRepository;

    @Autowired
    private producerCategoriesRepository producerCategoriesRepository;

    @Autowired
    private pendingProductRepository pendingProductRepository;
    
    
    @Override
    public String requestAdd(requestedProducers requestedProducer) {
        List<pendingProducers> pendingProducers = pendingProducerRepository.findAll();
        for (com.intouncommon.backend.Entity.pendingProducers pendingProducers1 : pendingProducers){
            if (pendingProducers1.getContact().equals(requestedProducer.getContact())){
                if (pendingProducers1.getAdminStatus().equalsIgnoreCase("qualified")){
                    requestProducerRepository.save(requestedProducer);
                    List<pendingProducts> pendingProducts = pendingProducers1.getPendingProducts();
                    for (com.intouncommon.backend.Entity.pendingProducts pendingProducts1 : pendingProducts){
                        pendingProductRepository.deleteByProductId(pendingProducts1.getId());
                    }
                    pendingProducerRepository.deleteByProducersId(pendingProducers1.getId());
                    return "added";
                }
            }
        }
        return "not qualified";
    }

    @Override
    public String addSlip(slip slip) {
        Optional<requestedProducers> producer = requestProducerRepository.findByContact(slip.getContact());
        if (producer.isPresent()){
            producer.get().setSlipUrl(slip.getUrl());
            requestProducerRepository.save(producer.get());
            return "added";
        }

        return "error contact";

    }

    @Override
    public String confirmRequest(confirmReqBody confirmReqBody,Long id) {
        System.out.println(id);
        Optional<requestedProducers> requestedProducer = requestProducerRepository.findById(id);
        producers producer = new producers();
        List<producerCategories> producerCategories = new ArrayList<>();
        if (requestedProducer.isPresent()){
            producer.setName(requestedProducer.get().getName());
            producer.setBasicDetails(requestedProducer.get().getBasicDetails());
            producer.setContact(requestedProducer.get().getContact());
            producer.setNicNo(requestedProducer.get().getNicNo());
            producer.setWhatsApp(requestedProducer.get().getWhatsApp());
            producer.setEmail(requestedProducer.get().getEmail());
            Long producerId = commonMethodService.addProducer(producer).getProducerId();
            requestProducerRepository.deleteByProducersId(id);
            producers existingProducer = producerRepository.findById(producerId).orElseThrow(() ->
                    new ResourceNotFoundException("Location", "Id", producerId));
            for (Long catId : confirmReqBody.getCatIds()){
                producerCategories producerCategory = new producerCategories();
                producerCategory.setCatId(catId);
                producerCategory.setProducers(existingProducer);
                producerCategoriesRepository.save(producerCategory);

            }
            return "confirmed";
        }
        return "error id";
    }

    @Override
    public List<requestedProducers> getRequests() {
        return requestProducerRepository.findAll();
    }

    @Override
    public String rejectRequest(Long id) {
        Optional<requestedProducers> requestedProducer = requestProducerRepository.findById(id);
        if (requestedProducer.isPresent()){
            requestProducerRepository.deleteByProducersId(id);
            return "deleted";
        }
        return "error id";
    }

    @Override
    public Long getLatestId() {
        List<requestedProducers> requestedProducers = requestProducerRepository.findAll();
        Long latest = 0L;
        for (com.intouncommon.backend.Entity.requestedProducers requestedProducers1 : requestedProducers){
            if (requestedProducers1.getProducerId()>latest){
                latest=requestedProducers1.getProducerId();
            }
        }
        return latest+1;
    }
}
