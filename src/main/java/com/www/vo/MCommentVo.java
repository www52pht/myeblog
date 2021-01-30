package com.www.vo;

import com.www.entity.MComment;
import lombok.Data;

/**
 * @author www
 * @creat 2021/1/29
 */
@Data
public class MCommentVo extends MComment {
    private Long authorId;
    private String authorName;
    private String authorAvatar;

}
