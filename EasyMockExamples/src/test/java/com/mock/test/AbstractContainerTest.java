package com.mock.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
import com.easyMock.Portion;
import com.easyMock.NotEnoughException;
import com.easyMock.WaterContainer;
import com.easyMock.IContainer;
 
public class AbstractContainerTest {
 
    IContainer waterContainer;
    private final static int VOLUME = 10;
 
    @Before
    public void beforeTest() {
        waterContainer = new WaterContainer(VOLUME);
    }
 
    @After
    public void afterTest() {
        waterContainer = null;
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testAbstractContainer() {
        waterContainer = new WaterContainer(0);
    }
 
    @Test
    public void testGetPortion() throws NotEnoughException {
        int expCurVolume = VOLUME;
 
        waterContainer.getPortion(Portion.SMALL);
        expCurVolume -= Portion.SMALL.size();
        assertEquals("Calculation for the SMALL portion is incorrect",
                expCurVolume, waterContainer.getCurrentVolume());
 
        waterContainer.getPortion(Portion.MEDIUM);
        expCurVolume -= Portion.MEDIUM.size();
        assertEquals("Calculation for the MEDIUM portion is incorrect",
                expCurVolume, waterContainer.getCurrentVolume());
 
        waterContainer.getPortion(Portion.LARGE);
        expCurVolume -= Portion.LARGE.size();
        assertEquals("Calculation for the LARGE portion is incorrect",
                expCurVolume, waterContainer.getCurrentVolume());
 
    }
 
    @Test(expected = NotEnoughException.class)
    public void testNotEnoughException() throws NotEnoughException {
        waterContainer.getPortion(Portion.LARGE);
        waterContainer.getPortion(Portion.LARGE);
        waterContainer.getPortion(Portion.LARGE);
        waterContainer.getPortion(Portion.LARGE);
    }
 
    @Test
    public void testGetCurrentVolume() {
        assertEquals("Current volume has incorrect value.", VOLUME,
                waterContainer.getCurrentVolume());
    }
 
    @Test
    public void testGetTotalVolume() {
        assertEquals("Total volume has incorrect value.", VOLUME,
                waterContainer.getTotalVolume());
    }
 
    @Test
    public void testRefillContainer() throws NotEnoughException {
        waterContainer.getPortion(Portion.SMALL);
        waterContainer.refillContainer();
        assertEquals("Refill functionality works incorectly.", VOLUME,
                waterContainer.getCurrentVolume());
    }
 
}