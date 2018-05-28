package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String mStory = "T1_Story";
    String mAns1 = "T1_Ans1";
    String mAns2 = "T1_Ans2";

    // TODO: Steps 4 & 8 - Declare member variables here:

    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        UpdateViews(mStory,mAns1,mAns2);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAns1.equals("T1_Ans1") || mAns1.equals("T2_Ans1") ){
                    mStory = "T3_Story";
                    mAns1 = "T3_Ans1";
                    mAns2 = "T3_Ans2";
                    UpdateViews(mStory,mAns1,mAns2);
                } else if(mAns1.equals("T3_Ans1")){
                    mStory = "T6_End";
                    mButtonTop.setVisibility(mButtonTop.INVISIBLE);
                    mButtonBottom.setVisibility(mButtonBottom.INVISIBLE);
                    UpdateViews(mStory,mAns1,mAns2);
                }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAns2.equals("T1_Ans2")){
                    mStory = "T2_Story";
                    mAns1 = "T2_Ans1";
                    mAns2 = "T2_Ans2";
                    UpdateViews(mStory,mAns1,mAns2);
                }else if(mAns2.equals("T3_Ans2")){
                    mStory = "T5_End";
                    mButtonTop.setVisibility(mButtonTop.INVISIBLE);
                    mButtonBottom.setVisibility(mButtonBottom.INVISIBLE);
                    UpdateViews(mStory,mAns1,mAns2);
                } else if(mAns2.equals("T2_Ans2")){
                    mStory = "T4_End";
                    mButtonTop.setVisibility(mButtonTop.INVISIBLE);
                    mButtonBottom.setVisibility(mButtonBottom.INVISIBLE);
                    UpdateViews(mStory,mAns1,mAns2);
                }
            }
        });

    }

    public void UpdateViews (String mStory, String mAns1, String mAns2){
        int resIDView = getResources().getIdentifier(mStory , "string", getPackageName());
        mStoryTextView.setText(resIDView);

        int resIDBtnTop = getResources().getIdentifier(mAns1 , "string", getPackageName());
        mButtonTop.setText(resIDBtnTop);

        int resIDBtnBottom = getResources().getIdentifier(mAns2 , "string", getPackageName());
        mButtonBottom.setText(resIDBtnBottom);

    }

}
