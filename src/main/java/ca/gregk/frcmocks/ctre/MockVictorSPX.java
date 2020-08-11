package ca.gregk.frcmocks.ctre;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class MockVictorSPX extends MockCTREController<VictorSPX>{

    @Override
    public Class<VictorSPX> getType() {
        return VictorSPX.class;
    }
}