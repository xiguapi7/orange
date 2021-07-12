package cloud.xiguapi.orange.advice;

import cloud.xiguapi.orange.annotation.IgnoreResponseAdvice;
import cloud.xiguapi.orange.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 通用响应
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 12:48
 * desc:
 */
@RestControllerAdvice
public class CommonResponseAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否需要对响应进行处理
     *
     * @param returnType    当前Controller方法的定义
     * @param converterType 消息转换器类型
     * @return 是否需要处理
     */
    @SuppressWarnings("all")
    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {

        // 如果当前方法所在类标记了 @IgnoreResponseAdvice 则不需要处理; 否则进行通用响应增强
        if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        // 如果当前方法标记了 @IgnoreResponseAdvice 则不需要处理; 否则进行通用响应增强
        if (returnType.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        // 返回true则会执行 beforeBodyWrite 方法
        return true;
    }

    /**
     * 响应返回前的处理
     */
    @SuppressWarnings("all")
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        // 定义最终的返回对象
        CommonResponse<Object> resp = new CommonResponse<>(0, "");

        if (null == body) {
            // 判断body参数, 如果为空则无需设置CommonResponse的data属性
            return resp;
        } else if (body instanceof CommonResponse) {
            // 如果body参数已是CommonResponse类型则无需再次处理
            resp = (CommonResponse<Object>) body;
            return resp;
        } else {
            // 否则将 body参数作为CommonResponse的data
            resp.setData(body);
            return resp;
        }
    }
}
