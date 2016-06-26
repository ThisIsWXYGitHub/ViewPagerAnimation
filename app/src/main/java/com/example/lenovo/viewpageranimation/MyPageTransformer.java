package com.example.lenovo.viewpageranimation;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by lenovo on 26/6/2016.
 */
public class MyPageTransformer implements ViewPager.PageTransformer {

    private static final float ROT_MAX = 20.0f;
      private float mRot;


     public void transformPage(View view, float position)
   {

              Log.e("TAG", view + " , " + position + "");

           if (position < -1)
                 {
                 //这个view 已经完全滑动到最左边 不见了
                 // [-Infinity,-1)
                     // This page is way off-screen to the left.
                     view.setRotation(0);
             } else if (position <= 1) // a页滑动至b页 ； a页从 0.0 ~ -1 ；b页从1 ~ 0.0
         { // [-1,1]
              // Modify the default slide transition to shrink the page as well
               if (position < 0)
                    {

                     //   a页从 0.0 ~ -1
                     //
                      mRot = (ROT_MAX * position);
                     view.setPivotX( view.getMeasuredWidth() * 0.5f);
                        view.setPivotY(view.getMeasuredHeight());
                        view.setRotation( mRot);
                       } else
               {

                   //b页从1 ~ 0.0
               mRot = (ROT_MAX * position);
                   view.setPivotX(view.getMeasuredWidth() * 0.8f);
                   view.setPivotY( view.getMeasuredHeight());
                   view.setRotation( mRot);
           }
        } else
          { // (1,+Infinity]
                 // This page is way off-screen to the right.
              view.setRotation(0);
               }
        }


}
