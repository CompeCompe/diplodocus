package eremenko.diplodocus.repos.kafka

import eremenko.diplodocus.entity.KafkaRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KafkaRecordRepository: JpaRepository<KafkaRecord, Long>