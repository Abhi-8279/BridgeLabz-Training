import java.util.*;

public class BuzzMainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 🔥 Loose Coupling (interface reference)
        Service service = new Service();

        while (true) {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    CreatorStats creator = new CreatorStats();

                    System.out.println("Enter Creator Name:");
                    creator.setCreatorName(sc.nextLine());

                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        likes[i] = sc.nextDouble();
                    }
                    sc.nextLine();

                    creator.setWeeklyLikes(likes);
                    service.registerCreator(creator);

                    System.out.println("Creator registered successfully");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold = sc.nextDouble();
                    sc.nextLine();

                    Map<String, Integer> result =
                            service.getTopPostCounts(
                                    CreatorStats.EngagementBoard,
                                    threshold);

                    if (result.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : result.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    System.out.println();
                    break;

                case 3:
                    double avg = service.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + avg);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    return;

                default:
                    System.out.println("Invalid choice");
                    System.out.println();
            }
        }
    }
}
