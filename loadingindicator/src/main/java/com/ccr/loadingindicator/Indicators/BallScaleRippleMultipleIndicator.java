package com.ccr.loadingindicator.Indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;

/**
 * 在此写用途
 *
 * @Author: Acheng
 * @Email: 345887272@qq.com
 * @Date: 2017-08-19 10:13
 * @Version: V1.0 <描述当前版本功能>
 */

public class BallScaleRippleMultipleIndicator extends BallScaleMultipleIndicator {
    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        super.draw(canvas, paint);
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators=new ArrayList<>();
        long[] delays=new long[]{0, 200, 400};
        for (int i = 0; i < 3; i++) {
            final int index=i;
            ValueAnimator scaleAnim=ValueAnimator.ofFloat(0,1);
            scaleAnim.setInterpolator(new LinearInterpolator());
            scaleAnim.setDuration(1000);
            scaleAnim.setRepeatCount(-1);
            addUpdateListener(scaleAnim,new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scaleFloats[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            scaleAnim.setStartDelay(delays[i]);

            ValueAnimator alphaAnim=ValueAnimator.ofInt(0,255);
            scaleAnim.setInterpolator(new LinearInterpolator());
            alphaAnim.setDuration(1000);
            alphaAnim.setRepeatCount(-1);
            addUpdateListener(alphaAnim,new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    alphaInts[index] = (int) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            scaleAnim.setStartDelay(delays[i]);

            animators.add(scaleAnim);
            animators.add(alphaAnim);
        }
        return animators;
    }
}
