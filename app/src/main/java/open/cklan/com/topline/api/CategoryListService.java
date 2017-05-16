package open.cklan.com.topline.api;

import java.util.List;

import open.cklan.com.library.model.CategoryEntity;
import rx.Observable;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:01
 */
public interface CategoryListService {

    Observable<List<CategoryEntity>> categoryList();
}
