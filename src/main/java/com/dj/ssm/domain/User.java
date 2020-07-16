package com.dj.ssm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户
 */
@Data
@TableName("user") // 实体类对应数据库表名
public class User {
    //....
    @TableId(type = IdType.AUTO)// 主键策略
    private Integer id;
    @TableField("user_name")
    private String userName;
    @TableField("user_pwd")
    private String userPwd;
    @TableField("is_del")
   private Integer isDel;
}
