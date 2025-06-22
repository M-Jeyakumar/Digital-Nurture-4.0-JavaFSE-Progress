package Week_1.Design_Patterns_and_Principles.Exercise_2_Implementing_the_Factory_Method_Pattern.Code;

abstract class DocumentFactory{
    public abstract Document createDocument();
}
class WordDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        return new ExcelDocument();
    }
}
public class FactoryPatternTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument  = wordFactory.createDocument();
        wordDocument.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDocument = excelFactory.createDocument();
        excelDocument.open();
    }
}
