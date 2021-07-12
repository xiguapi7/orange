package cloud.xiguapi.orange.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * Jackson 自定义配置
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 12:39
 * desc:
 */
@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // 定义JSON日期格式
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return mapper;
    }
}
