package com.hlxy.syc.fragmentbestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 这里的main布局文件有两个
 * layout-sw600dp（sw:smallwidth）：当屏幕绝对宽度大于600dp时，屏幕就会自动调用该文件夹下的布局
 * 绝对宽度：手机较小边的宽度，与手机是否横屏无关
 * 相对宽度：手机相对放置的宽度，即竖屏时取较小边，横屏时取较长边
 * 类比：
 * layout-w600dp:当屏幕相对宽度大于600dp时调用
 * layout-h600dp:当屏幕相对高度大于600dp时调用<不建议使用>
 * values-sw600dp/values-w600dp:用法同layout
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
