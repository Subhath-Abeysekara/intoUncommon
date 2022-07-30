package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface loginRepository extends JpaRepository<login, Integer> {
    
    @Transactional
    @Modifying
    @Query("update login A set A.loginCount=:loginCount where A.id=:id")
    void setCount(int loginCount, int id);
}
