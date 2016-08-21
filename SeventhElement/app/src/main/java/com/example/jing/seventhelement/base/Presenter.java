package com.example.jing.seventhelement.base;

public interface Presenter<V> {
    void attachView(V mvpView);
    void detachView();
}
