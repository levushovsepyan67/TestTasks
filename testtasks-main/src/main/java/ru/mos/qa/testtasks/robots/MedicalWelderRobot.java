package ru.mos.qa.testtasks.robots;

import java.util.ArrayList;
import java.util.List;

/**
 * Мультизадачный робот: медик-сварщик
 * Принцип ООП: Наследование - наследует функциональность от базового Robot
 * Принцип ООП: Композиция - объединяет функциональность медицинского робота и сварщика
 */
public class MedicalWelderRobot extends Robot {
    private List<String> medicalTools;
    private double fuelTankCapacity;
    
    public MedicalWelderRobot(String name, MovementType movementType, EnergyType energyType) {
        super(name, movementType, energyType);
        this.medicalTools = new ArrayList<>();
        this.medicalTools.add("Сканер");
        this.medicalTools.add("Инъектор");
        this.fuelTankCapacity = 50.0;
    }
    
    public List<String> getMedicalTools() {
        return new ArrayList<>(medicalTools);
    }
    
    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }
    
    @Override
    public String refuel() {
        switch (energyType) {
            case HYBRID_ATOMIC_ELECTRIC:
                return name + " заправлен атомной энергией и заряжен электричеством";
            case HYBRID_COMBUSTION_ELECTRIC:
                return name + " заправлен топливом и заряжен электричеством";
            default:
                return name + " заправлен";
        }
    }
    
    @Override
    public String performTask() {
        return name + " может выполнять медицинские процедуры и сварку";
    }
    
    public String performMedicalTask() {
        return name + " проводит медицинский анализ";
    }
    
    public String performWeldingTask() {
        return name + " сваривает детали";
    }
}
