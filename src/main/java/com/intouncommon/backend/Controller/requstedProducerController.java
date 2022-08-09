package com.intouncommon.backend.Controller;

import com.intouncommon.backend.Entity.*;
import com.intouncommon.backend.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intouncommon")
@CrossOrigin
public class requstedProducerController {

//    String requestAdd(requestedProducers requestedProducer);
//    String confirmRequest(producers producer,Long id);
//    List<requestedProducers> getRequests();
//    String rejectRequest(Long id);

    @Autowired
    private requestProducerService requestProducerService;

    @PostMapping("/addRequest")
    private String addPending(@RequestBody requestedProducers requestedProducers){
        return requestProducerService.requestAdd(requestedProducers);
    }

    @PostMapping("/confirmRequest/{id}")
    private String getPending(@RequestBody producers producer,@PathVariable Long id){
        return requestProducerService.confirmRequest(producer,id);
    }

    @GetMapping("/getRequests")
    private List<requestedProducers> getRequests(){
        return requestProducerService.getRequests();
    }

    @GetMapping("/getRequestLastId")
    private Long getRequestId(){
        return requestProducerService.getLatestId();
    }


    @DeleteMapping("/rejectRequest/{id}")
    private String rejectRequest(@PathVariable Long id){
        return requestProducerService.rejectRequest(id);
    }
}
