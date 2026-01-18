package ru.mos.qa.testtasks.robotstests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.MedicalWelderRobot;
import ru.mos.qa.testtasks.robots.MovementType;
import ru.mos.qa.testtasks.robots.EnergyType;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalWelderRobotTests {

    @Test
    public void testMedicalWelderRobotCreation() {
        MedicalWelderRobot robot = new MedicalWelderRobot("МедСвар-1", MovementType.DRIVE, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        assertEquals("МедСвар-1", robot.getName());
        assertEquals(MovementType.DRIVE, robot.getMovementType());
        assertEquals(EnergyType.HYBRID_COMBUSTION_ELECTRIC, robot.getEnergyType());
    }

    @Test
    public void testMedicalWelderRobotMove() {
        MedicalWelderRobot robot = new MedicalWelderRobot("МедСвар-1", MovementType.DRIVE, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        assertTrue(robot.move().contains("едет"));
    }

    @Test
    public void testMedicalWelderRobotRefuel() {
        MedicalWelderRobot robot = new MedicalWelderRobot("МедСвар-1", MovementType.DRIVE, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("топливом"));
        assertTrue(refuelMessage.contains("электричеством"));
    }

    @Test
    public void testMedicalWelderRobotPerformTask() {
        MedicalWelderRobot robot = new MedicalWelderRobot("МедСвар-1", MovementType.DRIVE, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String task = robot.performTask();
        assertTrue(task.contains("медицинские процедуры"));
        assertTrue(task.contains("сварку"));
    }

    @Test
    public void testMedicalWelderRobotPerformMedicalTask() {
        MedicalWelderRobot robot = new MedicalWelderRobot("МедСвар-1", MovementType.DRIVE, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String task = robot.performMedicalTask();
        assertTrue(task.contains("медицинский анализ"));
    }

    @Test
    public void testMedicalWelderRobotPerformWeldingTask() {
        MedicalWelderRobot robot = new MedicalWelderRobot("МедСвар-1", MovementType.DRIVE, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String task = robot.performWeldingTask();
        assertTrue(task.contains("сваривает детали"));
    }

    @Test
    public void testMedicalWelderRobotTools() {
        MedicalWelderRobot robot = new MedicalWelderRobot("МедСвар-1", MovementType.DRIVE, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        assertFalse(robot.getMedicalTools().isEmpty());
    }

    @Test
    public void testMedicalWelderRobotFuelTank() {
        MedicalWelderRobot robot = new MedicalWelderRobot("МедСвар-1", MovementType.DRIVE, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        assertEquals(50.0, robot.getFuelTankCapacity());
    }
}
