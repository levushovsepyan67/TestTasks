package ru.mos.qa.testtasks.robotstests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.WelderChefRobot;
import ru.mos.qa.testtasks.robots.MovementType;
import ru.mos.qa.testtasks.robots.EnergyType;

import static org.junit.jupiter.api.Assertions.*;

public class WelderChefRobotTests {

    @Test
    public void testWelderChefRobotCreation() {
        WelderChefRobot robot = new WelderChefRobot("СварПовар-1", MovementType.WALK, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        assertEquals("СварПовар-1", robot.getName());
        assertEquals(MovementType.WALK, robot.getMovementType());
        assertEquals(EnergyType.HYBRID_COMBUSTION_ELECTRIC, robot.getEnergyType());
    }

    @Test
    public void testWelderChefRobotMove() {
        WelderChefRobot robot = new WelderChefRobot("СварПовар-1", MovementType.WALK, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        assertTrue(robot.move().contains("идет"));
    }

    @Test
    public void testWelderChefRobotRefuel() {
        WelderChefRobot robot = new WelderChefRobot("СварПовар-1", MovementType.WALK, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("топливом"));
        assertTrue(refuelMessage.contains("электричеством"));
    }

    @Test
    public void testWelderChefRobotPerformTask() {
        WelderChefRobot robot = new WelderChefRobot("СварПовар-1", MovementType.WALK, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String task = robot.performTask();
        assertTrue(task.contains("сваривать детали"));
        assertTrue(task.contains("готовить еду"));
    }

    @Test
    public void testWelderChefRobotPerformWeldingTask() {
        WelderChefRobot robot = new WelderChefRobot("СварПовар-1", MovementType.WALK, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String task = robot.performWeldingTask();
        assertTrue(task.contains("сваривает детали"));
    }

    @Test
    public void testWelderChefRobotPerformCookingTask() {
        WelderChefRobot robot = new WelderChefRobot("СварПовар-1", MovementType.WALK, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String task = robot.performCookingTask();
        assertTrue(task.contains("готовит еду"));
    }

    @Test
    public void testWelderChefRobotFuelTank() {
        WelderChefRobot robot = new WelderChefRobot("СварПовар-1", MovementType.WALK, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        assertEquals(50.0, robot.getFuelTankCapacity());
    }
}
