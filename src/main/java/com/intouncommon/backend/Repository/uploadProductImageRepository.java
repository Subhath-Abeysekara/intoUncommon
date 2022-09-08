package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.productImages;
import com.intouncommon.backend.Entity.uploadProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface uploadProductImageRepository extends JpaRepository<uploadProductImages, Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM uploadProductImages v WHERE v.id = :id")
    void deleteByImageId(Long id);
}
