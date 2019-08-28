package cn.tellsea.server.image.controller;

import cn.tellsea.skeleton.core.global.dto.ResponseResult;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import cn.tellsea.skeleton.core.util.UploadUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 文件上传控制器
 *
 * @author Tellsea
 * @Description Created on 2019/8/20
 */
@Controller
public class FileUploadController {

    @GetMapping("")
    public String index() {
        return "index";
    }

    /**
     * 文件上传
     *
     * @param request
     * @return
     */
    @PostMapping("upload")
    @ResponseBody
    public ResponseResult upload(HttpServletRequest request,
                                 @RequestParam(value = "folder", defaultValue = "default") String folder) {
        List<MultipartFile> list = ((MultipartHttpServletRequest) request).getFiles("file");
        String url = null;
        if (!CollectionUtils.isEmpty(list)) {
            url = UploadUtils.uploadFile(list, folder);
        }
        if (StringUtils.isEmpty(url)) {
            System.out.println("上传后的路径为空");
            return ResponseResult.build(StatusEnums.UPLOAD_ERROR);
        }
        return ResponseResult.build(StatusEnums.OK, url);
    }

    /**
     * 文件上传
     *
     * @param request
     * @return
     */
    @PostMapping("uploadFileThumbnail")
    @ResponseBody
    public ResponseResult uploadFileThumbnail(HttpServletRequest request,
                                              @RequestParam(value = "folder", defaultValue = "default") String folder) {
        List<MultipartFile> list = ((MultipartHttpServletRequest) request).getFiles("file");
        String url = null;
        if (!CollectionUtils.isEmpty(list)) {
            url = UploadUtils.uploadFileThumbnail(list, folder);
        }
        if (StringUtils.isEmpty(url)) {
            System.out.println("上传后的路径为空");
            return ResponseResult.build(StatusEnums.UPLOAD_ERROR);
        }
        return ResponseResult.build(StatusEnums.OK, url);
    }
}