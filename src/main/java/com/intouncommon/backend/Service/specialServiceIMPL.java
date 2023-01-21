package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.*;
import com.intouncommon.backend.Repository.producerRepository;
import com.intouncommon.backend.Repository.productionRepository;
import com.intouncommon.backend.Repository.uncommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class specialServiceIMPL implements specialService{

    @Autowired
    private productionRepository productionRepository;

    @Autowired
    private com.intouncommon.backend.Repository.categoryRepository categoryRepository;

    @Autowired
    private com.intouncommon.backend.Repository.producerRepository producerRepository;


    @Autowired
    private com.intouncommon.backend.Repository.statecodesRepository statecodesRepository;

    @Autowired
    private com.intouncommon.backend.Repository.uncommonRepository uncommonRepository;

    @Override
    public List<productions> getSpecial() {
        List<productions> productions = productionRepository.findAll();
        List<productions> productionsList = new ArrayList<>();
        for (com.intouncommon.backend.Entity.productions productions1 : productions){
            if (productions1.getCat_type()==null || productions1.getProducer_name()==null){
                productionsList.add(productions1);
            }
        }
        return productionsList;
    }

    @Override
    public List<productions> fillSpecial() {
        List<productResDto> productResDtos = new ArrayList<>();
        List<categories> categories = categoryRepository.findAll();
        List<producers> producers = producerRepository.findAll();
        // System.out.println(producers);
        List<productions> productions = productionRepository.findAll();
        List<statecodes> statecodes = statecodesRepository.findAll();
        List<productions> productionsListReturn = new ArrayList<>();
        // System.out.println(productions);
        for (com.intouncommon.backend.Entity.productions productions1 : productions){

            if (productions1.getCat()!=null){
                continue;
            }
           // Optional<uncommonProduct> uncommonProduct = uncommonRepository.findById(productions1.getId());
//            if (uncommonProduct.isPresent()){
////                Optional<statecodes> statecodes = statecodesRepository.findById(1L);
////                if (statecodes.isPresent()){
////                    System.out.println(statecodes.get());
////                    stateCodeDto stateCodeDto = new stateCodeDto();
////                    stateCodeDto.setStateId(statecodes.get().getStateId());
////                    stateCodeDto.setChangeColor(statecodes.get().getChangeColor());
////                    productResDto.setStatecodes(stateCodeDto);
////                }
//
//
//                //System.out.println("states"+statecodes);
//                for (com.intouncommon.backend.Entity.statecodes statecodes1: statecodes){
//                    boolean logicState = false;
//                    List<uncommonProduct> productionsList = statecodes1.getUncommonProducts();
//                    //
//                    for (com.intouncommon.backend.Entity.uncommonProduct productions2 : productionsList){
//                        if (uncommonProduct.get().getId().equals(productions2.getId())){
//                            // System.out.println(statecodes1);
//                            productions1.setRepayColor(statecodes1.getRepayColor());
//                            productions1.setChangeColor(statecodes1.getChangeColor());
//                            productions1.setDiscountColor(statecodes1.getDiscountColor());
//                            productions1.setWarrantyColor(statecodes1.getWarrantyColor());
//                            logicState=true;
//                            break;
//                        }
//                    }
//                    if (logicState){
//                        break;
//                    }
//                }
//            }

            for (com.intouncommon.backend.Entity.categories categories1: categories){
                boolean logicCat = false;
                List<productions> productionsList = categories1.getProductsions();
                for (com.intouncommon.backend.Entity.productions productions2 : productionsList){
                    if (productions1.equals(productions2)){
                        productions1.setCat(categories1.getCategoryId());
//                        productions1.setCat_material(categories1.getMaterial());
                        logicCat=true;
                        break;
                    }
                }
                if (logicCat){
                    break;
                }
            }

//            for (com.intouncommon.backend.Entity.producers producers1: producers){
//                boolean logicPro = false;
//                List<productions> productionsList = producers1.getProductions();
//                for (com.intouncommon.backend.Entity.productions productions2 : productionsList){
//                    if (productions1.equals(productions2)){
//                        productions1.setProducer_name(producers1.getName());
//                        productions1.setProducer_basicDetails(producers1.getBasicDetails());
//                        logicPro=true;
//                        break;
//                    }
//                }
//                if (logicPro){
//                    break;
//                }
//            }

            productionsListReturn.add(productions1);
            productionRepository.save(productions1);
        }

        return productionsListReturn;
    }

    @Override
    public List<productions> getAll() {
        return productionRepository.findAll();
    }

    @Override
    public List<productions> getAllByCat(Long id) {
        Optional<categories> categories = categoryRepository.findById(id);
        return categories.map(com.intouncommon.backend.Entity.categories::getProductsions).orElse(null);
    }

    @Override
    public List<productions> getPaginationByCat(Long id, int limit, int offset) {
        Pageable firstPageWithTwoElements = PageRequest.of(offset, limit);
        return productionRepository.findByCat(id , firstPageWithTwoElements);
    }

    @Override
    public Page<productions> getPagination(int limit, int offset) {
        Pageable firstPageWithTwoElements = PageRequest.of(offset, limit);
        return productionRepository.findAll(firstPageWithTwoElements);
    }
}
