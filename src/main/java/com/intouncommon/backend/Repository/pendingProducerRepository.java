package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.pendingProducers;
import com.intouncommon.backend.Entity.producers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface pendingProducerRepository extends JpaRepository<pendingProducers, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pendingProducers v WHERE v.id = :id")
    void deleteByProducersId(Long id);
    Optional<pendingProducers> findByContact(String contact);
}
