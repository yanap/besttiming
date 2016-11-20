package com.yanap.besttiming;

import com.github.mikephil.charting.components.AxisBase;

/**
 * Created by yanap on 2016/11/20.
 */

public interface IAxisValueFormatter {
    String getFormattedValue(float value, AxisBase axis);
}
