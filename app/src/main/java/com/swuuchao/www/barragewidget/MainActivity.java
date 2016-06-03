package com.swuuchao.www.barragewidget;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.swuuchao.www.barragewidget.widget.Barrage;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Barrage mBarrage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBarrage = (Barrage) findViewById(R.id.barrage);
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        for (int i = 0; i < 1000; i++) {
            Barrage.BarrageItem barrageItem = new Barrage.BarrageItem(this);
            barrageItem.setText("tnatantan");
            int y = new Random().nextInt(height);
            int x = new Random().nextInt(1000);
            barrageItem.setCurX(width + x);
            barrageItem.setCurY(y);
            mBarrage.addBarrageItem(barrageItem);
        }
    }
}
