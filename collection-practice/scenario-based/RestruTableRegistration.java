import java.util.*;


class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}
class Table {
    int tableNumber;
    boolean reserved;

    Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.reserved = false;
    }
}

class Reservation {
    int tableNumber;

    Reservation(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}

public class RestruTableRegistration {

    Map<Integer, Table> table = new HashMap<>();
    List<Reservation> reservations = new ArrayList<>();

    // constructor – initialize tables
    public RestruTableRegistration() {
        table.put(1, new Table(1000));
        table.put(2, new Table(2080));
        table.put(3, new Table(3900));
        table.put(4, new Table(167));
        table.put(5, new Table(14));
        table.put(6, new Table(002));
        table.put(7, new Table(980));
        table.put(8, new Table(678));
        table.put(9, new Table(456));
    }

    // reserve table
    public void reserveTable(int tableNumber) throws TableAlreadyReservedException {
        Table tab = table.get(tableNumber);

        if (tab == null) {
            System.out.println("Invalid table number");
            return;
        }

        if (tab.reserved)throw new TableAlreadyReservedException("Table " + tableNumber + " is already reserved");
        tab.reserved = true;
        reservations.add(new Reservation(tableNumber));
        System.out.println("Table " + tableNumber + " reserved");
    }

    // cancel reservation
    public void cancelReservation(int tableNumber) {
        Table ta = table.get(tableNumber);

        if (ta == null || !ta.reserved) {
            System.out.println("No reservation found");
            return;
        }

        ta.reserved = false;
        reservations.removeIf(r -> r.tableNumber == tableNumber);
        System.out.println("Reservation cancelled for table " + tableNumber);
    }

    // show available tables
    public void showAvailableTables() {
        System.out.println("Available Tables:");
        for (Table table : table.values()) {
            if (!table.reserved) {
                System.out.println("Table " + table.tableNumber);
            }
        }
    }

    // main
    public static void main(String[] args) {
        RestruTableRegistration system = new RestruTableRegistration();

        try {
            system.reserveTable(1);
            system.reserveTable(2);
            system.reserveTable(1); // exception
        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        system.showAvailableTables();
        system.cancelReservation(1);
        system.showAvailableTables();
    }
}
