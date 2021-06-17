package com.quanlykho.service;

import com.quanlykho.dto.OutputinfoDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOutputinfoService {
    List<OutputinfoDTO> findAll(Pageable pageable);
    int getTotalItem();
    OutputinfoDTO findById(long id);
    OutputinfoDTO save(OutputinfoDTO dto);
    void delete(long[] ids);
}
