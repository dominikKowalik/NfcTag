package com.kowalik.dominik.nfc.page_content.controller;

import com.kowalik.dominik.nfc.page_content.domain.Page;
import com.kowalik.dominik.nfc.page_content.repository.PageMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dominik on 28.07.17.
 */

@Controller
@RequestMapping("/page-controller")
public class PageController {

    @Autowired
    PageMongoRepository pageMongoRepository;

    @RequestMapping
    public String get(Model model){
        Page page = pageMongoRepository.findOne(1L);
        model.addAttribute("header", page.getHeader());
        model.addAttribute("body", page.getBody());
        return "page";
    }
}