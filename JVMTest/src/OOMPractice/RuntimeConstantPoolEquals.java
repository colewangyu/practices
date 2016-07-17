package OOMPractice;

public class RuntimeConstantPoolEquals {
	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		//“计算机软件”第一次出现，intern()方法将其放入运行时常量区，并返回常量区地址，因此相等。
		System.out.println(str1.intern() == str1); //true
		
		String str2 = new StringBuilder("ja").append("va").toString();
		//“java”非第一次出现（特殊字符，看似第一次出现，实际上不是），intern()方法返回其在运行时常量区的地址,str2本身指向堆区，因此不等
		System.out.println(str2.intern() == str2); //false
		
		String str3 = new StringBuilder("计算机").append("软件").toString();
		//“计算机软件”非第一次出现，intern()方法返回其在运行时常量区的地址
		System.out.println(str3.intern() == str3); //false
		
		//str1和str3均为“计算机软件”，执行intern()方法，返回运行时常量区的地址，为一个地址
		System.out.println(str1.intern() == str3.intern()); //true
		
		//
		System.out.println(str1 == str3.intern());
	}
}
