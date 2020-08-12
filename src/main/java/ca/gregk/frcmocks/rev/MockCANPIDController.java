package ca.gregk.frcmocks.rev;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;

import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;

import ca.gregk.frcmocks.MockBase;

/**
 * Wrapper used to mock {@link CANPIDController}s and track changes
 * <p> Used by (and requires) {@link MockCANSparkMax}.
 */
public class MockCANPIDController extends MockBase<CANPIDController> {

    /** Parent {@link MockCANSparkMax} controller. */
    MockCANSparkMax spark;

    /**
     * P constant, either set with {@link CANPIDController#setP(double,int)} or specified by test code.
     * <p> Note: This has no impact on the mock controller's behaviour, and is merely for confirming changes
     */
    public double kP;
    /**
     * I constant, either set with {@link CANPIDController#setI(double,int)} or specified by test code.
     * <p> Note: This has no impact on the mock controller's behaviour, and is merely for confirming changes
     */
    public double kI;
    /**
     * D constant, either set with {@link CANPIDController#setD(double,int)} or specified by test code.
     * <p> Note: This has no impact on the mock controller's behaviour, and is merely for confirming changes
     */
    public double kD;
    /**
     * F constant, either set with {@link CANPIDController#setFF(double,int)} or specified by test code.
     * <p> Note: This has no impact on the mock controller's behaviour, and is merely for confirming changes
     */
    public double kF;

    /**
     * Create a wrapper for a mock {@link CANPIDController}.
     * 
     * @param spark The parent {@link MockCANSparkMax} controller
     */
    public MockCANPIDController(MockCANSparkMax spark) {
        super();
        this.spark = spark;
    }

    @Override
    protected void mapWrapper() {        
        // Update P constant
        doAnswer(invocation -> {
            kP = (double) invocation.getArguments()[0];
            return CANError.kOk;
        }).when(mock).setP(anyDouble());
        doAnswer(invocation -> {
            kP = (double) invocation.getArguments()[0];
            return CANError.kOk;
        }).when(mock).setP(anyDouble(), anyInt());
        
        // Update I constant
        doAnswer(invocation -> {
            kI = (double) invocation.getArguments()[0];
            return CANError.kOk;
        }).when(mock).setI(anyDouble());
        doAnswer(invocation -> {
            kI = (double) invocation.getArguments()[0];
            return CANError.kOk;
        }).when(mock).setI(anyDouble(), anyInt());
        
        // Update D constant
        doAnswer(invocation -> {
            kD = (double) invocation.getArguments()[0];
            return CANError.kOk;
        }).when(mock).setD(anyDouble());
        doAnswer(invocation -> {
            kD = (double) invocation.getArguments()[0];
            return CANError.kOk;
        }).when(mock).setD(anyDouble(), anyInt());
        
        // Update F constant
        doAnswer(invocation -> {
            kF = (double) invocation.getArguments()[0];
            return CANError.kOk;
        }).when(mock).setFF(anyDouble());
        doAnswer(invocation -> {
            kF = (double) invocation.getArguments()[0];
            return CANError.kOk;
        }).when(mock).setFF(anyDouble(), anyInt());
    
        // Update when control set
        doAnswer(invocation ->{
            Object[] args = invocation.getArguments();
            spark.setpoint = (double) args[0];
            spark.controlType = (ControlType) args[1];
            if(spark.controlType == ControlType.kPosition || spark.controlType == ControlType.kSmartMotion){
                spark.encoder.position = spark.setpoint;
            } else if(spark.controlType == ControlType.kVelocity || spark.controlType == ControlType.kSmartVelocity){
                spark.encoder.velocity = spark.setpoint;
            }
            spark.pidMode = true;
            return CANError.kOk;
        }).when(mock).setReference(anyDouble(), any(ControlType.class));
    }

    @Override
    public Class<CANPIDController> getType() {
        return CANPIDController.class;
    }
}