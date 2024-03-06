/*
 * Created on Nov 1, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.tathvatech.unit.entity;

import com.tathvatech.common.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Hari
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@Entity
@Table(name="TAB_UNIT_LOCATION")
public class UnitLocation extends AbstractEntity implements Serializable
{
	@Id
	private long pk;
	private int projectPk;
	private int unitPk;
	private int workstationPk;
	private String status;
	private int current;
	private Date moveInDate;
	private Date moveOutDate;
	private int movedInBy;
	private int movedOutBy;
	private Date firstFormAccessDate;
	private Date firstFormLockDate;
	private Date firstFormSaveDate;
	private Date lastFormAccessDate;
	private Date lastFormLockDate;
	private Date lastFormUnlockDate;
	private Date lastFormSaveDate;
	private Date completedDate;
	private Date lastUpdated;

	public long getPk() {
		return pk;
	}

	public void setPk(long pk) {
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

	public int getUnitPk() {
		return unitPk;
	}

	public void setUnitPk(int unitPk) {
		this.unitPk = unitPk;
	}

	public int getWorkstationPk() {
		return workstationPk;
	}

	public void setWorkstationPk(int workstationPk) {
		this.workstationPk = workstationPk;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public int getCurrent()
	{
		return current;
	}

	public void setCurrent(int current)
	{
		this.current = current;
	}

	public Date getMoveInDate() {
		return moveInDate;
	}

	public void setMoveInDate(Date moveInDate) {
		this.moveInDate = moveInDate;
	}

	public Date getMoveOutDate() {
		return moveOutDate;
	}

	public void setMoveOutDate(Date moveOutDate) {
		this.moveOutDate = moveOutDate;
	}

	public int getMovedInBy() {
		return movedInBy;
	}

	public void setMovedInBy(int movedInBy) {
		this.movedInBy = movedInBy;
	}

	public int getMovedOutBy() {
		return movedOutBy;
	}

	public void setMovedOutBy(int movedOutBy) {
		this.movedOutBy = movedOutBy;
	}

	public Date getFirstFormAccessDate() {
		return firstFormAccessDate;
	}

	public void setFirstFormAccessDate(Date firstFormAccessDate) {
		this.firstFormAccessDate = firstFormAccessDate;
	}

	public Date getFirstFormLockDate() {
		return firstFormLockDate;
	}

	public void setFirstFormLockDate(Date firstFormLockDate) {
		this.firstFormLockDate = firstFormLockDate;
	}

	public Date getFirstFormSaveDate() {
		return firstFormSaveDate;
	}

	public void setFirstFormSaveDate(Date firstFormSaveDate) {
		this.firstFormSaveDate = firstFormSaveDate;
	}

	public Date getLastFormAccessDate() {
		return lastFormAccessDate;
	}

	public void setLastFormAccessDate(Date lastFormAccessDate) {
		this.lastFormAccessDate = lastFormAccessDate;
	}

	public Date getLastFormLockDate() {
		return lastFormLockDate;
	}

	public void setLastFormLockDate(Date lastFormLockDate) {
		this.lastFormLockDate = lastFormLockDate;
	}

	public Date getLastFormUnlockDate() {
		return lastFormUnlockDate;
	}

	public void setLastFormUnlockDate(Date lastFormUnlockDate) {
		this.lastFormUnlockDate = lastFormUnlockDate;
	}

	public Date getLastFormSaveDate() {
		return lastFormSaveDate;
	}

	public void setLastFormSaveDate(Date lastFormSaveDate) {
		this.lastFormSaveDate = lastFormSaveDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}


	public Date getLastUpdated()
	{
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated)
	{
		this.lastUpdated = lastUpdated;
	}

	/**
     * 
     */
    public UnitLocation()
    {
    }

    public static String STATUS_WAITING = "Waiting";
    public static String STATUS_IN_PROGRESS = "In Progress";
    public static final String STATUS_COMPLETED = "Completed";
}