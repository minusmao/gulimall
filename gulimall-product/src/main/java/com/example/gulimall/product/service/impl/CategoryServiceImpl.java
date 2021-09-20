package com.example.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gulimall.common.utils.PageUtils;
import com.example.gulimall.common.utils.Query;

import com.example.gulimall.product.dao.CategoryDao;
import com.example.gulimall.product.entity.CategoryEntity;
import com.example.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     *
     * @return 分类列表
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        // 查出所有分类
        List<CategoryEntity> categoryList = baseMapper.selectList(null);

        // 组装成树型结构
        List<CategoryEntity> level1CategoryList = categoryList.stream()
                .filter(c -> c.getParentCid() == 0)
                .peek(c -> c.setChildren(getChildren(c, categoryList)))
                .sorted((c1, c2) -> (c1.getSort() == null? 0 : c1.getSort()) - (c2.getSort() == null? 0 : c2.getSort()))
                .collect(Collectors.toList());

        return level1CategoryList;
    }

    /**
     * 查找父分类的所有子分类，再递归查找各个子分类的子分类
     *
     * @param categoryRoot 父分类
     * @param categoryList 分类列表
     * @return 子分类列表
     */
    public List<CategoryEntity> getChildren(CategoryEntity categoryRoot, List<CategoryEntity> categoryList) {

        return categoryList.stream()
                .filter(c -> c.getParentCid().equals(categoryRoot.getCatId()))
                .peek(c -> c.setChildren(this.getChildren(c, categoryList)))
                .sorted(Comparator.comparingInt(c -> (c.getSort() == null ? 0 : c.getSort())))
                .collect(Collectors.toList());
    }

}