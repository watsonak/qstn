package com.arun.externaldatabsedemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EmployeEdit extends Activity {

	private Button btCancel;
	private Button btDone;
	private EditText etfirstName;
	private EditText etlastaName;
	private EditText etPhone;
	private String employeeId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_employee);
		btDone = (Button) findViewById(R.id.bt_done);
		btCancel = (Button) findViewById(R.id.bt_cancel);
		etfirstName = (EditText) findViewById(R.id.et_edit_first_name);
		etlastaName = (EditText) findViewById(R.id.et_edit_last_name);
		etPhone = (EditText) findViewById(R.id.et_edit_phone);
		Bundle getData = getIntent().getExtras();
		employeeId = getData.getString("empID");

		setEditTextFields();

		btDone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String UpdateQuery = " UPDATE employe set first_name='"
						+ etfirstName.getText().toString() + "' ,"
						+ "last_name='" + etlastaName.getText().toString()
						+ "' , phone_no='" + etPhone.getText().toString()
						+ "' where employee_id='" + employeeId + "' ";

				DataBaseHelper.execute(UpdateQuery);
				Intent intent = new Intent(EmployeEdit.this, MainActivity.class);
				startActivity(intent);

			}
		});
		btCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}
		});
	}

	private void setEditTextFields() {

		String query = "SELECT * FROM employe where  employee_id='"
				+ employeeId + "' ";
		Cursor c1 = DataBaseHelper.rawQuery(query);
		if (c1 != null && c1.getCount() != 0) {
			if (c1.moveToFirst()) {
				do {

					etfirstName.setText(c1.getString(c1
							.getColumnIndex("first_name")));
					etlastaName.setText(c1.getString(c1
							.getColumnIndex("last_name")));
					etPhone.setText(c1.getString(c1.getColumnIndex("phone_no")));

				} while (c1.moveToNext());
			}
		}
		c1.close();
	}

}
