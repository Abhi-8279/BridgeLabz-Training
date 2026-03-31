public class IPValidator {

    public static void main(String[] args) {

        String ip = "192.168.1.1";

        String regex =
            "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}"
          + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";

        System.out.println(ip.matches(regex) ? "Valid IP" : "Invalid IP");
    }
}
