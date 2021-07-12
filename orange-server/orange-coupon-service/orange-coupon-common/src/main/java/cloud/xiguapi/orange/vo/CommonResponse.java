package cloud.xiguapi.orange.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用响应对象
 *
 * @author 大大大西西瓜皮🍉
 * date: 2021/7/12 12:44
 * desc:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResponse<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
