// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class VarDeclV extends VarDecl {

    private FirstDeclaredVariable FirstDeclaredVariable;
    private VarList VarList;

    public VarDeclV (FirstDeclaredVariable FirstDeclaredVariable, VarList VarList) {
        this.FirstDeclaredVariable=FirstDeclaredVariable;
        if(FirstDeclaredVariable!=null) FirstDeclaredVariable.setParent(this);
        this.VarList=VarList;
        if(VarList!=null) VarList.setParent(this);
    }

    public FirstDeclaredVariable getFirstDeclaredVariable() {
        return FirstDeclaredVariable;
    }

    public void setFirstDeclaredVariable(FirstDeclaredVariable FirstDeclaredVariable) {
        this.FirstDeclaredVariable=FirstDeclaredVariable;
    }

    public VarList getVarList() {
        return VarList;
    }

    public void setVarList(VarList VarList) {
        this.VarList=VarList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FirstDeclaredVariable!=null) FirstDeclaredVariable.accept(visitor);
        if(VarList!=null) VarList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FirstDeclaredVariable!=null) FirstDeclaredVariable.traverseTopDown(visitor);
        if(VarList!=null) VarList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FirstDeclaredVariable!=null) FirstDeclaredVariable.traverseBottomUp(visitor);
        if(VarList!=null) VarList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclV(\n");

        if(FirstDeclaredVariable!=null)
            buffer.append(FirstDeclaredVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarList!=null)
            buffer.append(VarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclV]");
        return buffer.toString();
    }
}
