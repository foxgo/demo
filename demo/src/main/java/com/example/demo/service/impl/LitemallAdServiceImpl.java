package com.example.demo.service.impl;

import com.example.demo.entity.LitemallAd;
import com.example.demo.mapper.LitemallAdMapper;
import com.example.demo.service.LitemallAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LitemallAdServiceImpl implements LitemallAdService {

    @Autowired
    private   LitemallAdMapper litemallAdMapper;

    @Override
    public LitemallAd get(Integer id) {
       return litemallAdMapper.selectLitemallAdById(id);
    }
}
