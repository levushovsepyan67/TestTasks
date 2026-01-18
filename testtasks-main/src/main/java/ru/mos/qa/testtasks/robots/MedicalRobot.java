package ru.mos.qa.testtasks.robots;

import java.util.ArrayList;
import java.util.List;

/**
 * Медицинский робот
 * Принцип ООП: Наследование - наследует базовую функциональность от Robot
 * Принцип ООП: Инкапсуляция - скрывает детали работы с инструментами
 */
public class MedicalRobot extends Robot {
    private List<String> tools;
    
    public MedicalRobot(String name, MovementType movementType, EnergyType energyType) {
        super(name, movementType, energyType);
        this.tools = new ArrayList<>();
        this.tools.add("Сканер");
        this.tools.add("Инъектор");
        this.tools.add("Диагностический датчик");
    }
    
    public List<String> getTools() {
        return new ArrayList<>(tools);
    }
    
    @Override
    public String refuel() {
        switch (energyType) {
            case ATOMIC:
                return name + " заправлен атомной энергией (следующая заправка через 50 лет)";
            case ELECTRIC:
                return name + " заряжен электричеством (зарядка при 20%)";
            case HYBRID_ATOMIC_ELECTRIC:
                return name + " заправлен атомной энергией и заряжен электричеством";
            default:
                return name + " заправлен";
        }
    }
    
    @Override
    public String performTask() {
        return name + " проводит медицинский анализ с помощью инструментов: " + String.join(", ", tools);
    }
    
    public String performOperation() {
        return name + " выполняет операцию с помощью хирургических инструментов";
    }
}
