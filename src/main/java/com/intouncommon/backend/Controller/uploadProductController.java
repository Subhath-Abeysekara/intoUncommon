package com.intouncommon.backend.Controller;

import com.intouncommon.backend.Entity.uploadProducts;
import com.intouncommon.backend.Service.uploadProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/intouncommon")
@CrossOrigin
public class uploadProductController {

//    Long getLatestImageId();
//    String uploadProduct(uploadProducts uploadProducts);
//    String cancelUploadProduct(Long id);

    @Autowired
    private uploadProductService uploadProductService;

    @GetMapping("/upload/getLatestId")
    public Long getLatest(){
        return uploadProductService.getLatestImageId();
    }

    @PostMapping("/upload/upload")
    public String uploadProduct(@RequestBody uploadProducts uploadProducts){
        return uploadProductService.uploadProduct(uploadProducts);
    }

    @DeleteMapping("/upload/cancel/{id}")
    public String cancelUpload(@PathVariable Long id){
        return uploadProductService.cancelUploadProduct(id);
    }
}
