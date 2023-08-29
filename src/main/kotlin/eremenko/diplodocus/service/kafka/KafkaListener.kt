package eremenko.diplodocus.service.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import eremenko.diplodocus.constansts.KafkaConsts.Companion.TEST_TOPIC_NAME
import eremenko.diplodocus.dto.KafkaRecordDto
import eremenko.diplodocus.entity.KafkaRecord
import eremenko.diplodocus.repos.kafka.KafkaRecordRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class KafkaListener(
    val kafkaRecordRepository: KafkaRecordRepository
) {
    private val mapper = ObjectMapper().findAndRegisterModules()
    @KafkaListener(topics= [TEST_TOPIC_NAME], groupId = "test_id")
    fun consumeTestTopic(record: String) {
        val kafkaRecord = mapper.readValue(record, KafkaRecordDto::class.java)

        kafkaRecordRepository.save(KafkaRecord(
            createDate = kafkaRecord.createdDate,
            catchDate = LocalDateTime.now(),
            message = kafkaRecord.message
        ))
        println("record received from topic : $record");
    }
}