package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.productImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface productionImageRepository extends JpaRepository<productImages, Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productImages v WHERE v.id = :id")
    void deleteByImageId(Long id);
}
