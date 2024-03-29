// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class ArrayAssignment extends DesignatorStatement {

    private Designator Designator;
    private ArrayAssignmentList ArrayAssignmentList;
    private Designator Designator1;

    public ArrayAssignment (Designator Designator, ArrayAssignmentList ArrayAssignmentList, Designator Designator1) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ArrayAssignmentList=ArrayAssignmentList;
        if(ArrayAssignmentList!=null) ArrayAssignmentList.setParent(this);
        this.Designator1=Designator1;
        if(Designator1!=null) Designator1.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ArrayAssignmentList getArrayAssignmentList() {
        return ArrayAssignmentList;
    }

    public void setArrayAssignmentList(ArrayAssignmentList ArrayAssignmentList) {
        this.ArrayAssignmentList=ArrayAssignmentList;
    }

    public Designator getDesignator1() {
        return Designator1;
    }

    public void setDesignator1(Designator Designator1) {
        this.Designator1=Designator1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ArrayAssignmentList!=null) ArrayAssignmentList.accept(visitor);
        if(Designator1!=null) Designator1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ArrayAssignmentList!=null) ArrayAssignmentList.traverseTopDown(visitor);
        if(Designator1!=null) Designator1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ArrayAssignmentList!=null) ArrayAssignmentList.traverseBottomUp(visitor);
        if(Designator1!=null) Designator1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayAssignment(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ArrayAssignmentList!=null)
            buffer.append(ArrayAssignmentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator1!=null)
            buffer.append(Designator1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayAssignment]");
        return buffer.toString();
    }
}
