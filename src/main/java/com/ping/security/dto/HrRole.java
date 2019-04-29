package com.ping.security.dto;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("hr_role")
@Data
public class HrRole implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long hrid;

    private Long rid;
}
