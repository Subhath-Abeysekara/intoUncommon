package com.intouncommon.backend.Service;


import com.intouncommon.backend.Entity.pendingProducers;
import com.intouncommon.backend.Entity.producers;
import com.intouncommon.backend.Entity.requestedProducers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intouncommon.backend.Repository.*;
import com.intouncommon.backend.Entity.*;

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
    
    
    @Override
    public String requestAdd(requestedProducers requestedProducer) {
        List<pendingProducers> pendingProducers = pendingProducerRepository.findAll();
        for (com.intouncommon.backend.Entity.pendingProducers pendingProducers1 : pendingProducers){
            if (pendingProducers1.getContact().equals(requestedProducer.getContact())){
                if (pendingProducers1.getAdminStatus().equalsIgnoreCase("qualified")){
                    requestProducerRepository.save(requestedProducer);
                    return "added";
                }
            }
        }
        return "not qualified";
    }

    @Override
    public String confirmRequest(producers producer,Long id) {
        Optional<requestedProducers> requestedProducer = requestProducerRepository.findById(id);
        if (requestedProducer.isPresent()){
            producer.setName(requestedProducer.get().getName());
            producer.setBasicDetails(requestedProducer.get().getBasicDetails());
            producer.setContact(requestedProducer.get().getContact());
            producer.setNicNo(requestedProducer.get().getNicNo());
            producer.setWhatsApp(requestedProducer.get().getWhatsApp());
            commonMethodService.addProducer(producer);
            requestProducerRepository.deleteByProducersId(id);
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
}
