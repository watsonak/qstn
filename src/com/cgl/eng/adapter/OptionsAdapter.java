package com.cgl.eng.adapter;

import java.util.List;





import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class OptionsAdapter extends BaseAdapter{
    Context context;
    List<String> optionlist;
	
	
	public OptionsAdapter(Context context,
			List<String> optionlist) {
		super();
		this.context = context;
		this.optionlist = optionlist;
	}

	@Override
	public int getCount() {
		
		return optionlist.size();
	}

	@Override
	public Object getItem(int position) {
		
		return optionlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String choice = optionlist.get(position);
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);
			
		}
		TextView option = (TextView) convertView.findViewById(android.R.id.text1);
		option.setText(choice);
		
		return convertView;
	}

}
