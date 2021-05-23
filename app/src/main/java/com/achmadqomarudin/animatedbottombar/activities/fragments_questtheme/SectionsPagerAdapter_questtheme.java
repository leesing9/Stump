package com.achmadqomarudin.animatedbottombar.activities.fragments_questtheme;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.achmadqomarudin.animatedbottombar.fragments.QuestFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter_questtheme extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{
            R.drawable.quest_icon1
            ,R.drawable.quest_icon2
            ,R.drawable.quest_icon3
            ,R.drawable.quest_icon4
            ,R.drawable.quest_icon5
            ,R.drawable.quest_icon6
            ,R.drawable.quest_icon7
            ,R.drawable.quest_icon8
            ,R.drawable.quest_icon9};
    private final QuestFragment mContext;

    public SectionsPagerAdapter_questtheme(QuestFragment context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment_quest_frag1 fragment_quest_frag1 = new Fragment_quest_frag1();
                return fragment_quest_frag1;
            case 1:
                Fragment_quest_frag2 fragment_quest_frag2 = new Fragment_quest_frag2();
                return fragment_quest_frag2;
            case 2:
                Fragment_quest_frag3 fragment_quest_frag3 = new Fragment_quest_frag3();
                return fragment_quest_frag3;

            case 3:
                Fragment_quest_frag4 fragment_quest_frag4 = new  Fragment_quest_frag4();
                return fragment_quest_frag4;
            case 4:
                Fragment_quest_frag5 fragment_quest_frag5 = new  Fragment_quest_frag5();
                return fragment_quest_frag5;
            case 5:
                Fragment_quest_frag6 fragment_quest_frag6 = new Fragment_quest_frag6();
                return fragment_quest_frag6;
            case 6:
                Fragment_quest_frag7 fragment_quest_frag7 = new Fragment_quest_frag7();
                return fragment_quest_frag7;
            case 7:
                Fragment_quest_frag8 fragment_quest_frag8 = new Fragment_quest_frag8();
                return fragment_quest_frag8;
            case 8:
                Fragment_quest_frag9 fragment_quest_frag9 = new Fragment_quest_frag9();
                return fragment_quest_frag9;
            default:
                Fragment_quest_frag_ fragment_quest_frag_ = new Fragment_quest_frag_();
                return fragment_quest_frag_;

        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
    Drawable image = mContext.getResources().getDrawable(TAB_TITLES[position]);
    image.setBounds(0, 0, image.getIntrinsicWidth()/3, image.getIntrinsicHeight()/3);
    SpannableString sb = new SpannableString("  ");
    ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
    sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    return sb;
    }
    @Override
    public int getCount() {
        // Show 2 total pages.
        return 9;
    }

}