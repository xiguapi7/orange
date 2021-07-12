package cloud.xiguapi.orange.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * Zuul Pre生命周期的自定义过滤器抽象类
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 11:48
 * desc:
 */
public abstract class AbstractPreZuulFilter extends AbstractZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
}
