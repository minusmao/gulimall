package com.example.gulimall.coupon.dao;

import com.example.gulimall.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author TechRice
 * @email trice12345@aliyun.com
 * @date 2021-09-10 23:23:55
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}
