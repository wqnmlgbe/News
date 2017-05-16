
package open.cklan.com.library.model;

import com.alibaba.fastjson.annotation.JSONField;

public class NetEasyCategoryEntity {

    @JSONField(name = "ad_type")
    public Long mAdType;
    @JSONField(name = "alias")
    public String mAlias;
    @JSONField(name = "bannerOrder")
    public Long mBannerOrder;
    @JSONField(name = "cid")
    public String mCid;
    @JSONField(name = "color")
    public String mColor;
    @JSONField(name = "ename")
    public String mEname;
    @JSONField(name = "hasAD")
    public Long mHasAD;
    @JSONField(name = "hasCover")
    public Boolean mHasCover;
    @JSONField(name = "hasIcon")
    public Boolean mHasIcon;
    @JSONField(name = "hashead")
    public Long mHashead;
    @JSONField(name = "headLine")
    public Boolean mHeadLine;
    @JSONField(name = "img")
    public String mImg;
    @JSONField(name = "isHot")
    public Long mIsHot;
    @JSONField(name = "isNew")
    public Long mIsNew;
    @JSONField(name = "recommend")
    public String mRecommend;
    @JSONField(name = "recommendOrder")
    public Long mRecommendOrder;
    @JSONField(name = "showType")
    public String mShowType;
    @JSONField(name = "special")
    public Long mSpecial;
    @JSONField(name = "subnum")
    public String mSubnum;
    @JSONField(name = "template")
    public String mTemplate;
    @JSONField(name = "tid")
    public String mTid;
    @JSONField(name = "tname")
    public String mTname;
    @JSONField(name = "topicid")
    public String mTopicid;


    public String toString() {
        return "NetEasyCategoryEntity{" +
                "mTname='" + mTname + '\'' +
                '}';
    }
}
