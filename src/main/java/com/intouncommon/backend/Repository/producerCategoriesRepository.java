package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.producerCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface producerCategoriesRepository extends JpaRepository<producerCategories, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producerCategories v WHERE v.id = :id")
    void deleteByProducersCatId(Long id);
}
