package com.quanlykho.api.admin;


import com.quanlykho.dto.UnitDTO;
import com.quanlykho.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UnitAPI {
    @Autowired
    IUnitService unitService;

    @PostMapping("/api/unit")
    public UnitDTO createUnit(@RequestBody UnitDTO unitDTO){
        return unitService.save(unitDTO);
    }

    @PutMapping("/api/unit")
    public UnitDTO updateUnit(@RequestBody UnitDTO unitDTO){
        return unitService.save(unitDTO);
    }

    @DeleteMapping("/api/unit")
    public void deleteUnit(@RequestBody long[] ids){
        unitService.delete(ids);
    }
}
