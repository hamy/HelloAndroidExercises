package sudoku01.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.os.Bundle;
import android.view.View;

public class Graphics extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new GraphicsView(this));
	}

	static public class GraphicsView extends View {
		public GraphicsView(Context context) {
			super(context);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			Paint p = new Paint();
			p.setColor(Color.LTGRAY);
			Path circle = new Path();
			circle.addCircle(170, 170, 160, Direction.CW);
			canvas.drawPath(circle, p);
			p.setColor(Color.RED);p.setTextSize(30);
			canvas.drawTextOnPath(QUOTE, circle, 0, 20, p);
		}

		private static final String QUOTE = "Now is the time for all good men "
				+ "to come to the aid of their country.";
	}
}