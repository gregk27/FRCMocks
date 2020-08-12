package ca.gregk.frcmocks.rev;

import static org.junit.Assert.assertEquals;

import com.revrobotics.CANEncoder;

import org.junit.Test;

import ca.gregk.frcmocks.TestBase;

public class MockCANEncoderTest extends TestBase<MockCANEncoder> {

    /**
     * Test that the mock's {@link CANEncoder#getVelocity()} method works
     */
    @Test
    public void testGetVelocity(){
        // Arrange
        wrapper.velocity = 5;
        // Assert
        assertEquals(5, wrapper.getMock().getVelocity(), 0);
    }

    /**
     * Test that the mock's {@link CANEncoder#getVelocity()} method works
     */
    @Test
    public void testSetVelocityConversionFactor(){
        // Arrange
        wrapper.getMock().setVelocityConversionFactor(5);
        // Assert
        assertEquals(5, wrapper.velocityConversionFactor, 0);
    }

    /**
     * Test that the mock's {@link CANEncoder#getPosition()} method works
     */
    @Test
    public void testGetPosition(){
        // Arrange
        wrapper.position = 5;
        // Assert
        assertEquals(5, wrapper.getMock().getPosition(), 0);
    }

    /**
     * Test that the mock's {@link CANEncoder#getPosition()} method works
     */
    @Test
    public void testSetPositionConversionFactor(){
        // Arrange
        wrapper.getMock().setPositionConversionFactor(5);
        // Assert
        assertEquals(5, wrapper.positionConversionFactor, 0);
    }

    @Override
    protected Class<MockCANEncoder> getType() {
        return MockCANEncoder.class;
    }
    
}