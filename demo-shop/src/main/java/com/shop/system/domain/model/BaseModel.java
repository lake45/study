package com.shop.system.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 类作用：
 *
 * @author Lake
 * @date 上午 10:45 2021-03-20
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shop_center_pic")
@EqualsAndHashCode(callSuper=false)
public class BaseModel {
    @Id
    private String id;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;

    @Column(name = "is_deleted")
    private Boolean deleted;
}
