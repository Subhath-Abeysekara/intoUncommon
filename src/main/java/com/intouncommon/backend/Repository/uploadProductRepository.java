package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.productions;
import com.intouncommon.backend.Entity.uploadProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface uploadProductRepository extends JpaRepository<uploadProducts, Long> {

        List<uploadProducts> findByContact(String contact);
}
