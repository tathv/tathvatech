package com.tathvatech.openitem.andon.entity;

import com.tathvatech.common.entity.AbstractEntity;
import com.tathvatech.openitem.andon.oids.OpenItemOID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name="openitem_v2")
public class OpenItemV2 extends AbstractEntity implements Serializable
{
	public static enum StatusEnum{Draft, Open, Completed, Closed};
	
	public static String ImageContextPrimary = "Primary";
	
	@Id
	private long pk;
	private int openItemSetPk;
	private int openItemType;
	private String referenceNo;
	private Integer projectPk;
	private Integer unitPk;
	private Integer projectStageFk;
	private String status;
	private Integer reportedAtWorkstationPk;
	private Integer fixAtWorkstationPk;
	private String description;
	private String assyNo;
	private String supplier;
	private String carType;
	private String tramNo;
	private String partNo;
	public String partDesc;
	public String partRequiredDesc;
	private String functionVal;
	private Float quantity;
	private Integer unitOfMeasurePk;
	private Boolean escape;
	private String rootCause;
	private String reworkOrderNo;
	private String resourceRequirement;
	private Date forecastStartDate;
	private Date forecastCompletionDate;
	private Integer custodianPk;
	private String disposition;
	private Integer category;
	private Integer subcategory;
	private Float estimatedHours;
	private Integer priority;
	private Integer severity;
	private Integer occurance;
	private Integer detection;
	private String source;
	private Integer createdBy;
	private Date createdDate;
	private Integer publishedBy;
	private Date publishedDate;
	private Integer completedBy;
	private Date completedDate;
	private String completedComment;
	private Integer closedBy;
	private Date closedDate;
	private String closedComment;
	private String comments;
	private Boolean internalIssue;
	private String extDescription;
	private String extComment;
	private Integer markedInternalByPk;
	private Date markedInternalDate;

	private Integer pictureFk; // represents the project level attached picture on which the open item is marked.
	private Integer xCord;
	private Integer yCord;
	
	private Date lastUpdated;

	public OpenItemOID getOID() 
	{
		return new OpenItemOID((int) pk, referenceNo);
	}

	@Override
	public long getPk() {
		return pk;
	}

	public void setPk(long pk) {
		this.pk = pk;
	}

	public int getOpenItemSetPk()
	{
		return openItemSetPk;
	}

	public void setOpenItemSetPk(int openItemSetPk)
	{
		this.openItemSetPk = openItemSetPk;
	}

	public Integer getProjectPk()
	{
		return projectPk;
	}

	public void setProjectPk(Integer projectPk)
	{
		this.projectPk = projectPk;
	}

	public Integer getUnitPk()
	{
		return unitPk;
	}

	public void setUnitPk(Integer unitPk)
	{
		this.unitPk = unitPk;
	}

	public Integer getProjectStageFk()
	{
		return projectStageFk;
	}

