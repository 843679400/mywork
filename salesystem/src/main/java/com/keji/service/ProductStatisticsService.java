package com.keji.service;

import com.keji.pojo.ProductStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProductStatisticsService {

    /**
     * 查询所有的商品
     * @return
     */
    List<ProductStatistics> findByProduct();

    /**
     *  商品名称
     * @param productName
     * @return
     */
    List<ProductStatistics> findAmountByIDName(String productName);


    /**
     * 查询输入年份月份的销售数量
     * @param productid 商品id
     * @param year 年
     * @param month 月
     * @return
     */
    List<ProductStatistics> findAmountByYearMonth(int productid,int year,int month);


}
