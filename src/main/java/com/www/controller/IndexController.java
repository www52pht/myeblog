package com.www.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author www
 * @creat 2021/1/27
 */
@Controller
public class IndexController extends BaseController {
    @RequestMapping({"", "/", "/index"})
    public String index() {
        // 1、分页信息 2、分类 3、用户 4、置顶 5、精选 6、排序
        IPage results = mPostService.paging(getPage(), null, null, null, null, "created");

        req.setAttribute("pageData",results);
        req.setAttribute("currentCategoryId", 0);
        return "index";
    }
}
