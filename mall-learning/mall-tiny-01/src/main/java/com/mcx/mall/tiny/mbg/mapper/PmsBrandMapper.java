package com.mcx.mall.tiny.mbg.mapper;

import com.mcx.mall.tiny.mbg.model.PmsBrand;
import com.mcx.mall.tiny.mbg.model.PmsBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * PmsBrandMapper
 *
 * @author mcx
 * @date 2020/12/1
 */
public interface PmsBrandMapper {
    /**
     * count by example
     *
     * @param example
     *
     * @return int
     */
    int countByExample(PmsBrandExample example);

    /**
     * delete by example
     *
     * @param example
     *
     * @return int
     */
    int deleteByExample(PmsBrandExample example);

    /**
     * delete by primary key
     *
     * @param id
     *
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert
     *
     * @param record
     *
     * @return int
     */
    int insert(PmsBrand record);

    /**
     * insert selective
     *
     * @param record
     *
     * @return int
     */
    int insertSelective(PmsBrand record);

    /**
     * select by example with blobs
     *
     * @param example
     *
     * @return List<PmsBrand>
     */
    List<PmsBrand> selectByExampleWithBLOBs(PmsBrandExample example);

    /**
     * select by example
     *
     * @param example
     *
     * @return List<PmsBrand>
     */
    List<PmsBrand> selectByExample(PmsBrandExample example);

    /**
     * select by primary key
     *
     * @param id
     *
     * @return PmsBrand
     */
    PmsBrand selectByPrimaryKey(Long id);

    /**
     * update by example selective
     *
     * @param record
     * @param example
     *
     * @return int
     */
    int updateByExampleSelective(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    /**
     * update by example with blobs
     *
     * @param record
     * @param example
     *
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    /**
     * update by example
     *
     * @param record
     * @param example
     *
     * @return int
     */
    int updateByExample(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    /**
     * update by primary key selective
     *
     * @param record
     *
     * @return int
     */
    int updateByPrimaryKeySelective(PmsBrand record);

    /**
     * update by primary key with blobs
     *
     * @param record
     *
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(PmsBrand record);

    /**
     * update by primary key
     *
     * @param record
     *
     * @return int
     */
    int updateByPrimaryKey(PmsBrand record);
}