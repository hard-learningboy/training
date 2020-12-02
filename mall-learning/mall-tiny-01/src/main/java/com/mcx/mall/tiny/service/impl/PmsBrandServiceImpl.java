package com.mcx.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.mcx.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.mcx.mall.tiny.mbg.model.PmsBrand;
import com.mcx.mall.tiny.mbg.model.PmsBrandExample;
import com.mcx.mall.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PmsBrandServiceImpl
 *
 * @author mcx
 * @date 2020/12/1
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        List<PmsBrand> pmsBrandList = pmsBrandMapper.selectByExample(new PmsBrandExample());
        return pmsBrandList;
    }

    @Override
    public List<PmsBrand> listBrand(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize);
        List<PmsBrand> pmsBrands = pmsBrandMapper.selectByExample(new PmsBrandExample());
        return pmsBrands;
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return pmsBrandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return pmsBrandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
