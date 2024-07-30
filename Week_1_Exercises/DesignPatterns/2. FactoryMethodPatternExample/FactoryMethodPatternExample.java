import java.util.Scanner;

interface Document {
    void open();
    void close();
    void save();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document...");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document...");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document...");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentFactory factory = null;

        System.out.println("Enter the type of document to create (word, pdf, excel): ");
        String docType = scanner.nextLine();

        switch (docType.toLowerCase()) {
            case "word":
                factory = new WordDocumentFactory();
                break;
            case "pdf":
                factory = new PdfDocumentFactory();
                break;
            case "excel":
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Unknown document type.");
                scanner.close();
                return;
        }

        Document document = factory.createDocument();
        document.open();
        document.save();
        document.close();

        scanner.close();
    }
}
