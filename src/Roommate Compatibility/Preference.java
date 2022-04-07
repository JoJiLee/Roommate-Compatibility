package project2;

public class Preference {

	int quietTime;
	int music;
	int reading; 
	int chatting; 
	
	//constructor
	public Preference(int quietTime, int music, int reading, int chatting) {
		//0 means hate activity
		//10 means love activity
		
		if (quietTime >= 0 && quietTime <=10) {
			this.quietTime = quietTime;
		}
		if (music >= 0 && music <= 10) {
			this.music = music;
		}
		if (reading >= 0 && reading <= 10) {
			this.reading = music;
		}
		if (chatting >= 0 && chatting <= 10) {
			this.chatting = chatting;
		}
	}

	//Accessor
	public int getQuietTime() {
		return quietTime;
	}
	
	//Accessor
	public int getMusic() {
		return music;
	}
	
	//Accessor
	public int getReading() {
		return reading;
	}
	
	//Accessor
	public int getChatting() {
		return chatting;
	}
	
	//Compares Preferences
	public int compare(Preference pref) {
		int diff = Math.abs((this.getQuietTime() - pref.getQuietTime()) + (this.getMusic() - pref.getMusic()) + (this.getReading() - pref.getReading()) + (this.getChatting() - pref.getChatting()));
		
		return diff;
	}

}