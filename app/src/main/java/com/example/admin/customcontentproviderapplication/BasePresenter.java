package com.example.admin.customcontentproviderapplication;

public interface BasePresenter <V extends BaseView> {
    void addView(V View);
    void removeView();
}
