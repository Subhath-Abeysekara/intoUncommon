package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface categoryRepository extends JpaRepository<categories, Long> {
    @Query("select c.categoryId from categories c where c.common=:common")
    List<Long> getIds(boolean common);
    @Query("select c.type from categories c where c.categoryId=:id")
    String getType(Long id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM categories v WHERE v.categoryId = :id")
    void deleteByCatId(Long id);
}
