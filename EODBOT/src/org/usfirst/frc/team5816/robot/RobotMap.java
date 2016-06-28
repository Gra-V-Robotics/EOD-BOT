package org.usfirst.frc.team5816.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {

	static Compressor compressor;
	static Solenoid solenoid;
	static CANTalon frontLeftMotor = new CANTalon(0);
	static CANTalon rearLeftMotor = new CANTalon(1);
	static CANTalon leftSlave = new CANTalon(2);
	static CANTalon frontRightMotor = new CANTalon(3);
	static CANTalon rearRightMotor = new CANTalon(4);
	static CANTalon rightSlave = new CANTalon(5);
	static CANTalon motorActuator = new CANTalon(6);
	static RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	static Encoder encoder1, encoder2;
	static SmartDashboard dashboard;
	static CameraServer camera0, camera1;

	static int cPort = 0;
	static int sPort = 0;
	static int e1Port1 = 0;
	static int e1Port2 = 1;
	static int e2Port1 = 2;
	static int e2Port2 = 3;
	static String Camera0Port = "cam0";
	static String Camera1Port = "cam1";
	static double power = 0.3;

	public static void Compressor_Config() {
		compressor = new Compressor(cPort);
	}

	public static void Solenoid_Config() {
		solenoid = new Solenoid(sPort);
	}
	
	public static void talonInit() {
		leftSlave.changeControlMode(TalonControlMode.Follower);
		rightSlave.changeControlMode(TalonControlMode.Follower);
		leftSlave.set(0);
		rightSlave.set(3);
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

	public static void driver() {
		compressor.start();
		drive.tankDrive(OI.leftJoystick, OI.rightJoystick);
	}
	
	public static void manipulator() {
		if (OI.highGearButton) {
			solenoid.set(true);
		} else if (OI.lowGearButton) {
			solenoid.set(false);
		}
		
		if (OI.XboxController.getRawButton(5)) {
			motorActuator.set(power);
		} else if (OI.XboxController.getRawButton(6)) {
			motorActuator.set(-power);
		} else {
			motorActuator.set(0);
		}
	}
}
