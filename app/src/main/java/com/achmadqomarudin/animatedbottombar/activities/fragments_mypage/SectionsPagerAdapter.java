package com.achmadqomarudin.animatedbottombar.activities.fragments_mypage;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.fragments_mypage.MypageFragment_frag1;
import com.achmadqomarudin.animatedbottombar.activities.fragments_mypage.MypageFragment_frag2;
import com.achmadqomarudin.animatedbottombar.activities.fragments_mypage.MypageFragment_frag3;
import com.achmadqomarudin.animatedbottombar.fragments.MypageFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final MypageFragment mContext;

    public SectionsPagerAdapter(MypageFragment context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MypageFragment_frag1 mypagefragment_frag1 = new MypageFragment_frag1();
                return mypagefragment_frag1;
            case 1:
                MypageFragment_frag2 mypagefragment_frag2 = new MypageFragment_frag2();
                return mypagefragment_frag2;
            case 2:
                MypageFragment_frag3 mypagefragment_frag3 = new MypageFragment_frag3();
                return mypagefragment_frag3;

            default:
                MypageFragment_frag_ mypagefragment_frag_ = new MypageFragment_frag_();
                return mypagefragment_frag_;

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