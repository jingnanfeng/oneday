package com.nanfeng.one.three;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-10 8:53
 */

/**
 * 计算商品的总价
 */
public class Product {

    public double productCLick(int sum,double price){
        double totle = 0;
        double totleProduct = sum * price;
        totle = totle + totleProduct;
        return totle;
    }

    public static void main(String[] args) {
        Product product = new Product();
        double totle = product.productCLick(5,23.8);
        System.out.println(totle);
    }
}
