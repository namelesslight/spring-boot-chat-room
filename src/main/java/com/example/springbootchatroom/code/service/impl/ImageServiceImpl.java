package com.example.springbootchatroom.code.service.impl;

import com.example.springbootchatroom.code.entity.po.Image;
import com.example.springbootchatroom.code.mapper.ImageMapper;
import com.example.springbootchatroom.code.service.IImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private ImageMapper imageMapper;

    /**
     * 添加图片
     * @param imageId 图片编号
     * @param imageName 图片名
     * @param imagePath 图片路径
     * @return java.lang.Boolean
     */
    @Override
    public Boolean addImage(String imageId, String imageName, String imagePath) {
        return imageMapper.addImage(imageId, imageName, imagePath) == 1;
    }

    /**
     * 删除图片
     * @param imageId 图片编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteImage(String imageId) {
        return imageMapper.deleteImage(imageId) == 1;
    }

    /**
     * 修改图片
     * @param imageId 图片编号
     * @param imageName 图片名
     * @param imagePath 图片路径
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateImage(String imageId, String imageName, String imagePath) {
        return imageMapper.updateImage(imageId, imageName, imagePath) == 1;
    }

    /**
     * 分页获取图片
     * @param start 开始位置
     * @param size 获取的图片数量
     * @return java.util.List
     */
    @Override
    public List<Image> listDeleteImage(Integer start, Integer size) {
        return imageMapper.listDeleteImage(start, size);
    }


}
