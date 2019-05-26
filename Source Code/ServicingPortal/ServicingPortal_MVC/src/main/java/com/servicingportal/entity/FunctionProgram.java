package com.servicingportal.entity;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the functionprogram database table.
 * 
 */
@Entity
@Table(name = "functionprogram")
@NamedQuery(name="FunctionProgram.findAll", query="SELECT f FROM FunctionProgram f")
public class FunctionProgram  {
	@Id
	@GeneratedValue
	private int funcID;

	private String funcDescription;

	private String funcName;

	//bi-directional many-to-one association to RoleFunction
	@OneToMany(mappedBy="functionprogram", fetch=FetchType.LAZY)
	private List<RoleFunction> rolefunctions;

	public FunctionProgram() {
	}

	public int getFuncID() {
		return this.funcID;
	}

	public void setFuncID(int funcID) {
		this.funcID = funcID;
	}

	public String getFuncDescription() {
		return this.funcDescription;
	}

	public void setFuncDescription(String funcDescription) {
		this.funcDescription = funcDescription;
	}

	public String getFuncName() {
		return this.funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public List<RoleFunction> getRolefunctions() {
		return this.rolefunctions;
	}

	public void setRolefunctions(List<RoleFunction> rolefunctions) {
		this.rolefunctions = rolefunctions;
	}

	public RoleFunction addRolefunction(RoleFunction rolefunction) {
		getRolefunctions().add(rolefunction);
		rolefunction.setFunctionprogram(this);

		return rolefunction;
	}

	public RoleFunction removeRolefunction(RoleFunction rolefunction) {
		getRolefunctions().remove(rolefunction);
		rolefunction.setFunctionprogram(null);

		return rolefunction;
	}

}