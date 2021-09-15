package com.example.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import com.example.gulimall.member.feign.CouponFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gulimall.member.entity.MemberEntity;
import com.example.gulimall.member.service.MemberService;
import com.example.gulimall.common.utils.PageUtils;
import com.example.gulimall.common.utils.R;



/**
 * 会员
 *
 * @author TechRice
 * @email trice12345@aliyun.com
 * @date 2021-09-10 23:43:18
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private CouponFeignService couponFeignService;

    /**
     * 测试 Feign 访问 gulimall-coupon 服务，获取会员的优惠卷列表
     * @return 会员的优惠卷列表
     */
    @RequestMapping("/coupons")
    public R memberCoupons(){
        // 会员
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("张三");
        // 优惠卷
        R memberCoupons = couponFeignService.memberCoupons();

        return Objects.requireNonNull(R.ok().put("member", memberEntity))
                .put("coupons", memberCoupons.get("coupons"));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
