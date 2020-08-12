package ca.gregk.frcmocks.rev;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doAnswer;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;

import ca.gregk.frcmocks.MockBase;

/**
 * Wrapper used to mock {@link CANEncoder}s and track changes
 * <p> Used by {@link MockCANSparkMax}.
 */
public class MockCANEncoder extends MockBase<CANEncoder> {

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
     * Set with {@link CANEncoder#setVelocityConversionFactor(double)} or
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
     * Set with {@link CANEncoder#setPositionConversionFactor(double)} or
     * specified by test code
     */
    public double positionConversionFactor;
    
    /**
     * Create a wrapper for a mock {@link CANEncoder}.
     */
    public MockCANEncoder() {
        super();
    }

    @Override
    protected void mapWrapper() {
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

    @Override
    public Class<CANEncoder> getType() {
        return CANEncoder.class;
    }

}