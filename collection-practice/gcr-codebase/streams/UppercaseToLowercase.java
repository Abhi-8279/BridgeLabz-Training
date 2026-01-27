import java.io.*;
public class UppercaseToLowercase {
	public static void main(String[] args) {
		String path = "collections-practice/gcr-codebase/streams/";
		String sourceFile =path+"sourceFile.txt";
        String destinationFile =path+"destinationFile.txt";
       
        try (
            BufferedReader br=new BufferedReader(new FileReader(sourceFile));
            BufferedWriter bw=new BufferedWriter(new FileWriter(destinationFile))
        ) {
            String line;
            System.out.println("Reading from source file and converting to lowercase...");
            while ((line =br.readLine())!=null) {
                String lowerLine =line.toLowerCase();
                bw.write(lowerLine);
                bw.newLine();
            }
            System.out.println("Conversion completed. Output saved to- "+destinationFile);

        } catch (IOException e) {
            System.out.println("Error occurred- "+e.getMessage());
        }
    }


}