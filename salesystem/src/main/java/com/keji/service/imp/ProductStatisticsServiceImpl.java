package com.keji.service.imp;

import com.keji.mapper.ProductStatisticsMapper;
import com.keji.pojo.ProductStatistics;
import com.keji.service.ProductStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * cpq
 * Created by Administrator on 2019/9/9.
 *  商品销售额同环比
 */
@Service
public class ProductStatisticsServiceImpl implements ProductStatisticsService{

    @Autowired
    ProductStatisticsMapper productStatisticsMapper;

    /**
     * 查询所有的商品
     * @return
     */
    @Override
    public List<ProductStatistics> findByProduct() {
        return productStatisticsMapper.findByProduct();
    }

    /**
     * 商品名称
     * @param productName 商品名称
     * @return
     */
    @Override
    public List<ProductStatistics> findAmountByIDName(String productName) {
        return productStatisticsMapper.findAmountByIDName(productName);
    }

    /**
     * 查询商品订单明细表中  商品数量 日期
     * @param productid 商品id
     * @param year 年
     * @param month 月
     * @return
     */
    @Override
    public List<ProductStatistics> findAmountByYearMonth(int productid, int year, int month) {
        return productStatisticsMapper.findAmountByYearMonth(productid,year,month);
    }


}
