package com.kevin.tech.kevinbase.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.kevin.tech.kevinbase.R;

/**
 * Created by Kevin on 2017/3/28.
 * Describe: Loading Dialog.
 * <p>
 * How to use：
 * LoadingDialog mLoadingDialog = new LoadingDialog();
 * mLoadingDialog.show(getSupportFragmentManager(), "LoadingDialog");
 */
public class LoadingDialog extends DialogFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_loading, container, false);

//        //hide the border of dialog itself.
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        //you can set background transparent with this.
        // getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}