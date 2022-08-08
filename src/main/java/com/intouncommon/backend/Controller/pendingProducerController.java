package com.intouncommon.backend.Controller;

import com.intouncommon.backend.Service.pendingProducerService;
import com.intouncommon.backend.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/intouncommon")
@CrossOrigin
public class pendingProducerController {

//    String addPendingProducer(pendingProducers pendingProducer);
//    String addUrl(pendingProducts pendingProduct);
//    pendingProducers getByContact(String contact);
//    String deleteUrl(Long id);
//    String deleteProducer(Long id);

    @Autowired
    private pendingProducerService pendingProducerService;

    @PostMapping("/addPending")
    private String addPending(@RequestBody pendingProducers pendingProducers){
        return pendingProducerService.addPendingProducer(pendingProducers);
    }

    @GetMapping("/getPendingProducer/{contact}")
    private pendingProducers getPending(@PathVariable String contact){
        return pendingProducerService.getByContact(contact);
    }

    @GetMapping("/getLastId")
    private Long getLatest(){
        return pendingProducerService.getLatestId();
    }

    @DeleteMapping("/deletePendingProduct/{id}")
    private String deletePending1(@PathVariable Long id){
        return pendingProducerService.deleteUrl(id);
    }

    @DeleteMapping("/deletePendingProducer/{id}")
    private String deletePending2(@PathVariable Long id){
        return pendingProducerService.deleteProducer(id);
    }

    @PutMapping("/confirmPending/{contact}")
    private String confirmPending(@PathVariable String contact){
        return pendingProducerService.confirmPendingProducer(contact);
    }

}
