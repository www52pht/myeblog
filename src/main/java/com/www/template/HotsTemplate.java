package com.www.template;

import com.www.common.templates.DirectiveHandler;
import com.www.common.templates.TemplateDirective;
import com.www.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author www
 * @version 1.0
 * @create 2021/2/18 17:01
 */
//本周热议
@Component
public class HotsTemplate extends TemplateDirective {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public String getName() {
        return "hots";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {

        String weekRankKey = "week:rank";

        Set<ZSetOperations.TypedTuple> typedTuples = redisUtil.getZSetRank(weekRankKey, 0, 6);

        ArrayList<Map> hotPosts = new ArrayList<>();

        for (ZSetOperations.TypedTuple typedTuple : typedTuples) {
            Map<String, Object> map = new HashMap<>();

            Object value = typedTuple.getValue(); //post的id

            String postKey = "rank:post:" + value;

            map.put("id", value);
            map.put("title", redisUtil.hget(postKey, "post:title")); //初始化就有了，如果新评论了将会有缓存记录
            map.put("commentCount", typedTuple.getScore());

            hotPosts.add(map);
        }

        handler.put(RESULTS, hotPosts).render();
    }
}
