package com.example.viewpagertabindicator;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TabPageIndicator;

/***
 * 
 * 
 * @author zq
 *
 */
public class MainActivity extends FragmentActivity {
    private static final String[] CONTENT = new String[] { "推荐", "热点", "视频", "本地", "科技", "健康" };

    private List<Fragment> list=new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentPagerAdapter adapter = new GoogleMusicAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }

    class GoogleMusicAdapter extends FragmentPagerAdapter {
        public GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
            list.add(new TestFragment(CONTENT[0]));
            list.add(new TestFragment(CONTENT[1]));
            list.add(new TestFragment(CONTENT[2]));
            list.add(new TestFragment(CONTENT[3]));
            list.add(new TestFragment(CONTENT[4]));
            list.add(new TestFragment(CONTENT[5]));
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override
        public int getCount() {
            return CONTENT.length;
        }
    }
}
