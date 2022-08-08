package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.*;

public interface pendingProducerService {

    String addPendingProducer(pendingProducers pendingProducer);
    String addUrl(pendingProducts pendingProduct);
    pendingProducers getByContact(String contact);
    String deleteUrl(Long id);
    String deleteProducer(Long id);
    Long getLatestId();
    String confirmPendingProducer(String contact);
}
