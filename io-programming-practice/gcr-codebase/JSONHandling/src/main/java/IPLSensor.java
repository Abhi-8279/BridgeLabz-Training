
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;

class IPLSensor {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<Map<String, Object>> matches =
                mapper.readValue(new File("C:\\Users\\sr779\\OneDrive\\Desktop\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\JSONHandling\\src\\main\\java\\matches.csv"), List.class);

        for (Map<String, Object> match : matches) {
            
            match.put("team2", maskTeam((String) match.get("team2")));
            match.put("playerOfMatch", "REDACTED");
        }

        // Write censored JSON
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File("matches_censored.json"), matches);

        // Process CSV
        processCSV();

        System.out.println("Censorship completed!");
    }

    static String maskTeam(String team) {
        return team.split(" ")[0] + " ***";
    }

    static void processCSV() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("D:\\BT\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\jsonHandling\\src\\main\\java\\matches.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\BT\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\jsonHandling\\src\\main\\java\\matches_censored.csv"));

        bw.write(br.readLine());
        bw.newLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");

            d[1] = maskTeam(d[1]);
            d[2] = maskTeam(d[2]);
            d[3] = "REDACTED";

            bw.write(String.join(",", d));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}