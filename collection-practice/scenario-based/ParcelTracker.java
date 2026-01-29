public class ParcelTracker {

    static class Stage {
        String status;
        Stage next;

        Stage(String status) {
            this.status = status;
            this.next = null;
        }
    }

    private Stage head;

    public void addStage(String status) {
        Stage newStage = new Stage(status);

        if (head == null) {
            head = newStage;
            return;
        }

        Stage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStage;
    }

    public void addCheckpoint(String afterStage, String newStage) {
        Stage temp = head;

        while (temp != null && !temp.status.equals(afterStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found: " + afterStage);
            return;
        }

        Stage checkpoint = new Stage(newStage);
        checkpoint.next = temp.next;
        temp.next = checkpoint;
    }

    // Forward tracking
    public void trackParcel() {
        if (head == null) {
            System.out.println("No tracking information available");
            return;
        }

        Stage temp = head;
        System.out.println("Parcel Tracking:");

        while (temp != null) {
            System.out.print(temp.status);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void checkLostParcel() {
        if (head == null) {
            System.out.println("Parcel LOST (no stages found)");
            return;
        }

        Stage temp = head;
        while (temp != null) {
            if (temp.next == null && !temp.status.equals("Delivered")) {
                System.out.println("Warning: Parcel may be LOST after stage: " + temp.status);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Parcel successfully delivered");
    }

    public static void main(String[] args) {

        ParcelTracker tracker = new ParcelTracker();

        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        tracker.addCheckpoint("Shipped", "Customs Check");

        tracker.trackParcel();

        tracker.checkLostParcel();
    }
}
