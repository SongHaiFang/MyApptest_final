package demo.song.com.myapptest_final.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/10/25.
 */

public class Huayuan extends View {
    public Huayuan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
//    测量


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
//    重写布局

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }
//    重写一个绘制

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        在这里画个圆
       Paint paint= new Paint();
        paint.setColor(Color.BLUE);

        canvas.drawCircle(60,60,60,paint);

    }
}
