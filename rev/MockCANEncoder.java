package ler.mocks.rev;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doAnswer;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;

import org.mockito.Mockito;

/**
 * Wrapper used to mock {@link CANEncoder}s and track changes
 * <p> Used by {@link MockCANSparkMax}.
 */
public class MockCANEncoder {

    private CANEncoder mock;
    MockCANSparkMax spark;

    /**
     * The encoder velocity.
     * <p>
     * Set with
     * {@link CANPIDController#setReference(double, com.revrobotics.ControlType)}
     * using {@link ControlType#kVelocity}/{@link ControlType#kSmartVelocity} or
     * specified by test code
     */
    public double velocity;
    /**
     * The encoder velocity conversion factor.
     * <p>
     * Set with {@link CANPIDController#setVelocityConversionFactor(double)} or
     * specified by test code
     */
    public double velocityConversionFactor;

    /**
     * The encoder position.
     * <p>
     * Set with
     * {@link CANPIDController#setReference(double, com.revrobotics.ControlType)}
     * using {@link ControlType#kPosition}/{@link ControlType#kSmartMotion} or
     * specified by test code
     */
    public double position;
    /**
     * The encoder position conversion factor.
     * <p>
     * Set with {@link CANPIDController#setVelocityConversionFactor(double)} or
     * specified by test code
     */
    public double positionConversionFactor;
    
    /**
     * Create a wrapper for a mock {@link CANEncoder}.
     * 
     * @param spark The parent {@MockCANSparkMax} controller
     */
    public MockCANEncoder(MockCANSparkMax spark) {
        this.spark = spark;
        mock = Mockito.mock(CANEncoder.class);

        // Handle velocity functions
        doAnswer(invocation -> {
            return velocity;
        }).when(mock).getVelocity();
        doAnswer(invocation -> {
            velocityConversionFactor = invocation.getArgument(0);
            return CANError.kOk;
        }).when(mock).setVelocityConversionFactor(anyDouble());
        doAnswer(invocation -> {
            return velocityConversionFactor;
        }).when(mock).getVelocityConversionFactor();

        // Handle position functions
        doAnswer(invocation -> {
            return position;
        }).when(mock).getPosition();
        doAnswer(invocation -> {
            positionConversionFactor = invocation.getArgument(0);
            return CANError.kOk;
        }).when(mock).setPositionConversionFactor(anyDouble());
        doAnswer(invocation -> {
            return positionConversionFactor;
        }).when(mock).getPositionConversionFactor();
    }

    /**
     * Get the mocked {@link CANEncoder} to be passed to the subsystem.
     * 
     * @return The mock object
     */
    public CANEncoder getMock(){
        return mock;
    }

}