package com.quanlykho.converter;

import com.quanlykho.dto.SuplierDTO;
import com.quanlykho.entity.SuplierEntity;
import org.springframework.stereotype.Component;

@Component
public class SuplierConverter {
    public SuplierDTO toDTO(SuplierEntity entity) {
        SuplierDTO result = new SuplierDTO();
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

    public SuplierEntity toEntity(SuplierDTO dto){
        SuplierEntity result = new SuplierEntity();
        result.setDisplayName(dto.getDisplayName());
        result.setEmail(dto.getEmail());
        result.setPhone(dto.getPhone());
        result.setAddress(dto.getAddress());
        result.setContractDate(dto.getContractDate());
        return result;
    }

    public SuplierEntity toEntity(SuplierEntity result, SuplierDTO dto){
        result.setDisplayName(dto.getDisplayName());
        result.setEmail(dto.getEmail());
        result.setPhone(dto.getPhone());
        result.setAddress(dto.getAddress());
        result.setContractDate(dto.getContractDate());
        return result;
    }
}
