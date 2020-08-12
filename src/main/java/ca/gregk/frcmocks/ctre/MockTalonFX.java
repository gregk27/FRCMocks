package ca.gregk.frcmocks.ctre;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class MockTalonFX extends MockCTREController<TalonFX>{

    @Override
    public Class<TalonFX> getType() {
        return TalonFX.class;
    }
    
}