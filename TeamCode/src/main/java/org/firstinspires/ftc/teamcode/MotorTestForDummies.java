package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Motor Test", group="Linear Opmode")
public class MotorTestForDummies extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DcMotor beta;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        beta = hardwareMap.get(DcMotor.class, "alpha");

        waitForStart();
        runtime.reset();

        double y = 0;
        while (opModeIsActive()) {

            boolean x = gamepad1.a;

            double thing = 0;
            double thingy= 0;

            if (x) {
                if (y == 0) {
                    y = 2;
                }
                if (y == 1) {
                    y = 3;
                }
            } else {
                if (y == 2) {
                    y = 1;
                }
                if (y == 3) {
                    y = 0;
                }
            }

            if (y == 1) {
                thing = gamepad1.left_stick_x;
                thingy= gamepad1.left_stick_y;
            } else {
                thing = gamepad1.right_stick_x;
                thingy= gamepad1.right_stick_y;
            }

            thing = Math.abs(thing);
            thingy = Math.abs(thingy);



            beta.setPower(thing + thingy);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}




