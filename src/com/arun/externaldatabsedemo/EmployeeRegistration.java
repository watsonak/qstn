package com.arun.externaldatabsedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EmployeeRegistration extends Activity {
	private Button btSubmit;
	private Button btCancel;
	private EditText etEmpId;
	private EditText etfirstName;
	private EditText etlastaName;
	private EditText etPhone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_registration);
		btSubmit = (Button) findViewById(R.id.bt_submit);
		btCancel = (Button) findViewById(R.id.bt_reg_cancel);
		etEmpId = (EditText) findViewById(R.id.et_id);
		etfirstName = (EditText) findViewById(R.id.et_first_name);
		etlastaName = (EditText) findViewById(R.id.et_last_name);
		etPhone = (EditText) findViewById(R.id.et_phone);

		btSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String insertQuery = "INSERT INTO employe VALUES('"
						+ etEmpId.getText().toString() + "'," + "'"
						+ etfirstName.getText().toString() + "','"
						+ etlastaName.getText().toString() + "','"
						+ etPhone.getText().toString() + "')";

				DataBaseHelper.execute(insertQuery);
				Intent intent = new Intent(EmployeeRegistration.this,
						MainActivity.class);
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

}
