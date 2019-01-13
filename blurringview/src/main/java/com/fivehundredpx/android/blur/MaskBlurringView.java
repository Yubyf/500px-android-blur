package com.fivehundredpx.android.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;

public class MaskBlurringView extends BlurringView {

    private Canvas mBlurredCanvas = new Canvas();
    private Paint mBlurredPaint = new Paint();

    public MaskBlurringView(Context context) {
        super(context);
    }

    public MaskBlurringView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected Bitmap advancedProcessBlurredBitmap(Bitmap bitmap) {
        mBlurredCanvas.setBitmap(bitmap);
        mBlurredPaint.setAntiAlias(true);
        mBlurredPaint.setFilterBitmap(true);
        mBlurredPaint.setDither(true);
        mBlurredPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        mBlurredCanvas.drawCircle(bitmap.getWidth() / 2f,
                bitmap.getHeight() / 2f,
                bitmap.getWidth() / 3f, mBlurredPaint);
        return super.advancedProcessBlurredBitmap(bitmap);
    }
}
