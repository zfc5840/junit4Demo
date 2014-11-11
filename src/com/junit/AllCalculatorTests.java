package com.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({CalculateTest.class})//此处可以添加多个测试类
public class AllCalculatorTests {

}
