package com.cgl.eng.dao;

import com.cgl.eng.entity.Question;

public interface QuestionDAO {
	public Question getQuestion (Integer QID);
	public Boolean addToFav(Integer QID);

}
