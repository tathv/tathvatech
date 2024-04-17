/*
 * Created on Jun 2, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.tathvatech.forms.entity;

import java.io.Serializable;
import java.util.Date;

import com.tathvatech.common.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * @author Hari
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */

@Entity
@Table(name="TAB_RESPONSE_desc")
public class FormResponseDesc extends AbstractEntity implements Serializable
{
	@Id
	private long pk;
	private int		responseId;

	private int		surveyPk;
	private String	questionId;
	private Integer 	key1;
	private Integer		key2;
	private Integer 	key3;
	private String 	key4;
	private Date lastUpdated;



	public long getPk() {
		return pk;
	}

	public void setPk(long pk) {
		this.pk = pk;
	}

	public int getResponseId()
	{
		return responseId;
	}

	public void setResponseId(int responseId)
	{
		this.responseId = responseId;
	}

	public int getSurveyPk() {
		return surveyPk;
	}

	public void setSurveyPk(int surveyPk) {
		this.surveyPk = surveyPk;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public Integer getKey1() {
		return key1;
	}

	public void setKey1(Integer key1) {
		this.key1 = key1;
	}

	public Integer getKey2() {
		return key2;
	}

	public void setKey2(Integer key2) {
		this.key2 = key2;
	}

	public Integer getKey3() {
		return key3;
	}

	public void setKey3(Integer key3) {
		this.key3 = key3;
	}

	public String getKey4() {
		return key4;
	}

	public void setKey4(String key4) {
		this.key4 = key4;
	}


	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}