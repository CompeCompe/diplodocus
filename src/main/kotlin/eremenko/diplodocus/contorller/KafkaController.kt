package eremenko.diplodocus.contorller

import eremenko.diplodocus.service.kafka.ProducerForKafkaMessages
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import lombok.AllArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@RestController
class KafkaController(
    val kafkaProducer: ProducerForKafkaMessages
) {

    @GetMapping("/produce")
    @Operation(description = "Create kafka message")
    @Parameter(name = "message", description = "message")
    fun produceMessage(@RequestParam("message") message : String) : ResponseEntity<String> {
        kafkaProducer.sendMessage(message)
        return ResponseEntity.ok("message sent");
    }

}