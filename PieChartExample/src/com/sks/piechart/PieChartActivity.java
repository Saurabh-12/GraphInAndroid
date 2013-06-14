package com.sks.piechart;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PieChartActivity extends Activity {

	List<PieItem> piedata = new ArrayList<PieItem>(0);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pie_chart);

		PieItem item;
		int maxCount = 0;
		int itemCount = 0;
		int items[] = { 1, 5, 3, 8, 6 };
		//int colors[] = { -6777216, -16776961, -16711681, -12303292, -7829368 };
		int colors[] = { -16776961, -16711936, -65536, -256, -12303292};
		String itemslabel[] = { "Part A 100", "Part B 200",
				"Part C 300", "Part D 400", "Part E 500" };
		for (int i = 0; i < items.length; i++) {
			itemCount = items[i];
			item = new PieItem();
			item.count = itemCount;
			item.label = itemslabel[i];
			item.color = colors[i];
			piedata.add(item);
			maxCount = maxCount + itemCount;
		}
		int size = 255;
		int BgColor = 0xffa11b1;
		Bitmap mBaggroundImage = Bitmap.createBitmap(size, size,Bitmap.Config.ARGB_8888);
		Piechart piechart = new Piechart(this);
		piechart.setLayoutParams(new LayoutParams(size, size));
		piechart.setGeometry(size, size, 2, 2, 2, 2, 2130837504);
		piechart.setSkinparams(BgColor);
		piechart.setData(piedata, maxCount);
		piechart.invalidate();
		piechart.draw(new Canvas(mBaggroundImage));
		piechart = null;
		ImageView mImageView = new ImageView(this);
		mImageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		mImageView.setBackgroundColor(BgColor);
		mImageView.setImageBitmap(mBaggroundImage);
		LinearLayout finalLayout = (LinearLayout) findViewById(R.id.pie_container);
		finalLayout.addView(mImageView);
	}
}