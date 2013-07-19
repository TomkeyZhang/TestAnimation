package com.example.testanimation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class IndividualityDialogActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		
		Button btn = (Button) findViewById(R.id.button1);

		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 多个Activity嵌套时用this.parent否则异常
				new myDialog(IndividualityDialogActivity.this).showDialog(R.layout.dialog, 80, 50);
			}
		});
	}

	// 自定义Dialog
	class myDialog extends Dialog {

		private Window window = null;

		public myDialog(Context context) {
			super(context);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}

		public void showDialog(int layoutResID, int x, int y) {
			setContentView(layoutResID);

			windowDeploy(x, y);

			// 设置触摸对话框意外的地方取消对话框
			setCanceledOnTouchOutside(true);
			show();
		}

		// 设置窗口显示
		public void windowDeploy(int x, int y) {
			window = getWindow(); // 得到对话框
			window.setWindowAnimations(R.style.dialogWindowAnim); // 设置窗口弹出动画
			window.setBackgroundDrawableResource(R.color.vifrification); // 设置对话框背景为透明
			WindowManager.LayoutParams wl = window.getAttributes();
			// 根据x，y坐标设置窗口需要显示的位置
			wl.x = x; // x小于0左移，大于0右移
			wl.y = y; // y小于0上移，大于0下移
			// wl.alpha = 0.6f; //设置透明度
			// wl.gravity = Gravity.BOTTOM; //设置重力
			window.setAttributes(wl);
		}
	}
}
