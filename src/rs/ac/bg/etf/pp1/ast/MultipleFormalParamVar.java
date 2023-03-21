// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class MultipleFormalParamVar extends FormalParams {

    private FormalParams FormalParams;
    private Type Type;
    private Variable Variable;

    public MultipleFormalParamVar (FormalParams FormalParams, Type Type, Variable Variable) {
        this.FormalParams=FormalParams;
        if(FormalParams!=null) FormalParams.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Variable=Variable;
        if(Variable!=null) Variable.setParent(this);
    }

    public FormalParams getFormalParams() {
        return FormalParams;
    }

    public void setFormalParams(FormalParams FormalParams) {
        this.FormalParams=FormalParams;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public Variable getVariable() {
        return Variable;
    }

    public void setVariable(Variable Variable) {
        this.Variable=Variable;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormalParams!=null) FormalParams.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(Variable!=null) Variable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormalParams!=null) FormalParams.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Variable!=null) Variable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormalParams!=null) FormalParams.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Variable!=null) Variable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleFormalParamVar(\n");

        if(FormalParams!=null)
            buffer.append(FormalParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Variable!=null)
            buffer.append(Variable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleFormalParamVar]");
        return buffer.toString();
    }
}
