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
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class ShawdowLayout extends LinearLayout {
    public ShawdowLayout(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setWillNotDraw(false);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    public ShawdowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ShawdowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ShawdowLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
//        getChildAt(0).measure(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed,l,t,r,b);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private Bitmap mOffscreenBitmap;
    private Canvas mOffscreenCanvas;
    private BitmapShader mBitmapShader;
    private Paint mPaint;
    private RectF mRectF;
    @Override
    protected void onDraw(Canvas canvas) {

////        if (mOffscreenBitmap == null) {
//            mOffscreenBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
//            mOffscreenCanvas = new Canvas(mOffscreenBitmap);
//            mBitmapShader = new BitmapShader(mOffscreenBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//            mPaint.setShader(mBitmapShader);
////            mPaint.setShadowLayer(15, 0, 0,  Color.YELLOW);
//            mRectF = new RectF(0f, 0f, canvas.getWidth(), canvas.getHeight());
////        }else {
////            mOffscreenCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
////        }
//        super.draw(mOffscreenCanvas);
//
//        canvas.drawRoundRect(mRectF, 45, 45, mPaint);
//        drawShawdow(canvas);
//        super.onDraw(canvas);


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
    }
}
