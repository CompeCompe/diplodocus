package eremenko.diplodocus.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.Data
import java.time.LocalDateTime
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
data class KafkaRecordDto(
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val message: String = "some message"
)