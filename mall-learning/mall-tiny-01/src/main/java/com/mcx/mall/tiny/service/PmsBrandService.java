package com.mcx.mall.tiny.service;

import com.mcx.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/*
 * PmsBrandService
 * Created by mcx on 2020/12/1
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    List<PmsBrand> listBrand(Integer pageNum ,Integer pageSize);
}
