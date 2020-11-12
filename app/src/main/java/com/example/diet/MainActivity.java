package com.example.diet;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
    private AnimationDrawable mAnimationDrawable;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    public ArrayList<Integer> names = new ArrayList<>();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.catanimation);

        mAnimationDrawable = (AnimationDrawable) imageView.getBackground();
        mAnimationDrawable.setOneShot(false);
        mAnimationDrawable.start();

    }
    @Override
    public void onClick(View v) {
        int ImageId; ImageButton btn;
//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
        TranslateAnimation animationLeft = new TranslateAnimation(0, -0, 0, 100);
        animationLeft.setRepeatCount(1);
        animationLeft.setDuration(1000);
        animationLeft.setRepeatMode(Animation.REVERSE);
        animationLeft.setStartOffset(1000);

        switch (v.getId()) {
            case R.id.bananaBtn:
                ImageId=R.drawable.icons8_tomato_50;  btn = findViewById( R.id.bananaBtn); btn.startAnimation(animationLeft); break;
            case R.id.avocadoBtn:
                ImageId=R.drawable.icons8_avocado_50; btn = findViewById( R.id.avocadoBtn); btn.startAnimation(animationLeft); break;
            case R.id.breadBtn:
                ImageId=R.drawable.icons8_toast_50;
                btn = findViewById( R.id.breadBtn); btn.startAnimation(animationLeft); break;
            case R.id.appleBtn:
                ImageId=R.drawable.icons8_apple_50;
                btn = findViewById( R.id.appleBtn); btn.startAnimation(animationLeft); break;
            default:
                ImageId=R.drawable.icons8_apple_50;
        }
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
        int btnGravity = Gravity.LEFT;
        lParams.gravity = btnGravity;
        ImageButton btnNew = new ImageButton(this);
        btnNew.setImageResource(ImageId);
        LinearLayout sc = findViewById(R.id.sc);
        btnNew.setId(names.size());
        names.add(btnNew.getId());
        btnNew.setBackgroundColor(0x00FFFFFF);
        registerForContextMenu(btnNew);
        btnNew.setOnClickListener(new Click());
        sc.addView(btnNew, 0);
    }
    class Click implements View.OnClickListener{
        @Override
        public void onClick(View view) { // метод для кнопки

                    ImageButton btn = findViewById(view.getId());
                    btn.setVisibility(View.GONE);

        }
    }

}
