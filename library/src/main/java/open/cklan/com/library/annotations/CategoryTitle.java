package open.cklan.com.library.annotations;

import android.support.annotation.StringDef;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_BEAUTY;
import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_CAR;
import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_ENTERTAINMENT;
import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_GAME;
import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_HISTORY;
import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_HOT;
import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_IMAGE;
import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_SPORTS;
import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_TECH;
import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_TOP;
import static open.cklan.com.library.annotations.CategoryTitle.CATEGORY_TITLE_VIDEO;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:09
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@StringDef(value = {
        CATEGORY_TITLE_TOP,
        CATEGORY_TITLE_HISTORY,
        CATEGORY_TITLE_CAR,
        CATEGORY_TITLE_ENTERTAINMENT,
        CATEGORY_TITLE_HOT,
        CATEGORY_TITLE_IMAGE,
        CATEGORY_TITLE_SPORTS,
        CATEGORY_TITLE_TECH,
        CATEGORY_TITLE_VIDEO,
        CATEGORY_TITLE_GAME,
        CATEGORY_TITLE_BEAUTY
})
public @interface CategoryTitle {
    String CATEGORY_TITLE_TOP="头条";
    String CATEGORY_TITLE_HOT="热点";
    String CATEGORY_TITLE_IMAGE="图片";
    String CATEGORY_TITLE_SPORTS="体育";
    String CATEGORY_TITLE_TECH="科技";
    String CATEGORY_TITLE_VIDEO="视频";
    String CATEGORY_TITLE_CAR="汽车";
    String CATEGORY_TITLE_HISTORY="历史";
    String CATEGORY_TITLE_GAME="游戏";
    String CATEGORY_TITLE_BEAUTY="美女";
    String CATEGORY_TITLE_ENTERTAINMENT="娱乐";
}
