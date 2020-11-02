/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

void AutoTracking() {

        if (gamepad1.dpad_right) {
            posX = 0;
            posY = 0;
            GS1 = angles.firstAngle;
        }

        H1Loop = (7.42108499463f * (LFE / 1440)) - OldH1;
        H2Loop = (7.42108499463f * (RBE / 1440)) - OldH2;
        V1Loop = (7.42108499463f * (RFE / 1440)) - OldV1;
        V2Loop = (7.42108499463f * (LBE / 1440)) - OldV2;

        OldH1 = (7.42108499463f * (LFE / 1440));
        OldH2 = (7.42108499463f * (RBE / 1440));
        OldV1 = (7.42108499463f * (RFE / 1440));
        OldV2 = (7.42108499463f * (LBE / 1440));

        posY += ((Math.cos(Math.toRadians(-currentDegree)) * (V1Loop) + Math.cos(Math.toRadians(-currentDegree)) * (V2Loop)) / 2) + (((Math.sin(Math.toRadians(currentDegree)) * (H1Loop)) + (Math.sin(Math.toRadians(currentDegree)) * (H1Loop))) / 2);
        posX += ((Math.sin(Math.toRadians(-currentDegree)) * (V1Loop) + Math.sin(Math.toRadians(-currentDegree)) * (V2Loop)) / 2) + (((Math.cos(Math.toRadians(currentDegree)) * (H1Loop)) + (Math.cos(Math.toRadians(currentDegree)) * (H1Loop))) / 2);

        distToTarget = (float) Math.sqrt(Math.pow(posX, 2) + Math.pow(posY, 2));

        targetAngle = (float) Math.toDegrees((Math.atan(posY / posX))) + 180;
        if (posX > 0) targetAngle += 90;
        else targetAngle -= 90;


        if (targetAngle > 180) targetAngle -= 360;
        else if(targetAngle < -180) targetAngle += 360;



        //direction2 = distToTarget / 20 + .5f;


    }
