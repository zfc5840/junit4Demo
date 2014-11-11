package com.junit;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import java.util.Arrays;

//@RunWith(TestClassRunner.class)默认运行器
@RunWith(Parameterized.class)
public class CalculateTest {
	public static Calculate calcuate = new Calculate();
	
	private int a;
	private int b;
	private int result;
	
	@Parameters
	@SuppressWarnings("rawtypes")
	public static Collection data() {
        return Arrays.asList(new Object[][]{{2,4,6},{0,6,6},{3,4,7}});
	}
	
	public CalculateTest(int a,int b,int result){
		this.a=a;
		this.b=b;
		this.result=result;
	}
	
	
	@BeforeClass
	//方法必须被public static 所修饰，且一个类中只有一个
	public static void beforeclass(){
		System.out.println("所有单元测试前运行，只运行一次");
	}
	
	//@Before可以有多个，执行顺序为倒叙，即前面的后运行
	@Before
	public void before(){
		System.out.println("每个单元测试前运行");
	}
	
	@Before
	public void before2(){
		System.out.println("每个单元测试前运行222222");
	}
	

	//@ignore用于将测试单元忽略
	@Ignore("该方法已测试过")
	@Test
	public void testSum() {
		int sum = calcuate.sum(2, 5);
		assertEquals(8, sum);
	}
	
	@Test
	public void testSum2() {
		int sum = calcuate.sum(2, 5);
		assertEquals(7, sum);
	}
	
	
	//timeout=100用于测试死循环之类，可以设置规定时间运行完测试案例
	@Test(timeout=1000)
	public void testSum3() throws InterruptedException {
		Thread.sleep(3000);
		int sum = calcuate.sum(2, 5);
		assertEquals(8, sum);
	}

	//expected用于测试是否抛出特定的异常，若抛出则测试通过
	@Test(expected=ArithmeticException.class)
	public void testSum4() {
		calcuate.divide(0);
	}

	
	//使用了参数的个数等于执行此类的次数
	@Test
	public void testSum5() {
		int result2=calcuate.sum(a, b);
		assertEquals(result, result2);
	}
	
	

	//@After可以有多个，执行的顺序为正序，即前面的先运行
	@After
	public void after(){
		System.out.println("每个单元测试结束后运行");
	}
	
	@After
	public void after2(){
		System.out.println("每个单元测试结束后运行22222");
	}
	
	@AfterClass
	public static void afterclass(){
		System.out.println("所有单元测试结束后运行，只运行一次");
	}
}
