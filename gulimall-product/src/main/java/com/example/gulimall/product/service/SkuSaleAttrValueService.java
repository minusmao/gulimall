package com.example.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gulimall.common.utils.PageUtils;
import com.example.gulimall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author TechRice
 * @email trice12345@aliyun.com
 * @date 2021-09-10 21:16:03
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

