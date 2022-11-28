import javax.xml.bind.JAXBException;

public class Main {

    private final static int MIN=3;
    private  static final String FileInput="C:\\Users\\andre\\IdeaProjects\\taskBankXML\\taskBankXML\\src\\main\\resources\\dataInput.xml";
    private final static String FileOutput="C:\\Users\\andre\\IdeaProjects\\taskBankXML\\taskBankXML\\src\\main\\resources\\dataOutput.xml";

    public static void main(String[] args) throws JAXBException {
        Bank bank = Service.parseRead(FileInput);
        Total total = Service.getResult(bank, MIN);
        Service.parseWrite(total, FileOutput);
    }
}