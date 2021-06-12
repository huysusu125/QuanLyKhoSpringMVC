package com.quanlykho.api.admin;

import com.quanlykho.dto.SuplierDTO;
import com.quanlykho.service.ISuplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SuplierAPI {

    @Autowired
    ISuplierService suplierService;

    @PostMapping("/api/suplier")
    public SuplierDTO createSuplier(@RequestBody SuplierDTO suplierDTO){
        return suplierService.save(suplierDTO);
    }

    @PutMapping("/api/suplier")
    public SuplierDTO updateSuplier(@RequestBody SuplierDTO suplierDTO) {
        return suplierService.save(suplierDTO);
    }

    @DeleteMapping("/api/suplier")
    public void deleteSuplier(@RequestBody long[] ids){
        suplierService.delete(ids);
    }
}
