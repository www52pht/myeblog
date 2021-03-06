package com.www.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.www.entity.MPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.www.vo.MPostVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
public interface MPostMapper extends BaseMapper<MPost> {

    IPage<MPostVo> selectPosts(Page page, @Param(Constants.WRAPPER) QueryWrapper wrapper);

    MPostVo selectOnePost(@Param(Constants.WRAPPER) QueryWrapper<MPost> wrapper);
}
