package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.producers;
import com.intouncommon.backend.Entity.requestedProducers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface requestProducerRepository extends JpaRepository<requestedProducers, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM requestedProducers v WHERE v.producerId = :id")
    void deleteByProducersId(Long id);

    Optional<requestedProducers> findByContact(String contact);
}
