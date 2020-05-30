package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.Repository;

import java.util.List;

/**
 * @author TianXiangbo
 * @date 2019/9/7 000720:25
 * Content:库存管理业务层
 */
public interface RepositoryService {

    /**
     * 分页查询库存信息
     * @param pageNum 当前页
     * @param pageSize 每页数量
     * @return PageInfo （）
     */
    PageInfo<Repository> findRepositoryByPage(int pageNum, int pageSize,Repository repository);

    /**
     * 分页查询所有库存值低于预警值库存实体对象
     * @return 分页类型
     */
    PageInfo<Repository> findAllWarnRep(int pageNum, int pageSize);

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
    PageInfo<Repository> findRepListByListId(int pageNum, int pageSize,List<Integer> list);

    /**
     * 采购入库，如果商品进价相同，直接修改库存数量，如果商品数量不同，添加库存数据
     * @param repository 库存数据
     * @return 返回受影响的行数
     */
    int updateRepository(Repository repository);



}
