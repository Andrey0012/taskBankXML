import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@XmlRootElement(name = "Bank")
@XmlType(propOrder = {"person"})
public class Bank {
    private BigDecimal wallet;
    private ArrayList<Person> person;

    @XmlAttribute
    public BigDecimal getWallet() {
        return wallet;
    }
    @XmlElement(name = "Person")
    public ArrayList<Person> getPerson() {
        return person;
    }
}
