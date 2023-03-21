// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class Assignment extends Statement {

    private AssignmentStatement AssignmentStatement;

    public Assignment (AssignmentStatement AssignmentStatement) {
        this.AssignmentStatement=AssignmentStatement;
        if(AssignmentStatement!=null) AssignmentStatement.setParent(this);
    }

    public AssignmentStatement getAssignmentStatement() {
        return AssignmentStatement;
    }

    public void setAssignmentStatement(AssignmentStatement AssignmentStatement) {
        this.AssignmentStatement=AssignmentStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignmentStatement!=null) AssignmentStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignmentStatement!=null) AssignmentStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignmentStatement!=null) AssignmentStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Assignment(\n");

        if(AssignmentStatement!=null)
            buffer.append(AssignmentStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Assignment]");
        return buffer.toString();
    }
}
