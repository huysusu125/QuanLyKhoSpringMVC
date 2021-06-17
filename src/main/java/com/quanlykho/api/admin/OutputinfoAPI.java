package com.quanlykho.api.admin;

import com.quanlykho.dto.OutputinfoDTO;
import com.quanlykho.service.IOutputinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OutputinfoAPI {

    @Autowired
    private IOutputinfoService outputinfoService;

    @PostMapping("/api/outputinfo")
    public OutputinfoDTO createOutputinfo(@RequestBody OutputinfoDTO outputinfoDTO) {
        return outputinfoService.save(outputinfoDTO);
    }

    @PutMapping("/api/outputinfo")
    public OutputinfoDTO editOutputinfo(@RequestBody OutputinfoDTO outputinfoDTO){
        return outputinfoService.save(outputinfoDTO);
    }
    @DeleteMapping("/api/outputinfo")
    public void deleteOutputinfo(@RequestBody long[] ids){
        outputinfoService.delete(ids);
    }
}
