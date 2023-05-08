package com.beihua.test;

import java.util.Calendar;

public class TestCal {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println("星期" + c.get(Calendar.DAY_OF_WEEK));
		System.out.println("午别" + c.get(Calendar.AM_PM));
	}
}
