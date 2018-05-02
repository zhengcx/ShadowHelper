package cn.davidsu.shadowhelper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.davidsu.library.ShadowConfig;
import cn.davidsu.library.ShadowHelper;

public class MainActivity extends AppCompatActivity {

    private EditText etColor;
    private EditText etRadius;
    private EditText etShadowColor;
    private EditText etOffsetX;
    private EditText etOffsetY;
    private Button btnDone;

    private int[] mColor;
    private int mRadius;
    private int mShadowColor;
    private int mOffsetX;
    private int mOffsetY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColor = new int[]{Color.parseColor("#ffa726")};
        mRadius = Util.dp2px(this, 30);
        mShadowColor = Color.parseColor("#ffa726");
        mOffsetX = Util.dp2px(this, 2);
        mOffsetY = Util.dp2px(this, 2);

        bindViews();
        initView();
        setShadow();
    }


    private void bindViews() {
        etColor = findViewById(R.id.et_color);
        etRadius = findViewById(R.id.et_radius);
        etShadowColor = findViewById(R.id.et_shadowcolor);
        etOffsetX = findViewById(R.id.et_offsetX);
        etOffsetY = findViewById(R.id.et_offsetY);
        btnDone = findViewById(R.id.btn_done);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setShadow();
            }
        });

    }

    private void initView() {
        etColor.setText("#ffa726");
        etRadius.setText("30");
        etShadowColor.setText("#ffa726");
        etOffsetX.setText("2");
        etOffsetY.setText("2");
    }

    private void setShadow() {

        initData();

        TextView textView1 = findViewById(R.id.tv_1);
        ShadowConfig.Builder config = new ShadowConfig.Builder()
                .setColor(mColor[0])
                .setShadowColor(mShadowColor)
                .setGradientColorArray(mColor)
                .setRadius(mRadius)
                .setOffsetX(mOffsetX)
                .setOffsetY(mOffsetY);
        ShadowHelper.setShadowBgForView(textView1, config);
    }


    private void initData() {
        try {
            if (!Util.emptyOrNull(etColor.getText().toString())) {
                String[] colors = etColor.getText().toString().split(",");
                mColor = new int[colors.length];
                for (int i = 0; i < colors.length; i++) {
                    mColor[i] = Color.parseColor(colors[i]);
                }
            }

            if (!Util.emptyOrNull(etShadowColor.getText().toString())) {
                mShadowColor = Color.parseColor(etShadowColor.getText().toString());
            }
        } catch (Exception e) {
            Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();
            mColor = new int[]{Color.parseColor("#ffa726")};
            mShadowColor = Color.parseColor("#ffa726");
        }

        if (!Util.emptyOrNull(etRadius.getText().toString())) {
            mRadius = Util.dp2px(this, Integer.valueOf(etRadius.getText().toString()));
        }

        if (!Util.emptyOrNull(etOffsetX.getText().toString())) {
            mOffsetX = Util.dp2px(this, Integer.valueOf(etOffsetX.getText().toString()));
        }

        if (!Util.emptyOrNull(etOffsetY.getText().toString())) {
            mOffsetY = Util.dp2px(this, Integer.valueOf(etOffsetY.getText().toString()));
        }


    }
}
