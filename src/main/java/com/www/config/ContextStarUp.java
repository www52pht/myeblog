package com.www.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.www.entity.MCategory;
import com.www.service.MCategoryService;
import com.www.service.MPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author www
 * @creat 2021/1/28
 */
@Component
public class ContextStarUp implements ApplicationRunner, ServletContextAware {
    @Autowired
    MCategoryService mCategoryService;

    ServletContext servletContext;

    @Autowired
    MPostService mPostService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<MCategory> categories = mCategoryService.list(new QueryWrapper<MCategory>().eq("status", 0));

        servletContext.setAttribute("categories", categories);

        mPostService.initWeekRank();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
