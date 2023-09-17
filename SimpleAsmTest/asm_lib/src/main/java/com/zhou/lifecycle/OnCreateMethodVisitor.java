package com.zhou.lifecycle;


import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class OnCreateMethodVisitor extends MethodVisitor {

    private String className;
    private String methodName;

    public OnCreateMethodVisitor(MethodVisitor mv, String className, String methodName) {
        super(Opcodes.ASM5, mv);
        this.className = className;
        this.methodName = methodName;
    }


    @Override
    public void visitInsn(int opcode) {
        if (opcode == Opcodes.RETURN) {// 在原来的方法体执行之后，加入字节码
            // 加入日志打印代码
            mv.visitLdcInsn("ActivityTag"); // 预设方法入参1
            mv.visitLdcInsn(className + "--after-->" + methodName); // 预设方法入参2
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, // 调用静态方法
                    "android/util/Log", // 方法所在的类签名
                    "i", // 方法名i
                    "(Ljava/lang/String;Ljava/lang/String;)I", // 锁定了 android.util.Log类中的静态方法 int i(String tag,String message)
                    false // 不是接口，所以传false
            );
        }
        super.visitInsn(opcode);
    }

    // 在原来的方法体执行之后，加入字节码
    @Override
    public void visitCode() {
        super.visitCode(); // 这行代码可有可无
        System.out.println("Method visitor visited code---------");

        mv.visitLdcInsn("ActivityTag"); // 预设方法入参1
        mv.visitLdcInsn(className + "--before-->" + methodName); // 预设方法入参2
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, // 调用静态方法
                "android/util/Log", // 方法所在的类签名
                "i", // 方法名i
                "(Ljava/lang/String;Ljava/lang/String;)I", // 锁定了 android.util.Log类中的静态方法 int i(String tag,String message)
                false // 不是接口，所以传false
        );

        mv.visitInsn(Opcodes.POP);
    }

}
