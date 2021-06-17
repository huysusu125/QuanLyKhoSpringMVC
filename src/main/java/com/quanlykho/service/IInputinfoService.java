package com.quanlykho.service;

import com.quanlykho.dto.InputinfoDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInputinfoService {
    List<InputinfoDTO> findAll(Pageable pageable);
    int getTotalItem();
    InputinfoDTO findById(long id);
    InputinfoDTO save(InputinfoDTO dto);
    void delete(long[] ids);
}
