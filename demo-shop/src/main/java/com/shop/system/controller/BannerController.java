package com.shop.system.controller;

import com.shop.system.common.message.ReturnFactory;
import com.shop.system.common.message.ReturnMessage;
import com.shop.system.domain.model.BannerModel;
import com.shop.system.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类作用：
 *
 * @author
 * @date
 */
@RestController
@RequestMapping("${process.apiPath}/main/")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @GetMapping("getBanner")
    public ReturnMessage getBanner(){
        List<BannerModel> bannerModelList = bannerService.getBannerMessage();
        return ReturnFactory.success(bannerModelList);
    }
}
