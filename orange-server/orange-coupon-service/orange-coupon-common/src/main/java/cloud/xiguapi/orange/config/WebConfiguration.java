package cloud.xiguapi.orange.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 定制HTTP消息转换器
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 12:35
 * desc:
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        // 指定消息转换器为Jackson, 不需要Spring Boot为我们选择
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
