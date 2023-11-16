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


        while (opModeIsActive()) {

            double thing = gamepad1.left_stick_y;

            beta.setPower(thing);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}




