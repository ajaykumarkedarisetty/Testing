package commonscripts;

public class Config {

	public static String ChromeBrowser_exePath = "A:\\Selenium WorkSpace\\lib\\chromedriver.exe";
	public static final String AdminEmail = "amanda.cole@mailinator.com";
	public static final String Password = "12345678";
	public final String letters = "abcdefghijklmnopqrstuvwxyz";
	public final String numbers = "0123456789";
	public static char[] Aplhanumeric;
	public static String dialcodes;
	public static String phonenumber;
	public static String datetoselect;
	public static StringBuilder RequisitionNumber;

	// Create Job variables
	public static String HiringCompanyname = "Amzur";
	public static final String JobdescriptionContent = "As a software tester, you are involved in the quality assurance stage of software development and deployment."
			+ " You'll conduct automated and manual tests to ensure the software created by developers is fit for purpose...."
			+ " Assessing code is one part of the role of a software tester.";

	public static String[] RequiredSkills = new String[] { "core java", "Qa Automation", "Manual Testing",
			"Selenium Webdriver", "Selenium Grid" };

	public static String[] OptionalSkill = new String[] { "HTML", "Load Testing", "Performance Testing", "html5",
			"Ruby", "java script" };

	public static String YearsofExperience = "3";
	public static String NumberofCandidates = "1";
	public static boolean Codingsamples;
	public static boolean Whiteboardsamples;
	public static boolean SelectedInterviewer;

	// Interviewer job Acceptance variables
	public static String InterviewerDisplayName;
	public static String InterviewerMail;
	public static String InterviewerStatustoJob;

}
