package ru.mos.qa.testtasks.robotstests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.WelderRobot;
import ru.mos.qa.testtasks.robots.MovementType;
import ru.mos.qa.testtasks.robots.EnergyType;

import static org.junit.jupiter.api.Assertions.*;

public class WelderRobotTests {

    @Test
    public void testWelderRobotCreation() {
        WelderRobot robot = new WelderRobot("Сварщик-1", MovementType.DRIVE, EnergyType.COMBUSTION);
        assertEquals("Сварщик-1", robot.getName());
        assertEquals(MovementType.DRIVE, robot.getMovementType());
        assertEquals(EnergyType.COMBUSTION, robot.getEnergyType());
    }

    @Test
    public void testWelderRobotMove() {
        WelderRobot robot = new WelderRobot("Сварщик-1", MovementType.DRIVE, EnergyType.COMBUSTION);
        assertTrue(robot.move().contains("едет"));
    }

    @Test
    public void testWelderRobotRefuelCombustion() {
        WelderRobot robot = new WelderRobot("Сварщик-1", MovementType.DRIVE, EnergyType.COMBUSTION);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("топливом"));
        assertTrue(refuelMessage.contains("50"));
    }

    @Test
    public void testWelderRobotRefuelElectric() {
        WelderRobot robot = new WelderRobot("Сварщик-2", MovementType.DRIVE, EnergyType.ELECTRIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("электричеством"));
    }

    @Test
    public void testWelderRobotPerformTask() {
        WelderRobot robot = new WelderRobot("Сварщик-1", MovementType.DRIVE, EnergyType.COMBUSTION);
        String task = robot.performTask();
        assertTrue(task.contains("сваривает детали"));
    }

    @Test
    public void testWelderRobotFuelTankCapacity() {
        WelderRobot robot = new WelderRobot("Сварщик-1", MovementType.DRIVE, EnergyType.COMBUSTION);
        assertEquals(50.0, robot.getFuelTankCapacity());
    }

    @Test
    public void testWelderRobotCustomFuelTankCapacity() {
        WelderRobot robot = new WelderRobot("Сварщик-1", MovementType.DRIVE, EnergyType.COMBUSTION, 100.0);
        assertEquals(100.0, robot.getFuelTankCapacity());
    }

    @Test
    public void testWelderRobotHybridRefuel() {
        WelderRobot robot = new WelderRobot("Сварщик-3", MovementType.DRIVE, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("топливом"));
        assertTrue(refuelMessage.contains("электричеством"));
    }
}
