package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品数据层
 */
@Mapper
public interface ProductMapper {

    //查询商品所有信息
    public Page<Product> findAllProducts();

    //增加一条商品信息
    public int  addProduct(Product product);

    //通过id删除商品信息
    public int deleteProductById(@Param("id") int id);

    //通过id修改一条商品信息
    public int updateProductById(Product product);

    //查询商品类别
    public List<Product> fingAllType();

    //根据商品名称查询商品
    public List<Product> findConditionProduct(@Param("name") String name);

    //多条件查询
    public Page<Product> findProduct(@Param("name")String name, @Param("type")String type,@Param("state")String state);

    //查询单个商品
    public Product findOneProduct(int id);

    //根据id 查询一件商品的全部信息
    Product findProductById(@Param("id") int id);

    //商品进货
    int pullProduct(Product product);

    //商品上下架
    int productState(Product product);

    //根据商品状态获取商品信息
    List<Product> stateGetProduct(Product product);

    //修改商品库存
    int updateProductNum(Product product);
}
