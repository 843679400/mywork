package com.keji.mapper;

import com.keji.pojo.ProductStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * cpq
 * Created by Administrator on 2019/9/9.
 * 商品销售额同环比
 */
@Mapper
public interface ProductStatisticsMapper {

    /**
     * 查询所有的商品
     * @return
     */
    List<ProductStatistics> findByProduct();

    /**
     * 商品名称
     * @param productName
     * @return
     */
    List<ProductStatistics> findAmountByIDName(@Param("productName")String productName);

    /**
     * 查询输入年份月份的销售数量
     * @param productid 商品id
     * @param year 年
     * @param month 月
     * @return
     */
    List<ProductStatistics> findAmountByYearMonth(@Param("productid")int productid,@Param("year") int year, @Param("month") int month);


}
