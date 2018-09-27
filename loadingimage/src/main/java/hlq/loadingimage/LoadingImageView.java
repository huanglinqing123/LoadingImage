package hlq.loadingimage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author Huanglinqing
 * @create 2018 - 09 - 27 -11:20
 * * QQ Email:1306214077@qq.com
 * 加载的ImageView 动画
 */

@SuppressLint("AppCompatCustomView")
public class LoadingImageView extends ImageView {

    /**
     * 加载动画动画类型
     * animation ：三点竖线
     * animator:弹跳动画
     */
    private String animationStyle;
    private final String animation = "0";
    private final String animator = "1";
    private int mTop;
    private Context mContext;
    private ValueAnimator v;
    private AnimationDrawable anim;
    private int imageResource[] = {R.mipmap.pic_1,R.mipmap.pic_2,R.mipmap.pic_3};
    private int mCurImgIndex = 0;
    private  int mImgCount = imageResource.length;
    private boolean isSeltImage = false;

    private static volatile LoadingImageView loadingImageView;

    public static LoadingImageView getInstance(Context c) {
        if (loadingImageView == null){
            synchronized (LoadingImageView.class){
                if (loadingImageView == null){
                    loadingImageView = new LoadingImageView(c);
                }
            }
        }
        return loadingImageView;
    }

    public void setImageResource(int image[]){
        if (image == null){
            return;
        }
        imageResource = image;
        isSeltImage = true;
    }

    public LoadingImageView(Context context) {
        super(context);
    }

    public LoadingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypeArrar = context.obtainStyledAttributes(attrs, R.styleable.loadingimage);
        animationStyle = mTypeArrar.getString(R.styleable.loadingimage_styleanima) ==
                null ? animation : mTypeArrar.getString(R.styleable.loadingimage_styleanima);
        mTypeArrar.recycle();
        init(context);
    }


    public LoadingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mTop = top;
    }

    /**
     * 初始化相关配置
     *
     * @param context
     */
    private void init(Context context) {
        switch (animationStyle) {
            case animation:
                setBackgroundResource(R.drawable.type1);
                anim = (AnimationDrawable) getBackground();
                anim.start();
                break;
            case animator:
                initValueAnimator();
                break;
            default:
                break;
        }
    }

    /**
     * 创建相关属性动画
     */
    private void initValueAnimator() {
        if (isSeltImage){
            Log.d("不不急不急","图片结果");
        }
        v = ValueAnimator.ofInt(0, 100, 0);
        v.setRepeatMode(ValueAnimator.RESTART);
        v.setRepeatCount(ValueAnimator.INFINITE);
        v.setDuration(2000);
        v.setInterpolator(new AccelerateDecelerateInterpolator());
        v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer dx = (Integer) animation.getAnimatedValue();
                setTop(mTop - dx);
            }
        });
        v.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                setImageDrawable(getResources().getDrawable(R.mipmap.pic_1));
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                mCurImgIndex++;
                switch (mCurImgIndex % mImgCount) {
                    case 0:
                        setImageDrawable(getResources().getDrawable(imageResource[0]));
                        break;
                    case 1:
                        setImageDrawable(getResources().getDrawable(imageResource[1]));
                        break;
                    case 2:
                        setImageDrawable(getResources().getDrawable(imageResource[2]));
                        break;
                    default:
                        break;
                }
            }
        });
        v.start();
    }
}
