package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.producers;
import com.intouncommon.backend.Entity.requestedProducers;

import java.util.List;

public interface requestProducerService {

    String requestAdd(requestedProducers requestedProducer);
    String confirmRequest(producers producer,Long id);
    List<requestedProducers> getRequests();
    String rejectRequest(Long id);
}
