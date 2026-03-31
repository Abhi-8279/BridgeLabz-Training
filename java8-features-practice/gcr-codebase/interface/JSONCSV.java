interface Exporter {
    void export();
}

class CsvExporter implements Exporter {
    public void export() {
        System.out.println("Exporting CSV");
    }
}
class PdfExporter implements Exporter {
    public void export() {
        System.out.println("Exporting PDF");
    }
}

class ReportService {

    private Exporter exporter;   // depends on abstraction

    ReportService(Exporter exporter) {
        this.exporter = exporter;
    }

    void generateReport() {
        exporter.export();
    }
}
public class JSONCSV {

    public static void main(String[] args) {

        Exporter csv = new CsvExporter();
        Exporter pdf = new PdfExporter();

        csv.export();
        csv.export();   // default method

        pdf.export();
        pdf.export();   // default method
    }
}

