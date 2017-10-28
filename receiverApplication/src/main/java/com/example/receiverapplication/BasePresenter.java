package com.example.receiverapplication;

public interface BasePresenter <V extends BaseView> {
    void addView(V View);
    void removeView();
}
