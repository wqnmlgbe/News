package open.cklan.com.library.annotations;

import android.support.annotation.StringDef;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_BEAUTY;
import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_CAR;
import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_ENTERTAINMENT;
import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_GAME;
import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_HISTORY;
import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_HOT;
import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_IMAGE;
import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_SPORTS;
import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_TECH;
import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_TOP;
import static open.cklan.com.library.annotations.CategoryType.CATEGORY_TYPE_VIDEO;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:09
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@StringDef(value = {
        CATEGORY_TYPE_TOP,
        CATEGORY_TYPE_HISTORY,
        CATEGORY_TYPE_CAR,
        CATEGORY_TYPE_ENTERTAINMENT,
        CATEGORY_TYPE_HOT,
        CATEGORY_TYPE_IMAGE,
        CATEGORY_TYPE_SPORTS,
        CATEGORY_TYPE_TECH,
        CATEGORY_TYPE_VIDEO,
        CATEGORY_TYPE_GAME,
        CATEGORY_TYPE_BEAUTY
})
public @interface CategoryType {
    String CATEGORY_TYPE_TOP="top";
    String CATEGORY_TYPE_HOT="hot";
    String CATEGORY_TYPE_IMAGE="image";
    String CATEGORY_TYPE_SPORTS="sports";
    String CATEGORY_TYPE_TECH="tech";
    String CATEGORY_TYPE_VIDEO="video";
    String CATEGORY_TYPE_CAR="car";
    String CATEGORY_TYPE_HISTORY="history";
    String CATEGORY_TYPE_GAME="game";
    String CATEGORY_TYPE_BEAUTY="beauty";
    String CATEGORY_TYPE_ENTERTAINMENT="entertainment";
}
