package com.example.administrator.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class WelcomeGuideActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private GuideViewPagerAdapter adapter;
    private List<View> viewList;
    private Button startBtn;
    // 引导页图片资源
    private int[] pics = {R.layout.guid_view1, R.layout.guid_view2, R.layout.guid_view3, R.layout.guid_view4};
    // 底部小圆点按钮
    private Button[] dots;
    // 记录当前选中位置
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_guide);

        // 初始化引导页视图列表
        initPageView();

        // 初始化小圆点状态
        initDots();

        // 获取ViewPager控件并填充页面
        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        adapter = new GuideViewPagerAdapter(viewList);// 初始化adapter
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new PageChangeListener());
    }

    /**
     * 初始化页面引导视图
     */
    private void initPageView() {
        // 实例化视图集合
        viewList = new ArrayList<View>();
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);
            if (i == pics.length - 1) {// 即到最后一页时
                startBtn = (Button) view.findViewById(R.id.btn_login);// 进入首页按钮
                // 设置"点击进入"按钮的事件监听器
                startBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v.getId() == R.id.btn_login) {
                            Intent intent = new Intent(WelcomeGuideActivity.this, SplashActivity.class);
                            startActivity(intent);
                            Utils.putBoolean(WelcomeGuideActivity.this,"first_open",true);// 在打开过引导页面后就设置为true
                        }
                    }
                });
            }
            viewList.add(view);
        }

    }

    /**
     * 初始化小圆点状态
     */
    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        dots = new Button[pics.length];

        // 循环取得小圆点
        for (int i = 0; i < pics.length; i++) {
            // 得到一个LinearLayout下面的每一个子元素
            dots[i] = (Button) ll.getChildAt(i);
            dots[i].setBackgroundResource(R.drawable.button_shape_gray);
        }
        // 设置第一个小圆点为被选中状态（即白色背景）
        dots[0].setBackgroundResource(R.drawable.button_shape_white);
        // 设置当前页码是第1页
        currentIndex = 0;
    }

    /**
     * 设置当前指示点
     *
     * @param position 当前页面位置（0~3）
     */
    private void setCurDot(int position) {
        // 判断位置是否合法
        if (position < 0 || position > pics.length || currentIndex == position) {
            return;
        }
        // 设置当前选中的页面的小圆点背景色为白色
        dots[position].setBackgroundResource(R.drawable.button_shape_white);
        // 设置上一个页面的小圆点背景色改为灰色（即未选择状态）
        dots[currentIndex].setBackgroundResource(R.drawable.button_shape_gray);
        // 保存当前页的位置
        currentIndex = position;
    }

    /**
     * 引导页面被选中监听器
     */
    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // 当滑动状态改变时调用
        }

        @Override
        public void onPageSelected(int position) {
            // 当新的页面被选中时调用
            // 设置翻页后底部小圆点的状态变化
            setCurDot(position);// position指的是当前第几页，从0开始计算的，所以0表示第1页，1表示第2页，...
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            // 当滑动状态改变时调用
        }
    }
}
