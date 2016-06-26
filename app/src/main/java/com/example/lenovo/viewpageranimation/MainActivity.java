package com.example.lenovo.viewpageranimation;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ImageView>list=new ArrayList<ImageView>();
    int []picture={R.drawable.p,R.drawable.p1,R.drawable.p2,R.drawable.p3};
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView view=new ImageView(MainActivity.this);
        view.setImageBitmap(BitmapFactory.decodeResource(getResources(), picture[0]));
        list.add(view);

        ImageView view1=new ImageView(MainActivity.this);
        view1.setImageBitmap(BitmapFactory.decodeResource(getResources(), picture[1]));
        list.add(view1);

        ImageView view2=new ImageView(MainActivity.this);
        view2.setImageBitmap(BitmapFactory.decodeResource(getResources(), picture[2]));
        list.add(view2);

        ImageView view3=new ImageView(MainActivity.this);
        view3.setImageBitmap(BitmapFactory.decodeResource(getResources(), picture[3]));
        list.add(view3);


        viewPager= (ViewPager) findViewById(R.id.viewpager);
        viewPager.setPageTransformer(true,new MyPageTransformer());
        viewPager.setAdapter(new Adapter());
    }


    class Adapter extends PagerAdapter
    {
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.d("4577155","destroyItem："+String.valueOf(position));
            container.removeView(list.get(position));
           // super.destroyItem(container, position, object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }


}
