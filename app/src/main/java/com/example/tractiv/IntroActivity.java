package com.example.tractiv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SlideAdapter sliderAdapter;
    private ImageButton mNextBtn;
    private Button mPreBtn;
    private int mCurrentPage;
    private ConstraintLayout mainback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();

        /**
         * Add adapters
         */
        setAdapterAndViewpager();

    }

    private void setAdapterAndViewpager() {

        // SlideAdapter class will handle add data and size of the slider.
        sliderAdapter = new SlideAdapter(this);

        //setting the adapter to view pager
        viewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListner);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        //Handling click event (next button pressed.)
      /*  mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if user if one third slider and he/she clicks on next button he/she will be send to Login Screen
                if (mCurrentPage == 2) {

                    Toast.makeText(IntroActivity.this,"Hello",Toast.LENGTH_LONG).show();
                  //  sendToLoginScreen();

                }

                //sending user to next screen
                viewPager.setCurrentItem(mCurrentPage + 1); // sending back to next page from the current one
            }
        });*/

        // Handling click event (previous button clicked)

       mPreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // send user to previous slide from the current one.
                viewPager.setCurrentItem(mCurrentPage + 1);
                //if user if one third slider and he/she clicks on next button he/she will be send to Login Screen
                if (mCurrentPage == 2) {

                    Toast.makeText(IntroActivity.this,"Hello",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(IntroActivity.this,MainHomeScreen.class));
                    //  sendToLoginScreen();

                }
            }
        });

    }

    private void AddXMLToJava() {

        viewPager = findViewById(R.id.viewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        mNextBtn = findViewById(R.id.nextBtn);
        mPreBtn = findViewById(R.id.preBtn);
        mainback = findViewById(R.id.main_background);



    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

        public void transformPage(View view, float position) {

            TextView desc = view.findViewById(R.id.text2);
           // TextView title = view.findViewById(R.id.text1);



        }
    }
    /** page transform ends */


    /**
     * Starting new function to add dots
     */

    public void addDotsIndicator(int j) {

        mDots = new TextView[3];
        mDotLayout.removeAllViews();     // removing multiples dots

        // Adding All Dots on the MainScreen
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(IntroActivity.this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.dotColor));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[j].setTextColor(getResources().getColor(R.color.whiteColor));
        }

    }

    // page Selector

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @SuppressLint("ResourceAsColor")
        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;
            if(position == 0){
                mainback.setBackgroundResource(R.color.firstcolor);
            }
            if(position == 1){
                mainback.setBackgroundResource(R.color.secondcolor);
            }
            if(position == 2){
                mainback.setBackgroundResource(R.color.lastcolor);
            }

            if (position == 0) {
                mNextBtn.setEnabled(true);
                mPreBtn.setEnabled(true);
                mPreBtn.setVisibility(View.VISIBLE);

                // mNextBtn.setText("Next");
                mPreBtn.setText("NExt");


            } else if (position == mDots.length - 1) {
                mNextBtn.setEnabled(true);
                mPreBtn.setEnabled(true);
                mPreBtn.setVisibility(View.VISIBLE);
              //  mainback.setBackgroundColor(R.color.btnColor);

                //  mNextBtn.setText("Let's Start");
                mPreBtn.setText("Next");

            } else {
                mNextBtn.setEnabled(true);
                mPreBtn.setEnabled(true);
                mPreBtn.setVisibility(View.VISIBLE);

                //mNextBtn.setText("Next");
                mPreBtn.setText("next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