	public void setProjectStageFk(Integer projectStageFk)
	{
		this.projectStageFk = projectStageFk;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public Integer getReportedAtWorkstationPk()
	{
		return reportedAtWorkstationPk;
	}

	public void setReportedAtWorkstationPk(Integer reportedAtWorkstationPk)
	{
		this.reportedAtWorkstationPk = reportedAtWorkstationPk;
	}

	public Integer getFixAtWorkstationPk()
	{
		return fixAtWorkstationPk;
	}

	public void setFixAtWorkstationPk(Integer fixAtWorkstationPk)
	{
		this.fixAtWorkstationPk = fixAtWorkstationPk;
	}

	public int getOpenItemType()
	{
		return openItemType;
	}

	public void setOpenItemType(int openItemType)
	{
		this.openItemType = openItemType;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getAssyNo()
	{
		return assyNo;
	}

	public void setAssyNo(String assyNo)
	{
		this.assyNo = assyNo;
	}

	public String getSupplier()
	{
		return supplier;
	}

	public void setSupplier(String supplier)
	{
		this.supplier = supplier;
	}

	public String getCarType()
	{
		return carType;
	}

	public void setCarType(String carType)
	{
		this.carType = carType;
	}

	public String getTramNo()
	{
		return tramNo;
	}

	public void setTramNo(String tramNo)
	{
		this.tramNo = tramNo;
	}

	public String getPartNo()
	{
		return partNo;
	}

	public void setPartNo(String partNo)
	{
		this.partNo = partNo;
	}

	public String getPartDesc()
	{
		return partDesc;
	}

	public void setPartDesc(String partDesc)
	{
		this.partDesc = partDesc;
	}

	public String getPartRequiredDesc()
	{
		return partRequiredDesc;
	}

	public void setPartRequiredDesc(String partRequiredDesc)
	{
		this.partRequiredDesc = partRequiredDesc;
	}

	public String getFunctionVal()
	{
		return functionVal;
	}

	public void setFunctionVal(String functionVal)
	{
		this.functionVal = functionVal;
	}

	public String getReferenceNo()
	{
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo)
	{
		this.referenceNo = referenceNo;
	}

	public Float getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Float quantity)
	{
		this.quantity = quantity;
	}

	public Integer getUnitOfMeasurePk()
	{
		return unitOfMeasurePk;
	}

	public void setUnitOfMeasurePk(Integer unitOfMeasurePk)
	{
		this.unitOfMeasurePk = unitOfMeasurePk;
	}

	public Boolean getEscape()
	{
		return escape;
	}

	public void setEscape(Boolean escape)
	{
		this.escape = escape;
	}

	public String getRootCause()
	{
		return rootCause;
	}

	public void setRootCause(String rootCause)
	{
		this.rootCause = rootCause;
	}

	public String getReworkOrderNo()
	{
		return reworkOrderNo;
	}

	public void setReworkOrderNo(String reworkOrderNo)
	{
		this.reworkOrderNo = reworkOrderNo;
	}

	public String getResourceRequirement()
	{
		return resourceRequirement;
	}

	public void setResourceRequirement(String resourceRequirement)
	{
		this.resourceRequirement = resourceRequirement;
	}
	public Date getForecastStartDate()
	{
		return forecastStartDate;
	}

	public void setForecastStartDate(Date forecastStartDate)
	{
		this.forecastStartDate = forecastStartDate;
	}

	public Date getForecastCompletionDate()
	{
		return forecastCompletionDate;
	}

	public void setForecastCompletionDate(Date forecastCompletionDate)
	{
		this.forecastCompletionDate = forecastCompletionDate;
	}

	public Integer getCustodianPk()
	{
		return custodianPk;
	}

	public void setCustodianPk(Integer custodianPk)
	{
		this.custodianPk = custodianPk;
	}

	public String getDisposition()
	{
		return disposition;
	}

	public void setDisposition(String disposition)
	{
		this.disposition = disposition;
	}

	public Integer getCategory()
	{
		return category;
	}

	public void setCategory(Integer category)
	{
		this.category = category;
	}

	public Integer getSubcategory()
	{
		return subcategory;
	}

	public void setSubcategory(Integer subcategory)
	{
		this.subcategory = subcategory;
	}

	public Float getEstimatedHours()
	{
		return estimatedHours;
	}

	public void setEstimatedHours(Float estimatedHours)
	{
		this.estimatedHours = estimatedHours;
	}

	public Integer getPriority()
	{
		return priority;
	}

	public void setPriority(Integer priority)
	{
		this.priority = priority;
	}

	public Integer getSeverity()
	{
		return severity;
	}

	public void setSeverity(Integer severity)
	{
		this.severity = severity;
	}

	public Integer getOccurance()
	{
		return occurance;
	}

	public void setOccurance(Integer occurance)
	{
		this.occurance = occurance;
	}

	public Integer getDetection()
	{
		return detection;
	}

	public void setDetection(Integer detection)
	{
		this.detection = detection;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public Integer getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy)
	{
		this.createdBy = createdBy;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Date getPublishedDate()
	{
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate)
	{
		this.publishedDate = publishedDate;
	}

	public Integer getPublishedBy()
	{
		return publishedBy;
	}

	public void setPublishedBy(Integer publishedBy)
	{
		this.publishedBy = publishedBy;
	}

	public Date getCompletedDate()
	{
		return completedDate;
	}

	public void setCompletedDate(Date completedDate)
	{
		this.completedDate = completedDate;
	}

	public Integer getCompletedBy()
	{
		return completedBy;
	}

	public void setCompletedBy(Integer completedBy)
	{
		this.completedBy = completedBy;
	}

	public String getCompletedComment()
	{
		return completedComment;
	}

	public void setCompletedComment(String completedComment)
	{
		this.completedComment = completedComment;
	}

	public Date getClosedDate()
	{
		return closedDate;
	}

	public void setClosedDate(Date closedDate)
	{
		this.closedDate = closedDate;
	}

	public Integer getClosedBy()
	{
		return closedBy;
	}

	public void setClosedBy(Integer closedBy)
	{
		this.closedBy = closedBy;
	}

	public String getClosedComment()
	{
		return closedComment;
	}

	public void setClosedComment(String closedComment)
	{
		this.closedComment = closedComment;
	}

	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}


	public Date getLastUpdated()
	{
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated)
	{
		this.lastUpdated = lastUpdated;
	}

	public Boolean getInternalIssue()
	{
		return internalIssue;
	}

	public void setInternalIssue(Boolean internalIssue)
	{
		this.internalIssue = internalIssue;
	}

	public String getExtDescription()
	{
		return extDescription;
	}

	public void setExtDescription(String extDescription)
	{
		this.extDescription = extDescription;
	}

	public String getExtComment()
	{
		return extComment;
	}

	public void setExtComment(String extComment)
	{
		this.extComment = extComment;
	}

	public Integer getMarkedInternalByPk()
	{
		return markedInternalByPk;
	}

	public void setMarkedInternalByPk(Integer markedInternalByPk)
	{
		this.markedInternalByPk = markedInternalByPk;
	}

	public Date getMarkedInternalDate()
	{
		return markedInternalDate;
	}

	public void setMarkedInternalDate(Date markedInternalDate)
	{
		this.markedInternalDate = markedInternalDate;
	}

	public Integer getPictureFk()
	{
		return pictureFk;
	}

	public void setPictureFk(Integer pictureFk)
	{
		this.pictureFk = pictureFk;
	}

	public Integer getxCord()
	{
		return xCord;
	}

	public void setxCord(Integer xCord)
	{
		this.xCord = xCord;
	}

	public Integer getyCord()
	{
		return yCord;
	}

	public void setyCord(Integer yCord)
	{
		this.yCord = yCord;
	}

}
