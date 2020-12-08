package com.mcx.mall.tiny.service;

import com.mcx.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * PmsBrandService
 *
 * @author mcx
 * @date 2020/12/1
 */
public interface PmsBrandService {
    /**
     * list all brand
     *
     * @return List<PmsBrand>
     */
    List<PmsBrand> listAllBrand();

    /**
     * list brand
     *
     * @param pageNum
     * @param pageSize
     *
     * @return List<PmsBrand>
     */
    List<PmsBrand> listBrand(Integer pageNum ,Integer pageSize);

    /**
     * create brand
     *
     * @param brand
     *
     * @return int
     */
    int createBrand(PmsBrand brand);

    /**
     * update brand
     *
     * @param id
     * @param brand
     *
     * @return int
     */
    int updateBrand(Long id, PmsBrand brand);

    /**
     * delete brand
     *
     * @param id
     *
     * @return int
     */
    int deleteBrand(Long id);

    /**
     * get brand
     *
     * @param id
     *
     * @return PmsBrand
     */
    PmsBrand getBrand(Long id);
}
