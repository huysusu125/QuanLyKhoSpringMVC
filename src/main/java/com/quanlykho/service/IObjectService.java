package com.quanlykho.service;

import com.quanlykho.dto.ObjectDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IObjectService {
    List<ObjectDTO> findAll(Pageable pageable);
    int getTotalItem();
    ObjectDTO findById(long id);
    ObjectDTO save(ObjectDTO dto);
    void delete(long[] ids);
    Map<Long, String> findAll();
}
