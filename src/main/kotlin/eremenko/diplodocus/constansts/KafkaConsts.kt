package eremenko.diplodocus.constansts

class KafkaConsts {
    companion object {
        val producerProps = mapOf<String, String>(
            "key.serializer" to "org.apache.kafka.common.serialization.StringSerializer",
            "value.serializer" to "org.apache.kafka.common.serialization.StringSerializer",
            "bootstrap.servers" to "localhost:9092"
        )
        const val TEST_TOPIC_NAME = "test_topic"
    }
}