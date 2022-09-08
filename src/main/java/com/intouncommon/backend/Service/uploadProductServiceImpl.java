package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.pendingProducts;
import com.intouncommon.backend.Entity.producers;
import com.intouncommon.backend.Entity.uploadProducts;
import com.intouncommon.backend.Repository.producerRepository;
import com.intouncommon.backend.Repository.productionRepository;
import com.intouncommon.backend.Repository.uploadProductImageRepository;
import com.intouncommon.backend.Repository.uploadProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class uploadProductServiceImpl implements uploadProductService{

    @Autowired
    private productionRepository productionRepository;

    @Autowired
    private uploadProductRepository uploadProductRepository;

    @Autowired
    private uploadProductImageRepository uploadProductImageRepository;

    @Autowired
    private producerRepository producerRepository;

    @Override
    public Long getLatestImageId() {
        List<uploadProducts> uploadProducts = uploadProductRepository.findAll();
        Long latest = 0L;
        for(uploadProducts uploadProducts1 : uploadProducts){
            if (uploadProducts1.getId()>latest){
                latest=uploadProducts1.getId();
            }
        }
        return latest+1;
    }

    @Override
    public String uploadProduct(uploadProducts uploadProducts) {
        Optional<producers> producers = producerRepository.findByContact(uploadProducts.getContact());
        if(producers.isPresent()){
            uploadProductRepository.save(uploadProducts);
            return "added";
        }
        else {
            return "error contact";
        }

    }



    @Override
    public String cancelUploadProduct(Long id) {
        Optional<uploadProducts> uploadProducts = uploadProductRepository.findById(id);
        if(uploadProducts.isPresent()){
            uploadProductRepository.delete(uploadProducts.get());
            return "deleted";
        }
        return "error id";
    }
}
