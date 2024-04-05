/*
 * Created on Jun 2, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.tathvatech.survey.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.persist.annotations.Column;
import net.sf.persist.annotations.Table;

/**
 * @author Hari
 * 
 */

@Table(name="entity_review_version")
public class EntityVersionReview implements Serializable
{
	public static enum ReviewStatus{Pending, Complete, Rejected};
	
	private int pk;
	private int	entityPk;
	private int entityType;
	private Date createdDate;
	private Date updatedDate;
	private int createdBy;
	private String objectJson;
	private String status;
	private Date lastUpdated;
	
	@Column(autoGenerated=true)
	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}
	public Date getCreatedDate()
	{
		return createdDate;
	}

	public int getEntityPk() {
		return entityPk;
	}

	public void setEntityPk(int entityPk) {
		this.entityPk = entityPk;
	}

	public int getEntityType() {
		return entityType;
	}

	public void setEntityType(int entityType) {
		this.entityType = entityType;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getObjectJson() {
		return objectJson;
	}

	public void setObjectJson(String objectJson) {
		this.objectJson = objectJson;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public int getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(int createdBy)
	{
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(autoGenerated=true)
	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
