package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyzer extends VisitorAdaptor {

	Obj currentMethod = null;
	Struct currentType = null;
	boolean mainDeclared = false;
	boolean errorDetected = false;
	boolean returnFound = false;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);

		int line = (info == null) ? 0 : info.getLine();
		if (line != 0) {
			msg.append(" at line ").append(line);
		}

		log.error(msg.toString());
		errorDetected = true;
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);

		int line = (info == null) ? 0 : info.getLine();
		if (line != 0) {
			msg.append(" at line ").append(line);
		}

		log.info(msg.toString());
	}

	@Override
	public void visit(ProgName progName) {
		String programName = progName.getProgName();

		progName.obj = Tab.insert(Obj.Prog, programName, Tab.noType);
		Tab.openScope();
	}

	@Override
	public void visit(Program program) {
		Obj progObject = program.getProgName().obj;

		Tab.chainLocalSymbols(progObject);
		Tab.closeScope();

		if (!mainDeclared) {
			report_error("Function main wasn't declared!", null);
		}
	}

	@Override
	public void visit(Type type) {
		String typeName = type.getTypeName();

		Obj typeObject = Tab.find(typeName);
		if (typeObject == Tab.noObj) {
			report_error("Type (" + typeName + ") not found in symbol table!", null);
			type.struct = Tab.noType;
			return;
		}

		if (typeObject.getKind() != Obj.Type) {
			report_error("Given type name (" + typeName + ") is not a type!", type);
			type.struct = Tab.noType;
			return;
		}

		type.struct = typeObject.getType();
	}

	@Override
	public void visit(MethodTypeName methodTypeName) {
		String methodName = methodTypeName.getMethodName();
		Struct methodReturnType = methodTypeName.getType().struct;

		if (declaredInCurrentScope(methodName)) {
			report_error("Method name (" + methodName + ") already in use!", null);
			methodTypeName.obj = Tab.noObj;
			return;
		}

		currentMethod = Tab.insert(Obj.Meth, methodName, methodReturnType);
		methodTypeName.obj = currentMethod;
		Tab.openScope();
	}

	@Override
	public void visit(VoidMethodName voidMethodName) {
		String methodName = voidMethodName.getMethodName();

		if (declaredInCurrentScope(methodName)) {
			report_error("Method name (" + methodName + ") already in use!", null);
			voidMethodName.obj = Tab.noObj;
			return;
		}

		currentMethod = Tab.insert(Obj.Meth, methodName, Tab.noType);
		voidMethodName.obj = currentMethod;
		Tab.openScope();
	}

	@Override
	public void visit(MethodDeclVoid methodDeclVoid) {
		String methodName = methodDeclVoid.getVoidMethodName().getMethodName();

		if ("main".equals(methodName) && currentMethod.getFpPos() == 0) {
			mainDeclared = true;
		}

		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();

		currentMethod = null;
	}

	@Override
	public void visit(MethodDeclRet methodDeclRet) {
		String methodName = methodDeclRet.getMethodTypeName().getMethodName();

		if (!returnFound) {
			report_error("Method (" + methodName + ") doesn't have a return statement!", null);
		}

		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();

		currentMethod = null;
		returnFound = false;
	}

	@Override
	public void visit(SingleFormalParamVar singleFormalParamVar) {
		String paramName = singleFormalParamVar.getVariable().getVarName();
		if (declaredInCurrentScope(paramName)) {
			report_error("Function paramater name (" + paramName + ") already in use!", null);
			return;
		}

		Tab.insert(Obj.Var, paramName, singleFormalParamVar.getType().struct);
		currentMethod.setFpPos(currentMethod.getFpPos() + 1);
	}

	@Override
	public void visit(SingleFormalParamArr singleFormalParamArr) {
		String paramName = singleFormalParamArr.getArray().getArrName();
		Struct arrayElementType = singleFormalParamArr.getType().struct;

		if (declaredInCurrentScope(paramName)) {
			report_error("Function paramater name (" + paramName + ") already in use!", null);
			return;
		}

		Struct arrayStruct = new Struct(Struct.Array, arrayElementType);

		Tab.insert(Obj.Var, paramName, arrayStruct);
		currentMethod.setFpPos(currentMethod.getFpPos() + 1);
	}

	@Override
	public void visit(MultipleFormalParamVar multipleFormalParamVar) {
		String paramName = multipleFormalParamVar.getVariable().getVarName();
		Struct type = multipleFormalParamVar.getType().struct;

		if (declaredInCurrentScope(paramName)) {
			report_error("Function paramater name (" + paramName + ") already in use!", null);
			return;
		}

		Tab.insert(Obj.Var, paramName, type);
		currentMethod.setFpPos(currentMethod.getFpPos() + 1);
	}

	@Override
	public void visit(MultipleFormalParamArr multipleFormalParamArr) {
		String paramName = multipleFormalParamArr.getArray().getArrName();
		Struct arrayElementType = multipleFormalParamArr.getType().struct;

		if (declaredInCurrentScope(paramName)) {
			report_error("Function paramater name (" + paramName + ") already in use!", null);
			return;
		}

		Struct arrayStruct = new Struct(Struct.Array, arrayElementType);

		Tab.insert(Obj.Var, paramName, arrayStruct);
		currentMethod.setFpPos(currentMethod.getFpPos() + 1);
	}

	@Override
	public void visit(VarDeclV varDeclV) {
		currentType = null;
	}

	@Override
	public void visit(VarDeclA varDeclA) {
		currentType = null;
	}

	@Override
	public void visit(VarDeclChain varDeclChain) {
		String varName = varDeclChain.getVariable().getVarName();
		Struct type = currentType;

		if (declaredInCurrentScope(varName)) {
			report_error("Variable name (" + varName + ") already in use!", null);
			return;
		}

		Tab.insert(Obj.Var, varName, type);
	}

	@Override
	public void visit(ArrDeclChain arrDeclChain) {
		String varName = arrDeclChain.getArray().getArrName();
		Struct type = currentType;

		if (declaredInCurrentScope(varName)) {
			report_error("Variable name (" + varName + ") already in use!", null);
			return;
		}

		Struct arrayStruct = new Struct(Struct.Array, type);

		Tab.insert(Obj.Var, varName, arrayStruct);
	}

	@Override
	public void visit(FirstDeclaredVariable firstDeclaredVariable) {
		String variableName = firstDeclaredVariable.getVariable().getVarName();
		Struct type = firstDeclaredVariable.getType().struct;

		if (declaredInCurrentScope(variableName)) {
			report_error("Variable name (" + variableName + ") already in use!", null);
			return;
		}

		Tab.insert(Obj.Var, variableName, type);
		currentType = type;
	}

	@Override
	public void visit(FirstDeclaredArray firstDeclaredArray) {
		String variableName = firstDeclaredArray.getArray().getArrName();
		Struct type = firstDeclaredArray.getType().struct;

		if (declaredInCurrentScope(variableName)) {
			report_error("Variable name (" + variableName + ") already in use!", null);
			return;
		}

		Struct arrayStruct = new Struct(Struct.Array, type);

		Tab.insert(Obj.Var, variableName, arrayStruct);
		currentType = type;
	}

	@Override
	public void visit(ConstDecl constDecl) {
		currentType = null;
	}

	@Override
	public void visit(ConstDeclNum constDeclNum) {

	}

	@Override
	public void visit(ConstDeclBool constDeclBool) {

	}

	@Override
	public void visit(ConstDeclChar constDeclChar) {

	}

	@Override
	public void visit(FirstDeclaredConstantNum firstDeclaredConstantNum) {
		String constantName = firstDeclaredConstantNum.getConstantName().getConstantName();
		Struct type = firstDeclaredConstantNum.getType().struct;
		String typeName = firstDeclaredConstantNum.getType().getTypeName();

		if (type.getKind() != Struct.Int) {
			report_error("Constant declaration type (" + typeName + ") doesn't match!", null);
			return;
		}

		if (declaredInCurrentScope(constantName)) {
			report_error("Constant name (" + constantName + ") already in use!", null);
			return;
		}

		Tab.insert(Obj.Var, constantName, type);
		currentType = type;
	}

	@Override
	public void visit(FirstDeclaredConstantBool firstDeclaredConstantBool) {

	}

	@Override
	public void visit(FirstDeclaredConstantChar firstDeclaredConstantChar) {

	}

	private boolean declaredInCurrentScope(String objName) {
		Obj foundObj = Tab.find(objName);

		return currentMethod == null ? foundObj != Tab.noObj
				: foundObj != Tab.noObj && currentMethod.getLevel() + 1 == foundObj.getLevel();
	}

	public boolean passed() {
		return !errorDetected;
	}

}
