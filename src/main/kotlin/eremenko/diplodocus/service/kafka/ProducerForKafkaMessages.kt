package eremenko.diplodocus.service.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import eremenko.diplodocus.constansts.KafkaConsts
import eremenko.diplodocus.dto.KafkaRecordDto
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.concurrent.Future
@Service
class ProducerForKafkaMessages {
    private val mapper: ObjectMapper = ObjectMapper().findAndRegisterModules()
    private val producer = KafkaProducer<String, String>(KafkaConsts.producerProps)

    private val logger = LoggerFactory.getLogger(javaClass)

    fun sendMessage(message: String) {

        val producerRecord : ProducerRecord<String, String> = ProducerRecord(
            KafkaConsts.TEST_TOPIC_NAME, mapper.writeValueAsString(KafkaRecordDto(
                LocalDateTime.now(), message)))

        val future: Future<RecordMetadata> = producer.send(producerRecord)!!
        logger.info("message sent to " + future.get().topic())
    }
}