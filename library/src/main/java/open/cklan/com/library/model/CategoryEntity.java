package open.cklan.com.library.model;

import java.io.Serializable;

/**
 * AUTHOR：lanchuanke on 17/5/4 10:58
 */
public class CategoryEntity implements Serializable {
    public String title;
    public String type;
    public String tid;

    public CategoryEntity(String title,String type,String tid) {
        this.title = title;
        this.type=type;
        this.tid=tid;
    }
}
