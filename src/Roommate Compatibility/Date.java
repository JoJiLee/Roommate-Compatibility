package project2;

public class Date {

	int month;
	int day;
	int year;
	int yearsDiffInDays;
	int daysDiff;
	int monthsDiff;
	int totalDiff;

	//constructor
	public Date(int year, int month, int day) {
		if (year >= 1900 && year <= 3000) {
			this.year = year;
		}
		if (month >= 1 && month <= 12) {
			this.month = month;
		}
		if (day >= 1 && day <= 31) {
			this.day = day;
		}
	}

	//days till bday
	public int dayOfYear() {
		int totalDays = 0;
		switch (month) {
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9 : totalDays += 31;
		case 8 : totalDays += 31;
		case 7 : totalDays += 30;
		case 6 : totalDays += 31;
		case 5 : totalDays += 30;
		case 4 : totalDays += 31;
		case 3 : totalDays += 28;
		case 2 : totalDays += 31;
		}
		totalDays += day;
		return totalDays;
	}

	//Accessor
	public int getMonth() {
		return month;
	}

	//Accessor
	public int getDay() {
		return day;
	}

	//Accessor
	public int getYear() {
		return year;
	}

	//Compares Birthdates
	public int compare(Date dt) {
		yearsDiffInDays = Math.abs(this.getYear() - dt.getYear()) * 365;
		daysDiff = Math.abs(this.dayOfYear() - dt.dayOfYear());
		totalDiff = Math.abs(yearsDiffInDays - daysDiff);
		monthsDiff = totalDiff/30;

		if (monthsDiff > 60) {
			monthsDiff = 60;
		} 
		return monthsDiff;
	}
}
