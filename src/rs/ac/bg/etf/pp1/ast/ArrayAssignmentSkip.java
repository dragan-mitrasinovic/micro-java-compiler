// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class ArrayAssignmentSkip extends ArrayAssignmentList {

    private ArrayAssignmentList ArrayAssignmentList;

    public ArrayAssignmentSkip (ArrayAssignmentList ArrayAssignmentList) {
        this.ArrayAssignmentList=ArrayAssignmentList;
        if(ArrayAssignmentList!=null) ArrayAssignmentList.setParent(this);
    }

    public ArrayAssignmentList getArrayAssignmentList() {
        return ArrayAssignmentList;
    }

    public void setArrayAssignmentList(ArrayAssignmentList ArrayAssignmentList) {
        this.ArrayAssignmentList=ArrayAssignmentList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayAssignmentList!=null) ArrayAssignmentList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayAssignmentList!=null) ArrayAssignmentList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayAssignmentList!=null) ArrayAssignmentList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayAssignmentSkip(\n");

        if(ArrayAssignmentList!=null)
            buffer.append(ArrayAssignmentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayAssignmentSkip]");
        return buffer.toString();
    }
}
