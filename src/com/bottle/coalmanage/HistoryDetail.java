package com.bottle.coalmanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class HistoryDetail extends Activity {

	private ListView midListView;
	private ListView downListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.histroy_detail);
		
		midListView = (ListView) findViewById(R.id.mid_listView);
		downListView = (ListView) findViewById(R.id.d_listView);
		
		setListView();
	}
	
	private void setListView() {
		//先设置midListview
		MyList myList = new MyList("config/histoty_detail_mid.xml", HistoryDetail.this);
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		for (int i = 0; i < myList.list.size(); i += 3) {
			HashMap<String, String> hashMap = new HashMap<String, String>();
			hashMap.put("date", myList.list.get(i));
			hashMap.put("net_weight", myList.list.get(i + 1));
			hashMap.put("weight", myList.list.get(i + 2));
			list.add(hashMap);
		}
		ListAdapter adapter = new SimpleAdapter(
				HistoryDetail.this, list, 
				R.layout.adapter_item_detail_mid, 
				new String[] {"date", "net_weight", "weight" }, 
				new int[] { 
						R.id.txt_item_date,
						R.id.txt_item_coal_weight, 
						R.id.txt_item_weight });
		midListView.setAdapter(adapter);
		
		//设置dListview
		myList = new MyList("config/history_detail_down.xml", HistoryDetail.this);
		List<HashMap<String, String>> list2 = new ArrayList<HashMap<String, String>>();
		
		for (int i = 0; i < myList.list.size(); i += 6) {
			HashMap<String, String> hashMap = new HashMap<String, String>();
			hashMap.put("carNum", myList.list.get(i));
			hashMap.put("date", myList.list.get(i + 1));
			hashMap.put("coal_Weight", myList.list.get(i + 2));
			hashMap.put("core", myList.list.get(i + 3));
			hashMap.put("weight", myList.list.get(i + 4));
			hashMap.put("operater", myList.list.get(i + 5));
			list2.add(hashMap);
		}

		ListAdapter adapter2 = new SimpleAdapter(
				HistoryDetail.this, 
				list2, 
				R.layout.adapter_item_down, 
				new String[] {"carNum", "date", "coal_Weight", "core", "weight", "operater" }, 
				new int[] { 
						R.id.txt_item_car_num,
						R.id.txt_item_date, 
						R.id.txt_item_coal_weight, 
						R.id.txt_item_core, 
						R.id.txt_item_weight,
						R.id.txt_item_operater});
		downListView.setAdapter(adapter2);
	}

}
