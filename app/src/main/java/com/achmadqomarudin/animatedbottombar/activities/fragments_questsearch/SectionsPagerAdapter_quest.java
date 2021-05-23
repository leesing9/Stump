package com.achmadqomarudin.animatedbottombar.activities.fragments_questsearch;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.fragments.MypageFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter_quest extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_questsearch_1, R.string.tab_questsearch_2, R.string.tab_questsearch_3};
    private final SearchquestActivity mContext;

    public SectionsPagerAdapter_quest(SearchquestActivity context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SearchFragment_frag1 searchfragment_frag1 = new SearchFragment_frag1();
                return searchfragment_frag1;
            case 1:
                SearchFragment_frag2 searchfragment_frag2 = new SearchFragment_frag2();
                return searchfragment_frag2;
            case 2:
                SearchFragment_frag3 searchfragment_frag3 = new SearchFragment_frag3();
                return searchfragment_frag3;
            default:
                SearchFragment_frag_ searchfragment_frag_ = new SearchFragment_frag_();
                return searchfragment_frag_;

        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}