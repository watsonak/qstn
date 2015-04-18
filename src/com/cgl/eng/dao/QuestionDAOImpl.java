package com.cgl.eng.dao;

import android.content.Context;
import android.database.Cursor;

import com.arun.externaldatabsedemo.DataBaseHelper;
import com.cgl.eng.entity.Question;

public class QuestionDAOImpl implements QuestionDAO {
	public final static String DB_NAME = "ENG_QST";
	private DataBaseHelper dataBaseHelper;
	public QuestionDAOImpl(Context context) {
		// TODO Auto-generated constructor stub
		init(context);
	}
	
	private void init(Context context){
		dataBaseHelper = DataBaseHelper.getInstance(context, DB_NAME);
	}

	@Override
	public Question getQuestion(Integer QID) {
		Question question = null;
		// select query 
		String query = "SELECT QID, QUESTION, OPTIONS, CATEGORY_ID, RIGHT_OPTION  FROM eng_questions";
		// excute : Exception not handled 
		Cursor cursor = DataBaseHelper.rawQuery(query);
		// do parsing
		if(cursor != null && cursor.getCount() == 1 ){
			question = new Question();
			cursor.moveToFirst();
			question.setQID(cursor.getInt(cursor.getColumnIndex("QID")));
			
			question.setQuestions(cursor.getString(cursor.getColumnIndex("QUESTION")));
			question.parseOptions(cursor.getString(cursor.getColumnIndex("OPTIONS")));
			question.setCategoryID(cursor.getInt(cursor.getColumnIndex("CATEGORY_ID")));
			question.setRightOption(cursor.getInt(cursor.getColumnIndex("RIGHT_OPTION")));
		}
		//return 
		return question;
	}

	@Override
	public Boolean addToFav(Integer QID) {
		// update isfav flag to true.
		
		return null;
	}

}
