package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.productions;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface productionRepository extends JpaRepository<productions, Long> {
        @Query("select P.id from productions P where P.category=:id")
        List<Long> getIdsByCategory(Long id);

        List<productions> findByCat(Long id , Pageable pageable);

//        @Query("SELECT ALL FROM productions P ORDER BY P.id LIMIT=:limit OFFSET=:offset")
//        List<productions> getPagination(int limit , int offset);
        @Transactional
        @Modifying
        @Query("update productions P set P.category=:category where P.category=:oldCat")
        void setCategory(Long category, Long oldCat);
        @Transactional
        @Modifying
        @Query("update productions P set P.producer=:producer where P.producer=:oldPro")
        void setProducer(Long producer, Long oldPro);
        @Query("select P.amount from productions P where P.id=:id")
        int getAmount(Long id);
        @Transactional
        @Modifying
        @Query("update productions P set P.amount=:amount where P.id=:id")
        void setImageAmount(int amount, Long id);
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM productions v WHERE v.id = :id")
        void deleteByProductId(Long id);
}
