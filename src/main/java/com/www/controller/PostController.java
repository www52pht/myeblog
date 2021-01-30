package com.www.controller;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.www.entity.MComment;
import com.www.entity.MPost;
import com.www.vo.MCommentVo;
import com.www.vo.MPostVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * @author www
 * @creat 2021/1/28
 */
@Controller
public class PostController extends BaseController {

    //:\d*指定参数为数字类型
    @GetMapping("/category/{id:\\d*}")
    public String category(@PathVariable(name = "id") Long id) {
        req.setAttribute("currentCategoryId", id);
        return "post/category";
    }

    @GetMapping("/post/{id:\\d*}")
    public String detail(@PathVariable(name = "id") Long id) {

        MPostVo vo = mPostService.selectOnePost(new QueryWrapper<MPost>().eq("p.id", id));
        Assert.notNull(vo, "文章已经被删除！");

        //1、分页 2、文章Id 3、用户Id 4、排序
        IPage<MCommentVo> results = mCommentService.paging(getPage(), vo.getId(), null, "created");

        //回显页面，将获得的currentCategoryId返回去
        req.setAttribute("currentCategoryId", vo.getCategoryId());

        req.setAttribute("pageData",results);

        req.setAttribute("post", vo);
        return "post/detail";
    }
}
