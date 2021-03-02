package com.trace.trace.mapper;

import com.trace.trace.entity.AgeOrSexDistributionData;
import com.trace.trace.entity.ProvinceIndexData;
import com.trace.trace.entity.RelateSearchData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author jbk-xiao
 * @program trace192
 * @packagename com.trace.trace.mapper
 * @Description
 * @create 2021-02-23-20:56
 */
@Mapper
@Component
public interface ChartsMapper {
    @Select("SELECT period, age_range `range`, tgi, word_rate wordRate, all_rate allRate FROM age_distribution "
            + "WHERE keyword = #{keyword}")
    AgeOrSexDistributionData[] selectAgeDistributionData(@Param("keyword") String keyword);

    @Select("SELECT period, sex_range `range`, tgi, word_rate wordRate, all_rate allRate FROM sex_distribution "
            + "WHERE keyword = #{keyword}")
    AgeOrSexDistributionData[] selectSexDistributionData(String keyword);

    @Select("SELECT period, province name, sum_index value FROM province_index WHERE keyword = #{keyword}")
    ProvinceIndexData[] selectProvinceIndexData(@Param("keyword") String keyword);

    @Select("SELECT period, word, pv, ratio FROM relate_search WHERE keyword = #{keyword}")
    RelateSearchData[] selectRelateSearch(String keyword);
}