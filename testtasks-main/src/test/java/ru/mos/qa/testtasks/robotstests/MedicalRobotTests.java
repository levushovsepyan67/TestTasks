package ru.mos.qa.testtasks.robotstests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.MedicalRobot;
import ru.mos.qa.testtasks.robots.MovementType;
import ru.mos.qa.testtasks.robots.EnergyType;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalRobotTests {

    @Test
    public void testMedicalRobotCreation() {
        MedicalRobot robot = new MedicalRobot("Медбот-1", MovementType.WALK, EnergyType.ELECTRIC);
        assertEquals("Медбот-1", robot.getName());
        assertEquals(MovementType.WALK, robot.getMovementType());
        assertEquals(EnergyType.ELECTRIC, robot.getEnergyType());
    }

    @Test
    public void testMedicalRobotMove() {
        MedicalRobot robot = new MedicalRobot("Медбот-1", MovementType.WALK, EnergyType.ELECTRIC);
        assertTrue(robot.move().contains("идет"));
    }

    @Test
    public void testMedicalRobotRefuelElectric() {
        MedicalRobot robot = new MedicalRobot("Медбот-1", MovementType.WALK, EnergyType.ELECTRIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("заряжен электричеством"));
        assertTrue(refuelMessage.contains("20%"));
    }

    @Test
    public void testMedicalRobotRefuelAtomic() {
        MedicalRobot robot = new MedicalRobot("Медбот-2", MovementType.DRIVE, EnergyType.ATOMIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("атомной энергией"));
        assertTrue(refuelMessage.contains("50 лет"));
    }

    @Test
    public void testMedicalRobotPerformTask() {
        MedicalRobot robot = new MedicalRobot("Медбот-1", MovementType.WALK, EnergyType.ELECTRIC);
        String task = robot.performTask();
        assertTrue(task.contains("медицинский анализ"));
    }

    @Test
    public void testMedicalRobotPerformOperation() {
        MedicalRobot robot = new MedicalRobot("Медбот-1", MovementType.WALK, EnergyType.ELECTRIC);
        String operation = robot.performOperation();
        assertTrue(operation.contains("операцию"));
    }

    @Test
    public void testMedicalRobotTools() {
        MedicalRobot robot = new MedicalRobot("Медбот-1", MovementType.WALK, EnergyType.ELECTRIC);
        assertFalse(robot.getTools().isEmpty());
        assertTrue(robot.getTools().contains("Сканер"));
    }

    @Test
    public void testMedicalRobotHybridRefuel() {
        MedicalRobot robot = new MedicalRobot("Медбот-3", MovementType.FLY, EnergyType.HYBRID_ATOMIC_ELECTRIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("атомной энергией"));
        assertTrue(refuelMessage.contains("электричеством"));
    }
}
