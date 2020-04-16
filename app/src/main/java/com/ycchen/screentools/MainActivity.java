package com.ycchen.screentools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.math.MathUtils;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvShowParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module);
        mTvShowParams = (TextView) findViewById(R.id.tv_show_params);
        mTvShowParams.setText(getScreenParams());
    }

    /**
     * 获取屏幕相关参数
     *
     * @return
     */
    public String getScreenParams() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int heightPixels = ScreenUtils.getScreenHeight(this);
        int widthPixels = ScreenUtils.getScreenWidth(this);
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
        // adb shell getprop ro.sf.lcd_density
        int densityDpi = dm.densityDpi;
        float density = dm.density;
        float scaledDensity = dm.scaledDensity;
        float heightDP = heightPixels / density;
        float widthDP = widthPixels / density;
        float smallestWidthDP;
        if (widthDP < heightDP) {
            smallestWidthDP = widthDP;
        } else {
            smallestWidthDP = heightDP;
        }
        double screenSize = (Math.sqrt(heightPixels*heightPixels + widthPixels*widthPixels)) / densityDpi;
        String str = "=== screen params ===";
        str += "\nheightPixels: " + heightPixels + "px";
        str += "\nwidthPixels: " + widthPixels + "px";
        str += "\nxdpi: " + xdpi + "dpi";
        str += "\nydpi: " + ydpi + "dpi";
        str += "\ndensityDpi: " + densityDpi + "dpi";
        str += "\ndensity: " + density;
        str += "\nscaledDensity: " + scaledDensity;
        str += "\nheightDP: " + heightDP + "dp";
        str += "\nwidthDP: " + widthDP + "dp";
        str += "\nsmallestWidthDP: " + smallestWidthDP + "dp";
        str += "\n并不准确，仅供参考screenSize: " + screenSize;
        return str;
    }
}
