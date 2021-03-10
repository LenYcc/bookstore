package com.lzydmc.bookstore.service.impl;

import com.lzydmc.bookstore.model.dao.BannerMapper;
import com.lzydmc.bookstore.model.pojo.Banner;
import com.lzydmc.bookstore.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<Banner> showbanner(){
        return bannerMapper.selectAll();
    }
}
