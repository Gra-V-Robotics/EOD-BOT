package org.usfirst.frc.team5816.robot;

public class AutonomousMode {
	
	public static void autonomousInititialize() {
		
		RobotMap.Dashboard_Config();
		RobotMap.Compressor_Config();
		RobotMap.Encoder_Config();
		RobotMap.Solenoid_Config();
		
	}
	
	public static void autonomousRunning() {
		
		if (RobotMap.encoder1.get() >= 20000 && RobotMap.encoder2.get() >= 20000) {
			RobotMap.drive.drive(0.5, 0.5);
		} else {
			RobotMap.drive.drive(-0.5, 0.0);
		}
		
	}

}
