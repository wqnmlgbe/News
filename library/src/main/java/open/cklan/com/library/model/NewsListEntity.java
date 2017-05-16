package open.cklan.com.library.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * AUTHOR：lanchuanke on 17/5/7 18:03
 */
public class NewsListEntity<T> implements Serializable {
    @JSONField
    public List<T> entities;

}
