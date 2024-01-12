package top.jessi.banner.indicator;

import android.view.View;

import androidx.annotation.NonNull;

import top.jessi.banner.config.IndicatorConfig;
import top.jessi.banner.listener.OnPageChangeListener;

public interface Indicator extends OnPageChangeListener {
    @NonNull
    View getIndicatorView();

    IndicatorConfig getIndicatorConfig();

    void onPageChanged(int count, int currentPosition);

}
