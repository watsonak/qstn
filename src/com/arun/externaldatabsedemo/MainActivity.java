package com.arun.externaldatabsedemo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	private DataBaseHelper dataBaseHelper;
	private ListView lvEmployee;
	private Button btRegister;
	private static final String DB_NAME = "EMPLOYEE_DB";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dataBaseHelper = DataBaseHelper.getInstance(this, DB_NAME);
		lvEmployee = (ListView) findViewById(R.id.lv_employee);
		btRegister = (Button) findViewById(R.id.btn_register);

		showEmployeeDetails();

		lvEmployee.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				EmployeeListItems listItems = (EmployeeListItems) arg0
						.getItemAtPosition(position);
				String employeeId = listItems.getEmpId();
				Bundle passData = new Bundle();
				passData.putString("empID", employeeId);
				Intent Editintent = new Intent(MainActivity.this,
						EmployeEdit.class);
				Editintent.putExtras(passData);
				startActivity(Editintent);

				return false;
			}
		});

		btRegister.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						EmployeeRegistration.class);
				startActivity(intent);

			}
		});
	}

	private void showEmployeeDetails() {

		ArrayList<EmployeeListItems> employeeList = new ArrayList<EmployeeListItems>();
		employeeList.clear();
		String query = "SELECT * FROM employe";
		Cursor c1 = DataBaseHelper.rawQuery(query);

		if (c1 != null && c1.getCount() != 0) {
			if (c1.moveToFirst()) {
				do {
					EmployeeListItems employeeListItems = new EmployeeListItems();

					employeeListItems.setEmpId(c1.getString(c1
							.getColumnIndex("employee_id")));
					employeeListItems.setFirstName(c1.getString(c1
							.getColumnIndex("first_name")));
					employeeListItems.setLastName(c1.getString(c1
							.getColumnIndex("last_name")));
					employeeListItems.setPhoneNO(c1.getString(c1
							.getColumnIndex("phone_no")));
					employeeList.add(employeeListItems);

				} while (c1.moveToNext());
			}
		}
		c1.close();

		EmployeeListAdapter employeeListAdapter = new EmployeeListAdapter(
				MainActivity.this, employeeList);
		lvEmployee.setAdapter(employeeListAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
