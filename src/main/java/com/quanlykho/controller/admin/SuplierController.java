package com.quanlykho.controller.admin;

import com.quanlykho.dto.SuplierDTO;
import com.quanlykho.service.ISuplierService;
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
public class SuplierController {
    @Autowired
    private ISuplierService suplierService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/nha-cung-cap/danh-sach", method = RequestMethod.GET)
    public ModelAndView showListSuplier(@RequestParam("page") int page,
                                     @RequestParam("limit") int limit,
                                     HttpServletRequest request) {
        SuplierDTO model = new SuplierDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/suplier/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(suplierService.findAll(pageable));
        model.setTotalItem(suplierService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/nha-cung-cap/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editSuplier(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/suplier/edit");
        SuplierDTO model = new SuplierDTO();
        if (id != null) {
            model = suplierService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }
}
