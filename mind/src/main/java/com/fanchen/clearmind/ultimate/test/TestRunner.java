package com.fanchen.clearmind.ultimate.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.fanchen.clearmind.testcase.TestEmployeeDetails;

public class TestRunner {
	// public static void main(String[] args) {
	// Result result = JUnitCore.runClasses(TestEmployeeDetails.class);
	//
	// for (Failure failure : result.getFailures()) {
	// System.out.println(failure.toString());
	// }
	//
	// System.out.println(result.wasSuccessful());
	// }

	public static void main(String[] args) {
		Result res = JUnitCore.runClasses(TestEmployeeDetails.class);

		for (Failure fail : res.getFailures()) {
			System.out.println(fail.toString());
		}

		System.out.println(res.wasSuccessful());
	}
}
