package open.cklan.com.library.widget.refresh.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import open.cklan.com.library.widget.refresh.adapter.BaseAdapter;

/**
 * AUTHOR：lanchuanke on 17/5/12 11:39
 */
public class AlphaAnimation implements BaseAdapter.BaseAnimation {

    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view,"alpha",0.0f,1.0f)};
    }
}
