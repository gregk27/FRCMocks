# FRCMocks
This is a repository containing classes that can be used to mock behaviour of various FRC components.

Additionally, classes are included that allow for manually pumping the scheduler when testing. These are derived from https://github.com/robototes/2020_Template.

# Usage
To use the submodule with your project, run the command `git submodule add https://github.com/Aree-Vanier/FRCMocks.git src/test/java/ler/mocks` from the project root.

# Features
## Wpilib
### DoubleSolenoid
#### Supports
 - DoubleSolenoid.set(Value) 🠦 void
 - DoubleSolenoid.get() 🠦 Value
#### Tracks
 - Value (kOff, kForward, kReverse)

### Digital Input
#### Supports
 - DitigalInput.get() 🠦 boolean
#### Tracks
 - State (true/false) (Set by test code)

### DigitalOutput
#### Supports
 - DigitalOutput.set(boolean) 🠦 void
 - DigitalOutput.get() 🠦 boolean
#### Tracks
 - State (true/false)
 
## CTRE
### TalonSRX/VictorSPX
Both are mocked through the MockCTREController class
#### Supports
 - BaseMotorController.set(ControlMode, double) 🠦 void
 - BaseMotorController.getSelectedSensorPosition(int?) 🠦 int
 - BaseMotorController.getSelectedSensorVelcoity(int?) 🠦 int
 - BaseMotorController.config_kP(int, double, int?) 🠦 void
 - BaseMotorController.config_kI(int, double, int?) 🠦 void
 - BaseMotorController.config_kD(int, double, int?) 🠦 void
 - BaseMotorController.config_kF(int, double, int?) 🠦 void
#### Tracks
 - ControlMode (PercentOutput, PositionControl, ...)
 - setPoint (last value passed to `set()`)
 - velocity (set by `set(ControlMode.Velocity)` or test code)
 - position (set by `set(ControlMode.Position)` or test code)
 - PIDF constants

## Rev
### CANSparkMax
#### Supports
 - CANSparkMax.set(double) 🠦 CANError.kOK
 - CANSparkMax.getEncoder() 🠦 CANEncoder
 - CANSparkMax.getPIDController() 🠦 CANPIDController
#### Tracks
 - encoder (See [CANEncoder](#CANEncoder))
 - PID Controller (See [CANPIDController](#CANPIDController))
 - setPoint (last value passed to `set()` or `CANPIDController.setReference()`)
 - pidMode (flag indicating whether the spark is running open or closed loop)
 - controlType (last-used PID control type)
### CANEncoder
#### Supports
 - CANEncoder.getVelocity() 🠦 double
 - CANEncoder.setVelocityConversionFactor(double) 🠦 CANError.kOK
 - CANEncoder.getVelocityConversionFactor() 🠦 double
 - CANEncoder.getPosition() 🠦 double
 - CANEncoder.setPositionConversionFactor(double) 🠦 CANError.kOK
 - CANEncoder.getPositionConversionFactor() 🠦 double
#### Tracks
 - velocity (set by `CANPIDController.setReference(ControlType.kVelocity or ControlType.kSmartVelocity)` or test code)
 - velocityConversionFactor (set by `setVelocityConversionFactor()` or test code)
 - position (set by `CANPIDController.setReference(ControlType.kPosition or ControlType.kSmartMotion)` or test code)
 - positionConversionFactor (set by `setPositionConversionFactor()` or test code)
### CANPIDController
#### Supports
 - CANPIDController.setP(double) 🠦 CANError.ok
 - CANPIDController.setI(double) 🠦 CANError.ok
 - CANPIDController.setD(double) 🠦 CANError.ok
 - CANPIDController.setFF(double) 🠦 CANError.ok
 - CANPIDController.setReference(double, ControlType) 🠦 CANError.ok
#### Tracks
 - PIDF constants
 - ControlType (tracked by parent [CANSparkMax](#CANSparkMax))
 - setpoint (tracked by parent [CANSparkMax](#CANSparkMax))