// generated with ast extension for cup
// version 0.8
// 9/0/2023 15:11:29


package rs.ac.bg.etf.pp1.ast;

public class MultipleFormalParamArr extends FormalParams {

    private FormalParams FormalParams;
    private Type Type;
    private Array Array;

    public MultipleFormalParamArr (FormalParams FormalParams, Type Type, Array Array) {
        this.FormalParams=FormalParams;
        if(FormalParams!=null) FormalParams.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Array=Array;
        if(Array!=null) Array.setParent(this);
    }

    public FormalParams getFormalParams() {
        return FormalParams;
    }

    public void setFormalParams(FormalParams FormalParams) {
        this.FormalParams=FormalParams;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public Array getArray() {
        return Array;
    }

    public void setArray(Array Array) {
        this.Array=Array;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormalParams!=null) FormalParams.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(Array!=null) Array.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormalParams!=null) FormalParams.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Array!=null) Array.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormalParams!=null) FormalParams.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Array!=null) Array.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleFormalParamArr(\n");

        if(FormalParams!=null)
            buffer.append(FormalParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Array!=null)
            buffer.append(Array.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleFormalParamArr]");
        return buffer.toString();
    }
}
