package cn.tellsea.skeleton.core.global.enums;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * 异常枚举类
 *
 * @author Tellsea
 * @Description Created on 2019/7/13
 */
@AllArgsConstructor
public enum StatusEnums implements BaseEnums {

    OK(200, "OK"),
    FILE_NOT_NULL(404, "文件不能为空"),
    UPLOAD_ERROR(500, "上传错误"),
    SERVER_ERROR(500, "服务器累了，休息一会吧!"),
    ;

    @Setter
    private int code;

    @Setter
    private String info;


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getInfo() {
        return info;
    }
}
