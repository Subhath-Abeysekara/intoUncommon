package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.producers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface producerRepository extends JpaRepository<producers, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producers v WHERE v.producerId = :id")
    void deleteByProducersId(Long id);
}
