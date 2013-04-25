package com.bottle.coalmanage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import android.content.Context;
import android.util.Log;

public class MyList {
	public List<String> list;
	private String keyWord;
	private String fileUrl;
	private Context context;

	public MyList(String url, Context pContext) {
		this.keyWord = "String";
		this.fileUrl = url;
		this.context = pContext;
		list = new ArrayList<String>();

		setListContent();
	}

	private void setListContent() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser reader = factory.newSAXParser();
			XMLParase myClassRoomQueryConfig = new XMLParase(this.keyWord);
			InputStream inStream = this.context.getAssets().open(this.fileUrl);
			reader.parse(inStream, myClassRoomQueryConfig);
			list = myClassRoomQueryConfig.getList();
			inStream.close();
		} catch (Exception e) {
			Log.i("XML", e.toString());
		}
	}
}
