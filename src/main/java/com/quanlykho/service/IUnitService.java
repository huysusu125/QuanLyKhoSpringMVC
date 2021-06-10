package com.quanlykho.service;

import com.quanlykho.dto.UnitDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUnitService {
    List<UnitDTO> findAll(Pageable pageable);
    int getTotalItem();
    UnitDTO findById(long id);
    UnitDTO save(UnitDTO dto);
    void delete(long[] ids);
}
