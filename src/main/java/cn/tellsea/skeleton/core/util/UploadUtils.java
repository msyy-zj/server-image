package cn.tellsea.skeleton.core.util;

import cn.tellsea.skeleton.core.consts.FilePathConst;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import cn.tellsea.skeleton.core.global.exception.GlobalException;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 文件上传工具类
 *
 * @author Tellsea
 * @Description Created on 2019/8/20
 */
public class UploadUtils {

    /**
     * 上传图片后返回文件名称用于存储数据库
     *
     * @param file
     * @param folderName
     * @return
     */
    public static String uploadFile(List<MultipartFile> files, String folderName) {
        folderName = "/" + folderName;
        int index = 0;
        StringBuffer sb = new StringBuffer();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                throw new GlobalException(StatusEnums.FILE_NOT_NULL);
            }
            try {
                // 文件名
                String fileName = createFileName();
                // 后缀
                String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                // 完整文件名
                String destFile = FilePathConst.BASE_LOCATION.concat(folderName);
                File f = new File(destFile);
                if (!f.exists() && !f.isDirectory()) {
                    f.mkdirs();
                }
                destFile = destFile.concat("/").concat(fileName).concat(fileType);
                byte[] bytes = file.getBytes();
                Path path = Paths.get(destFile);
                // 写入磁盘
                Files.write(path, bytes);
                sb.append(folderName.concat("/").concat(fileName).concat(fileType));
                index++;
                if (files.size() != index) {
                    sb.append(",");
                }
            } catch (IOException e) {
                System.out.println("图片上传失败");
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String uploadFileThumbnail(List<MultipartFile> files, String folderName) {
        int index = 0;
        folderName = "/" + folderName;
        StringBuffer sb = new StringBuffer();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                throw new GlobalException(StatusEnums.FILE_NOT_NULL);
            }
            try {
                String fileName = createFileName();
                String location = FilePathConst.BASE_LOCATION.concat(folderName);
                String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                File filedict = new File(location.concat("/"));
                if (!filedict.exists()) {
                    filedict.mkdirs();
                }
                File targetFile = new File(location + File.separator + fileName.concat(fileType));
                File newFile = new File(location.concat(File.separator).concat(fileName).concat("-thumbnail").concat(fileType));
                file.transferTo(targetFile);
                Thumbnails.of(targetFile)
                        // 指定图片大小    0-1f  1f是原图
                        .scale(0.5f)
                        // 图片质量  0-1f  1f是原图
                        .outputQuality(1f)
                        .toFile(newFile);
                sb.append(folderName.concat("/").concat(fileName).concat(fileType));
                index++;
                if (files.size() != index) {
                    sb.append(",");
                }
            } catch (Exception e) {
                System.out.println("图片压缩上传失败");
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 创建文件名
     *
     * @return
     */
    public static String createFileName() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).concat(RandomStringUtils.random(4, false, true));
    }
}