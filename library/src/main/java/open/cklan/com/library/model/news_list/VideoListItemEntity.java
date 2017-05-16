package open.cklan.com.library.model.news_list;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * AUTHOR：lanchuanke on 17/5/9 11:23
 */
public class VideoListItemEntity extends BaseListItemEntity {
    public String cover;
    public int danmu;
    public String description;
    public int length;
    public String m3u8_url;
    public String mp4_url;
    public int playCount;
    public int playersize;
    public String program;
    public String prompt;
    public String ptime;
    public String replyBoard;
    public int replyCount;
    public String replyid;
    public String sectiontitle;
    public int sizeHD;
    public int sizeSD;
    public int sizeSHD;
    public String title;
    public String topicDesc;
    public String topicImg;
    public String topicName;
    public String topicSid;
    public String vid;
    public Videotopic videoTopic;
    public String videosource;

    public static class Videotopic implements Serializable{
        public String alias;
        public String ename;
        public String tid;
        public String tname;
        public String topic_icons;
    }
}
