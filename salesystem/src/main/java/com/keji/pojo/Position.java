package com.keji.pojo;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @program: sale
 * @description: 职位表
 * @author: lxh
 * @create: 2019-09-07 17:08
 **/
/*
Field            Type          Collation        Null    Key     Default  Extra           Privileges                       Comment
---------------  ------------  ---------------  ------  ------  -------  --------------  -------------------------------  --------------
pos_id           int(11)       (NULL)           NO      PRI     (NULL)   auto_increment  select,insert,update,references  职务id
pos_name         varchar(20)   utf8_general_ci  YES             (NULL)                   select,insert,update,references  职务名称
pos_creatDate    datetime      (NULL)           YES             (NULL)                   select,insert,update,references  创建日期
pos_modifieDate  datetime      (NULL)           YES             (NULL)                   select,insert,update,references  修改日期
pos_modifier     varchar(255)  utf8_general_ci  YES             (NULL)                   select,insert,update,references  修改人
pos_state        varchar(255)  utf8_general_ci  YES             0                        select,insert,update,references  状态
 */
public class Position {
    private int posId;//职务编号
    private String posName;//职务名称
    private Date posCreatDate;//创建日期
    private Date posModifieDate;//修改日期
    private int posModifier;//修改人；
    private int posState;//状态；

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public Date getPosCreatDate() {
        return posCreatDate;
    }

    public void setPosCreatDate(Date posCreatDate) {
        this.posCreatDate = posCreatDate;
    }

    public Date getPosModifieDate() {
        return posModifieDate;
    }

    public void setPosModifieDate(Date posModifieDate) {
        this.posModifieDate = posModifieDate;
    }

    public int getPosModifier() {
        return posModifier;
    }

    public void setPosModifier(int posModifier) {
        this.posModifier = posModifier;
    }

    public int getPosState() {
        return posState;
    }

    public void setPosState(int posState) {
        this.posState = posState;
    }

    @Override
    public String toString() {
        return "Position{" +
                "posId=" + posId +
                ", posName='" + posName + '\'' +
                ", posCreatDate=" + posCreatDate +
                ", posModifieDate=" + posModifieDate +
                ", posModifier=" + posModifier +
                ", posState=" + posState +
                '}';
    }
}
