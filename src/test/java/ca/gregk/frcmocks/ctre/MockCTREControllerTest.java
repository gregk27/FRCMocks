package ca.gregk.frcmocks.ctre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import org.junit.Test;

import ca.gregk.frcmocks.TestBase;

/**
 * This tests the MockCTRELContoller base class using a barebones TalonSRX 
 */
public class MockCTREControllerTest extends TestBase<BaseCTREController>{
    
    /**
     * Test that the mock's {@link BaseMotorController#set(ControlMode, double)} method works for {@link ControlMode#PercentOutput}
     */
    @Test
    public void testSetPercent(){
        // Arrange
        wrapper.setpoint = 0;
        wrapper.controlMode = null;
        // Act
        wrapper.getMock().set(ControlMode.PercentOutput, 0.5);
        // Assert
        assertEquals(0.5, wrapper.setpoint, 0);
        assertEquals(ControlMode.PercentOutput, wrapper.controlMode);
    }
    
    /**
     * Test that the mock's {@link BaseMotorController#set(ControlMode, double)} method works for {@link ControlMode#Position}
     */
    @Test
    public void testSetPosition(){
        // Arrange
        wrapper.setpoint = 0;
        wrapper.controlMode = null;
        wrapper.position = 0;
        // Act
        wrapper.getMock().set(ControlMode.Position, 5);
        // Assert
        assertEquals(5, wrapper.setpoint, 0);
        assertEquals(ControlMode.Position, wrapper.controlMode);
        assertEquals(5, wrapper.position, 0);
    }
    
    /**
     * Test that the mock's {@link BaseMotorController#set(ControlMode, double)} method works for {@link ControlMode#Velocity}
     */
    @Test
    public void testSetVelocity(){
        // Arrange
        wrapper.setpoint = 0;
        wrapper.controlMode = null;
        wrapper.velocity = 0;
        // Act
        wrapper.getMock().set(ControlMode.Velocity, 5);
        // Assert
        assertEquals(5, wrapper.setpoint, 0);
        assertEquals(ControlMode.Velocity, wrapper.controlMode);
        assertEquals(5, wrapper.velocity, 0);
    }

    /**
     * Test that the mock's {@link BaseMotorController#getSelectedSensorPosition()} and {@link BaseMotorController#getSelectedSensorPosition(int)} methods works
     */
    @Test
    public void testGetSelectedSensorPosition(){
        // Arrange
        wrapper.position = 5;
        // Assert
        assertEquals(5, wrapper.getMock().getSelectedSensorPosition(), 0);
        assertEquals(5, wrapper.getMock().getSelectedSensorPosition(1), 0);
    }

    /**
     * Test that the mock's {@link BaseMotorController#getSelectedSensorVelocity()} and {@link BaseMotorController#getSelectedSensorVelocity(int)} methods works
     */
    @Test
    public void testGetSelectedSensorVelocity(){
        // Arrange
        wrapper.velocity = 5;
        // Assert
        assertEquals(5, wrapper.getMock().getSelectedSensorVelocity(), 0);
        assertEquals(5, wrapper.getMock().getSelectedSensorVelocity(1), 0);
    }

    /**
     * Test that the mock's {@link BaseMotorController#config_kP(int, double)} and {@link BaseMotorController#config_kP(int, double, int)} methods works
     */
    @Test
    public void testConfigKP(){
        // Arrange
        wrapper.kP = 0;
        // Act
        wrapper.getMock().config_kP(0, 0.5);
        // Assert
        assertEquals(0.5, wrapper.kP, 0);

        // Act
        wrapper.getMock().config_kP(0, 0.5, 1);
        // Assert
        assertEquals(0.5, wrapper.kP, 0);
    }

    /**
     * Test that the mock's {@link BaseMotorController#config_kI(int, double)} and {@link BaseMotorController#config_kI(int, double, int)} methods works
     */
    @Test
    public void testConfigKI(){
        // Arrange
        wrapper.kI = 0;
        // Act
        wrapper.getMock().config_kI(0, 0.5);
        // Assert
        assertEquals(0.5, wrapper.kI, 0);
        
        // Act
        wrapper.getMock().config_kI(0, 0.5, 1);
        // Assert
        assertEquals(0.5, wrapper.kI, 0);
    }

    /**
     * Test that the mock's {@link BaseMotorController#config_kD(int, double)} and {@link BaseMotorController#config_kD(int, double, int)} methods works
     */
    @Test
    public void testConfigKD(){
        // Arrange
        wrapper.kD = 0;
        // Act
        wrapper.getMock().config_kD(0, 0.5);
        // Assert
        assertEquals(0.5, wrapper.kD, 0);
        
        // Act
        wrapper.getMock().config_kD(0, 0.5, 1);
        // Assert
        assertEquals(0.5, wrapper.kD, 0);
    }

    /**
     * Test that the mock's {@link BaseMotorController#config_kF(int, double)} and {@link BaseMotorController#config_kF(int, double, int)} methods works
     */
    @Test
    public void testConfigKF(){
        // Arrange
        wrapper.kF = 0;
        // Act
        wrapper.getMock().config_kF(0, 0.5);
        // Assert
        assertEquals(0.5, wrapper.kF, 0);
        
        // Act
        wrapper.getMock().config_kF(0, 0.5, 1);
        // Assert
        assertEquals(0.5, wrapper.kF, 0);
    }

    /**
     * Test that the {@link MockCTREController#getPIDF()} method works
     */
    @Test
    public void testGetPIDF(){
        // Arrange
        wrapper.kP = 0;
        wrapper.kI = 1;
        wrapper.kD = 2;
        wrapper.kF = 3;
        // Act
        double[] vals = wrapper.getPIDF();
        // Assert
        assertEquals(0, vals[0], 0);
        assertEquals(1, vals[1], 0);
        assertEquals(2, vals[2], 0);
        assertEquals(3, vals[3], 0);
    }

    /**
     * Test that the {@link MockCTREController#getPIDF()} method works
     */
    @Test
    public void testSetPIDF(){
        // Act
        boolean res = wrapper.setPIDF(new double[] {0,1,2,3});
        // Assert
        assertTrue("Set PIDF should return true", res);
        assertEquals(0, wrapper.kP, 0);
        assertEquals(1, wrapper.kI, 0);
        assertEquals(2, wrapper.kD, 0);
        assertEquals(3, wrapper.kF, 0);

        // Assert that invalid entry returns false
        assertFalse("Set PIDF should return false", wrapper.setPIDF(new double[] {0,0,0,0,0}));
    }


    /**
     * Test that the {@link MockCTREController#getPID()} method works
     */
    @Test
    public void testGetPID(){
        // Arrange
        wrapper.kP = 0;
        wrapper.kI = 1;
        wrapper.kD = 2;
        // Act
        double[] vals = wrapper.getPID();
        // Assert
        assertEquals(0, vals[0], 0);
        assertEquals(1, vals[1], 0);
        assertEquals(2, vals[2], 0);
    }
    
    /**
     * Test that the {@link MockCTREController#getPID()} method works
     */
    @Test
    public void testSetPID(){
        // Act
        boolean res = wrapper.setPID(new double[] {0,1,2});
        // Assert
        assertTrue("Set PID should return true", res);
        assertEquals(0, wrapper.kP, 0);
        assertEquals(1, wrapper.kI, 0);
        assertEquals(2, wrapper.kD, 0);

        // Assert that invalid entry returns false
        assertFalse("Set PID should return false", wrapper.setPID(new double[] {0,0,0,0,0}));
    }

    @Override
    protected Class<BaseCTREController> getType() {
        return BaseCTREController.class;
    }
    
}