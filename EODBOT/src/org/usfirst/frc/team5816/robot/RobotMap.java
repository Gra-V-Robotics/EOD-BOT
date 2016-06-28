package org.usfirst.frc.team5816.robot;

//Imports required classes.
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//Creates the class RobotMap
public class RobotMap {
	
	//Creates the compressor.
	static Compressor compressor;
	//Creates the solenoid.
	static Solenoid solenoid;
	//Creates the Motors.
	static SpeedController leftMotorTop, leftMotorBack, leftMotorFront, rightMotorTop, rightMotorBack, rightMotorFront, armMotor;
	//Creates the RobotDrive types.
	static RobotDrive drive1, drive2, drive3;
	//Creates the encoders.
	static Encoder encoder1, encoder2;
	//Creates the dashboard.
	static SmartDashboard dashboard;
	//Creates the cameras.
	static CameraServer camera0, camera1;
	
	//Creates variables for ports.
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
	
	//Creates variables for camera names.
	static String Camera0Port = "cam0";
	static String Camera1Port = "cam1";
	
	//Creates variables for speed levels.
	static double lowSpeed = 0.33;
	static double mediumSpeed = 0.66;
	static double highSpeed = 1.0;
	static double defaultSpeed = 0.5;
	
	//Creates the function Compressor_Config().
	public static void Compressor_Config() {
		
		//Initializes the compressor to its port.
		compressor = new Compressor(cPort);
		
	}
	
	//Creates the function Solenoid_Config().
	public static void Solenoid_Config() {
		
		//Initializes the solenoid to its port.
		solenoid = new Solenoid(sPort);
		
	}
	
	//Creates the function SpeedController_Config().
	public static void SpeedController_Config() {
		
		//Initializes the motors to their ports.
		leftMotorTop = new Talon(lMTPort);
		leftMotorBack = new Talon(lMBPort);
		leftMotorFront = new Talon(lMFPort);
		
		rightMotorTop = new Talon(rMTPort);
		rightMotorBack = new Talon(rMBPort);
		rightMotorFront = new Talon(rMFPort);
		
		armMotor = new Talon(aPort);
		
	}
	
	//Creates the function DriveTrain_Config().
	public static void DriveTrain_Config() {
		
		//Initializes the Drive Trains to their motors.
		drive1 = new RobotDrive(leftMotorTop, rightMotorTop);
		
		drive2 = new RobotDrive(leftMotorBack, rightMotorBack);
		
		drive3 = new RobotDrive(leftMotorFront, rightMotorFront);
		
	}
	
	//Creates the function Encoder_Config().
	public static void Encoder_Config() {
		
		//Initializes the encoders to their ports.
		encoder1 = new Encoder(e1Port1, e1Port2);
		
		encoder2 = new Encoder(e2Port1, e2Port2);
		
	}
	
	//Suppresses a really stupid, unnecessary warning.
	@SuppressWarnings("static-access")
	//Creates the function Dashboard_Config().
	public static void Dashboard_Config() {
		
		//Adds compressor telemetry to the dashboard.
		dashboard.putBoolean("Compressor On: ", compressor.enabled());
		//Adds solenoid telemetry to the dashboard.
		dashboard.putBoolean("Solenoid Activated: ", solenoid.get());
		//Runs the function UtilityProgramsInit() in the UtilityPrograms class.
		UtilityPrograms.UtilityProgramsInit();
		
	}
	
	//Creates the function Camera_Config().
	public static void Camera_Config() {
		
		//Gets the feed from the specified cameras.
		camera0.startAutomaticCapture(Camera0Port);
		camera1.startAutomaticCapture(Camera1Port);
		//Changes the quality the cameras output.
		camera0.setQuality(50);
		camera1.setQuality(50);
		
	}
	
	//Creates the speedButtonConfig() class.
	public static void speedButtonConfig() {
		
		//Checks to see if the lowSpeedButton is pressed.
		/*if (OI.lowSpeedButton) {
			//Sets the max speed to lowSpeed.
			drive1.setMaxOutput(lowSpeed);
			drive2.setMaxOutput(lowSpeed);
			drive3.setMaxOutput(lowSpeed);
		//Checks to see if the mediumSpeedButton is pressed.
		} else if (OI.mediumSpeedButton){
			//Sets the max speed to mediumSpeed.
			drive1.setMaxOutput(mediumSpeed);
			drive2.setMaxOutput(mediumSpeed);
			drive3.setMaxOutput(mediumSpeed);
		//Checks to see if the highSpeedButton is pressed.
		} else if (OI.highSpeedButton) {
			//Sets the max speed to highSpeed.
			drive1.setMaxOutput(highSpeed);
			drive2.setMaxOutput(highSpeed);
			drive3.setMaxOutput(highSpeed);
		}*/
		
	}
	
	//Creates the function gearButton().
	public static void gearButton() {
		
		//Checks to see if the highGearButton is pressed.
		if (OI.highGearButton) {
			//Extends the actuator.
			solenoid.set(true);
		//Checks to see if the lowGearButton is pressed.
		} else if (OI.lowGearButton) {
			//Retracts the actuator.
			solenoid.set(false);
		}
		
	}
	
	//Creates the function robotDriving().
	public static void robotDriving() {
		
		//Starts the compressor.
		compressor.start();
		//Sets the drive trains to all have the same inputs.
		drive1.tankDrive(OI.leftJoystick, OI.rightJoystick);
		drive2.tankDrive(OI.leftJoystick, OI.rightJoystick);
		drive3.tankDrive(OI.leftJoystick, OI.rightJoystick);
		
	}
	
	public static void armDriving() {
		
		armMotor.set(OI.XboxController.getY());
	}

}
