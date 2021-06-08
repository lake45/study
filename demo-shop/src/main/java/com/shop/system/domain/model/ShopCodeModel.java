package com.shop.system.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 类作用：
 *
 * @author Lake
 * @date 下午 9:17 2021-05-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shop_user")
@EqualsAndHashCode(callSuper=false)
public class ShopCodeModel extends BaseModel{

    /**
     * 码值
     */
    @Column(name = "code")
    private String code;

    /**
     * 中文
     */
    @Column(name = "code_name")
    private String codeName;

    /**
     * 排序
     */
    @Column(name = "code_sort")
    private String codeSort;
}
