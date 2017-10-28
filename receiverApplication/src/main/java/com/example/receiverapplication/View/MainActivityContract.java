package com.example.receiverapplication.View;

import com.example.receiverapplication.BasePresenter;
import com.example.receiverapplication.BaseView;

public interface MainActivityContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {

    }
}
