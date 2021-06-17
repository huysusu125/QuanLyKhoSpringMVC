package com.quanlykho.controller.admin;

import com.quanlykho.dto.InputinfoDTO;
import com.quanlykho.service.IInputinfoService;
import com.quanlykho.service.IObjectService;
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
public class InputinfoController {

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private IInputinfoService inputinfoService;

    @Autowired
    private IObjectService objectService;

    @GetMapping("/quan-tri/nhap-hang/danh-sach")
    public ModelAndView showListInputInfo(@RequestParam("page") int page,
                                          @RequestParam("limit") int limit,
                                          HttpServletRequest request) {
        InputinfoDTO model = new InputinfoDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/inputinfo/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(inputinfoService.findAll(pageable));
        model.setTotalItem(inputinfoService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @GetMapping("/quan-tri/nhap-hang/chinh-sua")
    public ModelAndView editInputinfo(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/inputinfo/edit");
        InputinfoDTO model = new InputinfoDTO();
        if (id != null) {
            model = inputinfoService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("object", objectService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
