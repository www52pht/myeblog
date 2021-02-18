package com.www.config;

import com.www.template.HotsTemplate;
import com.www.template.PostsTemplate;
import com.www.template.TimeAgoMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author www
 * @create 2021/1/29
 */
@Component
public class FreemarkerConfig {
    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    PostsTemplate postsTemplate;

    @Autowired
    HotsTemplate hotsTemplate;




    @PostConstruct
    public void setUp() {
        configuration.setSharedVariable("timeAgo", new TimeAgoMethod());
        configuration.setSharedVariable("posts", postsTemplate);
        configuration.setSharedVariable("hots", hotsTemplate);
    }
}
