package com.arun.externaldatabsedemo;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class EmployeeListAdapter extends BaseAdapter {

	Context context;
	ArrayList<EmployeeListItems> employeeList;

	public EmployeeListAdapter(Context context,
			ArrayList<EmployeeListItems> employeeList) {

		this.context = context;
		this.employeeList = employeeList;
	}

	@Override
	public int getCount() {

		return employeeList.size();
	}

	@Override
	public Object getItem(int position) {

		return employeeList.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		EmployeeListItems employeeListItems = employeeList.get(position);

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.employee_list_row, null);

		}
		TextView tvSlNo = (TextView) convertView.findViewById(R.id.tv_slno);
		tvSlNo.setText(employeeListItems.getEmpId());
		TextView tvFirstName = (TextView) convertView
				.findViewById(R.id.tv_first_name);
		tvFirstName.setText(employeeListItems.getFirstName());
		TextView tvLastName = (TextView) convertView
				.findViewById(R.id.tv_last_name);
		tvLastName.setText(employeeListItems.getLastName());
		TextView tvPhone = (TextView) convertView.findViewById(R.id.tv_phone);
		tvPhone.setText(employeeListItems.getPhoneNO());

		return convertView;
	}

}
