package com.andersonbraz.solution;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class NewRecordMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties());
		String value = "12345, 67890, 1634094000";
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("PRODUCER_NEW_RECORD", value, value);
		
		producer.send(record, (data, ex) -> {
			if(ex != null) {
				ex.printStackTrace();
				return;
			}
			System.out.println(
					"SUCCESS " + data.topic() 
					+ " ::: Partition " + data.partition() 
					+ ", Offset " + data.offset()
					+ ", Timestamp " + data.timestamp()
					);
			
		}).get();
		

	}

	private static Properties properties() {
		
		Properties properties = new Properties();
		
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		return properties;
	}

}
