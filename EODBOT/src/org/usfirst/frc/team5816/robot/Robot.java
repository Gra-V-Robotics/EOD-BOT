package org.usfirst.frc.team5816.robot;

//Imports required classes.
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//Creates the Robot class and extends it to the functions of the IterativeRobot class.
public class Robot extends IterativeRobot {

	//Creates the function robotInit().
    public void robotInit() {
    	
    	//Runs the function UtilityProgramsButtons() in the UtilityPrograms class.
    	UtilityPrograms.UtilityProgramsButtons();
    	//Runs the function Camera_Config() in the RobotMap class.
    	RobotMap.Camera_Config();

    }

    //Creates the function autonomousInit(), not used.
    public void autonomousInit() {

    }

   //Creates the function autonomousPeriodic(), not used.
    public void autonomousPeriodic() {

    }
    
    //Creates the function teleopInit().
    public void teleopInit() {
    	
    	//Runs the function Dashboard_Config() in the RobotMap class.
    	RobotMap.Dashboard_Config();
    	//Runs the function Compressor_Config() in the RobotMap class.
    	RobotMap.Compressor_Config();
    	//Runs the function Encoder_Config() in the RobotMap class.
    	RobotMap.Encoder_Config();
    	//Runs the function Solenoid_Config() in the RobotMap class.
    	RobotMap.Solenoid_Config();
    	//Runs the function DriveTrain_Config() in the RobotMap class.
    	RobotMap.DriveTrain_Config();
    	//Runs the function SpeedController_Config() in the RobotMap class.
    	RobotMap.SpeedController_Config();
    	
    }

    //Creates the function teleopPeriodic()
    public void teleopPeriodic() {
    	
    	//Runs the function gearButton() in the RobotMap class.
    	RobotMap.gearButton();
    	//Runs the function robotDriving() in the RobotMap class.
    	RobotMap.robotDriving();
        
    }
    
    //Creates the function testInit(), not used.
    public void testInit() {
    	
    }

    //Creates the function testPeriodic(), not used.
    public void testPeriodic() {
    
    }
    
}
