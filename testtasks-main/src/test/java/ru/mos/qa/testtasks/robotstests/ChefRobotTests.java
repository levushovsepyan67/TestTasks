package ru.mos.qa.testtasks.robotstests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.ChefRobot;
import ru.mos.qa.testtasks.robots.MovementType;
import ru.mos.qa.testtasks.robots.EnergyType;

import static org.junit.jupiter.api.Assertions.*;

public class ChefRobotTests {

    @Test
    public void testChefRobotCreation() {
        ChefRobot robot = new ChefRobot("Повар-1", MovementType.WALK, EnergyType.ELECTRIC);
        assertEquals("Повар-1", robot.getName());
        assertEquals(MovementType.WALK, robot.getMovementType());
        assertEquals(EnergyType.ELECTRIC, robot.getEnergyType());
    }

    @Test
    public void testChefRobotMove() {
        ChefRobot robot = new ChefRobot("Повар-1", MovementType.WALK, EnergyType.ELECTRIC);
        assertTrue(robot.move().contains("идет"));
    }

    @Test
    public void testChefRobotRefuelElectric() {
        ChefRobot robot = new ChefRobot("Повар-1", MovementType.WALK, EnergyType.ELECTRIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("электричеством"));
        assertTrue(refuelMessage.contains("20%"));
    }

    @Test
    public void testChefRobotPerformTask() {
        ChefRobot robot = new ChefRobot("Повар-1", MovementType.WALK, EnergyType.ELECTRIC);
        String task = robot.performTask();
        assertTrue(task.contains("готовит еду"));
    }

    @Test
    public void testChefRobotHybridRefuel() {
        ChefRobot robot = new ChefRobot("Повар-2", MovementType.WALK, EnergyType.HYBRID_COMBUSTION_ELECTRIC);
        String refuelMessage = robot.refuel();
        assertTrue(refuelMessage.contains("топливом"));
        assertTrue(refuelMessage.contains("электричеством"));
    }
}
