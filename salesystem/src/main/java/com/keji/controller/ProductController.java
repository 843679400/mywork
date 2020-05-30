package com.keji.controller;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.mapper.ProductMapper;
import com.keji.pojo.Position;
import com.keji.pojo.Product;
import com.keji.pojo.Supplier;
import com.keji.pojo.UserInfo;
import com.keji.service.ProductService;
import com.keji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.security.Principal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productController")
public class ProductController extends BaseController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserService userService;

    /**
     * 获取所有商品信息
     *
     * @return
     */
    @RequestMapping("/findAllProducts")
    public String findAllProducts(int page) {
        PageInfo<Product> pageInfo=productService.findAllProduct(page,4);
        String product=dealQueryResult(pageInfo,pageInfo);
        return product;
    }

    /**
     * 获取商品类别
     * @return
     */
    @RequestMapping("/getfingAllType")
    public String getfingAllType(){
        List<Product> Producttype= productService.fingAllType();
        String result =dealQueryResult(Producttype,Producttype);
        
        return result;
    }

    /**
     * 多条件分页查询
     * @param page
     * @param name
     * @param type
     * @return
     */
    @RequestMapping("/getProduct")
    public String getProduct(int page,String name,String type,String state){
        PageInfo<Product> productPageInfo = productService.findProduct(page,5,name,type,state);
        String result1=dealQueryResult(productPageInfo,productPageInfo);
        System.out.println(result1);
        return result1;
    }


    /**
     * 首页商品展示
     * @return
     */
    @RequestMapping("/getIndexProduct")
    public String getIndexProduct(){
        PageInfo<Product> productPageInfo = productService.findProduct(0,999,"","","1");
        List<Product> list= productPageInfo.getList();
        String result1=dealQueryResult(list,list);
        System.out.println(result1);
        return result1;
    }

    /**
     * 根据id查商品
     * @param productId
     * @return
     */
    @RequestMapping("/getOneProduct")
    public String getOneProduct(int productId){
        Product product= productService.findOneProduct(productId);
        String result=dealQueryResult(product,product);
        
        return result;
    }

    /**
     * 根据商品编号查询商品名称
     */
    @RequestMapping("/findProduct")
    public String findProduct(int productId) {
        Product product = productMapper.findProductById(productId);
        String result = dealQueryResult(product, product);
        
        return result;
    }

    /*
    添加商品
     */
    @PostMapping("/addProduct")
    public String addProduct(Product product, Principal principal)throws ParseException{
       /* String name= principal.getName();    //
        UserInfo user= userService.findUserByUserName(name);
        product.setModifierId(user.getId());*/
       int row=productService.addProduct(product);
        if(row==0){
            return dealSuccessResutl("添加信息失败",null);
        }
        return dealSuccessResutl("成功添加信息",null);
    }

    @PostMapping("/findProductById")
    public String findProductById(int productId){
        Product product=productMapper.findProductById(productId);
        String json =dealQueryResult(product,product);
        return json;
    }

    @PostMapping("/updateProduct")
    public String UpdateProduct(Product product){
        int row = productMapper.updateProductById(product);
        System.out.println(row);
        if(row==0){
            return dealSuccessResutl("修改信息失败",null);
        }else {
            return dealSuccessResutl("修改信息成功", null);
        }
    }

    @PostMapping("/deleteProductById")
    public String deleteProductById(int productId){
        int row=productMapper.deleteProductById(productId);
        if(row==0){
            return dealSuccessResutl("删除信息失败",null);
        }
        return dealSuccessResutl("删除信息成功",null);

    }

    /**
     * 上传图片
     * @param photo
     * @param request
     * @return
     */
    @RequestMapping("/uploadPhoto")
    public Map<String, String> uploadPhoto(MultipartFile photo, HttpServletRequest request){
        Map<String, String> ret = new HashMap<String, String>();
        if (photo == null) {
            ret.put("type", "error");
            ret.put("msg", "选择要上传的文件！");
            return ret;
        }
        if (photo.getSize() > 1024 * 1024 * 10) {
            ret.put("type", "error");
            ret.put("msg", "文件大小不能超过10M！");
            return ret;
        }
        //获取文件后缀
        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1, photo.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            ret.put("type", "error");
            ret.put("msg", "请选择jpg,jpeg,gif,png格式的图片！");
            return ret;
        }
        //获取项目根目录加上图片目录 webapp/static/imgages/upload/
        String savePath = "D:\\workspace\\salesystem\\src\\main\\resources\\static\\upload";
        //String savePath =request.getServletContext().getRealPath("/upload");
        //String savePath = "/home/docker/upload";
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        String filename = new Date().getTime() + "." + suffix;
        try {
            //将文件保存指定目录
            photo.transferTo(new File(savePath +"/"+ filename));
        } catch (Exception e) {
            ret.put("type", "error");
            ret.put("msg", "保存文件异常！");
            e.printStackTrace();
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "上传图片成功！");
        ret.put("filepath", "D:\\workspace\\salesystem\\src\\main\\resources\\static\\upload\\");
        ret.put("filename", filename);
        return ret;
    }

    //商品进货
    @RequestMapping("/pullProduct")
    public String pullProduct(int number,int id){
        Product product = new Product();
        product.setProductId(id);
        product.setProductWarning(number);
        int row = productMapper.pullProduct(product);
        if(row>0){
            return dealSuccessResutl("进货成功",null);
        }
        return null;
    }

    //商品上下架
    @RequestMapping("/productState")
    public String productState(int id,String price,int state){
        Product product = new Product();
        product.setProductId(id);
        product.setPrice(price);
        product.setProductState(state);
        int row = productMapper.productState(product);
        if(row>0){
            return dealSuccessResutl("成功",null);
        }
        return null;
    }

    /*//根据商品状态获取商品信息
    public String stateGetProduct(String state){
        return null;
    }*/


    /**
     * 获取商品库存量
     * @return
     */
    @RequestMapping("/productText")
    public String productText(){
        List<Product> list = productMapper.findConditionProduct("");
        String result= dealQueryResult(list,list);
        System.out.println(result);
        return result;
    }
}
