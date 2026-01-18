package ru.mos.qa.testtasks.robotstests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.MultiTaskRobot;
import ru.mos.qa.testtasks.robots.MovementType;
import ru.mos.qa.testtasks.robots.EnergyType;

import static org.junit.jupiter.api.Assertions.*;

public class MultiTaskRobotTests {

    @Test
    public void testMultiTaskRobotCreation() {
        MultiTaskRobot robot = new MultiTaskRobot("Универсал-1", MovementType.FLY, EnergyType.HYBRID_ATOMIC_ELECTRIC);
        assertEquals("Универсал-1", robot.getName());
        assertEquals(MovementType.FLY, robot.getMovementType());
        assertEquals(EnergyType.HYBRID_ATOMIC_ELECTRIC, robot.getEnergyType());
    }

    @Test
    public void testMultiTaskRobotMove() {
        MultiTaskRobot robot = new MultiTaskRobot("Универсал-1", MovementType.FLY, EnergyType.HYBRID_ATOMIC_ELECTRIC);
        assertTrue(robot.move().contains("летит"));
    }

    @Test
    public void testMultiTaskRobotRefuelHybridAtomicElectric() {
        MultiTaskRobot robot = new MultiTaskRobot("Универсал-1", MovementType.FLY, EnergyType.HYBRID_ATOMIC_ELECTRIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("атомной энергией"));
        assertTrue(refuelMessage.contains("электричеством"));
    }

    @Test
    public void testMultiTaskRobotRefuelHybridCombustionElectric() {
        MultiTaskRobot robot = new MultiTaskRobot("Универсал-2", MovementType.FLY, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("топливом"));
        assertTrue(refuelMessage.contains("электричеством"));
    }

    @Test
    public void testMultiTaskRobotPerformTask() {
        MultiTaskRobot robot = new MultiTaskRobot("Универсал-1", MovementType.FLY, EnergyType.HYBRID_ATOMIC_ELECTRIC);
        String task = robot.performTask();
        assertTrue(task.contains("медицинские процедуры"));
        assertTrue(task.contains("сварку"));
        assertTrue(task.contains("готовить еду"));
    }

    @Test
    public void testMultiTaskRobotPerformMedicalTask() {
        MultiTaskRobot robot = new MultiTaskRobot("Универсал-1", MovementType.FLY, EnergyType.HYBRID_ATOMIC_ELECTRIC);
        String task = robot.performMedicalTask();
        assertTrue(task.contains("медицинский анализ"));
    }

    @Test
    public void testMultiTaskRobotPerformWeldingTask() {
        MultiTaskRobot robot = new MultiTaskRobot("Универсал-1", MovementType.FLY, EnergyType.HYBRID_ATOMIC_ELECTRIC);
        String task = robot.performWeldingTask();
        assertTrue(task.contains("сваривает детали"));
    }

    @Test
    public void testMultiTaskRobotPerformCookingTask() {
        MultiTaskRobot robot = new MultiTaskRobot("Универсал-1", MovementType.FLY, EnergyType.HYBRID_ATOMIC_ELECTRIC);
        String task = robot.performCookingTask();
        assertTrue(task.contains("готовит еду"));
    }

    @Test
    public void testMultiTaskRobotTools() {
        MultiTaskRobot robot = new MultiTaskRobot("Универсал-1", MovementType.FLY, EnergyType.HYBRID_ATOMIC_ELECTRIC);
        assertFalse(robot.getMedicalTools().isEmpty());
        assertTrue(robot.getMedicalTools().contains("Сканер"));
    }

    @Test
    public void testMultiTaskRobotFuelTank() {
        MultiTaskRobot robot = new MultiTaskRobot("Универсал-1", MovementType.FLY, EnergyType.HYBRID_ATOMIC_ELECTRIC);
        assertEquals(50.0, robot.getFuelTankCapacity());
    }
}
