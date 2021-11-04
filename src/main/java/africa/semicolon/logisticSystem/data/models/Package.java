package africa.semicolon.logisticSystem.data.models;

import lombok.Data;

@Data
public class Package {
    private Integer id;
    private String name;
    private String senderName;
    private String receiverName;
    private String deliveryAddress;
    private double netWeight;
    private String senderPhone;
    private String receiverPhone;

}
