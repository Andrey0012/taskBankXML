import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement
@XmlType(propOrder = {"result", "minimum"})
public class Total {
//    @XmlElement(name = "result")
    private Result result;
 //   @XmlElement(name = "minimum")
    private Result minimum;

 //   @XmlElement(name = "result")
    public Result getResult() {
        return result;
    }

 //   @XmlElement(name = "minimum")
    public Result getMinimum() {
        return minimum;
    }

}
