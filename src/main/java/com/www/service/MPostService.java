package com.www.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.www.entity.MPost;
import com.baomidou.mybatisplus.extension.service.IService;
import com.www.vo.MPostVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author www
 * @since 2021-01-28
 */
public interface MPostService extends IService<MPost> {

    IPage paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommend, String order);

    MPostVo selectOnePost(QueryWrapper<MPost> wrapper);

    void initWeekRank();

    void incrCommentCountAndUnionForWeekRank(long postId, boolean isIncr);
}
