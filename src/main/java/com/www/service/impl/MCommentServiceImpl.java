package com.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.www.entity.MComment;
import com.www.mapper.MCommentMapper;
import com.www.service.MCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.www.vo.MCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author www
 * @since 2021-01-28
 */
@Service
public class MCommentServiceImpl extends ServiceImpl<MCommentMapper, MComment> implements MCommentService {
    @Autowired
    MCommentMapper mCommentMapper;

    @Override
    public IPage<MCommentVo> paging(Page page, Long postId, String userId, String order) {

        return mCommentMapper.selectComments(page, new QueryWrapper<MComment>()
                .eq(postId != null, "post_id", postId)
                .eq(userId != null, "user_id", userId)
                .orderByDesc(order != null, order));

    }
}
