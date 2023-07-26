package eremenko.diplodocus.service

import eremenko.diplodocus.constansts.KafkaConsts.Companion.TEST_TOPIC_NAME
import org.springframework.stereotype.Component
import org.springframework.kafka.annotation.KafkaListener

@Component
class KafkaListener {
    @KafkaListener(topics= [TEST_TOPIC_NAME], groupId = "test_id")
    fun consumeTestTopic(message: String) {
        println(" message received from topic : $message");
    }
}