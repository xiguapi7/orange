package cloud.xiguapi.orange.filter;

import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 访问日志过滤器类
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 12:10
 * desc:
 */
@Component
@Slf4j
public class AccessLogFilter extends AbstractPostZuulFilter {

    @Override
    protected Object customRun() throws ZuulException {
        HttpServletRequest request = ctx.getRequest();

        // 获取时间戳、URI、处理间隔
        Long startTime = (Long) ctx.get("startTime");
        String uri = request.getRequestURI();
        long duration = System.currentTimeMillis() - startTime;

        // 从网关通过的请求都记录日志: uri + duration
        log.info("uri: {}, duration: {}", uri, duration);

        return success();
    }

    @Override
    public int filterOrder() {
        // 在响应返回前执行该过滤器
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }
}
