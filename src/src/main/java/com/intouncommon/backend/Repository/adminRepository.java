package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRepository extends JpaRepository<admin, Integer> {
    admin findByUsername(String username);
}
