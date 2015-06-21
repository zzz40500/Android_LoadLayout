package com.mingle.loadlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mingle.LoadFrameLayout;
import com.mingle.LoadingViewConfig;
import com.mingle.loadview.GrayscaleLoadingView;
import com.mingle.loadview.ProgressTypeEnum;
import com.mingle.loadview.ShapeLoadingView;

public class MainActivity extends AppCompatActivity {


    private TextView tt;

    private LoadFrameLayout loadFrameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        int type=  getIntent().getIntExtra("type",0);
        LoadingViewConfig.getInstance().setCustom1LoadingView(new ShapeLoadingView());
        LoadingViewConfig.getInstance().setDefProgressType(ProgressTypeEnum.getProgressType(type));
        setContentView(R.layout.activity_main);
        tt= (TextView) findViewById(R.id.tt);
        tt.setText("....");
        loadFrameLayout= (LoadFrameLayout) findViewById(R.id.loadFL);
    }

    public void onClick1(View v){
        tt.setText("设置数据");
    }
    public void onClick2(View v){


        loadFrameLayout.setError("获取失败");
        loadFrameLayout.setErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrameLayout.showLoadView();

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
