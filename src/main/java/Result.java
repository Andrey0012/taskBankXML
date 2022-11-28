import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@Data
@XmlRootElement
@XmlType(propOrder = {"person"})
public class Result {
    ArrayList<Person> person;

    @XmlElement(name = "Person")
    public ArrayList<Person> getPerson() {return person;}
}
