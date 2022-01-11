package com.example.springbootchatroom.code.service;

import com.example.springbootchatroom.code.entity.po.Image;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 图片表 服务类
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
public interface IImageService extends IService<Image> {
    /**
     * 添加图片
     * @param imageId 图片编号
     * @param imageName 图片名
     * @param imagePath 图片路径
     * @return java.lang.Boolean
     */
    public Boolean addImage(String imageId,String imageName,String imagePath);

    /**
     * 删除图片
     * @param imageId 图片编号
     * @return java.lang.Boolean
     */
    public Boolean deleteImage(String imageId);

    /**
     * 修改图片
     * @param imageId 图片编号
     * @param imageName 图片名
     * @param imagePath 图片路径
     * @return java.lang.Boolean
     */
    public Boolean updateImage(String imageId,String imageName,String imagePath);

    /**
     * 分页列出全部图片
     * @param start 开始位置
     * @param size 获取的图片数量
     * @return java.util.List
     */
    public List<Image> listDeleteImage(Integer start,Integer size);
}
