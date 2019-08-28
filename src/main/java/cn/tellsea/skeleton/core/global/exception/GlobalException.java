package cn.tellsea.skeleton.core.global.exception;

import cn.tellsea.skeleton.core.global.enums.BaseEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 全局异常
 *
 * @author Tellsea
 * @Description Created on 2019/7/13
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException {

    private BaseEnums baseEnums;
}
