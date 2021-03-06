package com.anarsoft.vmlens.concurrent.example;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;



/**
 * 
 * Shows how to use org.junit.After annotation to check for the result of a computation. 
 * The assertion will fail when run with <a href="http://vmlens.com">vmlens.com</a> with
 * a waitpoint at com.anarsoft.vmlens.concurrent.example.RaceConditionVolatileCounter.i in
 * the method addOne, the variable i will be smaller than 4.
 * 
 * 
 * 
 * @author Thomas
 *
 */

@RunWith(ConcurrentTestRunner.class)
public class RaceConditionVolatileCounter {
	
	
	private volatile int i = 0;
	
	@Test
	public void addOne()
	{
		i++;
	}
	
	@After
	public void assertCount()
	{
		assertTrue("When run with a waitpoint it should be smaller than 4" ,   i < 4);
	}

}
