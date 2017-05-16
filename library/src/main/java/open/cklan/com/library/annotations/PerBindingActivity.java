package open.cklan.com.library.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * AUTHOR：lanchuanke on 17/5/3 22:10
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerBindingActivity {
}
