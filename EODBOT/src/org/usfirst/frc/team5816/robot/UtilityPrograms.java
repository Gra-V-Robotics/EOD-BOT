package org.usfirst.frc.team5816.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UtilityPrograms {

	static final String defaultTestProgram = "Default Test Program";
	static final String secondaryTestProgram = "Secondary Test Program";
	static final String tertiaryTestProgram = "Tertiary Test Program";
	static String utilityProgramSelected;
	static SendableChooser chooser;

	public static void UtilityProgramsButtons() {
		chooser = new SendableChooser();
		chooser.addDefault("Default Test Program", defaultTestProgram);
		chooser.addObject("Secondary Test Program", secondaryTestProgram);
		chooser.addObject("Tertiary Test Program", tertiaryTestProgram);
		SmartDashboard.putData("Utility Program Choices", chooser);
	}

	public static void UtilityProgramsControl() {
		switch(utilityProgramSelected) {
		case secondaryTestProgram:
			RobotMap.drive.drive(1.0, 0.0);
			break;
		case tertiaryTestProgram:
			RobotMap.solenoid.set(true);
			Timer.delay(5);
			RobotMap.solenoid.set(false);
			break;
		case defaultTestProgram:
			RobotMap.drive.drive(-1.0, 0.0);
		}
	}

	public static void UtilityProgramsInit() {
		utilityProgramSelected = (String) chooser.getSelected();
		System.out.println("Utility Program Selected: " + utilityProgramSelected);
	}
}
