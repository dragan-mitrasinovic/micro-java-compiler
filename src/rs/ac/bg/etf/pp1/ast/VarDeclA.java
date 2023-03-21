// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class VarDeclA extends VarDecl {

    private FirstDeclaredArray FirstDeclaredArray;
    private VarList VarList;

    public VarDeclA (FirstDeclaredArray FirstDeclaredArray, VarList VarList) {
        this.FirstDeclaredArray=FirstDeclaredArray;
        if(FirstDeclaredArray!=null) FirstDeclaredArray.setParent(this);
        this.VarList=VarList;
        if(VarList!=null) VarList.setParent(this);
    }

    public FirstDeclaredArray getFirstDeclaredArray() {
        return FirstDeclaredArray;
    }

    public void setFirstDeclaredArray(FirstDeclaredArray FirstDeclaredArray) {
        this.FirstDeclaredArray=FirstDeclaredArray;
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
        if(FirstDeclaredArray!=null) FirstDeclaredArray.accept(visitor);
        if(VarList!=null) VarList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FirstDeclaredArray!=null) FirstDeclaredArray.traverseTopDown(visitor);
        if(VarList!=null) VarList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FirstDeclaredArray!=null) FirstDeclaredArray.traverseBottomUp(visitor);
        if(VarList!=null) VarList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclA(\n");

        if(FirstDeclaredArray!=null)
            buffer.append(FirstDeclaredArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarList!=null)
            buffer.append(VarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclA]");
        return buffer.toString();
    }
}
