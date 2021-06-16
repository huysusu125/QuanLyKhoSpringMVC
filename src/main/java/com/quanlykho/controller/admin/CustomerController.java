package com.quanlykho.controller.admin;

import com.quanlykho.dto.CustomerDTO;
import com.quanlykho.service.ICustomerService;
import com.quanlykho.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/quan-tri/khach-hang/danh-sach")
    public ModelAndView showListCustomer(@RequestParam("page") int page,
                                         @RequestParam("limit") int limit,
                                         HttpServletRequest request) {
        CustomerDTO model = new CustomerDTO();
        model.setLimit(limit);
        model.setPage(page);
        ModelAndView mav = new ModelAndView("admin/customer/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(customerService.findAll(pageable));
        model.setTotalItem(customerService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @GetMapping("/quan-tri/khach-hang/chinh-sua")
    public ModelAndView editCustomer(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        CustomerDTO model = new CustomerDTO();
        if(id != null)
            model = customerService.findById(id);
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }
}
