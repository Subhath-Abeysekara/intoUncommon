package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.uploadProducts;

public interface uploadProductService {

    Long getLatestImageId();
    String uploadProduct(uploadProducts uploadProducts);
    String cancelUploadProduct(Long id);
}
