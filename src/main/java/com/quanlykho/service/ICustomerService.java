package com.quanlykho.service;

import com.quanlykho.dto.CustomerDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAll(Pageable pageable);
    int getTotalItem();
    CustomerDTO findById(long id);
    CustomerDTO save(CustomerDTO dto);
    void delete(long[] ids);
}
