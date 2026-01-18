package ru.mos.qa.testtasks.robots;

/**
 * Робот-повар
 * Принцип ООП: Наследование - наследует базовую функциональность от Robot
 */
public class ChefRobot extends Robot {
    
    public ChefRobot(String name, MovementType movementType, EnergyType energyType) {
        super(name, movementType, energyType);
    }
    
    @Override
    public String refuel() {
        switch (energyType) {
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
        return name + " готовит еду";
    }
}
