package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String status;
    private String foodId;
    private String orderId;
    private List<String> options;
    private String storeId;
    private String customerId;

    public OrderAccepted(Cooking aggregate){
        super(aggregate);
    }
    public OrderAccepted(){
        super();
    }
}
