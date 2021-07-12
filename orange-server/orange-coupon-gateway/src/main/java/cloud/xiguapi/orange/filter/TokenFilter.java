package cloud.xiguapi.orange.filter;

import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Token过滤器
 * 校验请求中传递的 Token
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 11:51
 * desc:
 */
@Component
@Slf4j
public class TokenFilter extends AbstractPreZuulFilter {

    @Override
    protected Object customRun() throws ZuulException {
        HttpServletRequest request = ctx.getRequest();
        log.info("{} request to {}", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("token");
        if (null == token || StringUtils.isEmpty(token)) {
            // 不存在token
            log.error("token is empty");
            return fail(401, "error: token is empty");
        }

        // TODO token校验规则

        return success();
    }

    @Override
    public int filterOrder() {
        // 数字越小, 过滤器的优先级越高, 此处使用1, 在校验token前可能会有其他过滤器
        return 1;
    }
}
