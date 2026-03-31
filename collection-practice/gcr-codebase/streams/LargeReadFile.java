import java.io.*;
public class LargeReadFile {
	public static void main(String[] args) {
		String path = "collections-practice/gcr-codebase/streams/";
        String filePath =path+"sourceFile.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber=1;
            System.out.println("Reading file line by line...");

            while ((line = br.readLine()) !=null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + "- "+line);
                }
                lineNumber++;
            }

            System.out.println("Finished reading file.");

        } catch (IOException e) {
            System.out.println("Error reading file- "+e.getMessage());
        }
    }
}