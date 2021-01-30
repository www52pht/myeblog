package com.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.www.entity.MPost;
import com.www.mapper.MPostMapper;
import com.www.service.MPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.www.vo.MPostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author www
 * @since 2021-01-28
 */
@Service
public class MPostServiceImpl extends ServiceImpl<MPostMapper, MPost> implements MPostService {

    @Autowired
    MPostMapper mPostMapper;

    @Override
    public IPage<MPostVo> paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommend, String order) {


        if(level == null) {
            level = -1;
        }

        QueryWrapper wrapper = new QueryWrapper<MPost>()
                .eq(categoryId != null,  "category_id", categoryId)
                .eq(userId != null,  "user_id", userId)
                .eq(level == 0,  "level", 0)
                .gt(level > 0,  "level", 0)
                .orderByDesc(order != null, order);

        return mPostMapper.selectPosts(page, wrapper);
    }

    @Override
    public MPostVo selectOnePost(QueryWrapper<MPost> wrapper) {
        return mPostMapper.selectOnePost(wrapper);
    }

}
