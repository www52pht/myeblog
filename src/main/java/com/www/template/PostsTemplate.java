package com.www.template;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.www.common.templates.DirectiveHandler;
import com.www.common.templates.TemplateDirective;
import com.www.service.MPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author www
 * @creat 2021/1/29
 */
@Component
public class PostsTemplate extends TemplateDirective {

    @Autowired
    MPostService mPostService;

    @Override
    public String getName() {
        return "posts";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {

        Integer level = handler.getInteger("level");
        Integer pn = handler.getInteger("pn", 1);
        Integer size = handler.getInteger("size", 2);
        Long categoryId = handler.getLong("categoryId");

        IPage page = mPostService.paging(new Page(pn, size), categoryId, null, level, null, "created");

        handler.put(RESULTS, page).render();
    }
}
