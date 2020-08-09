# FRCMocks
This is a library containing classes that can be used to mock behaviour of various FRC components.

Additionally, classes are included that allow for manually pumping the scheduler when testing. These are derived from https://github.com/robototes/2020_Template.

# Usage
To use the submodule with your project, run the command `git submodule add https://github.com/gregk27/FRCMocks.git src/test/java/ler/mocks` from the project root.

# Mocked Hardware
Full descriptions of the mocked hardware can be found in the wiki. The shortlist is as follows
 - WPILib
   - DoubleSolenoid
   - DigitalInput
   - DigitalOutput
 - CTRE
   - TalonSRX
   - VictorSPX
   - TalonFX (somewhat)
 - Rev
   - CANSparkMax
   - CANEncoder
   - CANPIDController
