package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Itemlevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "itemlevel", catalog = "o2owebsit")
public class Itemlevel implements java.io.Serializable {

	// Fields

	private Integer idItemLevel;
	private Integer surperId;
	private String levelName;
	private String subsuperIds;

	// Constructors

	/** default constructor */
	public Itemlevel() {
	}

	/** minimal constructor */
	public Itemlevel(Integer surperId, String levelName) {
		this.surperId = surperId;
		this.levelName = levelName;
	}

	/** full constructor */
	public Itemlevel(Integer surperId, String levelName, String subsuperIds) {
		this.surperId = surperId;
		this.levelName = levelName;
		this.subsuperIds = subsuperIds;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "idItemLevel", unique = true, nullable = false)
	public Integer getIdItemLevel() {
		return this.idItemLevel;
	}

	public void setIdItemLevel(Integer idItemLevel) {
		this.idItemLevel = idItemLevel;
	}

	@Column(name = "surperID", nullable = false)
	public Integer getSurperId() {
		return this.surperId;
	}

	public void setSurperId(Integer surperId) {
		this.surperId = surperId;
	}

	@Column(name = "LevelName", nullable = false, length = 45)
	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	@Column(name = "subsuperIDs")
	public String getSubsuperIds() {
		return this.subsuperIds;
	}

	public void setSubsuperIds(String subsuperIds) {
		this.subsuperIds = subsuperIds;
	}

}