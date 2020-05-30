package com.keji.service.imp;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.RepositoryMapper;
import com.keji.pojo.Repository;
import com.keji.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author TianXiangbo
 * @date 2019/9/8 8:12
 * Content:
 */
@Service
public class RepostitoryServiceImpl implements RepositoryService {

    @Autowired
    private RepositoryMapper repositoryMapper;

    /**
     * 分页查询库存信息
     * @param pageNum 当前页
     * @param pageSize 每页数量
     * @return PageInfo （）
     */
    @Override
    public PageInfo<Repository> findRepositoryByPage(int pageNum, int pageSize,Repository repository) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Repository> repositoryPage =   repositoryMapper.findAllRepostitories(repository);
        PageInfo<Repository> goodsPageInfo = new PageInfo<>(repositoryPage);
        return goodsPageInfo;
    }

    /**
     * 分页查询所有库存值低于预警值库存实体对象
     * @return 分页类型
     */
    @Override
    public PageInfo<Repository> findAllWarnRep(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Repository> repositoryPage =  repositoryMapper.findAllWarnRep();
        PageInfo<Repository> repositoryPageInfo = new PageInfo<>(repositoryPage);
        return repositoryPageInfo;
    }

    /**
     * 根据库存编号查询库存信息
     * @param repId 库存编号
     * @return 库存实体对象
     */
    @Override
    public Repository findRepositoryById(Integer repId) {
        return repositoryMapper.findRepositoryById( repId );
    }

    /**
     *根据一个库存编号集合查询库存集合
     * @param list 集合
     * @return 分页可行
     */
    @Override
    public PageInfo<Repository> findRepListByListId(int pageNum, int pageSize,List<Integer> list) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Repository> repositoryPage =  repositoryMapper.findRepListByListId( list );
        PageInfo<Repository> repositoryPageInfo = new PageInfo<>(repositoryPage);
        return repositoryPageInfo;
    }

    /**
     * 采购入库，如果商品进价相同，直接修改库存数量，如果商品数量不同，添加库存数据
     * @param repository 库存数据
     * @return 返回受影响的行数
     */
    @Override
    public int updateRepository(Repository repository) {
        int row;
        //判断库存是否存在进价相同商品
        int isExist = repositoryMapper.findPepByProNameAndPur(repository);
        if(isExist!=0){
            //进价相同，修改库存数量
            row = repositoryMapper.addQuantityByList( repository );
        }else {
            //根据库存编号获取库存信息
            Repository r = repositoryMapper.findRepositoryById( repository.getRepId() );
            //创建一个新的库存对象
            Repository rep = new Repository(r.getRepId(),r.getRepSupId(),r.getRepProductId(),repository.getRepPurch(),repository.getRepQuantity(),repository.getRepPurchDate(),repository.getRepRemark(),1);
            //将库存对象添加进库存
            row = repositoryMapper.addRepository( rep );
        }
        return row;
    }

}
