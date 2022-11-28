import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@Data
@XmlRootElement(name = "Person")
@XmlType(propOrder = {"name", "wallet","appendFromBank"})
public class Person {
    private String name;
    private BigDecimal wallet;
    private BigDecimal appendFromBank;
    public Person() {}

    public Person(String name) {this.name = name;}

    @XmlAttribute
    public String getName() {return name;}
    @XmlAttribute
    public BigDecimal getWallet() {return wallet;}
    @XmlAttribute
    public BigDecimal getAppendFromBank() {return appendFromBank;}
}
