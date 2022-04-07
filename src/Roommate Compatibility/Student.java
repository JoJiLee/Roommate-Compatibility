package project2;

public class Student {

	public String name;
	public char gender;
	public Date bDay;
	public Preference pref;
	public boolean matched;
	private int score;
	
	//constructor
	public Student(String name, char gender, Date birthdate, Preference pref) {
		this.name = name;
		this.gender = gender;
		this.bDay = birthdate;
		this.pref = pref;
	}
	
	//Accessor
	public String getName() {
		return name;
	}
	
	//Accessor
	public char getGender() {
		return gender;
	}
	
	//Accessor
	public Date getBirthdate() {
		return bDay;
	}
	
	//Accessor
	public Preference getPreference() {
		return pref;
	}
	
	//Accessor
	public boolean getMatched() {
		return matched;
	}
	
	//mutator
	public void setMatched(boolean match) {
		matched = match;
	}
	
	//Compares students 
	public int compare(Student st) {
		if (this.getGender() != st.getGender()) {
			score = 0;
		} else {
			int Preferences = pref.compare(st.pref);
			int AgeDifference = bDay.compare(st.bDay);
			score = (40 - Preferences) + (60 - AgeDifference);
		}
		return score;
	}
}