package cloud.xiguapi.orange.exception;

/**
 * 优惠券系统通用异常
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 15:31
 * desc:
 */
public class CouponException extends RuntimeException {

    public CouponException(String message) {
        super(message);
    }
}
