package jenkins_grid.jenkins_grid;

public class method_names {
	
	void m1()
	{
		System.out.println("m1 method" + Thread.currentThread().getStackTrace()[1].getClassName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	void m2()
	{
		System.out.println("m2 method" + Thread.currentThread().getStackTrace()[1].getClassName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	void m3()
	{
		System.out.println("m3 method" + Thread.currentThread().getStackTrace()[1].getClassName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	void m4()
	{
		System.out.println("m4 method" + Thread.currentThread().getStackTrace()[1].getClassName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
