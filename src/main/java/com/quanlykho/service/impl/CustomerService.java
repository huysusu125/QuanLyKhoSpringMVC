package com.quanlykho.service.impl;

import com.quanlykho.converter.CustomerConverter;
import com.quanlykho.dto.CustomerDTO;
import com.quanlykho.entity.CustomerEntity;
import com.quanlykho.repository.CustomerRepository;
import com.quanlykho.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public List<CustomerDTO> findAll(Pageable pageable) {
        List<CustomerDTO> models = new ArrayList<>();
        List<CustomerEntity> entities = customerRepository.findAll(pageable).getContent();
        entities.forEach(entity -> {
            models.add(customerConverter.toDTO(entity));
        });
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) customerRepository.count();
    }

    @Override
    public CustomerDTO findById(long id) {
        return customerConverter.toDTO(customerRepository.findOne(id));
    }

    @Override
    public CustomerDTO save(CustomerDTO dto) {
        CustomerEntity customerEntity;
        if (dto.getId() != null) {
            CustomerEntity oldCustomer = customerRepository.findOne(dto.getId());
            customerEntity = customerConverter.toEntity(oldCustomer, dto);
        } else {
            customerEntity = customerConverter.toEntity(dto);
        }
        return customerConverter.toDTO(customerRepository.save(customerEntity));
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            customerRepository.delete(id);
        }
    }
}
