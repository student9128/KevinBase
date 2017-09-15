package com.kevin.tech.kevinbase.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.tech.kevinbase.view.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Kevin on 2017/3/17.
 * Blog:http://blog.csdn.net/student9128.
 * Description:
 *  <div>
 * <br/>Base class for all the activities in the app except {@link AppBaseFragment}.
 * <p>There are some abstract methods that sub fragment must override.This class
 * extends {@link AppBaseFragment} which inherit {@link android.support.v4.app.Fragment}.</p>
 * Please inherit this class if you want to use all the methods in BaseFragment.
 * </div>
 */

public abstract class BaseFragment extends AppBaseFragment {
    /**
     * Tag,can be used for log or toast.
     */
    public String TAG = getClass().getSimpleName();
    public LoadingDialog mLoadingDialog;
    protected View mView;
    public Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(setLayoutResId(), container, false);
        ButterKnife.bind(this, mView);
        unbinder = ButterKnife.bind(this, mView);
        initView();
        initData();
        initListener();
        printLogi("onCreateVew");
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        printLogi("onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
//        refreshUI();
        printLogi("onStart");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLogi("onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        printLogi("onActivityCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * set Layout Resource Id
     *
     * @return
     */
    public abstract int setLayoutResId();

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();

    /**
     * refresh user interface.
     */
//    public abstract void refreshUI();

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
        mLoadingDialog.show(getFragmentManager(), TAG);
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

}
