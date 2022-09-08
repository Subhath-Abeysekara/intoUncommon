package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.producers;
import com.intouncommon.backend.Entity.requestedProducers;
import com.intouncommon.backend.Entity.slip;

import java.util.List;

public interface requestProducerService {

    String requestAdd(requestedProducers requestedProducer);

    String addSlip(slip slip);
    String confirmRequest(producers producer,Long id);
    List<requestedProducers> getRequests();
    String rejectRequest(Long id);
    Long getLatestId();
}
