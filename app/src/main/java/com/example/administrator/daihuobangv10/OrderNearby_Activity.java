package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wsj on 16/6/28.
 */
public class OrderNearby_Activity extends Activity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private LayoutInflater inflater;
    private List<String> titlelist = new ArrayList<>();
    private View view1,view2;
    private List<View> viewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_nearby);

        class MyPageAdapter extends PagerAdapter {
            private List<View> viewList;

            public MyPageAdapter(List<View> viewList) {
                this.viewList = viewList;
            }

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titlelist.get(position);
            }
        }

        inflater = getLayoutInflater();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);


        view1 = inflater.inflate(R.layout.content_order_nearby,null);
        view2 = inflater.inflate(R.layout.content_order_nearby,null);

        ListView lv1 = (ListView) view1.findViewById(R.id.lv);
        ListView lv2 = (ListView) view1.findViewById(R.id.lv);

        SimpleAdapter simpleAdapter1 = new SimpleAdapter(this,getData(),R.layout.item_nearby,
                new String[]{"img","tv1","tv2","tv3","tv4"},new int[]{R.id.img,R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4});
        lv1.setAdapter(simpleAdapter1);
        lv1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                HashMap<String,Object> m = (HashMap<String,Object>)listView.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        viewList.add(view1);
        viewList.add(view2);

        titlelist.add("综合排序");
        titlelist.add("筛选");

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText(titlelist.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titlelist.get(1)));

        MyPageAdapter adapter = new MyPageAdapter(viewList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);

    }

    private List<Map<String,Object>> getData() {
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (int i=0;i<3;i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", R.drawable.ic_menu_camera);
            map.put("tv1", "类型：图书");
            map.put("tv2", "重量：10KG");
            map.put("tv3", "目的地:华南理工大学大学城校区B7-233");
            map.put("tv4", "10KM");
            list.add(map);
        }

        return list;
    }
}
