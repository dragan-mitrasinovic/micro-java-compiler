// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private FirstDeclaredConstant FirstDeclaredConstant;
    private ConstList ConstList;

    public ConstDecl (FirstDeclaredConstant FirstDeclaredConstant, ConstList ConstList) {
        this.FirstDeclaredConstant=FirstDeclaredConstant;
        if(FirstDeclaredConstant!=null) FirstDeclaredConstant.setParent(this);
        this.ConstList=ConstList;
        if(ConstList!=null) ConstList.setParent(this);
    }

    public FirstDeclaredConstant getFirstDeclaredConstant() {
        return FirstDeclaredConstant;
    }

    public void setFirstDeclaredConstant(FirstDeclaredConstant FirstDeclaredConstant) {
        this.FirstDeclaredConstant=FirstDeclaredConstant;
    }

    public ConstList getConstList() {
        return ConstList;
    }

    public void setConstList(ConstList ConstList) {
        this.ConstList=ConstList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FirstDeclaredConstant!=null) FirstDeclaredConstant.accept(visitor);
        if(ConstList!=null) ConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FirstDeclaredConstant!=null) FirstDeclaredConstant.traverseTopDown(visitor);
        if(ConstList!=null) ConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FirstDeclaredConstant!=null) FirstDeclaredConstant.traverseBottomUp(visitor);
        if(ConstList!=null) ConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(FirstDeclaredConstant!=null)
            buffer.append(FirstDeclaredConstant.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstList!=null)
            buffer.append(ConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
