package com.example.gulimall.member.feign;

import com.example.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: CouponFeignService
 * @Description: 访问 gulimall-coupon 优惠卷服务
 * @Author: TechRice
 * @Date: 2021/9/13 19:27
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    /**
     * 请求会员的优惠卷列表
     * @return 会员的优惠卷列表
     */
    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
