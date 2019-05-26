package com.blackhole.entities;
// Generated Mar 1, 2019 9:23:01 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Functionprogram generated by hbm2java
 */
@Entity
@Table(name = "functionprogram", catalog = "servicingportaldb")
public class FunctionProgram implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer funcId;
	private String funcName;
	private String funcDescription;
	private Set<RoleFunction> rolefunctions = new HashSet<RoleFunction>(0);

	public FunctionProgram() {
	}

	public FunctionProgram(String funcName) {
		this.funcName = funcName;
	}

	public FunctionProgram(String funcName, String funcDescription, Set<RoleFunction> rolefunctions) {
		this.funcName = funcName;
		this.funcDescription = funcDescription;
		this.rolefunctions = rolefunctions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "FuncID", unique = true, nullable = false)
	public Integer getFuncId() {
		return this.funcId;
	}

	public void setFuncId(Integer funcId) {
		this.funcId = funcId;
	}

	@Column(name = "FuncName", nullable = false, length = 100)
	public String getFuncName() {
		return this.funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	@Column(name = "FuncDescription", length = 500)
	public String getFuncDescription() {
		return this.funcDescription;
	}

	public void setFuncDescription(String funcDescription) {
		this.funcDescription = funcDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "functionprogram")
	public Set<RoleFunction> getRolefunctions() {
		return this.rolefunctions;
	}

	public void setRolefunctions(Set<RoleFunction> rolefunctions) {
		this.rolefunctions = rolefunctions;
	}

}
