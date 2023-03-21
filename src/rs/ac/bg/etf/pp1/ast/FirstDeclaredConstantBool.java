// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class FirstDeclaredConstantBool extends FirstDeclaredConstant {

    private Type Type;
    private ConstantName ConstantName;
    private Boolean B3;

    public FirstDeclaredConstantBool (Type Type, ConstantName ConstantName, Boolean B3) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstantName=ConstantName;
        if(ConstantName!=null) ConstantName.setParent(this);
        this.B3=B3;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstantName getConstantName() {
        return ConstantName;
    }

    public void setConstantName(ConstantName ConstantName) {
        this.ConstantName=ConstantName;
    }

    public Boolean getB3() {
        return B3;
    }

    public void setB3(Boolean B3) {
        this.B3=B3;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstantName!=null) ConstantName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstantName!=null) ConstantName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstantName!=null) ConstantName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FirstDeclaredConstantBool(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstantName!=null)
            buffer.append(ConstantName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+B3);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FirstDeclaredConstantBool]");
        return buffer.toString();
    }
}
