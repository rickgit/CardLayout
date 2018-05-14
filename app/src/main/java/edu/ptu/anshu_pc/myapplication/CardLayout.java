package edu.ptu.anshu_pc.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * 不能设置背景色
 * 不然padding部分会变黑，可能是由于 BitmapShader 截取背景导致的。解决方法，该类继承 FrameLayout，再内嵌一个背景层。
 * 命名 区别于 CardView
 */
public class CardLayout extends FrameLayout {
    private Bitmap mOffscreenBitmap;
    private Canvas mOffscreenCanvas;
    private BitmapShader mBitmapShader;
    private Paint mPaint;
    private RectF mRectF;

    public CardLayout(Context context) {
        super(context);
        init();
    }

    public CardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CardLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {setLayerType(LAYER_TYPE_SOFTWARE, null);
        setWillNotDraw(false);
    }

    @Override
    public void draw(Canvas canvas) {
        drawShawdow(canvas);
        if (mOffscreenBitmap == null) {
            mOffscreenBitmap = Bitmap.createBitmap(canvas.getWidth()-getPaddingLeft()-getPaddingRight(), canvas.getHeight()-getPaddingTop()-getPaddingBottom(), Bitmap.Config.ARGB_8888);
            mOffscreenCanvas = new Canvas(mOffscreenBitmap);
            mBitmapShader = new BitmapShader(mOffscreenBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setShader(mBitmapShader);
//            mPaint.setShadowLayer(15, 0, 0,  Color.YELLOW);//设置后四个角会模糊化
            mRectF = new RectF(getPaddingLeft(), getPaddingTop(), canvas.getWidth()-getPaddingRight(), canvas.getHeight()-getPaddingBottom());
        }else {
            mOffscreenCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        }
        super.draw(mOffscreenCanvas);

        canvas.drawRoundRect(mRectF, radio, radio, mPaint);

//        super.draw(canvas);

    }
    int radio=45;
    private void drawShawdow(Canvas canvas) {
        Paint paint3 = new Paint();
        paint3.setColor(0x00ffffff);
        paint3.setShadowLayer(getPaddingRight(), getPaddingRight()-getPaddingLeft(), getPaddingBottom()-getPaddingTop(), 0x66000000);
//        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(1);
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        RectF rect = new RectF(getPaddingLeft(), getPaddingTop(), width -getPaddingRight(), height-getPaddingBottom() );
        canvas.drawRoundRect(rect, radio, radio, paint3);
        Paint paint4 = new Paint();
        paint4.setColor(0xffffffff);
        RectF rect2 = new RectF(getPaddingLeft(), getPaddingTop(), width -getPaddingRight(), height-getPaddingBottom() );
        canvas.drawRoundRect(rect2, radio, radio, paint4);
    }
}
