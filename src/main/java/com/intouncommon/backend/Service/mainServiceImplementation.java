package com.intouncommon.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intouncommon.backend.Repository.*;
import com.intouncommon.backend.Entity.*;

import java.util.List;
import java.util.Optional;

@Service
public class mainServiceImplementation implements mainService{

    @Autowired
    private categoryRepository categoryRepository;

    @Autowired
    private producerRepository producerRepository;

    @Autowired
    private productionRepository productionRepository;

    @Autowired
    private statecodesRepository statecodesRepository;

    @Autowired
    private uncommonRepository uncommonRepository;

    @Autowired
    private userRepository userRepository;

    @Override
    public List<Long> getAllCategoryIds(boolean common) {
        return categoryRepository.getIds(common);
    }

    @Override
    public String getCategoryType(Long id) {
        return categoryRepository.getType(id);
    }

    @Override
    public List<Long> getProductIds(Long id) {
        return productionRepository.getIdsByCategory(id);
    }

    @Override
    public Long getStateCodeId(Long id) {
        return uncommonRepository.getStateCode(id);
    }

    @Override
    public Optional<productions> getProductById(Long id) {
        return productionRepository.findById(id);
    }

    @Override
    public String getUserContact(Long id) {
        return userRepository.getContact(id);
    }

    @Override
    public void updateCategoryInProduction(Long cat, Long old) {
       productionRepository.setCategory(cat,old);
    }

    @Override
    public void updateProducerInProduction(Long pro, Long old) {
        productionRepository.setProducer(pro,old);
    }

    @Override
    public void updateStateCodeInUncommon(Long state, Long old) {
        uncommonRepository.setStateCode(state,old);
    }
}
