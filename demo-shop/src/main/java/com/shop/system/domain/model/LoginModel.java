package com.shop.system.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 类作用：
 *
 * @author Lake
 * @date 下午 9:58 2021-03-18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shop_user")
@EqualsAndHashCode(callSuper=false)
public class LoginModel extends BaseModel{

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "pass_word")
    private String passWord;

    /**
     * 昵称
     */
    @Column(name = "name")
    private String name;

    /**
     * 生日
     */
    @Column(name = "birthday")
    private String birthday;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 财富
     */
    @Column(name = "money")
    private String money;

    /**
     * 级别
     */
    @Column(name = "vip_level")
    private String vipLevel;

    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 财富
     */
    @Column(name = "error_count")
    private String errorCount;
}
