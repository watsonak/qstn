package com.cgl.eng.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
	public static final String OPTN_DE_LIMITER = "\\|";
	private Integer QID;
	private String question;
	private List<String> options = new ArrayList<String>();
	private Integer rightOption;
	private Integer categoryID;
	private boolean isFavorite;

	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Integer getQID() {
		return QID;
	}

	public void parseOptions(String optionsStr) {
		String[] optionArray = null;
		if (optionsStr != null) {
			optionArray = optionsStr.split(OPTN_DE_LIMITER);
			options.addAll(Arrays.asList(optionArray));
		}

	}

	public void setQID(Integer qID) {
		QID = qID;
	}

	public String getQuestions() {
		return question;
	}

	public void setQuestions(String questions) {
		this.question = questions;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public Integer getRightOption() {
		return rightOption;
	}

	public void setRightOption(Integer rightOption) {
		this.rightOption = rightOption;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((QID == null) ? 0 : QID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (QID == null) {
			if (other.QID != null)
				return false;
		} else if (!QID.equals(other.QID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [QID=" + QID + ", question=" + question + ", options="
				+ options + ", rightOption=" + rightOption + ", categoryID="
				+ categoryID + ", isFavorite=" + isFavorite + "]";
	}

}
