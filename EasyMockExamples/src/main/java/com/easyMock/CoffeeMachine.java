package com.easyMock;

public class CoffeeMachine implements ICoffeeMachine {
	 
    private IContainer coffeeContainer;
    private IContainer waterContainer;
 
    public CoffeeMachine(IContainer cContainer, IContainer wContainer) {
        coffeeContainer = cContainer;
        waterContainer = wContainer;
    }
 
    public boolean makeCoffee(Portion portion) throws NotEnoughException {
         
        boolean isEnoughCoffee = coffeeContainer.getPortion(portion);
        boolean isEnoughWater = waterContainer.getPortion(portion);
         
        if (isEnoughCoffee && isEnoughWater) {
            return true;
        } else {
            return false;
        }
    }
 
    public IContainer getWaterContainer() {
        return waterContainer;
    }
 
    public IContainer getCoffeeContainer() {
        return coffeeContainer;
    }
 
}
