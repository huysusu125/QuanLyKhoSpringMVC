package com.quanlykho.service;

import com.quanlykho.dto.SuplierDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISuplierService {
    List<SuplierDTO> findAll(Pageable pageable);
    int getTotalItem();
    SuplierDTO findById(long id);
    SuplierDTO save(SuplierDTO dto);
    void delete(long[] ids);
}
