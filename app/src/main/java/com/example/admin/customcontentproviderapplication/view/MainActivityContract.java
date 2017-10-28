package com.example.admin.customcontentproviderapplication.view;

import com.example.admin.customcontentproviderapplication.BasePresenter;
import com.example.admin.customcontentproviderapplication.BaseView;

public interface MainActivityContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {

    }
}
