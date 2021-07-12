package cloud.xiguapi.orange.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 限流过滤器
 * 限流规则基于Guava的限流工具类(令牌桶算法)
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 12:00
 * desc:
 */
@Component
@Slf4j
@SuppressWarnings("all")
public class RateLimiterFilter extends AbstractPreZuulFilter {

    /**
     * 限流过滤器, 每s可获取2个令牌
     */
    private RateLimiter limiter = RateLimiter.create(2.0);

    @Override
    protected Object customRun() throws ZuulException {
        HttpServletRequest request = ctx.getRequest();

        if (limiter.tryAcquire()) {
            log.info("get rate token sucess");
            return success();
        } else {
            log.error("rate limit: {}", request.getRequestURI());
            return fail(402, "error: rate limit");
        }
    }

    @Override
    public int filterOrder() {
        return 2;
    }
}
