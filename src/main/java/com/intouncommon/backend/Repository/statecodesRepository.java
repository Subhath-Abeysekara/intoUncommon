package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.statecodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface statecodesRepository extends JpaRepository<statecodes, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM statecodes v WHERE v.stateId = :id")
    void deleteByStateId(Long id);
}
