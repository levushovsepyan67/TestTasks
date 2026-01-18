package ru.mos.qa.testtasks.robots;

/**
 * Робот-сварщик
 * Принцип ООП: Наследование - наследует базовую функциональность от Robot
 */
public class WelderRobot extends Robot {
    private double fuelTankCapacity; // Объем бака для топлива
    
    public WelderRobot(String name, MovementType movementType, EnergyType energyType) {
        super(name, movementType, energyType);
        this.fuelTankCapacity = 50.0; // литров
    }
    
    public WelderRobot(String name, MovementType movementType, EnergyType energyType, double fuelTankCapacity) {
        super(name, movementType, energyType);
        this.fuelTankCapacity = fuelTankCapacity;
    }
    
    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }
    
    @Override
    public String refuel() {
        switch (energyType) {
            case COMBUSTION:
                return name + " заправлен топливом (бак " + fuelTankCapacity + " л, заправка по мере опустошения)";
            case ELECTRIC:
                return name + " заряжен электричеством (зарядка при 20%)";
            case HYBRID_COMBUSTION_ELECTRIC:
                return name + " заправлен топливом и заряжен электричеством";
            default:
                return name + " заправлен";
        }
    }
    
    @Override
    public String performTask() {
        return name + " сваривает детали";
    }
}
