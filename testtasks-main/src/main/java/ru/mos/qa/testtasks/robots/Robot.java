package ru.mos.qa.testtasks.robots;

/**
 * Базовый класс робота
 * Принцип ООП: Абстракция - определяет общий интерфейс для всех роботов
 * Принцип ООП: Инкапсуляция - скрывает детали реализации движения и питания
 */
public abstract class Robot {
    protected MovementType movementType;
    protected EnergyType energyType;
    protected String name;
    
    public Robot(String name, MovementType movementType, EnergyType energyType) {
        this.name = name;
        this.movementType = movementType;
        this.energyType = energyType;
    }
    
    public String getName() {
        return name;
    }
    
    public MovementType getMovementType() {
        return movementType;
    }
    
    public EnergyType getEnergyType() {
        return energyType;
    }
    
    /**
     * Движение робота
     */
    public String move() {
        switch (movementType) {
            case WALK:
                return name + " идет";
            case DRIVE:
                return name + " едет";
            case FLY:
                return name + " летит";
            default:
                return name + " перемещается";
        }
    }
    
    /**
     * Заправка робота
     * Принцип ООП: Полиморфизм - каждый тип робота может иметь свою реализацию
     */
    public abstract String refuel();
    
    /**
     * Выполнение основной задачи робота
     * Принцип ООП: Полиморфизм - каждый тип робота выполняет свою задачу
     */
    public abstract String performTask();
}
