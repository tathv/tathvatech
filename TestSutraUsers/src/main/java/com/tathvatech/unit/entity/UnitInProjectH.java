package com.tathvatech.unit.entity;

import com.tathvatech.common.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name="unit_project_ref_h")
public class UnitInProjectH extends AbstractEntity implements Serializable
{
	@Id
	private long pk;
	private int unitInProjectPk;
	private Integer projectPartPk;
	private String status;
	private int createdBy;
	private Date createdDate;
	private Integer parentPk;
	private Integer rootParentPk;
	private int level;
	private boolean hasChildren;
	private int orderNo;
	private String heiCode;
	private Date effectiveDateFrom;
	private Date effectiveDateTo;
	private Integer actionPk;
	private Date lastUpdated;

	public long getPk() {
		return pk;
	}

	public void setPk(long pk) {
		this.pk = pk;
	}

	public int getUnitInProjectPk()
	{
		return unitInProjectPk;
	}
	public void setUnitInProjectPk(int unitInProjectPk)
	{
		this.unitInProjectPk = unitInProjectPk;
	}
	public Integer getParentPk()
	{
		return parentPk;
	}
	public void setParentPk(Integer parentPk)
	{
		this.parentPk = parentPk;
	}
	public Integer getRootParentPk()
	{
		return rootParentPk;
	}
	public void setRootParentPk(Integer rootParentPk)
	{
		this.rootParentPk = rootParentPk;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}
	public boolean getHasChildren()
	{
		return hasChildren;
	}
	public void setHasChildren(boolean hasChildren)
	{
		this.hasChildren = hasChildren;
	}
	public int getOrderNo()
	{
		return orderNo;
	}
	public void setOrderNo(int orderNo)
	{
		this.orderNo = orderNo;
	}
	public String getHeiCode()
	{
		return heiCode;
	}
	public void setHeiCode(String heiCode)
	{
		this.heiCode = heiCode;
	}
	public Date getEffectiveDateFrom()
	{
		return effectiveDateFrom;
	}
	public void setEffectiveDateFrom(Date effectiveDateFrom)
	{
		this.effectiveDateFrom = effectiveDateFrom;
	}
	public Date getEffectiveDateTo()
	{
		return effectiveDateTo;
	}
	public void setEffectiveDateTo(Date effectiveDateTo)
	{
		this.effectiveDateTo = effectiveDateTo;
	}
	public Integer getActionPk()
	{
		return actionPk;
	}
	public void setActionPk(Integer actionPk)
	{
		this.actionPk = actionPk;
	}
	public Integer getProjectPartPk()
	{
		return projectPartPk;
	}
	public void setProjectPartPk(Integer projectPartPk)
	{
		this.projectPartPk = projectPartPk;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public int getCreatedBy()
	{
		return createdBy;
	}
	public void setCreatedBy(int createdBy)
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


	public Date getLastUpdated()
	{
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated)
	{
		this.lastUpdated = lastUpdated;
	}
	
	public UnitInProjectH clone()
	{
		UnitInProjectH h = new UnitInProjectH();
		h.pk = pk;
		h.unitInProjectPk = unitInProjectPk;
		h.projectPartPk = projectPartPk;
		h.status = status;
		h.createdBy = createdBy;
		h.createdDate = createdDate;
		h.parentPk = parentPk;
		h.rootParentPk = rootParentPk;
		h.level = level;
		h.hasChildren = hasChildren;
		h.orderNo = orderNo;
		h.heiCode = heiCode;
		h.effectiveDateFrom = effectiveDateFrom;
		h.effectiveDateTo = effectiveDateTo;
		h.lastUpdated = lastUpdated;
		
		return h;
		
	}
}