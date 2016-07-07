package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
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
    private Toolbar tb;

    private LayoutInflater inflater;
    private List<String> titlelist = new ArrayList<>();
    private View view1,view2;
    private List<View> viewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_nearby);


//      重写viewPager的适配器
        class MyPageAdapter extends PagerAdapter {
            private List<View> viewList;

            //构造方法，参数是页卡的list
            public MyPageAdapter(List<View> viewList) {
                this.viewList = viewList;
            }

            //返回页卡的数量
            @Override
            public int getCount() {
                return viewList.size();
            }

            //官方提示这样写，为什么呢？
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            //实例化页卡
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));  //添加
                return viewList.get(position);
            }

            //删除页卡
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            //取得页卡的标题
            @Override
            public CharSequence getPageTitle(int position) {
                return titlelist.get(position);
            }
        }


        //获取页面的布局layout
        final CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.layout_coor);
        inflater = getLayoutInflater();
        //通过ID获得页面控件
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tb = (Toolbar) findViewById(R.id.toolbar);

        //inflater找到页卡的页面view
        view1 = inflater.inflate(R.layout.content_order_nearby,null);
        view2 = inflater.inflate(R.layout.content_order_nearby,null);


        //标题栏返回按钮的点击监听响应
        tb.setNavigationIcon(R.drawable.ic_return);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(layout,"return",Snackbar.LENGTH_LONG).setAction("ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
            }
        });


        //获取view中的list view
        ListView lv1 = (ListView) view1.findViewById(R.id.lv);
        ListView lv2 = (ListView) view1.findViewById(R.id.lv);

        //重写list view适配器simpleadapter
        SimpleAdapter simpleAdapter1 = new SimpleAdapter(this,getData(),R.layout.item_nearby,
                new String[]{"img","tv1","tv2","tv3","tv4"},
                new int[]{R.id.img,R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4});
        //绑定list view的adapter
        lv1.setAdapter(simpleAdapter1);

        //给list view的item设置点击事件的监听
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClickItem();
            }
        });

        //页面列表添加页面view
        viewList.add(view1);
        viewList.add(view2);

        //添加页面的标题
        titlelist.add("正进行");
        titlelist.add("已完成");

        //设置TAB的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        //给tab添加tab栏
        tabLayout.addTab(tabLayout.newTab().setText(titlelist.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titlelist.get(1)));

        //新建viewpage的适配器adapter，传入参数是页面列表viewlist
        MyPageAdapter adapter = new MyPageAdapter(viewList);

        //将viewpage跟adapter绑定
        viewPager.setAdapter(adapter);
        //将tab跟viewpage连接
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

//    获取listview里面item项的内容
    private List<Map<String,Object>> getData() {
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i=0;i<3;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("img", R.drawable.ic_menu_camera);
            map.put("tv1", "类型：图书");
            map.put("tv2", "重量：10KG");
            map.put("tv3", "目的地:华南理工大学大学城校区B7-233");
            map.put("tv4", "10KM");
            list.add(map);
        }
        return list;
    }

    //点击列表项响应事件
    private void ClickItem() {
        Intent intent = new Intent(this,ViewOrder_Activity.class);
        startActivityForResult(intent,1);
    }
}
