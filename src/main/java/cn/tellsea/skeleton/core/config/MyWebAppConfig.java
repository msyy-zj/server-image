package cn.tellsea.skeleton.core.config;

import cn.tellsea.skeleton.core.consts.FilePathConst;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源映射路径
 *
 * @author Tellsea
 * @Description Created on 2019/7/20
 */
@Configuration
public class MyWebAppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:" + FilePathConst.BASE_LOCATION);
    }
}