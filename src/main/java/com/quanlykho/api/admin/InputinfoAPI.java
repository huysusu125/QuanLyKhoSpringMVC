package com.quanlykho.api.admin;

import com.quanlykho.dto.InputinfoDTO;
import com.quanlykho.service.IInputinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InputinfoAPI {

    @Autowired
    private IInputinfoService inputinfoService;

    @PostMapping("/api/inputinfo")
    public InputinfoDTO createInputinfo(@RequestBody InputinfoDTO inputinfoDTO){
        return inputinfoService.save(inputinfoDTO);
    }

    @PutMapping("/api/inputinfo")
    public InputinfoDTO editInputinfo(@RequestBody InputinfoDTO inputinfoDTO){
        return inputinfoService.save(inputinfoDTO);
    }

    @DeleteMapping("/api/inputinfo")
    public void deleteObject(@RequestBody long[] ids){
        inputinfoService.delete(ids);
    }
}
