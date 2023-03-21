// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class FirstDeclaredConstantChar extends FirstDeclaredConstant {

    private Type Type;
    private ConstantName ConstantName;
    private Character C3;

    public FirstDeclaredConstantChar (Type Type, ConstantName ConstantName, Character C3) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstantName=ConstantName;
        if(ConstantName!=null) ConstantName.setParent(this);
        this.C3=C3;
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
        buffer.append("FirstDeclaredConstantChar(\n");

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

        buffer.append(" "+tab+C3);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FirstDeclaredConstantChar]");
        return buffer.toString();
    }
}
