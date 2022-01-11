package com.example.springbootchatroom.code.mapper;

import com.example.springbootchatroom.code.entity.po.Image;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 图片表 Mapper 接口
 * </p>
 *
 * @author zcl
 * @since 2022-01-08
 */
@Repository
public interface ImageMapper extends BaseMapper<Image> {

    /**
     * 添加图片
     * @param imageId 图片编号
     * @param imageName 图片名
     * @param imagePath 图片路径
     * @return java.lang.Integer
     */
    public Integer addImage(String imageId,String imageName,String imagePath);

    /**
     * 删除图片
     * @param imageId 图片编号
     * @return java.lang.Integer
     */
    public Integer deleteImage(String imageId);

    /**
     * 修改图片
     * @param imageId 图片编号
     * @param imageName 图片名
     * @param imagePath 图片路径
     * @return java.lang.Integer
     */
    public Integer updateImage(String imageId,String imageName,String imagePath);

    /**
     * 列出全部已删除图片
     * @param start 开始位置
     * @param size 获取的图片数量
     * @return java.util.List
     */
    public List<Image> listDeleteImage(Integer start, Integer size);
}
