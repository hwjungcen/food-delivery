package fd.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fd.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fd.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired CookingRepository cookingRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_주문정보복제(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener 주문정보복제 : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        Cooking.주문정보복제(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_UpdateStatus(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener UpdateStatus : " + paid + "\n\n");


        

        // Sample Logic //
        Cooking.updateStatus(event);
        

        

    }

}


