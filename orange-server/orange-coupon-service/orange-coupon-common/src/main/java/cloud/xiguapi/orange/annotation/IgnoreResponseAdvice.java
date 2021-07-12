package cloud.xiguapi.orange.annotation;

import java.lang.annotation.*;

/**
 * 忽略通用响应注解
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 12:46
 * desc:
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreResponseAdvice {

    String value();
}
