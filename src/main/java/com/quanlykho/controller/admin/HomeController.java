package com.quanlykho.controller.admin;

import com.quanlykho.dto.ObjectDTO;
import com.quanlykho.service.IObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {


    @Autowired
    private IObjectService objectService;

    @RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
    public ModelAndView homePage(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit) {
        ObjectDTO model = new ObjectDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/home");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(objectService.findAll(pageable));
        model.setTotalItem(objectService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

        mav.addObject("model", model);

        return mav;
    }
}