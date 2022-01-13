package com.example.springbootchatroom.code.entity.vo;

import com.example.springbootchatroom.code.entity.po.Activity;
import com.example.springbootchatroom.code.entity.po.ActivityImage;
import com.example.springbootchatroom.code.entity.po.User;
import lombok.Data;

import java.util.List;

@Data
public class ActivityInfo {

    /**
     * 活动
     */
    private Activity activity;

    /**
     * 活动用户
     */
    private User user;

    /**
     * 活动图片
     */
    private List<ActivityImage> activityImage;

}
