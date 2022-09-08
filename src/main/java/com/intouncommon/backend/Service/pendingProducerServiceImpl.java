package com.intouncommon.backend.Service;


import com.intouncommon.backend.Entity.pendingProducers;
import com.intouncommon.backend.Entity.pendingProducts;
import com.intouncommon.backend.Entity.producers;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intouncommon.backend.Repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class pendingProducerServiceImpl implements pendingProducerService{

    @Autowired
    private pendingProducerRepository pendingProducerRepository;

    @Autowired
    private pendingProductRepository pendingProductRepository;

    @Autowired
    private producerRepository producerRepository;

    @Override
    public String addPendingProducer(pendingProducers pendingProducer) {
        if (pendingProducer.getContact().length()==10){
            char[] contact = pendingProducer.getContact().toCharArray();
            char[] numbers = {'1','2','3','4','5','6','7','8','9','0'};
            if(contact[0]=='0'){
                for (int i=1; i<contact.length; i++){
                    boolean logicNum = false;
                    for (int j=0; j<numbers.length; j++){
                        if (contact[i]==numbers[j]){
                            logicNum =true;
                            break;
                        }
                    }
                    if (!logicNum){
                        return "error contact";
                    }
                }
                Optional<pendingProducers> pendingProducers1 = pendingProducerRepository.findByContact(pendingProducer.getContact());
                Optional<producers> producer = producerRepository.findByContact(pendingProducer.getContact());
                if (!pendingProducers1.isPresent()&&!producer.isPresent()){
                    if (pendingProducer.getName()==""||pendingProducer.getAddress()==""){
                        return "empty fields";
                    }
                    pendingProducerRepository.save(pendingProducer);
                }
                else {
                    List<pendingProducts> pendingProducts = pendingProducer.getPendingProducts();
                    //System.out.println(pendingProducers1);
                    List<pendingProducts> pendingProductsExists = pendingProducers1.get().getPendingProducts();
//                    pendingProductsExists.addAll(pendingProducts);
//                    pendingProducers1.get().setPendingProducts(pendingProductsExists);
//                    pendingProducerRepository.save(pendingProducers1.get());
                    for (com.intouncommon.backend.Entity.pendingProducts pendingProducts1 : pendingProducts){
                        boolean logicExisting = false;
                        for (com.intouncommon.backend.Entity.pendingProducts pendingProducts2 : pendingProductsExists){
                            if (pendingProducts1.getUrl().equals(pendingProducts2.getUrl())){
                                logicExisting=true;
                                break;
                            }
                        }
                        if (!logicExisting){

                            pendingProducts1.setPendingProducers(pendingProducers1.get());
                            pendingProductRepository.save(pendingProducts1);
                        }

                    }
                }
                return "added";
            }
            return "error contact";
        }
        return "error contact";
    }

    @Override
    public String addUrl(pendingProducts pendingProduct) {
        return null;
    }

    @Override
    public pendingProducers getByContact(String contact) {
        Optional<pendingProducers> pendingProducer = pendingProducerRepository.findByContact(contact);
        if (pendingProducer.isPresent()){
            return pendingProducer.get();
        }

        return null;
    }

    @Override
    public String deleteUrl(Long id) {
        Optional<pendingProducts> pendingProduct = pendingProductRepository.findById(id);
        if (pendingProduct.isPresent()){
            pendingProductRepository.deleteByProductId(id);
            return "deleted";
        }
        return "error id";
    }

    @Override
    public String deleteProducer(Long id) {
        Optional<pendingProducers> pendingProducer = pendingProducerRepository.findById(id);
        if (pendingProducer.isPresent()){
            List<pendingProducts> pendingProducts = pendingProducer.get().getPendingProducts();
            for (com.intouncommon.backend.Entity.pendingProducts pendingProducts1 : pendingProducts){
                pendingProductRepository.deleteByProductId(pendingProducts1.getId());
            }
            pendingProducerRepository.deleteByProducersId(id);
            return "deleted";
        }
        return "error id";
    }

    @Override
    public Long getLatestId() {
        List<pendingProducts> pendingProducts = pendingProductRepository.findAll();
        Long latest = 0L;
        for(com.intouncommon.backend.Entity.pendingProducts pendingProducts1 : pendingProducts){
            if (pendingProducts1.getId()>latest){
                latest=pendingProducts1.getId();
            }
        }
        return latest+1;
    }

    @Override
    public String confirmPendingProducer(String contact) {
        Optional<pendingProducers> pendingProducer = pendingProducerRepository.findByContact(contact);
        if (pendingProducer.isPresent()){
            pendingProducer.get().setAdminStatus("qualified");
            pendingProducerRepository.save(pendingProducer.get());
            return "saved";
        }
        return "error id";
    }
}
