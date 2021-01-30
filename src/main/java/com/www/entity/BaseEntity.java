package com.www.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author www
 * @creat 2021/1/28
 */
@Data
public class BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Date created;
    private Date modified;
}
