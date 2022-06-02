package com.intouncommon.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intouncommon.backend.Entity.categories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface categoryRepository extends JpaRepository<categories, Long> {
    @Query("select c.categoryId from categories c where c.common=:common")
    List<Long> getIds(boolean common);
    @Query("select c.type from categories c where c.categoryId=:id")
    String getType(Long id);

}
