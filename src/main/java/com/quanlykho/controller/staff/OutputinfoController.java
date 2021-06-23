package com.quanlykho.controller.staff;

import com.quanlykho.dto.OutputinfoDTO;
import com.quanlykho.service.ICustomerService;
import com.quanlykho.service.IObjectService;
import com.quanlykho.service.IOutputinfoService;
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

@RestController("outputinfoControllerOfStaff")
public class OutputinfoController {
    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private IObjectService objectService;

    @Autowired
    private IOutputinfoService outputinfoService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/xuat-hang/danh-sach")
    public ModelAndView showListInputInfo(@RequestParam("page") int page,
                                          @RequestParam("limit") int limit,
                                          HttpServletRequest request) {
        OutputinfoDTO model = new OutputinfoDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("staff/outputinfo/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(outputinfoService.findAll(pageable));
        model.setTotalItem(outputinfoService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @GetMapping("/xuat-hang/chinh-sua")
    public ModelAndView editOutputinfo(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("staff/outputinfo/edit");
        OutputinfoDTO model = new OutputinfoDTO();
        if (id != null) {
            model = outputinfoService.findById(id);
        }

        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("customer", customerService.findAll());
        mav.addObject("object", objectService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}

