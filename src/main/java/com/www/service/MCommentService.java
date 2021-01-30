package com.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.www.entity.MComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.www.vo.MCommentVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author www
 * @since 2021-01-28
 */
public interface MCommentService extends IService<MComment> {

    IPage<MCommentVo> paging(Page page, Long postId, String userId, String order);

}
