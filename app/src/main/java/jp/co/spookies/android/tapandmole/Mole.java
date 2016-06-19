package jp.co.spookies.android.tapandmole;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * モグラクラス
 */
public class Mole {

    // 状態毎のイメージ[穴、半分穴、全部　]
    public static final Bitmap[] gangImages = new Bitmap[3];
    public static final Bitmap[] hitGangImages = new Bitmap[3];
    public static final Bitmap[] friendImages = new Bitmap[3];
    public static final Bitmap[] hitFriendImages = new Bitmap[3];

    public static final int STATUS_HIDDEN = 0; // 穴
    public static final int STATUS_HARF = 1; // 半分出現
    public static final int STATUS_FULL = 2; // 全部出現

    public static final int DIRECTION_UP = 0; // 上向きに移動
    public static final int DIRECTION_DOWN = 1; // 下向きに移動

    public static final int MOGURA_TOUCH_WIDTH = 60; // 各モグラタッチ可能幅
    public static final int MOGURA_TOUCH_HEIGHT = 71; // 各モグラタッチ可能高さ

    public static final double MOGURA_DIRECTION_UP_RATE = 0.01; // モグラ出現割合
    public static final double MOGURA_DIRECTION_DOWN_RATE = 0.05; // モグラ隠れる割合

    protected float density; // density
    protected boolean isGang; // ギャングモグラの真偽
    protected int status; // 表示ステータス
    protected boolean isHit; // ヒットされた状態か
    protected int direction; // 上下移動向きの方向
    protected float posX; // 設置位置のX座標
    protected float posY; // 設置位置のY座標
