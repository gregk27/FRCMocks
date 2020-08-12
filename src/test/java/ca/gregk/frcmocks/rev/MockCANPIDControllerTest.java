package ca.gregk.frcmocks.rev;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;

import org.junit.Before;
import org.junit.Test;

import ca.gregk.frcmocks.TestBase;

public class MockCANPIDControllerTest extends TestBase<MockCANPIDController>{

    @Before
    @Override
    public void setup() {
        // Instantiation has to be done here, as the PIDController depends on it's parent spark
        wrapper = new MockCANPIDController(new MockCANSparkMax());
    }

    /**
     * Test that the mock's {@link CANPIDController#setP(double)} and {@link CANPIDController#setP(double, int)} methods works
     */
    @Test
    public void testSetP(){
        // Arrange
        wrapper.kP = 0.1;
        // Act
        wrapper.getMock().setP(0.2);
        // Assert
        assertEquals(0.2, wrapper.kP, 0);

        
        // Act
        wrapper.getMock().setP(0.3, 0);
        // Assert
        assertEquals(0.3, wrapper.kP, 0);
    }

    /**
     * Test that the mock's {@link CANPIDController#setI(double)} and {@link CANPIDController#setI(double, int)} methods works
     */
    @Test
    public void testSetI(){
        // Arrange
        wrapper.kI = 0.1;
        // Act
        wrapper.getMock().setI(0.2);
        // Assert
        assertEquals(0.2, wrapper.kI, 0);

        
        // Act
        wrapper.getMock().setI(0.3, 0);
        // Assert
        assertEquals(0.3, wrapper.kI, 0);
    }

    /**
     * Test that the mock's {@link CANPIDController#setD(double)} and {@link CANPIDController#setD(double, int)} methods works
     */
    @Test
    public void testSetD(){
        // Arrange
        wrapper.kD = 0.1;
        // Act
        wrapper.getMock().setD(0.2);
        // Assert
        assertEquals(0.2, wrapper.kD, 0);

        
        // Act
        wrapper.getMock().setD(0.3, 0);
        // Assert
        assertEquals(0.3, wrapper.kD, 0);
    }

    /**
     * Test that the mock's {@link CANPIDController#setFF(double)} and {@link CANPIDController#setFF(double, int)} methods works
     */
    @Test
    public void testSetFF(){
        // Arrange
        wrapper.kF = 0.1;
        // Act
        wrapper.getMock().setFF(0.2);
        // Assert
        assertEquals(0.2, wrapper.kF, 0);

        
        // Act
        wrapper.getMock().setFF(0.3, 0);
        // Assert
        assertEquals(0.3, wrapper.kF, 0);
    }

    /**
     * Test that the mock's {@link CANPIDController#setReference(double, ControlType) methods works for {@link ControlType#kPosition}
     */
    @Test
    public void testSetReferencePosition(){
        // Arrange
        wrapper.spark.pidMode = false;
        wrapper.spark.setpoint = 0;
        wrapper.spark.controlType = null;
        // Act
        wrapper.getMock().setReference(5, ControlType.kPosition);
        // Assert
        assertTrue("Spark not in pidMode", wrapper.spark.pidMode);
        assertEquals(5, wrapper.spark.setpoint, 0);
        assertEquals(ControlType.kPosition, wrapper.spark.controlType);
        assertEquals(5, wrapper.spark.encoder.position, 0);
    }

    /**
     * Test that the mock's {@link CANPIDController#setReference(double, ControlType) methods works for {@link ControlType#kVelocity}
     */
    @Test
    public void testSetReferenceVelocity(){
        // Arrange
        wrapper.spark.pidMode = false;
        wrapper.spark.setpoint = 0;
        wrapper.spark.controlType = null;
        // Act
        wrapper.getMock().setReference(5, ControlType.kVelocity);
        // Assert
        assertTrue("Spark not in pidMode", wrapper.spark.pidMode);
        assertEquals(5, wrapper.spark.setpoint, 0);
        assertEquals(ControlType.kVelocity, wrapper.spark.controlType);
        assertEquals(5, wrapper.spark.encoder.velocity, 0);
    }

    @Override
    protected Class<MockCANPIDController> getType() {
        return MockCANPIDController.class;
    }
    
}