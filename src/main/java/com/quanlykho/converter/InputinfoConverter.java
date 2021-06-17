package com.quanlykho.converter;

import com.quanlykho.dto.InputinfoDTO;
import com.quanlykho.entity.InputinfoEntity;
import org.springframework.stereotype.Component;

@Component
public class InputinfoConverter {

    public InputinfoDTO toDto(InputinfoEntity entity) {
        InputinfoDTO result = new InputinfoDTO();
        result.setId(entity.getId());
        result.setObjectId(entity.getObjects().getId());
        result.setObjectName(entity.getObjects().getDisplayName());
        result.setSuplierId(entity.getObjects().getSuplier().getId());
        result.setSuplierName(entity.getObjects().getSuplier().getDisplayName());
        result.setUnitId(entity.getObjects().getUnit().getId());
        result.setUnitName(entity.getObjects().getUnit().getDisplayName());
        result.setCount(entity.getCount());
        result.setPrice(entity.getPrice());
        result.setCreatedBy(entity.getCreatedBy());
        result.setModifiedBy(entity.getModifiedBy());
        result.setCreatedDate(entity.getCreatedDate());
        result.setModifiedDate(entity.getModifiedDate());
        return result;
    }

    public InputinfoEntity toEntity(InputinfoDTO dto){
        InputinfoEntity result = new InputinfoEntity();
        result.setCount(dto.getCount());
        result.setPrice(dto.getPrice());
        return result;
    }

    public InputinfoEntity toEntity(InputinfoEntity result, InputinfoDTO dto){
        result.setCount(dto.getCount());
        result.setPrice(dto.getPrice());
        return result;
    }
}
