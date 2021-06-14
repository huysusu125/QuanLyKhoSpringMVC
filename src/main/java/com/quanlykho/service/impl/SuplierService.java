package com.quanlykho.service.impl;

import com.quanlykho.converter.SuplierConverter;
import com.quanlykho.dto.SuplierDTO;
import com.quanlykho.entity.SuplierEntity;
import com.quanlykho.repository.SuplierRepository;
import com.quanlykho.service.ISuplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SuplierService implements ISuplierService {

    @Autowired
    private SuplierRepository suplierRepository;

    @Autowired
    private SuplierConverter suplierConverter;

    @Override
    public List<SuplierDTO> findAll(Pageable pageable) {
        List<SuplierDTO> models = new ArrayList<>();
        List<SuplierEntity> entities = suplierRepository.findAll(pageable).getContent();
        entities.forEach(entity -> {
            SuplierDTO suplierDTO = suplierConverter.toDTO(entity);
            models.add(suplierDTO);
        });
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) suplierRepository.count();
    }

    @Override
    public SuplierDTO findById(long id) {
        return suplierConverter.toDTO(suplierRepository.findOne(id));
    }

    @Override
    @Transactional
    public SuplierDTO save(SuplierDTO dto) {
        SuplierEntity suplierEntity;
        if (dto.getId() != null) {
            SuplierEntity oldSuplierEntity = suplierRepository.findOne(dto.getId());
            suplierEntity = suplierConverter.toEntity(oldSuplierEntity, dto);
        } else {
            suplierEntity = suplierConverter.toEntity(dto);
        }
        return suplierConverter.toDTO(suplierRepository.save(suplierEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id : ids) {
            suplierRepository.delete(id);
        }
    }

    @Override
    public Map<Long, String> findAll() {
        Map<Long, String> result = new HashMap<>();
        List<SuplierEntity> entities = suplierRepository.findAll();
        for (SuplierEntity entity : entities) {
            result.put(entity.getId(), entity.getDisplayName());
        }
        return result;
    }
}
