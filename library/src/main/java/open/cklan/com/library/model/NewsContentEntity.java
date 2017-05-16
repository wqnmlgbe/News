package open.cklan.com.library.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * AUTHOR：lanchuanke on 17/5/5 14:08
 */
public class NewsContentEntity implements Serializable {
    public String body;
    public List<ImgEntity> img;

    public static class ImgEntity implements Serializable{
        public String ref;
        public String pixel;
        public String alt;
        public String src;
    }
}
