package com.quanlykho.api.admin;

import com.quanlykho.dto.CustomerDTO;
import com.quanlykho.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerAPi {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/api/customer")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.save(customerDTO);
    }

    @PutMapping("/api/customer")
    public CustomerDTO editCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.save(customerDTO);
    }

    @DeleteMapping("/api/customer")
    public void deleteCustomer(@RequestBody long[] ids){
        customerService.delete(ids);
    }
}
