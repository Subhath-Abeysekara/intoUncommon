package com.intouncommon.backend.Service;


import com.intouncommon.backend.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intouncommon.backend.Repository.*;

import java.util.Optional;

@Service
public class commonMethodServiceImpl implements commonMethodService{

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
    public categories addCategory(categories category) {
        return categoryRepository.save(category);
    }

    @Override
    public String updateCategory(Long id, categories category) {
        Optional<categories> sample = categoryRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        categoryRepository.save(category);
        return "Successfully Updated";
    }

    @Override
    public String deleteCategory(Long id) {
        Optional<categories> sample = categoryRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        categoryRepository.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public producers addProducer(producers producer) {
        return producerRepository.save(producer);
    }

    @Override
    public String updateProducer(Long id, producers producer) {
        Optional<producers> sample = producerRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        producerRepository.save(producer);
        return "Successfully Updated";
    }

    @Override
    public String deleteProducer(Long id) {
        Optional<producers> sample = producerRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        producerRepository.deleteById(id);
        return "Successfully Updated";
    }

    @Override
    public productions addProduction(productions production) {
        return productionRepository.save(production);
    }

    @Override
    public String updateProduction(Long id, productions production) {
        Optional<productions> sample = productionRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        productionRepository.save(production);
        return "Successfully Updated";
    }

    @Override
    public String deleteProduction(Long id) {
        Optional<productions> sample = productionRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        productionRepository.deleteById(id);
        return "Successfully Updated";
    }

    @Override
    public statecodes addStateCode(statecodes statecode) {
        return statecodesRepository.save(statecode);
    }

    @Override
    public String updateStateCode(Long id, statecodes statecode) {
        Optional<statecodes> sample = statecodesRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        statecodesRepository.save(statecode);
        return "Successfully Updated";
    }

    @Override
    public String deleteStateCode(Long id) {
        Optional<statecodes> sample = statecodesRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        statecodesRepository.deleteById(id);
        return "Successfully Updated";
    }

    @Override
    public uncommonProduct addUncommonProduction(uncommonProduct uncommonProduct) {
        return uncommonRepository.save(uncommonProduct);
    }

    @Override
    public String updateUncommonProduction(Long id, uncommonProduct uncommonProduct) {
        Optional<uncommonProduct> sample = uncommonRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        uncommonRepository.save(uncommonProduct);
        return "Successfully Updated";
    }

    @Override
    public String deleteUncommonProduction(Long id) {
        Optional<uncommonProduct> sample = uncommonRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        uncommonRepository.deleteById(id);
        return "Successfully Updated";
    }

    @Override
    public users addUser(users user) {
        return userRepository.save(user);
    }

    @Override
    public String updateUser(Long id, users user) {
        Optional<users> sample = userRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        userRepository.save(user);
        return "Successfully Updated";
    }

    @Override
    public String deleteUser(Long id) {
        Optional<users> sample = userRepository.findById(id);
        if (!sample.isPresent()){
            return "ERROR:Invalid Id";
        }
        userRepository.deleteById(id);
        return "Successfully Updated";
    }
}
