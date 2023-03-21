// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class ArrayAssignmentAdd extends ArrayAssignmentList {

    private ArrayAssignmentList ArrayAssignmentList;
    private Designator Designator;

    public ArrayAssignmentAdd (ArrayAssignmentList ArrayAssignmentList, Designator Designator) {
        this.ArrayAssignmentList=ArrayAssignmentList;
        if(ArrayAssignmentList!=null) ArrayAssignmentList.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public ArrayAssignmentList getArrayAssignmentList() {
        return ArrayAssignmentList;
    }

    public void setArrayAssignmentList(ArrayAssignmentList ArrayAssignmentList) {
        this.ArrayAssignmentList=ArrayAssignmentList;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayAssignmentList!=null) ArrayAssignmentList.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayAssignmentList!=null) ArrayAssignmentList.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayAssignmentList!=null) ArrayAssignmentList.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayAssignmentAdd(\n");

        if(ArrayAssignmentList!=null)
            buffer.append(ArrayAssignmentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayAssignmentAdd]");
        return buffer.toString();
    }
}
