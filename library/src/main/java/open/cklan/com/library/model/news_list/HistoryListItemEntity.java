package open.cklan.com.library.model.news_list;

import java.io.Serializable;
import java.util.List;

import open.cklan.com.library.model.common.ImgExtra;

/**
 * AUTHOR：lanchuanke on 17/5/9 11:23
 */
public class HistoryListItemEntity extends BaseListItemEntity {
    public String postid;
    public boolean hasCover;
    public int hasHead;
    public int replyCount;
    public int hasImg;
    public String digest;
    public boolean hasIcon;
    public String docid;
    public String title;
    public int order;
    public int priority;
    public String lmodify;
    public String boardid;
    public String photosetID;
    public int imgsum;
    public String topic_background;
    public String template;
    public int votecount;
    public String skipID;
    public String alias;
    public String skipType;
    public String cid;
    public int hasAD;
    public List<ImgExtra> imgextra;
    public String source;
    public String ename;
    public String tname;
    public String imgsrc;
    public String ptime;

}
