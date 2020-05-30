package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.Repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TianXiangbo
 * @date 2019/9/8 8:06
 * Content:
 */
@Mapper
public interface RepositoryMapper {

    /**
     * 查询所有库存
     * @return 页面类型
     */
    Page<Repository> findAllRepostitories(Repository repository);

    /**
     * 分页查询所有库存值低于预警值库存实体对象
     * @return 分页类型
     */
    Page<Repository> findAllWarnRep();

    /**
     * 根据库存编号查询库存信息
     * @param repId 库存编号
     * @return 库存实体对象
     */
    Repository findRepositoryById(Integer repId);

    /**
     *根据一个库存编号集合查询库存集合
     * @param list 集合
     * @return 分页可行
     */
    Page<Repository> findRepListByListId(List<Integer> list);

    /**
     * 判断是否存在相同进价商品
     * @return 受影响的行数
     */
    int findPepByProNameAndPur(Repository repository);

    /**
     * 商品入库，进价相同，修改库存数量
     * @param repository 条件封装对象
     * @return 受影响的行数
     */
    int addQuantityByList(Repository repository);

    /**
     * 商品入库，进价不同，添加库存信息
     * @param repository 库存信息
     * @return 受影响的行数
     */
    int addRepository(Repository repository);


    int updateQuantity(@Param("quantity") Integer quantity, @Param("productId")String productId);

}
