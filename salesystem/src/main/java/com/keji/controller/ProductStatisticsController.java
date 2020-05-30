package com.keji.controller;

import com.keji.common.utils.JsonUtil;
import com.keji.common.utils.StringUtils;
import com.keji.common.web.BaseController;
import com.keji.pojo.ProductStatistics;
import com.keji.service.ProductStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/statistics")
public class ProductStatisticsController extends BaseController {
    @Autowired
    ProductStatisticsService productStatisticsService;

    /**
     * 查询所有的商品
     * @return
     */
    @RequestMapping("/findByProduct")
    public String findByProduct(){
        List<ProductStatistics> productStatistics = productStatisticsService.findByProduct();
        String deal=dealQueryResult(productStatistics,productStatistics);
        return deal;
    }



    /**
     * 查询输入年份月份的销售数量
     * @param productid 商品id
     * @param year 年
     * @param month 月
     * @return
     */
    @PostMapping("/getAmountByYearMonth")
    public String getAmountByYearMonth(Integer productid,Integer year,Integer month) {
        List<ProductStatistics> productStatistics = productStatisticsService.findAmountByYearMonth(productid,year,month);
        return dealQueryResult(productStatistics,productStatistics);

        /*if(StringUtils.isNotBlank(productid) && StringUtils.isNotBlank(year) && StringUtils.isNotBlank(month)){
            List<ProductStatistics> productStatistics = productStatisticsService.findAmountByYearMonth(productid,year,month);
            System.out.println(productStatistics);
            return dealQueryResult(productStatistics,productStatistics);
        }else {
            return JsonUtil.getResponseJson(-1,"输入参数有误",null);
        }
*/
    }

}
