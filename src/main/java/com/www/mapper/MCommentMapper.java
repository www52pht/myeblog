package com.www.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.www.entity.MComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.www.vo.MCommentVo;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author www
 * @since 2021-01-28
 */
@MapperScan
public interface MCommentMapper extends BaseMapper<MComment> {

    IPage<MCommentVo> selectComments(Page page, @Param(Constants.WRAPPER) QueryWrapper<MComment> wrapper);
}
