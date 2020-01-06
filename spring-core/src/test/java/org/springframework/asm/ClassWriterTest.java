package org.springframework.asm;

import org.junit.Test;
import org.mockito.internal.util.Supplier;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

import static org.junit.Assert.*;
import static org.springframework.asm.Opcodes.*;

/**
 * @author zhixiang.yuan
 * @since 2020/01/04 13:05:32
 */
public class ClassWriterTest {

	@Test
	public void test() throws InvocationTargetException, IllegalAccessException {
		//定义一个叫做Example的类
		ClassWriter classWriter = new ClassWriter(0);
		classWriter.visit(V1_1, ACC_PUBLIC, "Example", null, "java/lang/Object", null);

		//生成默认的构造方法
		MethodVisitor mw = classWriter.visitMethod(ACC_PUBLIC,
				"<init>",
				"()V",
				null,
				null);

		//生成构造方法的字节码指令
		mw.visitVarInsn(ALOAD, 0);
		mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		mw.visitInsn(RETURN);
		mw.visitMaxs(1, 1);
		mw.visitEnd();

		//生成main方法
		mw = classWriter.visitMethod(ACC_PUBLIC + ACC_STATIC,
				"main",
				"([Ljava/lang/String;)V",
				null,
				null);

		//生成main方法中的字节码指令
		mw.visitFieldInsn(GETSTATIC,
				"java/lang/System",
				"out",
				"Ljava/io/PrintStream;");

		mw.visitLdcInsn("Hello world!");
		mw.visitMethodInsn(INVOKEVIRTUAL,
				"java/io/PrintStream",
				"println",
				"(Ljava/lang/String;)V");
		mw.visitInsn(RETURN);
		mw.visitMaxs(2, 2);

		//字节码生成完成
		mw.visitEnd();

		// 获取生成的class文件对应的二进制流
		byte[] code = classWriter.toByteArray();
	}

}