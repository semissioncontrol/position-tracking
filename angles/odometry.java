/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

void UpdateSensors() {
        angles = imu.getAngularOrientation().toAxesReference(AxesReference.INTRINSIC).toAxesOrder(AxesOrder.ZYX);
        currentDegree = angles.firstAngle - GS1;
        if((switchpoint < 0 && (angles.firstAngle > -180 && angles.firstAngle < switchpoint))){
            currentDegree += 360;
        }

        if((switchpoint > 0 && (angles.firstAngle < 180 && angles.firstAngle > switchpoint))){
            currentDegree -= 360;
        }

        LFPOS = (7.42108499463f * (LFE / 1440));
        RFPOS = (7.42108499463f * (RFE / 1440));
        LBPOS = (7.42108499463f * (LBE / 1440));
        RBPOS = (7.42108499463f * (RBE / 1440));
        distY = (RFPOS + LBPOS) / 2;
        distX = (LFPOS + RBPOS) / 2;


        LiftLE = LiftL.getCurrentPosition() - LiftLS;
        LiftRE = LiftR.getCurrentPosition() - LiftRS;

        LFE = -(LF.getCurrentPosition() - LFES);
        RFE = -(RF.getCurrentPosition() - RFES);
        LBE = -(LB.getCurrentPosition() - LBES);
        RBE = -(RB.getCurrentPosition() - RBES);
    }

public void gyroLock(float ramp){

        if (gyroTarget < currentDegree) { //Gyro turn for left.
            LFP += ((gyroTarget - currentDegree) / ramp)+ gyroramp; // Ramps the motors based on the gyro.
            LBP += ((gyroTarget - currentDegree) / ramp) + gyroramp;
            RFP += -((gyroTarget - currentDegree) / ramp) - gyroramp;
            RBP += -((gyroTarget - currentDegree) / ramp) - gyroramp;
        }

        if (gyroTarget > currentDegree) { // Gyro turn for right.
            LFP += ((gyroTarget - currentDegree) / ramp) - gyroramp;
            LBP += ((gyroTarget - currentDegree) / ramp) - gyroramp;
            RFP += -((gyroTarget - currentDegree) / ramp) + gyroramp;
            RBP += -((gyroTarget - currentDegree) / ramp) + gyroramp;
        } // Gyro lock
        telemetry.addData("GyroTarget", gyroTarget);
        telemetry.addData("CurrentDegree", currentDegree);
        telemetry.addData("LFP", LFP);
        telemetry.addData("RFP", RFP);

        telemetry.update();
    }
