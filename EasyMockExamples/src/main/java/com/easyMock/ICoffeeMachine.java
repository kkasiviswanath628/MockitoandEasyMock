package com.easyMock;

public interface ICoffeeMachine {
    
    public boolean makeCoffee(Portion portion) throws NotEnoughException;
    public IContainer getCoffeeContainer();
    public IContainer getWaterContainer();
 
}