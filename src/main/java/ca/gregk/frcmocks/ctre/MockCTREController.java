package ca.gregk.frcmocks.ctre;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 * Wrapper used to mock CTRE motor controllers and track changes.
 * 
 * @param <T> The motor controller type, either {@link TalonSRX} or
 *            {@link VictorSPX}
 */
public class MockCTREController<T extends BaseMotorController> {

    T mc;
    Class<T> type;

    /** Index of the P argument in a PIDF array. */
    private static final int P_INDEX = 0;
    /** Index of the I argument in a PIDF array. */
    private static final int I_INDEX = 1;
    /** Index of the D argument in a PIDF array. */
    private static final int D_INDEX = 2;
    /** Index of the F argument in a PIDF array. */
    private static final int F_INDEX = 3;

    /**
     * The last {@link ControlMode} set by.
     * {@link BaseMotorController#set(ControlMode, double)}
     */
    public ControlMode controlMode;
    /**
     * The last setpoint set by {@link BaseMotorController#set(ControlMode, double)}.
     */
    public double setpoint;
    /**
     * The controller velocity, either set with {@link ControlMode#Velocity} or
     * specified manually.
     */
    public double velocity;
    /**
     * The controller position, either set with {@link ControlMode#Position} or
     * specified manually.
     */
    public double position;

    /**
     * P constant, either set with {@link BaseMotorController#config_kP(int, double, int)}
     * or specified manually.
     * <p>
     * Note: This has no impact on the mock controller's behaviour, and is merely
     * for confirming changes
     */
    public double kP = 0;
    /**
     * I constant, either set with {@link BaseMotorController#config_kI(int,double,int)}
     * or specified manually.
     * <p>
     * Note: This has no impact on the mock controller's behaviour, and is merely
     * for confirming changes
     */
    public double kI = 0;
    /**
     * D constant, either set with {@link BaseMotorController#config_kD(int,double,int)}
     * or specified manually.
     * <p>
     * Note: This has no impact on the mock controller's behaviour, and is merely
     * for confirming changes
     */
    public double kD = 0;
    /**
     * F constant, either set with {@link BaseMotorController#config_kF(int,double,int)}
     * or specified manually.
     * <p>
     * Note: This has no impact on the mock controller's behaviour, and is merely
     * for confirming changes
     */
    public double kF = 0;

    /**
     * Create a wrapper for a mock CTRE controller.
     * 
     * @param mcClass Either {@link TalonSRX} or {@link VictorSPX}
     *                <code>.class</code>, corresponding with the controller type
     */
    public MockCTREController(Class<T> mcClass) {
        mc = mock(mcClass);
        type = mcClass;
        // Update when control set
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            controlMode = (ControlMode) args[0];
            setpoint = (double) args[1];
            if(controlMode == ControlMode.Position){
                position = setpoint;
            } else if(controlMode == ControlMode.Velocity){
                velocity = setpoint;
            }
            return null; // void method in a block-style lambda, so return null
        }).when(mc).set(any(ControlMode.class), anyDouble());

        // Send position on request
        doAnswer(invocation -> {
            return position;
        }).when(mc).getSelectedSensorPosition();
        doAnswer(invocation -> {
            return position;
        }).when(mc).getSelectedSensorPosition(anyInt());

        // Send velocity on request
        doAnswer(invocation -> {
            return velocity;
        }).when(mc).getSelectedSensorVelocity();
        doAnswer(invocation -> {
            return velocity;
        }).when(mc).getSelectedSensorVelocity(anyInt());

        // Update when kP set
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            controlMode = (ControlMode) args[0];
            kP = (double) args[1];
            return null; // void method in a block-style lambda, so return null
        }).when(mc).config_kP(anyInt(), anyDouble());
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            controlMode = (ControlMode) args[0];
            kP = (double) args[1];
            return null; // void method in a block-style lambda, so return null
        }).when(mc).config_kP(anyInt(), anyDouble(), anyInt());

        // Update when kI set
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            controlMode = (ControlMode) args[0];
            kI = (double) args[1];
            return null; // void method in a block-style lambda, so return null
        }).when(mc).config_kI(anyInt(), anyDouble());
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            controlMode = (ControlMode) args[0];
            kI = (double) args[1];
            return null; // void method in a block-style lambda, so return null
        }).when(mc).config_kI(anyInt(), anyDouble(), anyInt());

        // Update when kD set
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            controlMode = (ControlMode) args[0];
            kD = (double) args[1];
            return null; // void method in a block-style lambda, so return null
        }).when(mc).config_kD(anyInt(), anyDouble());
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            controlMode = (ControlMode) args[0];
            kD = (double) args[1];
            return null; // void method in a block-style lambda, so return null
        }).when(mc).config_kD(anyInt(), anyDouble(), anyInt());

        // Update when kF set
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            controlMode = (ControlMode) args[0];
            kF = (double) args[1];
            return null; // void method in a block-style lambda, so return null
        }).when(mc).config_kF(anyInt(), anyDouble());
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            controlMode = (ControlMode) args[0];
            kF = (double) args[1];
            return null; // void method in a block-style lambda, so return null
        }).when(mc).config_kF(anyInt(), anyDouble(), anyInt());
    }

    /**
     * Get the mock object to be passed to the subsystem
     * <p>
     * Note: The returned object must be cast to either {@link TalonSRX} or
     * {@link VictorSPX}.
     * 
     * @return The mock object
     */
    public T getMock() {
        return mc;
    }

    /**
     * Get the controller type, as specified in the.
     * {@link #MockCTREController(Class) constructor}
     * 
     * @return Either {@link TalonSRX} or {@link VictorSPX} <code>.class</code>
     */
    public Class<T> controllerType() {
        return type;
    }

    /**
     * Get the PIDF constants.
     * 
     * @return An array containing kP, kI, kD, kF in order
     */
    public double[] getPIDF() {
        return new double[] { kP, kI, kD, kF };
    }

    /**
     * Set the PIDF constants.
     * 
     * @param pidf An array containing kP, kI, kD, kF in order
     * @return Success flag, <code>false</code> if the array is not length 4
     */
    public boolean setPIDF(double[] pidf) {
        if(pidf.length != F_INDEX+1){
            return false;
        }
        kP = pidf[P_INDEX];
        kI = pidf[I_INDEX];
        kD = pidf[D_INDEX];
        kF = pidf[F_INDEX];
        return true;
    }

    /**
     * Get the PID constants.
     * 
     * @return An array containing kP, kI, kD in order
     */
    public double[] getPID() {
        return new double[] { kP, kI, kD };
    }

    /**
     * Set the PID constants.
     * 
     * @param pid An array containing kP, kI, kD in order
     * @return Success flag, <code>false</code> if the array is not length 3
     */
    public boolean setPID(double[] pid) {
        if(pid.length != F_INDEX+1){
            return false;
        }
        kP = pid[P_INDEX];
        kI = pid[I_INDEX];
        kD = pid[D_INDEX];
        return true;
    }
}