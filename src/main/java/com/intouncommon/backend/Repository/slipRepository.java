package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.productImages;
import com.intouncommon.backend.Entity.slip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface slipRepository extends JpaRepository<slip, Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM slip v WHERE v.id = :id")
    void deleteBySlipId(Long id);
}
