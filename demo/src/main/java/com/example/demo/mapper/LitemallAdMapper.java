package com.example.demo.mapper;

import com.example.demo.entity.LitemallAd;
import org.apache.ibatis.annotations.Mapper;

public interface LitemallAdMapper {
    LitemallAd selectLitemallAdById(Integer id);
}
