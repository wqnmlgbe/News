package open.cklan.com.library.model.news_list;

import java.io.Serializable;
import java.util.List;

/**
 * AUTHOR：lanchuanke on 17/5/9 11:23
 */
public class GameListItemEntity extends BaseListItemEntity {
    public String postid;
    public String region;
    public boolean hasCover;
    public int hasHead;
    public int replyCount;
    public String interests;
    public String ltitle;
    public int hasImg;
    public String digest;
    public boolean hasIcon;
    public String dkeys;
    public String ipadcomment;
    public String docid;
    public String title;
    public int order;
    public List<WapPluginfo> wap_pluginfo;
    public int priority;
    public String lmodify;
    public String boardid;
    public List<WapPortal> wap_portal;
    public String topic_background;
    public String template;
    public String url_3w;
    public int votecount;
    public String alias;
    public String cid;
    public String professional;
    public String url;
    public List<String> editor;
    public int hasAD;
    public String source;
    public int imgType;
    public String ename;
    public String tname;
    public String subtitle;
    public String imgsrc;
    public String ptime;
    public String prompt;

    public static class WapPluginfo {

        public String title;
        public String imgsrc;
        public String subtitle;
        public String url;
    }

    public static class WapPortal {

        public String title;
        public String subtitle;
        public String imgsrc;
        public String url;
    }
}
