package open.cklan.com.library.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * AUTHOR：lanchuanke on 17/5/7 16:54
 */
public class NetEasyCategoryListEntity implements Serializable {
    @JSONField(name ="tList")
    public List<NetEasyCategoryEntity> categoryEntities;

}
