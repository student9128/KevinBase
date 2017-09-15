package com.kevin.tech.kevinbase.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.tech.kevinbase.R;
import com.kevin.tech.kevinbase.view.LoadingDialog;


/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> for Project KevinBase on 2017/9/8.
 * <h3>Description:</h3>
 * <div>
 * <br/>Base class for all the activities in the app except {@link AppBaseActivity}.
 * <p>There are some abstract methods that sub activities must override.This class
 * extends {@link AppBaseActivity} which extends {@link AppBaseActivity}.</p>
 * Please inherit this class if you want to use all the methods in BaseActivity.
 * </div>
 */

public abstract class BaseActivity extends AppBaseActivity {
    /**
     * Tag,can be used for log or toast.
     */
    public String TAG = getClass().getSimpleName();

    public LoadingDialog mLoadingDialog;

    public TextView tvTitle;
    public ImageView ivFunction;
    public ImageView ivBack;
    public Toolbar toolBar;
    public ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResId());
        toolBar = (Toolbar) findViewById(R.id.tool_bar);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivFunction = (ImageView) findViewById(R.id.iv_function);
        setSupportActionBar(toolBar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        initView();
        initData();
        initListener();
    }

    public abstract int setLayoutResId();

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();
    //===============Some Methods=================//

    /**
     * init Loading Dialog.
     * <br/>call this method when create activity.
     */
    public void initLoadingDialog() {
        mLoadingDialog = new LoadingDialog();
    }

    /**
     * show Loading Dialog.
     * <br/>call this method where you need.
     */
    public void showLoadingDialog() {
        mLoadingDialog.show(getSupportFragmentManager(), TAG);
    }

    /**
     * dismiss Loading Dialog.
     * <br/>call this method where you need to dismiss dialog.
     */
    public void dismissLoadingDialog() {
        if (mLoadingDialog.isAdded()) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home://back to previous activity with click home button.
                onBackPressed();
                break;
            default:
                break;
        }
        return true;
    }
}
