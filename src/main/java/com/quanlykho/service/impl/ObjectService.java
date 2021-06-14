package com.quanlykho.service.impl;

import com.quanlykho.converter.ObjectConverter;
import com.quanlykho.dto.ObjectDTO;
import com.quanlykho.entity.ObjectEntity;
import com.quanlykho.entity.SuplierEntity;
import com.quanlykho.entity.UnitEntity;
import com.quanlykho.repository.ObjectRepository;
import com.quanlykho.repository.SuplierRepository;
import com.quanlykho.repository.UnitRepository;
import com.quanlykho.service.IObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectService implements IObjectService {

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private ObjectConverter objectConverter;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private SuplierRepository suplierRepository;

    @Override
    public List<ObjectDTO> findAll(Pageable pageable) {
        List<ObjectDTO> models = new ArrayList<>();
        List<ObjectEntity> entities = objectRepository.findAll(pageable).getContent();
        entities.forEach(item -> {
            ObjectDTO objectDTO = objectConverter.toDTO(item);
            models.add(objectDTO);
        });
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) objectRepository.count();
    }

    @Override
    public ObjectDTO findById(long id) {
        return objectConverter.toDTO(objectRepository.findOne(id));
    }

    @Override
    @Transactional
    public ObjectDTO save(ObjectDTO dto) {
        UnitEntity unit = unitRepository.findOne(dto.getUnitId());
        SuplierEntity suplier = suplierRepository.findOne(dto.getSuplierId());
        ObjectEntity objectEntity;

        if (dto.getId() != null) {
            ObjectEntity oldObjectEntity = objectRepository.findOne(dto.getId());
            oldObjectEntity.setUnit(unit);
            oldObjectEntity.setSuplier(suplier);
            objectEntity = objectConverter.toEntity(oldObjectEntity, dto);
        } else {
            objectEntity = objectConverter.toEntity(dto);
            objectEntity.setUnit(unit);
            objectEntity.setSuplier(suplier);
        }
        return objectConverter.toDTO((objectRepository.save(objectEntity)));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id : ids) {
            objectRepository.delete(id);
        }
    }
}
