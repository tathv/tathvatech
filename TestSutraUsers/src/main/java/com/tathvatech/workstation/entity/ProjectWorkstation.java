/*
 * Created on Nov 1, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.tathvatech.workstation.entity;

import java.util.Date;

import net.sf.persist.annotations.Column;
import net.sf.persist.annotations.Table;

/**
 * @author Hari
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@Table(name="TAB_PROJECT_WORKSTATIONS")
public class ProjectWorkstation
{
	private int pk;
	private int projectPk;
	private int workstationPk;
	private Date lastUpdated;
	
	@Column(autoGenerated=true)
    public int getPk()
	{
		return pk;
	}

	public void setPk(int pk)
	{
		this.pk = pk;
	}

	public int getProjectPk()
	{
		return projectPk;
	}

	public void setProjectPk(int projectPk)
	{
		this.projectPk = projectPk;
	}

	public int getWorkstationPk() {
		return workstationPk;
	}

	public void setWorkstationPk(int workstationPk) {
		this.workstationPk = workstationPk;
	}

	@Column(autoGenerated=true)
	public Date getLastUpdated()
	{
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated)
	{
		this.lastUpdated = lastUpdated;
	}

	public ProjectWorkstation()
    {
        super();
    }
}