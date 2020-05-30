package com.keji.pojo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体类
 * Field                Type           Collation        Null    Key     Default              Extra   Privileges                       Comment
 * -------------------  -------------  ---------------  ------  ------  -------------------  ------  -------------------------------  --------------------------------
 * product_id           int(10)        (NULL)           NO      PRI     (NULL)                       select,insert,update,references  商品id
 * product_name         varchar(255)   utf8_general_ci  YES             (NULL)                       select,insert,update,references  商品名称
 * product_brand        varchar(255)   utf8_general_ci  YES             (NULL)                       select,insert,update,references  商品品牌
 * product_type         varchar(255)   utf8_general_ci  YES             (NULL)                       select,insert,update,references  商品类别
 * product_standard     int(255)       (NULL)           YES             (NULL)                       select,insert,update,references  商品规格(容量,尺寸等)
 * product_address      varchar(255)   utf8_general_ci  YES             (NULL)                       select,insert,update,references  商品产地
 * product_warning      int   utf8_general_ci  YES             (NULL)                                select,insert,update,references  库存报警
 * product_price        decimal(10,2)  (NULL)           YES             (NULL)                       select,insert,update,references  商品单价(售价)
 * modifier_id          int(10)        (NULL)           NO              (NULL)                       select,insert,update,references  修改人id
 * product_state        varchar(255)   utf8_general_ci  YES             0                            select,insert,update,references  商品状态
 * product_creatDate    timestamp      (NULL)           NO              CURRENT_TIMESTAMP            select,insert,update,references  创建日期
 * product_modifieDate  timestamp      (NULL)           NO              0000-00-00 00:00:00          select,insert,update,references  修改日期
 */
@Data
public class Product {
    private int  productId; //商品编号
    private  String productName; // 商品名称
    private String productBrand; //商品品牌
    private  String productType; //商品类型
    private String productStandard; //商品规格
    private String productAddress; // 商品地址
    private int productWarning; //库存
    private BigDecimal productPrice; //进价
    private int modifierId; //修改人编号
    private int productState; //商品状态
    private Date productCreatDate;    //创建日期
    private Date productModifierDate; //修改日期
    private String photopath;//图片路径
    private String price;//售价
    private Repository repository =new Repository();

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

}
