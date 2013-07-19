package com.example.testanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ViewScale extends Activity implements OnClickListener {

	private RelativeLayout mLayout;
	private Animation mScaleIn, mScaleOut;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mScaleIn = AnimationUtils.loadAnimation(this, R.anim.scale_in);
		mScaleOut = AnimationUtils.loadAnimation(this, R.anim.scale_out);
		mLayout = (RelativeLayout) findViewById(R.id.mLayout);
		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(this);
		iv = (ImageView) findViewById(R.id.img);
		mLayout.removeView(iv);
		// iv = new ImageView(ViewScale.this);
		//
		// RelativeLayout.LayoutParams mParam = new
		// RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
		// LayoutParams.WRAP_CONTENT);
		// iv.setBackgroundResource(R.drawable.ic_launcher);
	}

	private int i = 0;
	private ImageView iv;

	@Override
	public void onClick(View v) {
		if (i % 2 == 0) {
			mLayout.addView(iv);
			iv.startAnimation(mScaleOut);
			mScaleOut.setAnimationListener(new AnimationListener() {
				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					// mLayout.removeView(iv);
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}
			});
		} else {
			iv.startAnimation(mScaleIn);
			mScaleIn.setAnimationListener(new AnimationListener() {
				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					mLayout.removeView(iv);
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}
			});
		}
		i++;

	}

}
