package com.twc.buygoods.goods;

/**
 * 优惠活动1
 */
public class DiscountMethod implements CalculatePrice{

    /**
     * 买 1-5个，就10元一个。 
     * 买5个以上 ，10个以下，就优惠一点，8元一个。
     * 买10个以上，就统一5元一个。
     *
     * @param goodsNum
     * @return
     */
    @Override
    public double calculatePrice(int goodsNum) {
        if (goodsNum > 0 && goodsNum < 5) {
            return 10;
        } else if (goodsNum >= 5 && goodsNum < 10) {
            return 8;
        } else {
            return 5;
        }
    }
}
