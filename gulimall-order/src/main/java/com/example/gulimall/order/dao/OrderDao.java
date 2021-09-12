package com.example.gulimall.order.dao;

import com.example.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author TechRice
 * @email trice12345@aliyun.com
 * @date 2021-09-10 23:54:45
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
