package com.ccr.loadingindicator.Indicators;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;

/**
 * 在此写用途
 *
 * @Author: Acheng
 * @Email: 345887272@qq.com
 * @Date: 2017-08-19 10:15
 * @Version: V1.0 <描述当前版本功能>
 */

public class BallZigZagDeflectIndicator extends BallZigZagIndicator{
    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators=new ArrayList<>();
        float startX=getWidth()/6;
        float startY=getWidth()/6;
        for (int i = 0; i < 2; i++) {
            final int index=i;
            ValueAnimator translateXAnim=ValueAnimator.ofFloat(startX,getWidth()-startX,startX,getWidth()-startX,startX);
            if (i==1){
                translateXAnim=ValueAnimator.ofFloat(getWidth()-startX,startX,getWidth()-startX,startX,getWidth()-startX);
            }
            ValueAnimator translateYAnim=ValueAnimator.ofFloat(startY,startY,getHeight()-startY,getHeight()-startY,startY);
            if (i==1){
                translateYAnim=ValueAnimator.ofFloat(getHeight()-startY,getHeight()-startY,startY,startY,getHeight()-startY);
            }

            translateXAnim.setDuration(2000);
            translateXAnim.setInterpolator(new LinearInterpolator());
            translateXAnim.setRepeatCount(-1);
            addUpdateListener(translateXAnim,new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    translateX [index]= (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });

            translateYAnim.setDuration(2000);
            translateYAnim.setInterpolator(new LinearInterpolator());
            translateYAnim.setRepeatCount(-1);
            addUpdateListener(translateYAnim,new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    translateY [index]= (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });

            animators.add(translateXAnim);
            animators.add(translateYAnim);
        }
        return animators;
    }

}
