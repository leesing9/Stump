package com.achmadqomarudin.animatedbottombar.activities.fragments_questexam1;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.QuestActivity_exam1;
import com.achmadqomarudin.animatedbottombar.activities.fragments_questsearch.SearchFragment_frag1;
import com.achmadqomarudin.animatedbottombar.activities.fragments_questsearch.SearchFragment_frag2;
import com.achmadqomarudin.animatedbottombar.activities.fragments_questsearch.SearchFragment_frag3;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter_quest_exam1 extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_questexam1_1, R.string.tab_questexam1_2, R.string.tab_questexam1_3};
    private final QuestActivity_exam1 mContext;

    public SectionsPagerAdapter_quest_exam1(QuestActivity_exam1 context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                QuestFragment_exam1_frag1 questfragment_exam1_frag1 = new QuestFragment_exam1_frag1();
                return questfragment_exam1_frag1;
            case 1:
                QuestFragment_exam1_frag2 questfragment_exam1_frag2 = new QuestFragment_exam1_frag2();
                return questfragment_exam1_frag2;
            case 2:
                QuestFragment_exam1_frag3 questfragment_exam1_frag3 = new QuestFragment_exam1_frag3();
                return questfragment_exam1_frag3;
            default:
                QuestFragment_exam1_frag_ questfragment_exam1_frag_ = new QuestFragment_exam1_frag_();
                return questfragment_exam1_frag_;

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