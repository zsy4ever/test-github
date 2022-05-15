package com.zsl.homestay.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 创建时间：2021年7月27日
 * 类说明：将物理磁盘文件存放的绝对路径映射为一个虚拟路径，就可以通过SpringBoot服务来访问文件了
 *
 * @author liubaohuan
 * @since JDK 1.8.0_51
 */
@Configuration
public class ResourceConfigAdapter extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
            registry.addResourceHandler("/upload/**").
                    addResourceLocations("file:D:/uploadBaseDir/upload/");
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/static/");
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        } else {//linux和mac系统
            registry.addResourceHandler("/upload/**").
                    addResourceLocations("file:/uploadBaseDir/upload/");
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/static/");
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
        super.addResourceHandlers(registry);
    }
}
