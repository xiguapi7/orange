package cloud.xiguapi.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 优惠券Eureka服务发现启动类
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 1:38
 * desc:
 */
@EnableEurekaServer
@SpringBootApplication
public class CouponEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponEurekaApplication.class, args);
    }
}
