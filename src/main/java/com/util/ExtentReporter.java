package com.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports getExtentReport() {
		
		String extentReportFilePath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFilePath);
		sparkReporter.config().setReportName("TutorialsNinja Automation Result");
		sparkReporter.config().setDocumentTitle("TutorialsNinja Test Automation Result");
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Selenium Version", "4.1.1");
		extentReport.setSystemInfo("Operation System", "Windows 11");
		extentReport.setSystemInfo("Executed By", "Abhishek Trivedi");
		return extentReport;
	}
}
