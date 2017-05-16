package open.cklan.com.topline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import open.cklan.com.topline.ui.fragment.base.BaseNewsListFragment;

/**
 * AUTHOR：lanchuanke on 17/5/4 15:25
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public MainFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList==null?0:fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        BaseNewsListFragment fragment= (BaseNewsListFragment) fragmentList.get(position);
        return fragment.getTitle();
    }
}
