package ru.mos.qa.testtasks.robots;

/**
 * Мультизадачный робот: сварщик-повар
 * Принцип ООП: Наследование - наследует функциональность от базового Robot
 * Принцип ООП: Композиция - объединяет функциональность сварщика и повара
 */
public class WelderChefRobot extends Robot {
    private double fuelTankCapacity;
    
    public WelderChefRobot(String name, MovementType movementType, EnergyType energyType) {
        super(name, movementType, energyType);
        this.fuelTankCapacity = 50.0;
    }
    
    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }
    
    @Override
    public String refuel() {
        switch (energyType) {
            case HYBRID_COMBUSTION_ELECTRIC:
                return name + " заправлен топливом и заряжен электричеством";
            case ELECTRIC:
                return name + " заряжен электричеством (зарядка при 20%)";
            default:
                return name + " заправлен";
        }
    }
    
    @Override
    public String performTask() {
        return name + " может сваривать детали и готовить еду";
    }
    
    public String performWeldingTask() {
        return name + " сваривает детали";
    }
    
    public String performCookingTask() {
        return name + " готовит еду";
    }
}
