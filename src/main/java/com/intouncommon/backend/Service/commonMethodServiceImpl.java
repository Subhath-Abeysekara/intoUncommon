package com.intouncommon.backend.Service;


import com.intouncommon.backend.Entity.*;
import com.intouncommon.backend.Repository.exception.ResourceNotFoundException;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import com.intouncommon.backend.Repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class commonMethodServiceImpl implements commonMethodService{

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

    @Autowired
    private productionImageRepository productionImageRepository;
    @Autowired
    private producerCategoriesRepository producerCategoriesRepository;



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

        List<productions> productions = sample.get().getProductsions();
        for (com.intouncommon.backend.Entity.productions productions1 : productions){
            List<productImages> productImages = productions1.getProductImages();
            for (com.intouncommon.backend.Entity.productImages productImages1 : productImages){
                productionImageRepository.deleteByImageId(productImages1.getId());
            }
            productionRepository.deleteByProductId(productions1.getId());
        }
        categoryRepository.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public List<categories> getAllCategories() {
        return categoryRepository.findAll();
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
        List<productions> productions = sample.get().getProductions();
        for (com.intouncommon.backend.Entity.productions productions1 : productions){
            List<productImages> productImages = productions1.getProductImages();
            for (com.intouncommon.backend.Entity.productImages productImages1 : productImages){
                productionImageRepository.deleteByImageId(productImages1.getId());
            }
            productionRepository.deleteByProductId(productions1.getId());
        }
     List<producerCategories> producerCategories = sample.get().getProducerCategories();
        for (com.intouncommon.backend.Entity.producerCategories producerCategories1 : producerCategories){
            producerCategoriesRepository.deleteByProducersCatId(producerCategories1.getId());
        }
        producerRepository.deleteByProducersId(id);
        return "Successfully Updated";
    }

    @Override
    public List<producers> getAllProducers() {
        return producerRepository.findAll();
    }

    private Long addProductPrimary(productionDto production) {

        productions productions = production.getProductions();

        categories existingcategory = categoryRepository.findById(production.getCategoryId()).orElseThrow(() ->
                new ResourceNotFoundException("Location", "Id", productions.getId()));
        productions.setCategory(existingcategory);

        producers existingProducer = producerRepository.findById(production.getProducerId()).orElseThrow(() ->
                new ResourceNotFoundException("Location", "Id", productions.getId()));
        productions.setProducer(existingProducer);
        return productionRepository.save(productions).getId();
    }
    @Override
    public Long addProduction(productionDto production) {
        return addProductPrimary(production);
    }

    @Override
    public String confirmProduction(productUncomAddObject productUncomAddObject) {

        Long id = addProductPrimary(productUncomAddObject.getProductionDto());
        addImageUrlPrimay(productUncomAddObject.getUrl1() , id);
        addImageUrlPrimay(productUncomAddObject.getUrl2() , id);

        return "success";
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
        List<productImages> productImages = sample.get().getProductImages();
        for (com.intouncommon.backend.Entity.productImages productImages1 : productImages){
            productionImageRepository.deleteByImageId(productImages1.getId());
        }
        productionRepository.deleteByProductId(sample.get().getId());
        return "Successfully Updated";
    }

    @Override
    public productResponse getAllProductions(Long id) {
        productResponse productResponse = new productResponse();
        productResponse.setProductions(productionRepository.findAll());
        productResponse.setContact(userRepository.getContact(id));
        return productResponse;
    }

    public productResDto setProduct(productions productions){
        productResDto productResDto = new productResDto();
        productResDto.setAmount(productions.getAmount());
        productResDto.setBrand(productions.getBrand());
        productResDto.setColor(productions.getColor());
        productResDto.setDelivery(productions.getDelivery());
        productResDto.setId(productions.getId());
        productResDto.setMaterial(productions.getMaterial());
        productResDto.setOptions(productions.getOptions());
        productResDto.setPrice(productions.getPrice());
        productResDto.setSize(productions.getSize());
        productResDto.setSpecialData(productions.getSpecialData());
        productResDto.setUses(productions.getUses());
        productResDto.setWarranty(productions.getWarranty());
        productResDto.setProductImages(productions.getProductImages());
        productResDto.setAddDate(productions.getAddDate());
        productResDto.setDesignBy(null);
        productResDto.setInventBy(null);
        productResDto.setMadeIn(null);
        productResDto.setQualityOf(null);
        productResDto.setSpecialUsage(null);
        return productResDto;
    }

    private productResDto setUncommon(uncommonProduct productions){
        productResDto productResDto = new productResDto();
        productResDto.setAmount(productions.getAmount());
        productResDto.setBrand(productions.getBrand());
        productResDto.setColor(productions.getColor());
        productResDto.setDelivery(productions.getDelivery());
        productResDto.setId(productions.getId());
        productResDto.setMaterial(productions.getMaterial());
        productResDto.setOptions(productions.getOptions());
        productResDto.setPrice(productions.getPrice());
        productResDto.setSize(productions.getSize());
        productResDto.setSpecialData(productions.getSpecialData());
        productResDto.setUses(productions.getUses());
        productResDto.setWarranty(productions.getWarranty());
        productResDto.setDesignBy(productions.getDesignBy());
        productResDto.setInventBy(productions.getInventBy());
        productResDto.setMadeIn(productions.getMadeIn());
        productResDto.setQualityOf(productions.getQualityOf());
        productResDto.setSpecialUsage(productions.getSpecialUsage());
        productResDto.setProductImages(productions.getProductImages());
        productResDto.setAddDate(productions.getAddDate());
        return productResDto;
    }
    @Override
    public List<productResDto> getProductions() {
        List<productResDto> productResDtos = new ArrayList<>();
        List<categories> categories = categoryRepository.findAll();
        List<producers> producers = producerRepository.findAll();
       // System.out.println(producers);
        List<productions> productions = productionRepository.findAll();
       // System.out.println(productions);
        for (com.intouncommon.backend.Entity.productions productions1 : productions){
            productResDto productResDto   = new productResDto();
            Optional<uncommonProduct> uncommonProduct = uncommonRepository.findById(productions1.getId());
            if (uncommonProduct.isPresent()){
                productResDto = setUncommon(uncommonProduct.get());
//                Optional<statecodes> statecodes = statecodesRepository.findById(1L);
//                if (statecodes.isPresent()){
//                    System.out.println(statecodes.get());
//                    stateCodeDto stateCodeDto = new stateCodeDto();
//                    stateCodeDto.setStateId(statecodes.get().getStateId());
//                    stateCodeDto.setChangeColor(statecodes.get().getChangeColor());
//                    productResDto.setStatecodes(stateCodeDto);
//                }

                List<statecodes> statecodes = statecodesRepository.findAll();
                //System.out.println("states"+statecodes);
                for (com.intouncommon.backend.Entity.statecodes statecodes1: statecodes){
                    boolean logicState = false;
                    List<uncommonProduct> productionsList = statecodes1.getUncommonProducts();
                    //
                    for (com.intouncommon.backend.Entity.uncommonProduct productions2 : productionsList){
                        if (uncommonProduct.get().getId().equals(productions2.getId())){
                           // System.out.println(statecodes1);
                    stateCodeDto stateCodeDto = new stateCodeDto();
                    stateCodeDto.setStateId(statecodes1.getStateId());
                    stateCodeDto.setChangeColor(statecodes1.getChangeColor());
                            stateCodeDto.setRepayColor(statecodes1.getRepayColor());
                            stateCodeDto.setDiscountColor(statecodes1.getDiscountColor());
                            stateCodeDto.setWarrantyColor(statecodes1.getWarrantyColor());
                    productResDto.setStatecodes(stateCodeDto);
                            productResDto.setStatecodes(stateCodeDto);
                            logicState=true;
                            break;
                        }
                    }
                    if (logicState){
                        break;
                    }
                }
            }
            else {
                productResDto = setProduct(productions1);
            }

            for (com.intouncommon.backend.Entity.categories categories1: categories){
                boolean logicCat = false;
                List<productions> productionsList = categories1.getProductsions();
                for (com.intouncommon.backend.Entity.productions productions2 : productionsList){
                    if (productions1.equals(productions2)){
                        categoryDto categoryDto = new categoryDto();
                        categoryDto.setCategoryId(categories1.getCategoryId());
                        categoryDto.setCommon(categories1.isCommon());
                        categoryDto.setMaterial(categories1.getMaterial());
                        categoryDto.setType(categories1.getType());
                        productResDto.setCategory(categoryDto);
                        logicCat=true;
                        break;
                    }
                }
                if (logicCat){
                    break;
                }
            }

            for (com.intouncommon.backend.Entity.producers producers1: producers){
                boolean logicPro = false;
                List<productions> productionsList = producers1.getProductions();
                for (com.intouncommon.backend.Entity.productions productions2 : productionsList){
                    if (productions1.equals(productions2)){
                        producerDto producerDto = new producerDto();
                        producerDto.setProducerId(producers1.getProducerId());
                        producerDto.setBasicDetails(producers1.getBasicDetails());
                        producerDto.setName(producers1.getName());
                        producerDto.setNicNo(producers1.getNicNo());
                        productResDto.setProducer(producerDto);
                        logicPro=true;
                        break;
                    }
                }
                if (logicPro){
                    break;
                }
            }

            productResDtos.add(productResDto);
        }

        return productResDtos;
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
        statecodesRepository.deleteByStateId(id);
        return "Successfully Updated";
    }

    @Override
    public List<statecodes> getAllStates() {
        return statecodesRepository.findAll();
    }

    @Override
    public Long addUncommonProduction(uncommonProductDto uncommonProduct) {
        com.intouncommon.backend.Entity.uncommonProduct uncommonProduct1 = uncommonProduct.getUncommonProduct();

        categories existingcategory = categoryRepository.findById(uncommonProduct.getCategoryId()).orElseThrow(() ->
                new ResourceNotFoundException("Location", "Id", uncommonProduct1.getId()));
        uncommonProduct1.setCategory(existingcategory);

        producers existingProducer = producerRepository.findById(uncommonProduct.getProducerId()).orElseThrow(() ->
                new ResourceNotFoundException("Location", "Id", uncommonProduct1.getId()));
        uncommonProduct1.setProducer(existingProducer);

        statecodes existingState = statecodesRepository.findById(uncommonProduct.getStateId()).orElseThrow(() ->
                new ResourceNotFoundException("Location", "Id", uncommonProduct1.getId()));
        uncommonProduct1.setStatecodes(existingState);
        return uncommonRepository.save(uncommonProduct1).getId();
    }

    @Override
    public String updateUncommonProduction(Long id, uncommonProduct uncommonProduct) {
        Optional<com.intouncommon.backend.Entity.uncommonProduct> sample = uncommonRepository.findById(id);
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

    @Override
    public List<users> getAllUsers() {
        return userRepository.findAll();
    }

    private productImages addImageUrlPrimay(String url , Long id) {
        productImages productImages = new productImages();
        productImages.setUrl(url);

        productions existingProduction = productionRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Location", "Id", id));
        productImages.setProductions(existingProduction);
        return productionImageRepository.save(productImages);
    }
    @Override
    public productImages addImageUrl(productImageDTO productImageDTO) {
        return addImageUrlPrimay(productImageDTO.getProductImages().getUrl() , productImageDTO.getProductId());
    }
}
