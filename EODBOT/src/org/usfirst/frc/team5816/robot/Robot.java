package org.usfirst.frc.team5816.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

    public void robotInit() {
    	
    	UtilityPrograms.UtilityProgramsButtons();
    	RobotMap.Camera_Config();

    }

    public void autonomousInit() {

    }

    public void autonomousPeriodic() {

    }
    
    public void teleopInit() {
    	
    	RobotMap.Dashboard_Config();
    	RobotMap.Compressor_Config();
    	RobotMap.Encoder_Config();
    	RobotMap.Solenoid_Config();
    	RobotMap.DriveTrain_Config();
    	RobotMap.SpeedController_Config();
    	
    }

    public void teleopPeriodic() {
    	
    	RobotMap.gearButton();
    	RobotMap.robotDriving();
        
    }
    
    public void testInit() {
    	
    }

    public void testPeriodic() {
    
    }
    
}
