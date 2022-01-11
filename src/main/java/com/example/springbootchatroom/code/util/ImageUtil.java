package com.example.springbootchatroom.code.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {
    /**
     * 活动图片编号
     * @param path 图片路径
     * @return 图片编号
     */
    public static Integer FileNum(String path){
        int sum=1;
        File searchFile=new File(path);
        for (File f: searchFile.listFiles()) {
            if (f.isFile()&&f.getName().contains(".jpg")) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 返回图片路径
     * @param path 图片路径
     * @return 返回所有图片的路径信息
     */
    public static String[] FileImgPath(String path){
        File searchFile=new File(path);
        File[] files=searchFile.listFiles();
        String[] filePaths=new String[files.length];
        for (int i=0;i<filePaths.length;i++) {
            filePaths[i]=files[i].getPath();
            System.out.println(files[i].getPath());
        }
        return filePaths;
    }

    /**
     * 下载图片
     * @param imageFile 图片文件
     * @param imagePath 图片下载到本地的路径
     * @param imageName 图片名
     * @throws IOException
     */
    public static void downloadImage(MultipartFile imageFile,String imagePath,String imageName) throws IOException {
        File imgFolder=new File(imagePath);
        if (!imgFolder.exists())
            imgFolder.mkdir();
        InputStream fis=imageFile.getInputStream();
        File img = new File(imagePath+'/' + imageName +".jpg");
        FileOutputStream fos=new FileOutputStream(img);
        byte[] bytes=new byte[1024*8];
        int len;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
    }
}
