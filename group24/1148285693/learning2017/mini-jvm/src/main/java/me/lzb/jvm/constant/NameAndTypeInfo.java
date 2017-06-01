package me.lzb.jvm.constant;

import me.lzb.jvm.print.PrintVisitor;

/**
 * @author LZB
 */
public class NameAndTypeInfo extends ConstantInfo {
    private int type = ConstantInfo.NameAndType_info;

    private int index1;
    private int index2;

    public NameAndTypeInfo(ConstantPool pool) {
        super(pool);
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void print(PrintVisitor visitor) {
        visitor.visitNameAndType(this);
    }

    public int getIndex1() {
        return index1;
    }

    public void setIndex1(int index1) {
        this.index1 = index1;
    }

    public int getIndex2() {
        return index2;
    }

    public void setIndex2(int index2) {
        this.index2 = index2;
    }


    public String getName() {
        ConstantPool pool = this.getConstantPool();
        UTF8Info utf8Info1 = (UTF8Info) pool.getConstantInfo(index1);
        return utf8Info1.getValue();
    }

    public String getTypeInfo() {
        ConstantPool pool = this.getConstantPool();
        UTF8Info utf8Info2 = (UTF8Info) pool.getConstantInfo(index2);
        return utf8Info2.getValue();
    }

    public String toString() {
        return getName() + "：" + getTypeInfo();
    }
}
