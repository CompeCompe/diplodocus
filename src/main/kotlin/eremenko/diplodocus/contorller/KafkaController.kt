package eremenko.diplodocus.contorller

import eremenko.diplodocus.constansts.KafkaConsts.Companion.TEST_TOPIC_NAME
import eremenko.diplodocus.constansts.KafkaConsts.Companion.producerProps
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Future

@RestController
class KafkaController {

    @GetMapping("/produce")
    @Operation(description = "Create kafka message")
    @Parameter(name = "message", description = "message")
    fun produceMessage(@RequestParam("message") message : String) : ResponseEntity<String> {
        val producerRecord : ProducerRecord<String, String> = ProducerRecord(TEST_TOPIC_NAME, message)

        val producer = KafkaProducer<String, String>(producerProps)
        val future: Future<RecordMetadata> = producer.send(producerRecord)!!
        return ResponseEntity.ok(" message sent to " + future.get().topic());
    }

}