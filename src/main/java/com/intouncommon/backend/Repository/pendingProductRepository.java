package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.pendingProducers;
import com.intouncommon.backend.Entity.pendingProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface pendingProductRepository extends JpaRepository<pendingProducts, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pendingProducts v WHERE v.id = :id")
    void deleteByProductId(Long id);
}
