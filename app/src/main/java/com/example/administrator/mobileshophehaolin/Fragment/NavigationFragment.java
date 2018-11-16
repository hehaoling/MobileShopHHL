package com.example.administrator.mobileshophehaolin.Fragment;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.util.EventLogTags;
import android.util.Log;
import com.example.administrator.mobileshophehaolin.R;

public class NavigationFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout tabItemHome;
    private LinearLayout tabItemCategory;
    private LinearLayout tabItemCart;
    private LinearLayout tabItemPersonal;

    private ImageButton tabItemHomeBtn;
    private ImageButton tabItemCategoryBtn;
    private ImageButton tabItemCartBtn;
    private ImageButton tabItemPersonalBtn;
    private FragmentManager fragmentManager;

    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private CartFragment cartFragment;
    private PersonFragment personFragment;
    //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    private static final String TAG = "NavigationFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedlnstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation,container,false);
        initViews(view);
        setTabSelection(R.id.tab_item_home);
        return view;
    }

    private void initViews(View view) {
//主页面
        tabItemHome = (LinearLayout) view.findViewById(R.id.tab_item_home);
        tabItemHome.setOnClickListener(this);
//分类页面
        tabItemCategory = (LinearLayout) view.findViewById(R.id.tab_item_category);
        tabItemCategory.setOnClickListener(this);
//购物车页面
        tabItemCart = (LinearLayout) view.findViewById(R.id.tab_item_eart);
        tabItemCart.setOnClickListener(this);
//个人中心页面
        tabItemPersonal = (LinearLayout) view.findViewById(R.id.tab_item_personal);
        tabItemPersonal.setOnClickListener(this);

        tabItemHomeBtn = (ImageButton) view.findViewById(R.id.tab_item_home_btn);
        tabItemCategoryBtn = (ImageButton) view.findViewById(R.id.tab_item_category_btn);
        tabItemCartBtn = (ImageButton) view.findViewById(R.id.tab_item_cart_btn);
        tabItemPersonalBtn = (ImageButton) view.findViewById(R.id.tab_item_personal_btn);
        fragmentManager = getFragmentManager();// 获得 Fragment 管理类对象
    }

    //点击事件
    @Override
    public void onClick(View v) {
        setTabSelection(v.getId());
    }

    //设置TAB选中
    public void setTabSelection(int id) {
        //重置所有tabltem状态
        tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_focus);
        tabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_focus);
        tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_focus);
        tabItemPersonalBtn.setImageResource(R.drawable.tab_item_personal_focus);
        //开启一个亊务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //隐藏所有Fragment
        if (homeFragment != null)
            fragmentTransaction.hide(homeFragment);
        if (categoryFragment != null)
            fragmentTransaction.hide(categoryFragment);
        if (cartFragment != null)
            fragmentTransaction.hide(cartFragment);
        if (personFragment != null)
            fragmentTransaction.hide(personFragment);
        //根据tabltem的id来执行不同的操作
        switch (id) {
            case R.id.tab_item_home:
                tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_normal);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content, homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.tab_item_category:
                tabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_normal);
                if (categoryFragment == null) {
                    categoryFragment = new CategoryFragment();
                    fragmentTransaction.add(R.id.content, categoryFragment);
                } else {
                    fragmentTransaction.show(categoryFragment);
                }
                break;
            case R.id.tab_item_eart:
                tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_normal);
                if (cartFragment == null) {
                    cartFragment = new CartFragment();
                    fragmentTransaction.add(R.id.content,cartFragment);
                } else {
                    fragmentTransaction.show(cartFragment);
                }
                break;
            case R.id.tab_item_personal:
                tabItemPersonalBtn.setImageResource(R.drawable.tab_item_personal_normal);
                if (personFragment == null) {
                    Log.d(TAG, "123456654");
                    personFragment = new PersonFragment();
                    fragmentTransaction.add(R.id.content,personFragment);
                } else {
                    fragmentTransaction.show(personFragment);
                    Log.d(TAG, "123");
                }
                break;
        }
        fragmentTransaction.commit();
    }
}