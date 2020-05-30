package com.keji.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AlipayService {

   /**
    * 支付宝支付调用接口
    * @param response
    * @param request
    * @throws IOException
    */
   void  aliPay(String price,String orderid,HttpServletResponse response, HttpServletRequest request) throws IOException;
}