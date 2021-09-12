package com.example.gulimall.member.dao;

import com.example.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author TechRice
 * @email trice12345@aliyun.com
 * @date 2021-09-10 23:43:18
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
