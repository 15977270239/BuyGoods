package com.twc.buygoods;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.twc.buygoods.goods.CalculatePrice;
import com.twc.buygoods.goods.DiscountMethod;
import com.twc.buygoods.goods.OtherDiscountMethod;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.dele)
    Button dele;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.totalprice)
    TextView totalprice;
    private CalculatePrice calculatePrice;
    private OtherDiscountMethod calculatePrice2;
    private int goodsNum = 0;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.add:
                    goodsNum++;
                    textView.setText(goodsNum + "");
                    price.setText("本地计算单价：" + calculatePrice.calculatePrice(goodsNum));
                    totalprice.setText("合计:" + calculatePrice.calculatePrice(goodsNum) * goodsNum + "");
                    break;
                case R.id.dele:
                    if (goodsNum == 0) {
                        price.setText("本地计算单价：" + "0");
                        Toast("数量不能少于0");
                        return;
                    }
                    goodsNum--;
                    textView.setText(goodsNum + "");
                    price.setText("本地计算单价：" + calculatePrice.calculatePrice(goodsNum));
                    totalprice.setText("合计:" + calculatePrice.calculatePrice(goodsNum) * goodsNum + "");
                    break;
            }
        }
    };

    private void Toast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dele.setOnClickListener(listener);
        add.setOnClickListener(listener);
        calculatePrice = new DiscountMethod();
        calculatePrice2 = new OtherDiscountMethod();
    }
}
