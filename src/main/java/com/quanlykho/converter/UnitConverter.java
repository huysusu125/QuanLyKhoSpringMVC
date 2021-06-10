package com.quanlykho.converter;

import com.quanlykho.dto.UnitDTO;
import com.quanlykho.entity.UnitEntity;
import org.springframework.stereotype.Component;

@Component
public class UnitConverter {
    public UnitDTO toDTO(UnitEntity entity) {
        UnitDTO result = new UnitDTO();
        result.setId(entity.getId());
        result.setDisplayName(entity.getDisplayName());
        result.setCreatedBy(entity.getCreatedBy());
        result.setModifiedBy(entity.getModifiedBy());
        result.setCreatedDate(entity.getCreatedDate());
        result.setModifiedDate(entity.getModifiedDate());
        return result;
    }

    public UnitEntity toEntity(UnitDTO dto) {
        UnitEntity result = new UnitEntity();
        result.setDisplayName(dto.getDisplayName());
        return result;
    }

    public UnitEntity toEntity(UnitEntity result, UnitDTO dto) {
        result.setDisplayName(dto.getDisplayName());
        return result;
    }
}
