
package open.cklan.com.library.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;
import open.cklan.com.library.model.image.ImageRespEntity;

public class NewsDetailEntity implements Serializable{

     @JSONField
    public NewsContentEntity entity;
}
