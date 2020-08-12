package ca.gregk.frcmocks.rev;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.revrobotics.CANSparkMax;

import org.junit.Test;

import ca.gregk.frcmocks.TestBase;

public class MockCANSparkMaxTest extends TestBase<MockCANSparkMax> {

    /**
     * Test that the mock's {@link CANSparkMax#getEncoder()} method works
     */
    @Test
    public void testGetEncocder(){
        String targetClass = wrapper.encoder.getType().toString();
        String mockClass = wrapper.getMock().getEncoder().getClass().toString();

        // Strip mockito info from classname
        mockClass = mockClass.substring(0, mockClass.lastIndexOf('$'));
        mockClass = mockClass.substring(0, mockClass.lastIndexOf('$'));

        assertEquals(targetClass, mockClass);
    }

    /**
     * Test that the mock's {@link CANSparkMax#getPIDController()} method works
     */
    @Test
    public void testGetPIDController(){
        String targetClass = wrapper.pidController.getType().toString();
        String mockClass = wrapper.getMock().getPIDController().getClass().toString();

        // Strip mockito info from classname
        mockClass = mockClass.substring(0, mockClass.lastIndexOf('$'));
        mockClass = mockClass.substring(0, mockClass.lastIndexOf('$'));

        assertEquals(targetClass, mockClass);
    }

    /**
     * Test that the mock's {@link CANSparkMax#set()} method works
     */
    @Test
    public void testSet(){
        // Arrange
        wrapper.pidMode = true; // Start this as true because it should end false
        
        // Act
        wrapper.getMock().set(1);

        // Assert
        assertFalse(wrapper.pidMode); // Ensure that pidMode is set to false
        assertEquals(1, wrapper.setpoint, 0);
    }

    @Override
    protected Class<MockCANSparkMax> getType() {
        return MockCANSparkMax.class;
    }
    
}