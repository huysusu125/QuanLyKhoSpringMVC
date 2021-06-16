package com.quanlykho.converter;

import com.quanlykho.dto.CustomerDTO;
import com.quanlykho.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    public CustomerDTO toDTO(CustomerEntity entity) {
        CustomerDTO result = new CustomerDTO();
        result.setId(entity.getId());
        result.setDisplayName(entity.getDisplayName());
        result.setEmail(entity.getEmail());
        result.setPhone(entity.getPhone());
        result.setAddress(entity.getAddress());
        result.setContractDate(entity.getContractDate());
        result.setCreatedBy(entity.getCreatedBy());
        result.setModifiedBy(entity.getModifiedBy());
        result.setCreatedDate(entity.getCreatedDate());
        result.setModifiedDate(entity.getModifiedDate());
        return result;
    }

    public CustomerEntity toEntity(CustomerDTO dto){
        CustomerEntity result = new CustomerEntity();
        result.setDisplayName(dto.getDisplayName());
        result.setEmail(dto.getEmail());
        result.setPhone(dto.getPhone());
        result.setAddress(dto.getAddress());
        result.setContractDate(dto.getContractDate());
        return result;
    }

    public CustomerEntity toEntity(CustomerEntity result, CustomerDTO dto){
        result.setDisplayName(dto.getDisplayName());
        result.setEmail(dto.getEmail());
        result.setPhone(dto.getPhone());
        result.setAddress(dto.getAddress());
        result.setContractDate(dto.getContractDate());
        return result;
    }
}
