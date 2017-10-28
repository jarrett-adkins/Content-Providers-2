package com.example.receiverapplication.View;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    @Override
    public void addView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {

    }
}
