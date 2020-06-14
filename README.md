# FRCMocks
This is a repository containing classes that can be used to mock behaviour of various FRC components.

# Implementation
To use the submodule with your project, run the command `git submodule add https://github.com/Aree-Vanier/FRCMocks.git src/test/java/ler/mocks` from the project root.

# Features
## Wpilib
### DoubleSolenoid
#### Supports
 - DoubleSolenoid.set(Value) → void
 - DoubleSolenoid.get() → Value
#### Tracks
 - Value (kOff, kForward, kReverse)

### Digital Input
#### Supports
 - DitigalInput.get() → boolean
#### Tracks
 - State (true/false) (Set by test code)

### DigitalOutput
#### Supports
 - DigitalOutput.set(boolean) → void
 - DigitalOutput.get() → boolean
#### Tracks
 - State (true/false)
 
## CTRE
### TalonSRX/VictorSPX
Both are mocked through the MockCTREController class
#### Supports
 - BaseMotorController.set(ControlMode, double) -> void
 - BaseMotorController.getSelectedSensorPosition(int?) -> int
 - BaseMotorController.getSelectedSensorVelcoity(int?) -> int
 - BaseMotorController.config_kP(int, double, int?) -> void
 - BaseMotorController.config_kI(int, double, int?) -> void
 - BaseMotorController.config_kD(int, double, int?) -> void
 - BaseMotorController.config_kF(int, double, int?) -> void
#### Tracks
 - ControlMode (PercentOutput, PositionControl, ...)
 - setPoint (last value passed to `set()`)
 - velocity (set by `set(ControlMode.Velocity)` or test code)
 - position (set by `set(ControlMode.Position)` or test code)
 - PIDF constants
