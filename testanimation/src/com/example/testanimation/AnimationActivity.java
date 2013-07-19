package com.example.testanimation;

import android.app.Activity;
import android.os.Bundle;

import com.example.testanimation.Effect.AnimRes;

public class AnimationActivity extends Activity {
	public static final String EXTRA_ANIMRES = "extra_animres";
	AnimRes animRes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animation);
		animRes = (AnimRes) getIntent().getSerializableExtra(EXTRA_ANIMRES);
	}

	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(animRes.getEnterAnim(), animRes.getExitAnim());
	}

}
