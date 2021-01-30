package com.www.vo;

import com.www.entity.MPost;
import lombok.Data;

/**
 * @author www
 * @creat 2021/1/28
 */
@Data
public class MPostVo extends MPost {
    private Long authorId;
    private String authorName;
    private String authorAvatar;

    private String categoryName;


}
