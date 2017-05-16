package open.cklan.com.library.model;

import java.io.Serializable;

import open.cklan.com.library.model.base.BaseMultiItem;

/**
 * AUTHOR：lanchuanke on 17/5/15 11:03
 */
public class NewsContentParserEntity extends BaseMultiItem implements Serializable {
    public static final int TYPE_TEXT=1;
    public static final int TYPE_IMG=2;
    public static final int TYPE_VIDEO=3;
    public static final int TYPE_COMMENT=4;

    public String body;

    public NewsContentParserEntity(String body) {
        this.body = body;
    }
}
