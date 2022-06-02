package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface producerCategoriesRepository extends JpaRepository<producerCategories, Long> {
}
