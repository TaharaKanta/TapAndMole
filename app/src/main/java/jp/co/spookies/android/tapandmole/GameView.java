package jp.co.spookies.android.tapandmole;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * ゲームView
 */
class GameView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private static final long GAME_TIME_SECOND = 30;// 制限時間（秒）
    private static final int MODE_SETTING = 0; // 開始前
    private static final int MODE_GAME = 1; // ゲーム中
    private static final int MODE_GAME_END = 2; // タイムアップ

    private static final int END_TIME_POS_X = 20; // 残り時間表示位置X
    private static final int END_TIME_POS_Y = 45; // 残り時間表示位置Y
    private static final int POINT_POS_X = 145; // ポイント表示位置X
    private static final int POINT_POS_Y = 45; // ポイント表示位置Y

    private static final int FIRST_MOLE_Y = 170; // 左上のモグラの位置Y
    private static final int RETRY_BUTTON_Y = 110; // もう一度ボタンの表示位置Y

    private Thread thread = null;
    private Canvas canvas;
    private Paint paint;

    private Bitmap imageBack = BitmapFactory.decodeResource(getResources(),
            R.drawable.back); // 背景画像
    private Rect backSrcRect; // 背景画像のRect
    private Rect backRect; // 背景画像の表示Rect
    private Bitmap imageRetry = BitmapFactory.decodeResource(getResources(),
            R.drawable.retry); // リトライ画像
    private Rect retrySrcRect; // リトライ画像のRect
    private RectF retryRect; // リトライ画像の表示Rect
    private Bitmap[] imageNumbers = { // 数値画像
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.number_white_0),
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.number_white_1),
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.number_white_2),
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.number_white_3),
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.number_white_4),
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.number_white_5),
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.number_white_6),
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.number_white_7),
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.number_white_8),
            BitmapFactory.decodeResource(getResources(),
                    R.drawable.number_white_9) };
    private int mode; // 表示モード
    private int point; // 得点
    private long restTime; // 残り時間
    private long endTimeMillis; // 終わり時間
    private float density;
    private ArrayList<Mole> moguras = new ArrayList<Mole>(); // モグラインスタンス

