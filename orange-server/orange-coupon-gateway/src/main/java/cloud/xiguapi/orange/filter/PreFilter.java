package cloud.xiguapi.orange.filter;

import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 定义Pre过滤器, 在过滤器中存储客户端发起请求的时间戳等信息
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 12:05
 * desc:
 */
@Component
@Slf4j
public class PreFilter extends AbstractPreZuulFilter {

    @Override
    protected Object customRun() throws ZuulException {
        // 记录请求的时间戳
        ctx.set("startTime", System.currentTimeMillis());
        return success();
    }

    @Override
    public int filterOrder() {
        // 设置最高优先级, 在请求进来时设置
        return 0;
    }
}
