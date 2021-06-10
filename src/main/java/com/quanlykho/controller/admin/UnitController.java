package com.quanlykho.controller.admin;

import com.quanlykho.dto.UnitDTO;
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
public class UnitController {

    @Autowired
    private IUnitService unitService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/don-vi/danh-sach", method = RequestMethod.GET)
    public ModelAndView showListUnit(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit,
                                 HttpServletRequest request) {
        UnitDTO model = new UnitDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/unit/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(unitService.findAll(pageable));
        model.setTotalItem(unitService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/don-vi/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editUnit(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/unit/edit");
        UnitDTO model = new UnitDTO();
        if (id != null) {
            model = unitService.findById(id);
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
