//import java.util.List;
//import java.util.Scanner;
//
//public class MovieMainApp {
//
//	List<String> title;
//	List<String> showtime;
//	
//	List<String> addMovie(String movie)
//	{
//		title.add(movie);
//		return title;
//	}
//	boolean searchMovie(String search)
//	{
//		if(title.contains(search))return true;
//		return false;
//	}
//	void displayMovie() {
//		for(int i=0;i<title.size();i++)
//		{
//			System.out.println(title.get(i));
//		}
//		
//	}
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
////		System.out.println("Enter the number of Moies you want to add");
//		MovieMainApp mv=new MovieMainApp();
//		mv.addMovie("Bahubali");
//		mv.displayMovie();
//		
//	}
//}


import java.util.ArrayList;
import java.util.List;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}
public class MovieMainApp {

    private List<String> titles = new ArrayList<>();
    private List<String> showTimes = new ArrayList<>();

    // Add movie with validation
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (isValidTime(time)) {
            titles.add(title);
            showTimes.add(time);
        }
        else throw new InvalidTimeFormatException("The Time " +time+" is Invalid for movie "+title);
        
    }

    // Search movie using contains()
    public void searchMovie(String keyword) {
        boolean found = false;

        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(
                    "Movie: " + titles.get(i) +
                    " | Showtime: " + showTimes.get(i)
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("Movie not found");
        }
    }


    // Display all movies
    public void displayAllMovies() {
        for (int i = 0; i < titles.size(); i++) {
            System.out.println("Movie: " +titles.get(i)+" | Showtime: "+showTimes.get(i));
        }
    }


    // Convert List to Array for report
    public void generateReport() {
        String[] report = new String[titles.size()];

        for (int i=0;i<titles.size();i++) {
            report[i] ="Movie: " +titles.get(i)+" | Showtime: "+showTimes.get(i);
        }

        System.out.println("\n--- Printable Report ---");
        for (String r : report) {
            System.out.println(r);
        }
    }  
    // Doing TIme validation
    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) return false;
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h>=0 && h<24 && m>=0 && m<59;
    }
    
    

    public static void main(String[] args) {           ///////////main

        MovieMainApp app = new MovieMainApp();

        try {
            app.addMovie("Saaaho", "18:30");
            app.addMovie("Avtaar", "21:00");
            app.addMovie("Pushpa", "25:99"); 
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- All Movies ---");
        app.displayAllMovies();

        System.out.println("\n--- Search Result ---");
        app.searchMovie("Avtaar");

        app.generateReport();
    }
}