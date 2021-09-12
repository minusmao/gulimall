package com.example.gulimall.ware.dao;

import com.example.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author TechRice
 * @email trice12345@aliyun.com
 * @date 2021-09-11 00:26:11
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
