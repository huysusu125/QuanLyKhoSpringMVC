package com.quanlykho.service.impl;

import com.quanlykho.converter.UnitConverter;
import com.quanlykho.dto.UnitDTO;
import com.quanlykho.entity.UnitEntity;
import com.quanlykho.repository.UnitRepository;
import com.quanlykho.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitService implements IUnitService {
    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private UnitConverter unitConverter;

    public List<UnitDTO> findAll(Pageable pageable) {
        List<UnitDTO> models = new ArrayList<>();
        List<UnitEntity> entities = unitRepository.findAll(pageable).getContent();
        for (UnitEntity item : entities) {
            UnitDTO unitDTO = unitConverter.toDTO(item);
            models.add(unitDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) unitRepository.count();
    }

    @Override
    public UnitDTO findById(long id) {
        UnitEntity entity = unitRepository.findOne(id);
        return unitConverter.toDTO(entity);
    }

    @Override
    @Transactional
    public UnitDTO save(UnitDTO dto) {
        UnitEntity unitEntity;
        if (dto.getId() != null) {
            UnitEntity oldUnitEntity = unitRepository.findOne(dto.getId());
            unitEntity = unitConverter.toEntity(oldUnitEntity, dto);
        } else {
            unitEntity = unitConverter.toEntity(dto);
        }
        return unitConverter.toDTO(unitRepository.save(unitEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id : ids) {
            unitRepository.delete(id);
        }
    }
}
