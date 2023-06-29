package eremenko.diplodocus.entity

import lombok.Data
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Data
@Table(name = "kafkaRecords")
@Entity
data class KafkaRecord(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "create_date")
    var createDate: LocalDateTime,
    @Column(name = "catch_date")
    var catchDate: LocalDateTime,
    @Column(name = "message")
    var message: String
)