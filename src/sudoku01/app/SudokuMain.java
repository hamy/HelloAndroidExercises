package sudoku01.app;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

public class SudokuMain extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		View continueButton = findViewById(R.id.continue_button);
		continueButton.setOnClickListener(this);
		View newButton = findViewById(R.id.new_button);
		newButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.exit_button);
		exitButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.continue_button:
 			startActivity(new Intent(this,Graphics.class));
			break;
		case R.id.about_button:
			Intent intent = new Intent(this, About.class);
			startActivity(intent);
			break;
		case R.id.new_button:
			openNewGameDialog();
			break;
		case R.id.exit_button:
			finish();
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, Prefs.class));
			return true;
		}
		return false;
	}

	private static final String TAG = "Sudoku";

	private void openNewGameDialog() {
		new AlertDialog.Builder(this)
				.setTitle(R.string.new_game_title)
				.setItems(R.array.difficulty,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								startGame(which);
							}
						}).show();
	}

	private void startGame(int which) {
		Log.d(TAG, "clicked on " + which);
	}
}