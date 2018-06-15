package com.example.demo.controller;


import com.example.demo.entity.LitemallAd;
import com.example.demo.service.LitemallAdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("LitemallAd")
public class LitemallAdController {

    private static final Logger logger = LoggerFactory.getLogger(LitemallAdController.class);

    @Autowired
    private LitemallAdService litemallAdService;


    @GetMapping("get/{id}")
    @ResponseBody
    public LitemallAd get(@PathVariable Integer id) throws Exception {
        logger.info("test");
        throw new NullPointerException("NullPointerException");
        //return litemallAdService.get(id);
    }

}
