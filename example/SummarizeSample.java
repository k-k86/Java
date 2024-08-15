package com.example;

import java.util.Arrays;

public class SummarizeSample {

    // 実数型の配列からpに対応する値を見つける関数
    public static double findRank(double[] sortedData, double p) {
        // インデックスiを計算 (小数点以下は切り上げ)
        int i = (int) Math.ceil(p * (sortedData.length - 1));
        // 対応する値を返す
        return sortedData[i];
    }

    // 実数型の配列をサマライズする関数
    public static double[] summarize(double[] sortedData) {
        // ランクデータを格納する配列
        double[] rankData = new double[5];
        // pの配列を定義
        double[] p = {0.0, 0.25, 0.5, 0.75, 1.0};

        // pの各値についてfindRankを呼び出し、rankDataに格納
        for (int i = 0; i < p.length; i++) {
            rankData[i] = findRank(sortedData, p[i]);
        }

        return rankData;
    }

    public static void main(String[] args) {
        // サンプルデータ
        double[] data = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
        // サマライズを実行
        double[] summarizedData = summarize(data);
        // 結果を出力
        System.out.println(Arrays.toString(summarizedData));
    }
}
