package com.twc.buygoods.goods;

public interface CalculatePrice {
    /**
     * 根据活动来计算价格。
     * @param goodsNum
     * @return
     */
    double calculatePrice(int goodsNum);
}
