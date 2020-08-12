package ca.gregk.frcmocks.rev;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import ca.gregk.frcmocks.MockBase;

/**
 * Wrapper used to mock {@link CANSparkMax}s and track changes.
 */
public class MockCANSparkMax extends MockBase<CANSparkMax>{

    public MockCANEncoder encoder;
    public MockCANPIDController pidController;

    /**
     * Flag indicating whether the last instruction was sent using
     * {@link CANPIDController#setReference(double, ControlType)} or
     * {@link CANSparkMax#set(double)}.
     */
    public boolean pidMode = false;
    /**
     * Last {@link ControlType} sent to {@link #pidController}. This is the active
     * control mode if {@link #pidMode} is <code>true</code>.
     */
    public ControlType controlType;
    /**
     * Currently active setpoint, set by
     * {@link CANPIDController#setReference(double, ControlType)} or
     * {@link CANSparkMax#set(double)}.
     */
    public double setpoint;

    /**
     * Create a wrapper for a mock {@link CANSparkMax}.
     */
    public MockCANSparkMax(){
        super();
    }

    /**
     * Get the mocked {@link CANSparkMax} to be passed to the subsystem.
     * 
     * @return The mock object
     */
    public CANSparkMax getMock(){
        return mock;
    }

    @Override
    protected void mapWrapper() {  
        encoder = new MockCANEncoder(this);
        pidController = new MockCANPIDController(this);  
        //Pass the components on request
        when(mock.getEncoder()).thenReturn(encoder.getMock());
        when(mock.getPIDController()).thenReturn(pidController.getMock());

        doAnswer(invocation -> {
            pidMode = false;
            setpoint = invocation.getArgument(0);
            return null;
        }).when(mock).set(anyDouble());
    }

    @Override
    public Class<CANSparkMax> getType() {
        return CANSparkMax.class;
    }

}