package com.electrocoder.teslacoiler.calculator

import com.electrocoder.teslacoiler.models.Primary

object Calculator {

    fun calculatePrimaryResFreq(primary: Primary) {
        val primaryResFreq: Float = 0f
        val primaryCap = primary.tankCapacitor.capacitance

        if(primaryCap > 0) {
            //primaryResFreq = 1/(2*Math.PI*)
        }

    }

   /* Cp=form.Cp_uF.value; //get current value
    Lp=l1;//get current value
    with(Math) {
        if(Cp>0) {
            f1 = 1/(2*PI*(sqrt((Lp+Lead)*Cp)))*1000; // l1 from geotc to ensure no cell format plus Lead Inductance
            form.Pri_Fres.value = ( format( f1, 100));
        }
    }
    Detune(form);
}*/

}