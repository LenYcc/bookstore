package com.lzydmc.bookstore.service;

import com.lzydmc.bookstore.model.pojo.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BannerService {
    List<Banner> showbanner();
}
