package com.quanlykho.service.impl;

import com.quanlykho.converter.OutputinfoConverter;
import com.quanlykho.dto.OutputinfoDTO;
import com.quanlykho.entity.CustomerEntity;
import com.quanlykho.entity.ObjectEntity;
import com.quanlykho.entity.OutputinfoEntity;
import com.quanlykho.repository.CustomerRepository;
import com.quanlykho.repository.ObjectRepository;
import com.quanlykho.repository.OutputinfoRepository;
import com.quanlykho.service.IOutputinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OutputinfoService implements IOutputinfoService {

    @Autowired
    private OutputinfoRepository outputinfoRepository;

    @Autowired
    private OutputinfoConverter outputinfoConverter;

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<OutputinfoDTO> findAll(Pageable pageable) {
        List<OutputinfoDTO> models = new ArrayList<>();
        List<OutputinfoEntity> entities = outputinfoRepository.findAll(pageable).getContent();
        entities.forEach(entity -> models.add(outputinfoConverter.toDTO(entity)));
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) outputinfoRepository.count();
    }

    @Override
    public OutputinfoDTO findById(long id) {
        return outputinfoConverter.toDTO(outputinfoRepository.findOne(id));
    }

    @Override
    public OutputinfoDTO save(OutputinfoDTO dto) {
        ObjectEntity object = objectRepository.findOne(dto.getObjectId());
        CustomerEntity customer = customerRepository.findOne(dto.getCustomerId());
        OutputinfoEntity outputinfo;
        if (dto.getId() != null) {
            OutputinfoEntity oldOutputinfo = outputinfoRepository.findOne(dto.getId());
            oldOutputinfo.setObjects(object);
            oldOutputinfo.setCustomers(customer);
            outputinfo = outputinfoConverter.toEntity(oldOutputinfo, dto);
        } else {
            outputinfo = outputinfoConverter.toEntity(dto);
            outputinfo.setObjects(object);
            outputinfo.setCustomers(customer);
        }
        return outputinfoConverter.toDTO(outputinfoRepository.save(outputinfo));
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            outputinfoRepository.delete(id);
        }
    }
}
