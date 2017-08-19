package com.ccr.achengloadingindicator;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ccr.loadingindicator.AVLoadingIndicatorView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        mRecycler= (RecyclerView) findViewById(R.id.recycler);

        GridLayoutManager layoutManager=new GridLayoutManager(this,4);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(new RecyclerView.Adapter<IndicatorHolder>() {
            @Override
            public IndicatorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView=getLayoutInflater().inflate(R.layout.item_indicator,parent,false);
                return new IndicatorHolder(itemView);
            }

            @Override
            public void onBindViewHolder(IndicatorHolder holder, final int position) {
                holder.indicatorView.setIndicator(INDICATORS[position]);
                holder.itemLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,IndicatorActivity.class);
                        intent.putExtra("indicator",INDICATORS[position]);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return INDICATORS.length;
            }
        });
    }

    final static class IndicatorHolder extends RecyclerView.ViewHolder{

        public AVLoadingIndicatorView indicatorView;
        public View itemLayout;

        public IndicatorHolder(View itemView) {
            super(itemView);
            itemLayout= itemView.findViewById(R.id.itemLayout);
            indicatorView= (AVLoadingIndicatorView) itemView.findViewById(R.id.indicator);
        }
    }



    private static final String[] INDICATORS=new String[]{
            "com.ccr.loadingindicator.Indicators.BallPulseIndicator",
            "com.ccr.loadingindicator.Indicators.BallGridPulseIndicator",
            "com.ccr.loadingindicator.Indicators.BallClipRotateIndicator",
            "com.ccr.loadingindicator.Indicators.BallClipRotatePulseIndicator",
            "com.ccr.loadingindicator.Indicators.SquareSpinIndicator",
            "com.ccr.loadingindicator.Indicators.BallClipRotateMultipleIndicator",
            "com.ccr.loadingindicator.Indicators.BallPulseRiseIndicator",
            "com.ccr.loadingindicator.Indicators.BallRotateIndicator",
            "com.ccr.loadingindicator.Indicators.CubeTransitionIndicator",
            "com.ccr.loadingindicator.Indicators.BallZigZagIndicator",
            "com.ccr.loadingindicator.Indicators.BallZigZagDeflectIndicator",
            "com.ccr.loadingindicator.Indicators.BallTrianglePathIndicator",
            "com.ccr.loadingindicator.Indicators.BallScaleIndicator",
            "com.ccr.loadingindicator.Indicators.LineScaleIndicator",
            "com.ccr.loadingindicator.Indicators.LineScalePartyIndicator",
            "com.ccr.loadingindicator.Indicators.BallScaleMultipleIndicator",
            "com.ccr.loadingindicator.Indicators.BallPulseSyncIndicator",
            "com.ccr.loadingindicator.Indicators.BallBeatIndicator",
            "com.ccr.loadingindicator.Indicators.LineScalePulseOutIndicator",
            "com.ccr.loadingindicator.Indicators.LineScalePulseOutRapidIndicator",
            "com.ccr.loadingindicator.Indicators.BallScaleRippleIndicator",
            "com.ccr.loadingindicator.Indicators.BallScaleRippleMultipleIndicator",
            "com.ccr.loadingindicator.Indicators.BallSpinFadeLoaderIndicator",
            "com.ccr.loadingindicator.Indicators.LineSpinFadeLoaderIndicator",
            "com.ccr.loadingindicator.Indicators.TriangleSkewSpinIndicator",
            "com.ccr.loadingindicator.Indicators.PacmanIndicator",
            "com.ccr.loadingindicator.Indicators.BallGridBeatIndicator",
            "com.ccr.loadingindicator.Indicators.SemiCircleSpinIndicator",
            "com.ccr.achengloadingindicator.MyCustomIndicator"
    };

}
