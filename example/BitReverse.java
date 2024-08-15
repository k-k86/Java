package com.example;


public class BitReverse {

    // 8ビットの値を反転するメソッド
    public static byte rev(byte input) {
        // 反転後の値を格納する変数
        byte r = 0;

        // 入力値を操作するための変数
        byte rbyte = input;

        // 8ビット分ループする
        for (int i = 1; i <= 8; i++) {
            // r を左に1ビットシフトし、rbyte の最下位ビットを加算（OR演算）
            r = (byte) ((r << 1) | (rbyte & 1));
            // rbyte を右に1ビットシフトして次のビットを処理
            rbyte = (byte) (rbyte >> 1);
            System.out.println(String.format("%8s", Integer.toBinaryString(r & 0xFF)).replace(' ', '0'));

        }

        // 反転された結果を返す
        return r;
    }

    public static void main(String[] args) {
        // 例として 01010101 (10進数の85) を使用
        byte input = 0b01001011;

        // 反転処理を実行
        byte result = rev(input);

        // 結果を二進数で表示
//        System.out.println(String.format("%8s", Integer.toBinaryString(result & 0xFF)).replace(' ', '0'));
    }
}