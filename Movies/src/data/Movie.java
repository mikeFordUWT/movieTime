package data;

import java.util.ArrayList;
/**
 * A Movie object class.
 * 
 * @author Michael Ford and Andy Bleich
 *
 */

public class Movie {
	private String myTitle;
	private int myRunTime;
	private int myYear;
	private int myBoxOffice;
	private String myMpaa;
	private ArrayList<Actor> myActors;
	private Director director;
	private String movieId;

	public Movie(String id,String title, int runTime, int year, int boxOffice, String mpaa) {
		movieId = id;
		myTitle = title;
		myRunTime = runTime;
		myYear = year;
		myBoxOffice = boxOffice;
		myMpaa = mpaa;
		myActors = new ArrayList<Actor>();
		director = null;
	}

	public String getTitle(){
		String title = myTitle;
		return title;
	}

	public int getRunTime(){
		return myRunTime;
	}

	public int getYear(){
		return myYear;
	}

	public int getBoxOffice(){
		return myBoxOffice;
	}

	public String getMPAA(){
		return myMpaa;
	}

	public String getID(){
		return movieId;
	}

	public void setDirector(Director direct){
		director = direct;
	}
	
	public Director getDirector(){
		return director;
	}
	
	public void addActor(Actor inputActor){
		myActors.add(inputActor);
	}
	
	public ArrayList<Actor> getActorList(){
		return myActors;
	}

	@Override
	public String toString(){
		String run = String.valueOf((myRunTime/60)) + "hr " + String.valueOf(myRunTime%60) + "mins";
		String toReturn = myTitle + "\n" + myMpaa + " | " + run + "\n" + getActors(myActors) +
				"\n" + myBoxOffice;
		return toReturn;
	}
	
	public String getActors(ArrayList<Actor> inputList) {
		String str = "";
		for(int i = 0; i <inputList.size(); i++){
			if(i!= inputList.size()-1){
				str += inputList.get(i) + ", ";
			} else {
				str += inputList.get(i);
			}
			
		}
		return str;
	}
}
