package open.cklan.com.library.annotations;

import android.support.annotation.StringDef;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_BEAUTY;
import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_CAR;
import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_ENTERTAINMENT;
import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_GAME;
import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_HISTORY;
import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_HOT;
import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_IMAGE;
import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_SPORTS;
import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_TECH;
import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_TOP;
import static open.cklan.com.library.annotations.CategoryTid.CATEGORY_TID_VIDEO;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:09
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@StringDef(value = {
        CATEGORY_TID_TOP,
        CATEGORY_TID_HISTORY,
        CATEGORY_TID_CAR,
        CATEGORY_TID_ENTERTAINMENT,
        CATEGORY_TID_HOT,
        CATEGORY_TID_IMAGE,
        CATEGORY_TID_SPORTS,
        CATEGORY_TID_TECH,
        CATEGORY_TID_VIDEO,
        CATEGORY_TID_GAME,
        CATEGORY_TID_BEAUTY
})
public @interface CategoryTid {
    String CATEGORY_TID_TOP="T1348647909107";
    String CATEGORY_TID_HOT="T1427878984398";
    String CATEGORY_TID_IMAGE="T1419316384474";
    String CATEGORY_TID_SPORTS="T1348649079062";
    String CATEGORY_TID_TECH="T1348649580692";
    String CATEGORY_TID_VIDEO="T1457068979049";
    String CATEGORY_TID_CAR="T1348654060988";
    String CATEGORY_TID_HISTORY="T1368497029546";
    String CATEGORY_TID_GAME="T1348654151579";
    String CATEGORY_TID_BEAUTY="T1456112189138";
    String CATEGORY_TID_ENTERTAINMENT="T1348648517839";
}
