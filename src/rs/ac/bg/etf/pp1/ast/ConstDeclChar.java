// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclChar extends ConstList {

    private ConstList ConstList;
    private ConstantName ConstantName;
    private Character C3;

    public ConstDeclChar (ConstList ConstList, ConstantName ConstantName, Character C3) {
        this.ConstList=ConstList;
        if(ConstList!=null) ConstList.setParent(this);
        this.ConstantName=ConstantName;
        if(ConstantName!=null) ConstantName.setParent(this);
        this.C3=C3;
    }

    public ConstList getConstList() {
        return ConstList;
    }

    public void setConstList(ConstList ConstList) {
        this.ConstList=ConstList;
    }

    public ConstantName getConstantName() {
        return ConstantName;
    }

    public void setConstantName(ConstantName ConstantName) {
        this.ConstantName=ConstantName;
    }

    public Character getC3() {
        return C3;
    }

    public void setC3(Character C3) {
        this.C3=C3;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstList!=null) ConstList.accept(visitor);
        if(ConstantName!=null) ConstantName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstList!=null) ConstList.traverseTopDown(visitor);
        if(ConstantName!=null) ConstantName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstList!=null) ConstList.traverseBottomUp(visitor);
        if(ConstantName!=null) ConstantName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclChar(\n");

        if(ConstList!=null)
            buffer.append(ConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstantName!=null)
            buffer.append(ConstantName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+C3);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclChar]");
        return buffer.toString();
    }
}
