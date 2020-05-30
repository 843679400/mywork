package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface ProductService {

    //获取所有商品信息
    public PageInfo<Product> findAllProduct(int pageNum, int pageSize);

    //查询商品类别
    public List<Product> fingAllType();

    //根据商品名称查询商品
    public List<Product> findConditionProduct(@Param("name") String name);

    //多条件查询
    public PageInfo<Product> findProduct(int pageNum,int pageSize,@Param("name")String name, @Param("type")String type,@Param("state")String state);

    //查询单个商品
    public Product findOneProduct(int id);

    //根据id 查询一件商品的全部信息
    Product findProductById(@Param("id") int id);

    //增加一条商品信息
    public int  addProduct(Product product);

    //通过id删除商品信息
    public int deleteProductById(@Param("id") int id);

    //通过id修改一条商品信息
    public int updateProductById(Product product);

    //商品进货
    int pullProduct(Product product);

    //商品上下架
    int productState(Product product);

    //根据商品状态获取商品信息
    List<Product> stateGetProduct(Product product);

    //修改商品库存
    int updateProductNum(Product product);
}
