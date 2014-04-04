package com.example.bluetoothfinder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RssiCompareSignalAdapter extends BaseAdapter {
	
private Context mContext;
	
	BluetoothSignalAdapter btSignal;
	
	
	public RssiCompareSignalAdapter(Context c) {
		mContext = c;
	}
	
	public RssiCompareSignalAdapter(Context c, BluetoothSignalAdapter btSignal) {
		mContext = c;
		this.btSignal=btSignal;
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public Object getItem(int position) {
		int compare = 0;
		if (btSignal == null || btSignal.getCount() < 4)
			return 0;
		switch (position) {
			case (0): 
				compare = ((BluetoothSignal)btSignal.getItem(0)).getRssi() -((BluetoothSignal)btSignal.getItem(1)).getRssi();
				break;
			case (1): 
				compare = ((BluetoothSignal)btSignal.getItem(2)).getRssi() -((BluetoothSignal)btSignal.getItem(3)).getRssi();
				break;
		}
		return (Integer)compare;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public boolean isEmpty() {
		if (btSignal.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView;
		if (convertView == null) {
			// Create new view
			// TODO: Move this into a layout file
			textView = new TextView(mContext);
		}
		else {
			// Recycle old view
			textView = (TextView)convertView;
		}
		int cur = (Integer)getItem(position);
		textView.setText("Result: " + cur + "\n");
		
		return textView;
	}
	
}
