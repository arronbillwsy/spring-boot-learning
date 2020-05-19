//package learn_spring_boot.demo.handler;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class MessageHandler {
//
//    private final String TOPIC_NAME = "testKafka";
//
//    @KafkaListener(topics = TOPIC_NAME, containerFactory = "ackContainerFactory")
//    public void handleMessage(ConsumerRecord record, Acknowledgment acknowledgment) {
//        try {
//            String message = (String) record.value();
//            System.out.println(message+"======================");
//            log.info("收到消息: {}", message);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            // 手动提交 offset
//            acknowledgment.acknowledge();
//        }
//    }
//}
