package com.easyMock;

public interface IContainer {
    
    public boolean getPortion(Portion portion) throws NotEnoughException;
    public int getCurrentVolume();
    public int getTotalVolume();
    public void refillContainer();
 
}