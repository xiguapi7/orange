package cloud.xiguapi.orange.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 自定义过滤器的抽象过滤类
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 11:34
 * desc:
 */
public abstract class AbstractZuulFilter extends ZuulFilter {

    /**
     * 表示下一个过滤器
     */
    private static final String NEXT = "next";
    /**
     * RequestContext用于在过滤器之间传递消息, 数据保存在每个请求的 ThreadLocal 中
     * RequestContext扩展了ConcurrentHashMap, 具备ConcurrentHashMap的功能
     */
    protected RequestContext ctx;

    @Override
    public boolean shouldFilter() {
        // 获取到当前请求的Request Context
        ctx = RequestContext.getCurrentContext();
        return (boolean) ctx.getOrDefault(NEXT, true);
    }

    @Override
    public Object run() throws ZuulException {
        ctx = RequestContext.getCurrentContext();
        return customRun();
    }

    /**
     * 真正的run方法实现, 即过滤器的处理逻辑
     *
     * @return 操作结果
     * @throws ZuulException Zuul网关异常
     */
    protected abstract Object customRun() throws ZuulException;

    protected Object fail(int code, String message) {
        ctx.set(NEXT, false);
        ctx.setSendZuulResponse(false);
        ctx.getResponse().setContentType("text/html;charset=UTF-8");
        ctx.setResponseStatusCode(code);
        ctx.setResponseBody(String.format("{\"result\": \"%s!\"}", message));

        return null;
    }

    protected Object success() {
        ctx.set(NEXT, true);
        return null;
    }
}
