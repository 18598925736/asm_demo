package com.zhou.lifecycle;


import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class LifecycleMethodVisitor extends MethodVisitor {

    private String className;
    private String methodName;

    public LifecycleMethodVisitor(MethodVisitor mv, String className, String methodName) {
        super(Opcodes.ASM5, mv);
        this.className = className;
        this.methodName = methodName;
    }

    @Override
    public void visitCode() {
        super.visitCode();
        System.out.println("Method visitor visited code---------");

        mv.visitLdcInsn("TAG"); // 预设方法入参1
        mv.visitLdcInsn(className + "---->" + methodName); // 预设方法入参2
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, // 调用静态方法
                "android/util/Log", // 方法所在的类签名
                "i", // 方法名i
                "(Ljava/lang/String;Ljava/lang/String;)I", // 锁定了 android.util.Log类中的静态方法 int i(String tag,String message)
                false // 不是接口，所以传false
        );
        mv.visitInsn(Opcodes.POP);
    }
}
