package DAIMLER.Validation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

public class UtilValues {

	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest logger;
	private String FirstName;
	private String LastName;
	Faker faker = new Faker();
	private static String SAMPLE_CSV_FILE = "./sample.csv";

	public UtilValues(WebDriver d, ExtentTest logger) {
		this.driver = d;
		this.logger = logger;
		this.wait = new WebDriverWait(this.driver, 50);
	}

	public String FullName() {
		String name = faker.name().fullName();
		return name;
	}

	public String FirstName() {
		String FName = faker.name().firstName();
		return FName;
	}

	public String LastName() {
		String LName = faker.name().lastName();
		return LName;
	}

	public String PhoneNumber() {
		String phoneNumber1 = faker.phoneNumber().cellPhone();
		String result1 = phoneNumber1.replaceAll("[-+.^:,' ')( x]", "");
		return result1;
	}

	public String Address() {
		String streetAddress = faker.address().streetAddress();
		return streetAddress;
	}

	public String company() {
		String company = faker.company().profession();
		return company;
	}

	public String job() {
		String job = faker.job().position();
		return job;
	}

	public String School() {
		String secondarySchool = faker.educator().secondarySchool();
		return secondarySchool;
	}

	public String university() {
		String university = faker.educator().university();
		return university;
	}

	public String Course() {
		String Course = faker.educator().course();
		return Course;
	}

	public String campus() {
		String campus = faker.educator().campus();
		return campus;
	}

	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public void BulkCaseData() throws IOException {

		PrintWriter pw;
		try {
			pw = new PrintWriter(new File(SAMPLE_CSV_FILE));

			StringBuffer csvHeader = new StringBuffer("");

			// Create the header name of the CSV File
			csvHeader.append("Employee_ID,FirstName,LastName,E-Mail,Gender,DOB\n");

			// write header
			pw.write(csvHeader.toString());

			for (int Count = 1; Count <= 5; Count++) {
				FirstName = faker.name().firstName().replace(",'.;><:!@#$%^&*()~","");; // Valid First Name
				LastName = faker.name().lastName().replace(",'.;><:!@#$%^&*()~","");; // Valid Last Name

				Random random = new Random(); // USed to Pick Random Value
				int minDay = (int) LocalDate.of(1980, 1, 1).toEpochDay(); // Value start from to Pick
				int maxDay = (int) LocalDate.of(2001, 1, 1).toEpochDay(); // Value end to Pick
				long randomDay = minDay + random.nextInt(maxDay - minDay); // Random Date Pick

				LocalDate BirthDate = LocalDate.ofEpochDay(randomDay);

				StringBuffer csvData = new StringBuffer("");

				// write data in the Each cell
				csvData.append("DEM0" + Count); // Employee ID
				csvData.append(',');
				csvData.append(FirstName); // First Name
				csvData.append(',');
				csvData.append(LastName); // Last Name
				csvData.append(',');
				csvData.append(getSaltString() + "@test.com"); // Email ID
				csvData.append(',');
				csvData.append("Male"); // Gender
				csvData.append(',');
				csvData.append(BirthDate); // Date of Birth
				csvData.append('\n');
				pw.write(csvData.toString()); // Write data into the csv file
			}
			pw.close(); // Close the File

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String read() throws Exception {
		String datas = "";
		Properties props = new Properties();

		props.load(new FileInputStream(new File("./smtp.properties")));

		Session session = Session.getDefaultInstance(props, null);

		Store store = session.getStore("imaps");
		store.connect("smtp.gmail.com", "starmani.143.program@gmail.com", "itstarmani");

		Folder inbox = store.getFolder("inbox");
		inbox.open(Folder.READ_ONLY);
		int messageCount = inbox.getMessageCount();

		System.out.println("Total Messages:- " + messageCount);

		Message[] messages = inbox.getMessages();
		System.out.println("------------------------------");

		System.out.println("Mail Subject:- " + messages[messages.length - 1].getSubject());
		DataHandler data = messages[messages.length - 1].getDataHandler();
		if (data.getContentType().equals("TEXT/HTML; charset=us-ascii")) {
			datas = data.getContent().toString();
		} else {
			// System.out.println("else");
			datas = "else";
		}

		inbox.close(true);
		store.close();
		return datas;
	}
}
