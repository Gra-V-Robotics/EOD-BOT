package org.usfirst.frc.team5816.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {
	static CANTalon frontLeft, frontRight, backLeft, backRight, slaveLeft, slaveRight;
	static RobotDrive drive;
	static int frontLeftPort = 3;
	static int backLeftPort = 6;
	static int slaveLeftPort = 8;
	static int frontRightPort = 4;
	static int backRightPort = 7;
	static int slaveRightPort = 5;
	static int frontLightPort = 0;
	static Joystick leftJoystick, rightJoystick;
	static Relay frontLight;
	static int lightConst = 1;
	
	public static void init() {
		frontLeft = new CANTalon(frontLeftPort);
		backLeft = new CANTalon(backLeftPort);
		slaveLeft = new CANTalon(slaveLeftPort);
		
		frontRight = new CANTalon(frontRightPort);
		backRight = new CANTalon(backRightPort);
		slaveRight = new CANTalon(slaveRightPort);
		
		//frontLeft.changeControlMode(TalonControlMode.Follower);
		//frontRight.changeControlMode(TalonControlMode.Follower);
		frontLeft.setInverted(false);
		backLeft.setInverted(true);
		slaveLeft.setInverted(true);
		frontRight.setInverted(false);
		backRight.setInverted(true);
		slaveRight.setInverted(false);
		
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
		
		//frontLight = new Relay(frontLightPort);
		frontLight = new Relay(frontLightPort, Relay.Direction.kForward);
		
		
		//frontLeft.set(backLeftPort);
		//frontRight.set(backRightPort);
		
		//drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

	}
	
	public static void teleop() {
		//drive.tankDrive(leftJoystick, rightJoystick);
		frontLeft.set(leftJoystick.getRawAxis(1)*0.99);
		frontRight.set(rightJoystick.getRawAxis(1)*0.99);
		backLeft.set(leftJoystick.getRawAxis(1)*0.99);
		backRight.set(rightJoystick.getRawAxis(1)*0.99);
		slaveLeft.set(leftJoystick.getRawAxis(1)*0.99);
		slaveRight.set(rightJoystick.getRawAxis(1) *0.99);
		if (leftJoystick.getRawButton(2)) {
			lightConst = lightConst * -1;
			Timer.delay(0.2);
		}
		
		if (lightConst == 1) {
			frontLight.set(Relay.Value.kOn);
		} else if (lightConst == -1) {
			frontLight.set(Relay.Value.kOff);
		}
	}
	
	public static void arcadeTestInit() {
		frontLeft = new CANTalon(frontLeftPort);
		backLeft = new CANTalon(backLeftPort);
		slaveLeft = new CANTalon(slaveLeftPort);
		frontRight = new CANTalon(frontRightPort);
		backRight = new CANTalon(backRightPort);
		slaveRight = new CANTalon(slaveRightPort);
		
		frontLeft.setInverted(false);
		backLeft.setInverted(true);
		slaveLeft.setInverted(true);
		frontRight.setInverted(false);
		backRight.setInverted(true);
		slaveRight.setInverted(false);
		
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
		
		frontLight = new Relay(frontLightPort, Relay.Direction.kForward);
		
		drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight)
		
		slaveLeft.changeControlMode(TalonControlMode.Follower);
		slaveRight.changeControlMode(TalonControlMode.Follower);
		
		slaveLeft.set(frontLeftPort);
		slaveRight.set(frontRightPort);
	}
	
	public static void arcadeTestTeleOp() {
		drive.arcadeDrive(leftJoystick);
		if (rightJoystick.getRawButton(1) {
			lightConst = lightConst * -1;
			Timer.delay(0.1);
		}
		
		if (lightConst == 1) {
			frontLight.set(Relay.Value.kOn);
		} else if (lightConst == -1) {
			frontLight.set(Relay.Value.kOff);
		}
	}
}
