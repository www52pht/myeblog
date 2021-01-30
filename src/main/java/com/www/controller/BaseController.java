package com.www.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.www.service.MCommentService;
import com.www.service.MPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author www
 * @creat 2021/1/28
 */
public class BaseController {
    @Autowired
    HttpServletRequest req;

    @Autowired
    MPostService mPostService;

    @Autowired
    MCommentService mCommentService;

    public Page getPage() {
        int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
        int size = ServletRequestUtils.getIntParameter(req, "size", 2);

        return new Page(pn, size);
    }



}
