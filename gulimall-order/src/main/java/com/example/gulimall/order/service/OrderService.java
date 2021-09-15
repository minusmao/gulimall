package com.example.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gulimall.common.utils.PageUtils;
import com.example.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author TechRice
 * @email trice12345@aliyun.com
 * @date 2021-09-10 23:54:45
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

