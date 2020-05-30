package com.keji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.ProductMapper;
import com.keji.pojo.Position;
import com.keji.pojo.Product;
import com.keji.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: sale_System
 * @description: 商品业务层实现类
 * @author: 李东升
 * @create: 2019-09-08 09:06
 **/

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询所有商品信息
     *
     * @return
     */
    @Override
    public PageInfo<Product> findAllProduct(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Product> productPage=productMapper.findAllProducts();
        PageInfo<Product> productPageInfo=new PageInfo<>(productPage);
        return productPageInfo;
    }


    @Override
    public List<Product> fingAllType() {
        return productMapper.fingAllType();
    }

    @Override
    public List<Product> findConditionProduct(String name) {
        return productMapper.findConditionProduct(name);
    }

    @Override
    public PageInfo<Product> findProduct(int pageNum, int pageSize, String name, String type,String state) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Product> product =productMapper.findProduct(name,type,state);
        PageInfo<Product> productPageInfo = new PageInfo<>(product);
        return productPageInfo;
    }

    @Override
    public Product findOneProduct(int id) {
        return productMapper.findOneProduct(id);
    }

    @Override
    public Product findProductById(int id) {
        return productMapper.findProductById(id);
    }

    //添加商品信息
    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }
    //删除商品信息
    @Override
    public int deleteProductById(int id) {
        return productMapper.deleteProductById(id);
    }
    //修改商品信息
    @Override
    public int updateProductById(Product product) {
        return productMapper.updateProductById(product);
    }

    @Override
    public int pullProduct(Product product) {
        return productMapper.pullProduct(product);
    }

    @Override
    public int productState(Product product) {
        return productMapper.productState(product);
    }

    @Override
    public List<Product> stateGetProduct(Product product) {
        return productMapper.stateGetProduct(product);
    }

    @Override
    public int updateProductNum(Product product) {
        return productMapper.updateProductNum(product);
    }

}
