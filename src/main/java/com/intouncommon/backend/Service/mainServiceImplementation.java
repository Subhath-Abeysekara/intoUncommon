package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.commonCheckDto;
import com.intouncommon.backend.Entity.productions;
import com.intouncommon.backend.Entity.uncommonCheckDto;
import com.intouncommon.backend.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class mainServiceImplementation implements mainService {

    @Autowired
    private com.intouncommon.backend.Repository.categoryRepository categoryRepository;

    @Autowired
    private com.intouncommon.backend.Repository.producerRepository producerRepository;

    @Autowired
    private com.intouncommon.backend.Repository.productionRepository productionRepository;

    @Autowired
    private com.intouncommon.backend.Repository.statecodesRepository statecodesRepository;

    @Autowired
    private com.intouncommon.backend.Repository.uncommonRepository uncommonRepository;

    @Autowired
    private com.intouncommon.backend.Repository.userRepository userRepository;

    @Override
    public String checkCommon(commonCheckDto commonCheckDto) {
        if (commonCheckDto.getCategoryId()!=0||commonCheckDto.getProducerId()!=0){
            Optional<categories> category = categoryRepository.findById(commonCheckDto.getCategoryId());
            if (category.isPresent()){
                if (category.get().isCommon()){
                    Optional<producers> producer = producerRepository.findById(commonCheckDto.getProducerId());
                    if (producer.isPresent()){
                        return "success";
                    }
                }
            }
        }

        return "error";
     }

    @Override
    public String checkUncommon(uncommonCheckDto uncommonCheckDto) {
        if (uncommonCheckDto.getCategoryId()!=0||uncommonCheckDto.getProducerId()!=0||uncommonCheckDto.getStateId()!=0){
            
            Optional<categories> category = categoryRepository.findById(uncommonCheckDto.getCategoryId());
            if (category.isPresent()){
                if (!category.get().isCommon()){
                    Optional<producers> producer = producerRepository.findById(uncommonCheckDto.getProducerId());
                    if (producer.isPresent()){
                        Optional<statecodes> statecode = statecodesRepository.findById(uncommonCheckDto.getStateId());
                        if (statecode.isPresent()){
                            return "success";
                        }
                    }
                }
            }
        }

        return "error";
    }

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

    @Override
    public int getImageAmount(Long id) {
        return productionRepository.getAmount(id);
    }

    @Override
    public void updateImageAmount(int amount, Long id) {
        productionRepository.setImageAmount(amount, id);
    }
}
