package com.cauvong.softwarearchitecture.MVP.Presenters;

import android.view.View;

/**
 * Created by ijuin on 12/4/2017.
 */

public interface IPresenter<V> {
    void setView(V view);
}
