package eremenko.diplodocus.repos

import eremenko.diplodocus.entity.KafkaRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KafkaRecordRepository: JpaRepository<KafkaRecord, Long>