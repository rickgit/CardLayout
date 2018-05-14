package edu.ptu.anshu_pc.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewTreeObserver;

public class ShawdowHelper {

    public void attachView(View mainView){
        // 从视图上获取视图树观察者
        ViewTreeObserver vo = mainView.getViewTreeObserver();
// 对视图监听即将绘制

        //XXX 添加移除
    }
    public void onDraw(Canvas canvas){
        Paint paint3 = new Paint();
        paint3.setColor(Color.RED);
        paint3.setShadowLayer(15, 0, 0, 0x66000000);

        RectF rect = new RectF(15, 15,150,150);
        canvas.drawRoundRect(rect,10f,10f, paint3);
    }
}
