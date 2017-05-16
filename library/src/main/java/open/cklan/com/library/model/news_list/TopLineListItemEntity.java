
package open.cklan.com.library.model.news_list;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

import open.cklan.com.library.model.common.ImgExtra;

public class TopLineListItemEntity extends BaseListItemEntity{

    public int adtype;
    public String boardid;
    public int clkNum;
    public int danmu;
    public String digest;
    public String docid;
    public int downTimes;
    public int hasHead;
    public String id;
    public String img;
    public int imgType;
    public String imgsrc;
    public int imgsum;
    public String interest;
    public String lmodify;
    public int picCount;
    public String program;
    public String prompt;
    public String ptime;
    public int recNews;
    public String recReason;
    public String recSource;
    public int recType;
    public String recprog;
    public int refreshPrompt;
    public int replyCount;
    public String replyid;
    public String source;
    public String template;
    public String title;
    public int upTimes;
    public List<ImgExtra> imgextra;

}
