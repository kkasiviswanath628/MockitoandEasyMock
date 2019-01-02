package com.mock.test;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.easyMock.CoffeeContainer;
import com.easyMock.CoffeeMachine;
import com.easyMock.ICoffeeMachine;
import com.easyMock.IContainer;
import com.easyMock.NotEnoughException;
import com.easyMock.Portion;
import com.easyMock.WaterContainer;
 
public class CoffeeMachineTest {
     
    ICoffeeMachine coffeeMachine;
    IContainer coffeeContainer;
    IContainer waterContainer;
 
    @Before
    public void setUp() {
        coffeeContainer = EasyMock.createMock(CoffeeContainer.class);
        waterContainer = EasyMock.createMock(WaterContainer.class);
        coffeeMachine = new CoffeeMachine(coffeeContainer, waterContainer);
    }
 
    @After
    public void tearDown() {
        coffeeContainer = null;
        waterContainer = null;
        coffeeMachine = null;       
    }
 
    @Test
    public void testMakeCoffe() throws NotEnoughException {
        EasyMock.expect(coffeeContainer.getPortion(Portion.LARGE)).andReturn(true);
        EasyMock.replay(coffeeContainer);
         
        EasyMock.expect(waterContainer.getPortion(Portion.LARGE)).andReturn(true);
        EasyMock.replay(waterContainer);
         
        assertTrue(coffeeMachine.makeCoffee(Portion.LARGE));
    }
     
    @Test
    public void testNotEnoughException() throws NotEnoughException {
        EasyMock.expect(coffeeContainer.getPortion(Portion.LARGE)).andReturn(false);
        EasyMock.replay(coffeeContainer);
         
        EasyMock.expect(waterContainer.getPortion(Portion.LARGE)).andReturn(true);
        EasyMock.replay(waterContainer);
         
        assertFalse(coffeeMachine.makeCoffee(Portion.LARGE));
    }
 
}