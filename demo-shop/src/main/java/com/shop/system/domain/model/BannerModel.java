package com.shop.system.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.tomcat.util.modeler.BaseModelMBean;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 类作用：
 *
 * @author Lake
 * @date 上午 10:37 2021-03-20
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shop_center_pic")
@EqualsAndHashCode(callSuper=false)
public class BannerModel extends BaseModel {

    /**
     * 图片
     */
    @Column(name = "banner_pic")
    private String bannerPic;

    /**
     * 说明
     */
    @Column(name = "banner_text")
    private String bannerText;

}
