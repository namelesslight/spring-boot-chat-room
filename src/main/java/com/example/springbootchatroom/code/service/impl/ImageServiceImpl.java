package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.Image;
import com.example.springbootchatroom.code.mapper.ImageMapper;
import com.example.springbootchatroom.code.service.IImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图片表 服务实现类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements IImageService {

}
