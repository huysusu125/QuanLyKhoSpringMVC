package com.quanlykho.service.impl;

import com.quanlykho.converter.InputinfoConverter;
import com.quanlykho.dto.InputinfoDTO;
import com.quanlykho.entity.InputinfoEntity;
import com.quanlykho.entity.ObjectEntity;
import com.quanlykho.repository.InputinfoRepository;
import com.quanlykho.repository.ObjectRepository;
import com.quanlykho.service.IInputinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InputinfoService implements IInputinfoService {

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private InputinfoRepository inputinfoRepository;

    @Autowired
    private InputinfoConverter inputinfoConverter;

    @Override
    public List<InputinfoDTO> findAll(Pageable pageable) {
        List<InputinfoDTO> models = new ArrayList<>();
        List<InputinfoEntity> entities = inputinfoRepository.findAll(pageable).getContent();
        entities.forEach(entity -> {
            InputinfoDTO inputinfoDTO = inputinfoConverter.toDto(entity);
            models.add(inputinfoDTO);
        });
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) inputinfoRepository.count();
    }

    @Override
    public InputinfoDTO findById(long id) {
        return inputinfoConverter.toDto(inputinfoRepository.findOne(id));
    }

    @Override
    public InputinfoDTO save(InputinfoDTO dto) {
        InputinfoEntity inputinfoEntity;
        ObjectEntity objectEntity = objectRepository.findOne(dto.getObjectId());

        if (dto.getId() != null) {
            InputinfoEntity oldInputInfoEntity = inputinfoRepository.findOne(dto.getId());
            oldInputInfoEntity.setObjects(objectEntity);
            inputinfoEntity = inputinfoConverter.toEntity(oldInputInfoEntity, dto);
        } else {
            inputinfoEntity = inputinfoConverter.toEntity(dto);
            inputinfoEntity.setObjects(objectEntity);
        }

        return inputinfoConverter.toDto(inputinfoRepository.save(inputinfoEntity));
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            inputinfoRepository.delete(id);
        }
    }
}
