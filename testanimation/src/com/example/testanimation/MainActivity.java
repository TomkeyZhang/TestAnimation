package com.example.testanimation;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.testanimation.Effect.AnimRes;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				Effect.NAMES));
		// startActivity(new Intent(this,
		// IndividualityDialogActivity.class));
		// startActivity(new Intent(this, ViewScale.class));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Effect effect = Effect.newInstance(position);
		startActivity(new Intent(this, AnimationActivity.class).putExtra(
				AnimationActivity.EXTRA_ANIMRES, effect.getNextAnimRes()));
		AnimRes currAnimRes = effect.getCurrAnimRes();
		overridePendingTransition(currAnimRes.getEnterAnim(), currAnimRes.getExitAnim());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is
		// present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
