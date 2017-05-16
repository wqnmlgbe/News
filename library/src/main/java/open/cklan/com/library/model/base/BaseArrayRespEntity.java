package open.cklan.com.library.model.base;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * AUTHOR：lanchuanke on 17/5/3 20:36
 */
public class BaseArrayRespEntity<T> extends BaseResp {
    @JSONField(name = "data")
    public List<T> data;
}
