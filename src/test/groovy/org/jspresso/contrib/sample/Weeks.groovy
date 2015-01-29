package org.jspresso.contrib.sample

import java.text.SimpleDateFormat

import org.jspresso.contrib.tmar.core.Tmar4JUnit
import org.junit.Test

class Weeks extends Tmar4JUnit {

	@Test
	void test() {
		eachIteration('test') { tmar ->

			// check week
			def Calendar cal = Calendar.getInstance()
			cal.setTime(new SimpleDateFormat("yyyy/MM/dd").parse(tmar.date))
			cal.setFirstDayOfWeek(Calendar.SUNDAY)
			cal.setMinimalDaysInFirstWeek(1);
			tmar.week = cal.get(Calendar.WEEK_OF_YEAR);

			// check day of week
			def index = cal.get(Calendar.DAY_OF_WEEK);
			tmar.dayOfWeek = tmar.getMapValue('days', index, 'name')
		}
	}

}
