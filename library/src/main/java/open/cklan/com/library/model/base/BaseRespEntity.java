package open.cklan.com.library.model.base;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * AUTHOR：lanchuanke on 17/5/3 20:35
 */
public class BaseRespEntity<T> extends BaseResp {

    @JSONField(name = "data")
    public T data;
}
