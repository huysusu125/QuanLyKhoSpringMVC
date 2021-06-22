package com.quanlykho.service.impl;

import com.quanlykho.converter.ObjectConverter;
import com.quanlykho.dto.ObjectDTO;
import com.quanlykho.entity.*;
import com.quanlykho.repository.*;
import com.quanlykho.service.IObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Autowired
    private InputinfoRepository inputinfoRepository;

    @Autowired
    private OutputinfoRepository outputinfoRepository;

    @Override
    public List<ObjectDTO> findAll(Pageable pageable) {
        List<ObjectDTO> models = new ArrayList<>();
        List<ObjectEntity> entities = objectRepository.findAll(pageable).getContent();
        List<InputinfoEntity> inputs = inputinfoRepository.findAll();
        List<OutputinfoEntity> outputs = outputinfoRepository.findAll();
        if (inputs.size() * outputs.size() != 0) {
            entities.forEach(item -> {
                long count = 0;
                for (InputinfoEntity input : inputs) {
                    if (Objects.equals(input.getObjects().getId(), item.getId())) {
                        count += input.getCount();
                    }
                }
                for (OutputinfoEntity output : outputs) {
                    if (Objects.equals(output.getObjects().getId(), item.getId())){
                        count -= output.getCount();
                    }
                }
                ObjectDTO objectDTO = objectConverter.toDTO(item);
                objectDTO.setCount(count);
                models.add(objectDTO);

            });
        } else {
            entities.forEach(item -> {
                ObjectDTO objectDTO = objectConverter.toDTO(item);
                models.add(objectDTO);
            });
        }
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

    @Override
    public Map<Long, String> findAll() {
        Map<Long, String> result = new HashMap<>();
        List<ObjectEntity> entities = objectRepository.findAll();
        entities.forEach(entity -> result.put((entity.getId()), entity.getDisplayName()));
        return result;
    }
}
