package com.quanlykho.api.admin;

import com.quanlykho.dto.ObjectDTO;
import com.quanlykho.service.IObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObjectAPI {

    @Autowired
    private IObjectService objectService;

    @PostMapping("/api/object")
    public ObjectDTO createObject(@RequestBody ObjectDTO objectDTO){
        return objectService.save(objectDTO);
    }

    @PutMapping("/api/object")
    public ObjectDTO editObject(@RequestBody ObjectDTO objectDTO){
        return objectService.save(objectDTO);
    }

    @DeleteMapping("/api/object")
    public void deleteObject(@RequestBody long[] ids){
        objectService.delete(ids);
    }
}
