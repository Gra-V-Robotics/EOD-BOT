package org.usfirst.frc.team5816.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {
	static CANTalon frontLeft, frontRight, backLeft, backRight, slaveLeft, slaveRight;
	static RobotDrive drive;
	static int frontLeftPort = 0;
	static int backLeftPort = 1;
	static int slaveLeftPort = 2;
	static int frontRightPort = 3;
	static int backRightPort = 4;
	static int slaveRightPort = 5;
	static Joystick leftJoystick, rightJoystick;
	
	public static void init() {
		frontLeft = new CANTalon(frontLeftPort);
		backLeft = new CANTalon(backLeftPort);
		slaveLeft = new CANTalon(slaveLeftPort);
		
		frontRight = new CANTalon(frontRightPort);
		backRight = new CANTalon(backRightPort);
		slaveRight = new CANTalon(slaveRightPort);
		
		drive = new RobotDrive(frontLeft, frontRight, backLeft, backRight);
		slaveLeft.changeControlMode(TalonControlMode.Follower);
		slaveRight.changeControlMode(TalonControlMode.Follower);
		slaveLeft.set(frontLeftPort);
		slaveRight.set(frontRightPort);
	}
	
	public static void teleop() {
		drive.tankDrive(leftJoystick, rightJoystick);
	}
	
}
