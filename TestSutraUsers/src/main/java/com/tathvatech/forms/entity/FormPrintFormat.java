/*
 * Created on Nov 1, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.tathvatech.forms.entity;

import java.util.Date;

import net.sf.persist.annotations.Column;
import net.sf.persist.annotations.Table;

/**
 * @author Hari
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@Table(name = "form_print_format")
public class FormPrintFormat
{
	private int pk;
	private long formFk;
	private String printClassName;
	private String templateName;
	private String printAreaDef;
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

	public long getFormFk() {
		return formFk;
	}

	public void setFormFk(long formFk) {
		this.formFk = formFk;
	}

	public String getPrintClassName() {
		return printClassName;
	}

	public void setPrintClassName(String printClassName) {
		this.printClassName = printClassName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getPrintAreaDef() {
		return printAreaDef;
	}

	public void setPrintAreaDef(String printAreaDef) {
		this.printAreaDef = printAreaDef;
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
}
