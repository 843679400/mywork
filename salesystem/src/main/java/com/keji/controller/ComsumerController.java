package com.keji.controller;

import com.keji.common.web.BaseController;
import com.keji.pojo.Consumer;
import com.keji.pojo.Login;
import com.keji.service.ConsumerService;
import com.keji.service.imp.ConsumerServiceImpl;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.krb5.Config;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ComsumerController extends BaseController {
    @Autowired
    private ConsumerServiceImpl consumerService;

    //消费者账户注册
    @RequestMapping("/register")
    public String register(Consumer consumer){
        int row = consumerService.consumerRegister(consumer);
        if(row>0){
            return dealSuccessResutl("注册成功",null);
        }
        return null;
    }

    //消费者登录账号
    @RequestMapping("/login")
    public String login(Consumer consumer, HttpServletRequest request){
        List<Consumer> list =  consumerService.login(consumer);
        request.getSession().setAttribute(request.getSession().getId(),consumer);
        if(list.size()>0){
            return dealSuccessResutl("登陆成功",null);
        }
        return null;
    }

    //获取消费者账号
    @RequestMapping("/getNumber")
    public String getNumber(HttpServletRequest request){
        Consumer consumer = (Consumer) request.getSession().getAttribute(request.getSession().getId());
        Login login = new Login();
        if(consumer!=null){
            login.setOnline(true);
            login.setNumber(consumer.getNumber());
        }else{
            login.setOnline(false);
        }
        return dealQueryResult(login,login);
    }

    //获取消费者信息
    @RequestMapping("/getconsumer")
    public String getconsumer(String number){
        List<Consumer> list = consumerService.getConsumer(number);
        return dealQueryResult(list.get(0),list.get(0));
    }

    //保存消费者信息
    @RequestMapping("/saveConsumer")
    public String saveConsumer(String name,String number,String phone,String address){
        Consumer consumer = new Consumer();
        consumer.setAddress(address);
        consumer.setName(name);
        consumer.setNumber(number);
        consumer.setPhone(phone);
        int row = consumerService.saveConsumer(consumer);
        if(row>0){
            return dealSuccessResutl("修改成功",null);
        }
        return null;
    }
}
