package org.usfirst.frc.team5816.robot;

//Imports the required classes.
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//Creates the class UtilityPrograms
public class UtilityPrograms {
	
	//Creates the names for the different programs.
	static final String defaultTestProgram = "Default Test Program";
	static final String secondaryTestProgram = "Secondary Test Program";
	static final String tertiaryTestProgram = "Tertiary Test Program";
	//Creates the name for the choosing variable.
	static String utilityProgramSelected;
	//Creates the SendableChooser.
	static SendableChooser chooser;
	
	//Creates the function UtilityProgramsButtons().
	public static void UtilityProgramsButtons() {
		
		//Initializes the SendableChooser.
		chooser = new SendableChooser();
		//Adds the default program to the chooser.
		chooser.addDefault("Default Test Program", defaultTestProgram);
		//Adds the other programs to the chooser.
		chooser.addObject("Secondary Test Program", secondaryTestProgram);
		chooser.addObject("Tertiary Test Program", tertiaryTestProgram);
		//Places the chooser on the dashboard.
		SmartDashboard.putData("Utility Program Choices", chooser);
		
	}
	
	//Creates the function UtilityProgramsControl().
	public static void UtilityProgramsControl() {
		
		//Creates a switch case for the program selection.
		switch(utilityProgramSelected) {
		//Creates the secondaryTestProgram.
		case secondaryTestProgram:
			//Drives the robot forward.
			RobotMap.drive1.drive(1.0, 0.0);
			RobotMap.drive2.drive(1.0, 0.0);
			RobotMap.drive3.drive(1.0, 0.0);
			break;
		//Creates the tertiaryTestProgram.
		case tertiaryTestProgram:
			//Extends the actuator.
			RobotMap.solenoid.set(true);
			//Delays the program for 5 seconds.
			Timer.delay(5);
			//Retracts the actuator.
			RobotMap.solenoid.set(false);
			break;
		//Creates the defaultTestProgram
		case defaultTestProgram:
			//Drives the robot backward.
			RobotMap.drive1.drive(-1.0, 0.0);
			RobotMap.drive2.drive(-1.0, 0.0);
			RobotMap.drive3.drive(-1.0, 0.0);
		}
		
	}
	
	//Creates the function UtilityProgramsInit().
	public static void UtilityProgramsInit() {
		
		//Gets the chosen program.
		utilityProgramSelected = (String) chooser.getSelected();
		//Displays the chosen program.
		System.out.println("Utility Program Selected: " + utilityProgramSelected);
		
	}

}
