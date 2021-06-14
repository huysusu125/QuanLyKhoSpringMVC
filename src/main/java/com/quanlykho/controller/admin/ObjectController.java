package com.quanlykho.controller.admin;

import com.quanlykho.dto.ObjectDTO;
import com.quanlykho.service.IObjectService;
import com.quanlykho.service.ISuplierService;
import com.quanlykho.service.IUnitService;
import com.quanlykho.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ObjectController {
    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private IObjectService objectService;

    @Autowired
    private IUnitService unitService;

    @Autowired
    private ISuplierService suplierService;

    @RequestMapping(value = "/quan-tri/mat-hang/danh-sach", method = RequestMethod.GET)
    public ModelAndView showListObject(@RequestParam("page") int page,
                                       @RequestParam("limit") int limit,
                                       HttpServletRequest request) {
        ObjectDTO model = new ObjectDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/object/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(objectService.findAll(pageable));
        model.setTotalItem(objectService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/mat-hang/chinh-sua", method = RequestMethod.GET)
    ModelAndView editObject(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/object/edit");
        ObjectDTO model = new ObjectDTO();
        if (id != null) {
            model = objectService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("unit", unitService.findAll());
        mav.addObject("suplier", suplierService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
