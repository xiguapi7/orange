package cloud.xiguapi.orange.advice;

import cloud.xiguapi.orange.exception.CouponException;
import cloud.xiguapi.orange.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 15:32
 * desc:
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    /**
     * 对 CouponException 异常拦截
     */
    @ExceptionHandler(value = CouponException.class)
    public CommonResponse<String> handlerCouponException(HttpServletRequest request, CouponException e) {
        CommonResponse<String> resp = new CommonResponse<>(-1, "business error");
        resp.setData(e.getMessage());
        log.error("异常处理信息: {}", resp);
        return resp;
    }
}
