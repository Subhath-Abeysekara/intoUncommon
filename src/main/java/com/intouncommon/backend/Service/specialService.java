package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.productions;
import org.springframework.data.domain.Page;

import java.util.List;

public interface specialService {

    List<productions> getSpecial();

    List<productions> fillSpecial();

    List<productions> getAll();

    List<productions> getAllByCat(Long id);

    List<productions> getPaginationByCat(Long id , int limit , int offset);

    Page<productions> getPagination(int limit , int offset);
}
