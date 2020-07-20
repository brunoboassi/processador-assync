package br.com.exemplo.processadorassync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

@Configuration
@EnableBinding(Processor.class)
@Slf4j
public class ConsumoConfigBean {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Message<Response> load(Message<Request> msg) {
        log.info("Consumer {}", msg);
        Request payload = msg.getPayload();
        Response response = Response.builder()
                .id(payload.getId())
                .message("Message " + payload.getMessageIndex())
                .origin(payload.getOrigin()).build();
        return MessageBuilder.withPayload(response).copyHeaders(msg.getHeaders()).build();
    }

}
