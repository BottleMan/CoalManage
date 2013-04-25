package com.bottle.coalmanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private ListView listView;
	private Button btnHistoryBusiness;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ListView) findViewById(R.id.listview);
		btnHistoryBusiness = (Button) findViewById(R.id.btn_history);
		
		btnHistoryBusiness.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, HistoryDetail.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		setListView();
	}

	private void setListView() {

		MyList myList = new MyList("config/details.xml", MainActivity.this);

		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < myList.list.size(); i += 5) {
			HashMap<String, String> hashMap = new HashMap<String, String>();
			hashMap.put("carNum", myList.list.get(i));
			hashMap.put("date", myList.list.get(i + 1));
			hashMap.put("coal_Weight", myList.list.get(i + 2));
			hashMap.put("core", myList.list.get(i + 3));
			hashMap.put("weight", myList.list.get(i + 4));
			list.add(hashMap);
		}

		ListAdapter adapter = new SimpleAdapter(MainActivity.this, list, R.layout.adapter_item, new String[] {
				"carNum", "date", "coal_Weight", "core", "weight" }, new int[] { R.id.txt_item_car_num,
				R.id.txt_item_date, R.id.txt_item_coal_weight, R.id.txt_item_core, R.id.txt_item_weight });

		listView.setAdapter(adapter);
	}

}
