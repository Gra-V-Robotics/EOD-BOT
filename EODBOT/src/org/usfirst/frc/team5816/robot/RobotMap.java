package org.usfirst.frc.team5816.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {

	static Compressor compressor;
	static Solenoid solenoid;
	static SpeedController leftMotorTop, leftMotorBack, leftMotorFront, rightMotorTop, rightMotorBack, rightMotorFront, armMotor;
	static RobotDrive drive1, drive2, drive3;
	static Encoder encoder1, encoder2;
	static SmartDashboard dashboard;
	static CameraServer camera0, camera1;

	static int cPort = 0;
	static int sPort = 0;
	static int lMTPort = 0;
	static int lMBPort = 1;
	static int lMFPort = 2;
	static int rMTPort = 3;
	static int rMBPort = 4;
	static int rMFPort = 5;
	static int aPort = 6;
	static int e1Port1 = 0;
	static int e1Port2 = 1;
	static int e2Port1 = 2;
	static int e2Port2 = 3;

	static String Camera0Port = "cam0";
	static String Camera1Port = "cam1";

	static double defaultSpeed = 0.5;

	public static void Compressor_Config() {

		compressor = new Compressor(cPort);
		
	}

	public static void Solenoid_Config() {

		solenoid = new Solenoid(sPort);
		
	}

	public static void SpeedController_Config() {

		leftMotorTop = new Talon(lMTPort);
		leftMotorBack = new Talon(lMBPort);
		leftMotorFront = new Talon(lMFPort);
		
		rightMotorTop = new Talon(rMTPort);
		rightMotorBack = new Talon(rMBPort);
		rightMotorFront = new Talon(rMFPort);
		
		armMotor = new Talon(aPort);
		
	}

	public static void DriveTrain_Config() {

		drive1 = new RobotDrive(leftMotorTop, rightMotorTop);
		
		drive2 = new RobotDrive(leftMotorBack, rightMotorBack);
		
		drive3 = new RobotDrive(leftMotorFront, rightMotorFront);
		
	}

	public static void Encoder_Config() {

		encoder1 = new Encoder(e1Port1, e1Port2);
		
		encoder2 = new Encoder(e2Port1, e2Port2);
		
	}

	public static void Dashboard_Config() {

		dashboard.putBoolean("Compressor On: ", compressor.enabled());
		dashboard.putBoolean("Solenoid Activated: ", solenoid.get());
		UtilityPrograms.UtilityProgramsInit();
		
	}

	public static void Camera_Config() {

		camera0.startAutomaticCapture(Camera0Port);
		camera1.startAutomaticCapture(Camera1Port);
		camera0.setQuality(50);
		camera1.setQuality(50);
		
	}

	public static void robotButtonConfig() {
		
	}

	public static void driver() {
		
		compressor.start();
		
		drive1.tankDrive(OI.leftJoystick, OI.rightJoystick);
		drive2.tankDrive(OI.leftJoystick, OI.rightJoystick);
		drive3.tankDrive(OI.leftJoystick, OI.rightJoystick);
		
	}
	
	public static void manipulaltor() {
		
		armMotor.set(OI.XboxController.getY());

		if (OI.highGearButton) {
			solenoid.set(true);
		} else if (OI.lowGearButton) {
			solenoid.set(false);
		}
		
	}

}
