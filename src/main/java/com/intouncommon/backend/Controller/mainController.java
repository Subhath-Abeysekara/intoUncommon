package com.intouncommon.backend.Controller;


import com.intouncommon.backend.Entity.*;
import com.intouncommon.backend.Service.mainService;
import com.intouncommon.backend.Service.specialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intouncommon")
@CrossOrigin
public class mainController {

    @Autowired
    private mainService mainService;

    @Autowired
    private specialService specialService;


    @PostMapping("/checkCommon")
    private String checkCom(@RequestBody commonCheckDto commonCheckDto){
        return mainService.checkCommon(commonCheckDto);
    }

    @PostMapping("/checkUncommon")
    private String checkUncom(@RequestBody uncommonCheckDto commonCheckDto){
        return mainService.checkUncommon(commonCheckDto);
    }

    @GetMapping("/get/category/ids")
    private List<Long> getCategoriesIds(@RequestParam boolean common){
        return mainService.getAllCategoryIds(common);
    }

    @GetMapping("/get/category/type")
    private String getCategoryType(@RequestParam Long id){
        return mainService.getCategoryType(id);
    }

    @GetMapping("/get/product/ids")
    private List<Long> getProductIds(@RequestParam Long id){
        return mainService.getProductIds(id);
    }

    @GetMapping("/get/product")
    private Optional<productions> getProduct(@RequestParam Long id){
        return mainService.getProductById(id);
    }

    @GetMapping("/get/state")
    private Long getState(@RequestParam Long id){
        return mainService.getStateCodeId(id);
    }

    @GetMapping("/get/contact")
    private String getContact(@RequestParam Long id){
        return mainService.getUserContact(id);
    }

    @PutMapping("/insert/category")
    private String addCategory(@RequestParam Long id){
        mainService.updateCategoryInProduction(id,null);
        return "Successfully Added";
    }

    @PutMapping("/insert/producer")
    private String addProducer(@RequestParam Long id){
        mainService.updateProducerInProduction(id,null);
        return "Successfully Added";
    }

    @PutMapping("/insert/state")
    private String addState(@RequestParam Long id){
        mainService.updateStateCodeInUncommon(id,null);
        return "Successfully Added";
    }

    @PutMapping("/addAmount")
    private String addAmount(@RequestParam int amount,@RequestParam Long id){
        mainService.updateImageAmount(amount, id);
        return "Successfully Added";
    }

    @GetMapping("/getAmount")
    private int getAmount(@RequestParam Long id){
        return mainService.getImageAmount(id);
    }

    @GetMapping("/getSpecial")
    private List<productions> getSpecial(){
        return specialService.getSpecial();
    }

    @GetMapping("/fillSpecial")
    private List<productions> fillSpecial(){
        return specialService.fillSpecial();
    }

    @GetMapping("/getAll/products")
    private List<productions> getAll(){
        return specialService.getAll();
    }

    @GetMapping("/getAll/productBycat/{id}")
    private List<productions> getAllByCat(@PathVariable Long id){
        return specialService.getAllByCat(id);
    }

    @GetMapping("/getAll/pagination/{limit}/{offset}")
    private Page<productions> getAllPagination(@PathVariable int limit , @PathVariable int offset){
        return specialService.getPagination(limit , offset);
    }

    @GetMapping("/getAll/paginationCat/{id}/{limit}/{offset}")
    private List<productions> getAllPaginationCat(@PathVariable Long id,@PathVariable int limit , @PathVariable int offset){
        return specialService.getPaginationByCat(id,limit , offset);
    }
}
