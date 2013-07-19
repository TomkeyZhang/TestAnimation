package com.example.testanimation;

import java.io.Serializable;

public class Effect {
	private AnimRes currAnimRes;
	private AnimRes nextAnimRes;

	private Effect(AnimRes currAnimRes, AnimRes nextAnimRes) {
		this.currAnimRes = currAnimRes;
		this.nextAnimRes = nextAnimRes;
	}

	public AnimRes getCurrAnimRes() {
		return currAnimRes;
	}

	public AnimRes getNextAnimRes() {
		return nextAnimRes;
	}

	public static Effect newInstance(int position) {
		if ("右入".equals(NAMES[position])) {
			return new Effect(new AnimRes(R.anim.in_from_right, R.anim.none),
					new AnimRes(R.anim.none, R.anim.out_to_right));
		} else if ("左入".equals(NAMES[position])) {
			return new Effect(new AnimRes(R.anim.in_from_left, R.anim.none),
					new AnimRes(R.anim.none, R.anim.out_to_left));
		} else if ("上入".equals(NAMES[position])) {
			return new Effect(new AnimRes(R.anim.in_from_top, R.anim.none),
					new AnimRes(R.anim.none, R.anim.out_to_top));
		} else if ("下入".equals(NAMES[position])) {
			return new Effect(new AnimRes(R.anim.in_from_bottom, R.anim.none),
					new AnimRes(R.anim.none, R.anim.out_to_bottom));
		} else if ("左出右入".equals(NAMES[position])) {
			return new Effect(new AnimRes(R.anim.in_from_right, R.anim.out_to_left),
					new AnimRes(R.anim.in_from_left, R.anim.out_to_right));
		} else if ("左入右出".equals(NAMES[position])) {
			return new Effect(new AnimRes(R.anim.in_from_left, R.anim.out_to_right),
					new AnimRes(R.anim.in_from_right, R.anim.out_to_left));
		} else if ("上出下入".equals(NAMES[position])) {
			return new Effect(new AnimRes(R.anim.in_from_bottom, R.anim.out_to_top),
					new AnimRes(R.anim.in_from_top, R.anim.out_to_bottom));
		} else if ("上入下出".equals(NAMES[position])) {
			return new Effect(new AnimRes(R.anim.in_from_top, R.anim.out_to_bottom),
					new AnimRes(R.anim.in_from_bottom, R.anim.out_to_top));
		} else if ("淡入淡出".equals(NAMES[position])) {
			return new Effect(new AnimRes(R.anim.in_zoom, R.anim.none), new AnimRes(
					R.anim.none, R.anim.out_zoom));
		}
		throw new IllegalArgumentException("位置不存在！");
	}

	public static final String[] NAMES = new String[] { "右入", "左入", "上入", "下入", "左出右入", "左入右出",
			"上出下入", "上入下出", "淡入淡出" };

	public static class AnimRes implements Serializable {
		private static final long serialVersionUID = 1L;
		private int enterAnim;
		private int exitAnim;

		/**
		 * 构造一次界面切换动画
		 * 
		 * @param enterAnim
		 *                下一个activity的进入动画
		 * @param exitAnim
		 *                当前activity的退出动画
		 */
		public AnimRes(int enterAnim, int exitAnim) {
			this.enterAnim = enterAnim;
			this.exitAnim = exitAnim;
		}

		public int getEnterAnim() {
			return enterAnim;
		}

		public int getExitAnim() {
			return exitAnim;
		}
	}
}
