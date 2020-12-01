package com.mcx.mall.tiny.controller;

import com.mcx.mall.tiny.common.api.CommonResult;
import com.mcx.mall.tiny.mbg.model.PmsBrand;
import com.mcx.mall.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * PmsBrandController
 * Created by mcx on 2020/12/1.
 */
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    @RequestMapping(value = "/listAllBrand")
    @ResponseBody
    public CommonResult<List<PmsBrand>> getAllBrandList(){
        List<PmsBrand> pmsBrandList = pmsBrandService.listAllBrand();
        return CommonResult.success(pmsBrandList);
    }

    @RequestMapping(value = "/listBrand")
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(
            @RequestParam(value = "pageNum" , defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize" , defaultValue = "3") Integer pageSize){
        List<PmsBrand> pmsBrandList = pmsBrandService.listBrand(pageNum,pageSize);
        return CommonResult.success(pmsBrandList);
    }
}
