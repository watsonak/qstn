package com.cgl.eng.activity;

import java.util.ArrayList;
import java.util.List;

import com.arun.externaldatabsedemo.R;
import com.cgl.eng.adapter.OptionsAdapter;
import com.cgl.eng.dao.QuestionDAO;
import com.cgl.eng.dao.QuestionDAOImpl;
import com.cgl.eng.entity.Question;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionActivity extends Activity {
	private QuestionDAO questionDao;
    private ListView listView ;
	
	private TextView questionView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question);
		questionDao = new QuestionDAOImpl(this);
		Question qstn = questionDao.getQuestion(1);
		System.out.println(qstn);
		questionView = (TextView) findViewById(R.id.questionView);
		questionView.setText(qstn.getQuestions());
		listView = (ListView)findViewById(R.id.optionList);
		OptionsAdapter optionsAdapter = new OptionsAdapter(this, qstn.getOptions());
		/*ArrayAdapter<String> itemsAdapter = 
			    new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, qstn.getOptions());*/
		listView.setAdapter(optionsAdapter);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
