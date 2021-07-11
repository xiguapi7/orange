package cloud.xiguapi.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 优惠券网关应用
 * <p>
 * {@code @EnableZuulProxy} 表示当前应用为Zuul网关服务器
 * {@code @SpringCloudApplication} 组合注解,
 * SpringCloudApplication = SpringBootApplication + Eureka Client + Circuit Client
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 4:05
 * desc:
 */
@EnableZuulProxy
@SpringCloudApplication
public class CouponGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponGatewayApplication.class, args);
    }
}
