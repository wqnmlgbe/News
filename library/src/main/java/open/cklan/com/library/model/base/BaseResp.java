package open.cklan.com.library.model.base;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * AUTHOR：lanchuanke on 17/5/3 20:31
 */
public class BaseResp implements Serializable {

    @JSONField(name = "has_more")
    public boolean hasMore;

    @JSONField(name = "message")
    public String message;
}
