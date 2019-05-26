package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.FunctionProgram;

public interface FunctionProgramDAO {
	public boolean createFunctionProgram(FunctionProgram functionProgram);
	public List<FunctionProgram> getListFuctionProgram();
	public FunctionProgram getFunctionProgramByID(int idFunctionProgram);
	public int getMaxFunctionProgramID();
}
