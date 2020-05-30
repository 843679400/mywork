package com.keji.pojo;

import java.util.Date;

/**
 * @program: sale_System
 * @description: 供货商实体类
 * @author: 李东升
 * @create: 2019-09-07 17:12
 * <p>
 * <p>
 * Field            Type          Collation        Null    Key     Default              Extra           Privileges                       Comment
 * ---------------  ------------  ---------------  ------  ------  -------------------  --------------  -------------------------------  -------------------------
 * sup_id           int(11)       (NULL)           NO      PRI     (NULL)               auto_increment  select,insert,update,references  供货商id
 * sup_name         varchar(20)   utf8_general_ci  YES             (NULL)                               select,insert,update,references  供货商名称
 * sup_contnct      varchar(20)   utf8_general_ci  YES             (NULL)                               select,insert,update,references  联系人
 * sup_note         varchar(200)  utf8_general_ci  YES             (NULL)                               select,insert,update,references  备注，不超过50字
 * sup_phone        varchar(50)   utf8_general_ci  YES             (NULL)                               select,insert,update,references  联系人电话
 * sup_addres       varchar(100)  utf8_general_ci  YES             (NULL)                               select,insert,update,references  供货商地址
 * sup_creatDate    timestamp     (NULL)           NO              CURRENT_TIMESTAMP                    select,insert,update,references  创建日期
 * sup_modifieDate  timestamp     (NULL)           NO              0000-00-00 00:00:00                  select,insert,update,references  修改日期
 * sup_state        varchar(20)   utf8_general_ci  YES             (NULL)                               select,insert,update,references  状态
 * sup_modifier     varchar(20)   utf8_general_ci  YES             (NULL)                               select,insert,update,references  修改人
 **/
public class Supplier {

    private int supId; // 供货商编号
    private String supName; //供货商姓名
    private String supContnct;//联系人
    private String supNote; //备注
    private String supPhone; // 联系电话
    private String supAddress; // 供货商地址
    private Date supCreatDate;//创建日期
    private Date supModifieDate; //修改日期
    private int supState; //供货商状态
    private int supModifier; // 修改人

    public int getSupId() {
        return supId;
    }

    public void setSupId(int supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupContnct() {
        return supContnct;
    }

    public void setSupContnct(String supContnct) {
        this.supContnct = supContnct;
    }

    public String getSupNote() {
        return supNote;
    }

    public void setSupNote(String supNote) {
        this.supNote = supNote;
    }

    public String getSupPhone() {
        return supPhone;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }

    public Date getSupCreatDate() {
        return supCreatDate;
    }

    public void setSupCreatDate(Date supCreatDate) {
        this.supCreatDate = supCreatDate;
    }

    public Date getSupModifieDate() {
        return supModifieDate;
    }

    public void setSupModifieDate(Date supModifieDate) {
        this.supModifieDate = supModifieDate;
    }

    public int getSupState() {
        return supState;
    }

    public void setSupState(int supState) {
        this.supState = supState;
    }

    public int getSupModifier() {
        return supModifier;
    }

    public void setSupModifier(int supModifier) {
        this.supModifier = supModifier;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supId=" + supId +
                ", supName='" + supName + '\'' +
                ", supContnct='" + supContnct + '\'' +
                ", supNote='" + supNote + '\'' +
                ", supPhone='" + supPhone + '\'' +
                ", supAddress='" + supAddress + '\'' +
                ", supCreatDate=" + supCreatDate +
                ", supModifieDate=" + supModifieDate +
                ", supState=" + supState +
                ", supModifier=" + supModifier +
                '}';
    }
}
