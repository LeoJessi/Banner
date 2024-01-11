package top.jessi.banner.youth.indicator;

import android.view.View;

import androidx.annotation.NonNull;

import top.jessi.banner.youth.config.IndicatorConfig;
import top.jessi.banner.youth.listener.OnPageChangeListener;

public interface Indicator extends OnPageChangeListener {
    @NonNull
    View getIndicatorView();

    IndicatorConfig getIndicatorConfig();

    void onPageChanged(int count, int currentPosition);

}
