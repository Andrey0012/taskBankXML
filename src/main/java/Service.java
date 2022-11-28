import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    public static Total getResult(Bank bank, int min){
        Total total=new Total();
        BigDecimal cash = bank.getWallet();
        ArrayList<Person> person = bank.getPerson();
        BigDecimal avgMoney = avgPerPerson(cash, person);
        Result resultPerson = putPersonToResult(person, avgMoney);
        Result resultMinimum = putMinimumToResult(min, person);
        total.setResult(resultPerson);
        total.setMinimum(resultMinimum);
        return total;
    }

    private static BigDecimal avgPerPerson(BigDecimal cash, ArrayList<Person> person) {
        List<BigDecimal> wallets = person.stream().map(Person::getWallet).collect(Collectors.toList());
        BigDecimal sum= cash;
        for (BigDecimal wallet:wallets){
            sum=sum.add(wallet);
        }
        BigDecimal divide = sum.divide(BigDecimal.valueOf(person.size()), RoundingMode.HALF_DOWN);
        return divide;
    }

    private static Result putPersonToResult(ArrayList<Person> person, BigDecimal avgMoney) {
        for (int i = 0; i < person.size(); i++) {
            person.get(i).setAppendFromBank(avgMoney.subtract(person.get(i).getWallet()));
        }
        Result result=new Result();
        result.setPerson(person);
        return result;
    }

    private static Result putMinimumToResult(int min, ArrayList<Person> person) {
        ArrayList<Person> personMinimum=new ArrayList<Person>();
        List<Person> collect1 = person.stream().sorted(Comparator.comparing(Person::getAppendFromBank)).collect(Collectors.toList());
        System.out.println("");
        for (int i = 0; i < min; i++) {
            personMinimum.add(new Person(collect1.get(i).getName()));
        }
        Result minimum=new Result();
        minimum.setPerson(personMinimum);
        return minimum;
    }

    public static Bank parseRead(String filename) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshal = jaxbUnmarshaller.unmarshal(new File(filename));
        return (Bank) unmarshal;
    }

    public static void parseWrite(Total total, String filename) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Total.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        jaxbMarshaller.marshal((Object) total, new File(filename));
        System.out.println("File written");;
    }

}
