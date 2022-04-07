package project2;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Match {

	public static void main(String[] args){
		Student[] arr = new Student[100];
		
		System.out.print("Please give the file name: ");
		Scanner input = new Scanner(System.in);
		String filename = input.next();
		System.out.println();
		
		try {
			int i = 0;
			Scanner fileInput = new Scanner (new FileReader(filename));
			while (fileInput.hasNextLine()){

				Scanner textInput = new Scanner(fileInput.nextLine());
				textInput.useDelimiter("[\t\r]"); 
				String name = textInput.next(); 
				String gender = textInput.next();
				String date = textInput.next(); 

				Scanner dateInput = new Scanner (date);
				dateInput.useDelimiter("-");
				int month = dateInput.nextInt();
				int day = dateInput.nextInt();
				int year = dateInput.nextInt();

				int quietTime = textInput.nextInt(); 
				int music = textInput.nextInt();
				int reading = textInput.nextInt();
				int chatting = textInput.nextInt();

				Date birthdate = new Date (year, month, day);
				Preference pref = new Preference(quietTime, music, reading, chatting);

				Student newStudent = new Student(name, gender.charAt(0), birthdate, pref);
				arr[i++] = newStudent;
				
				textInput.close();
				dateInput.close();
			}
			
			fileInput.close();
			
			int max = i;
			for (i = 0; i < max; i++){
				if (!arr[i].getMatched()){    //compare score
					int bestScore = 0; 
					int bestMatch = 0;
					for (int j=i+1; j<max;j++){
						if(!arr[j].getMatched()){
							int st = arr[i].compare(arr[j]);
							if (st > bestScore){
								bestScore = st;
								bestMatch = j;
							}
						}
					}
					if (bestScore != 0){     //match
						arr[i].setMatched(true);
						arr[bestMatch].setMatched(true);
						System.out.println(arr[i].getName() + " matches with " + arr[bestMatch].getName() + " with the score " + bestScore);
					} else
						if (!arr[i].getMatched())
							System.out.println(arr[i].getName() + " has no matches.");
				}
			}
			input.close();
		} catch (NoSuchElementException e){
			System.out.println(e);
		} catch (FileNotFoundException e){
			System.out.println(e);
		}
	}
}