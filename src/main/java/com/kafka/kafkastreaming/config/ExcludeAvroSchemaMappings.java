package com.kafka.kafkastreaming.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExcludeAvroSchemaMappings {

    @SuppressWarnings("unused")
    public abstract static class IgnoreSchemaProperty {
          @JsonIgnore
          abstract void getSchema();
    }

    @Bean
    public ObjectMapper objectMapper() {
          ObjectMapper om = new ObjectMapper();
          om.addMixIn(SpecificRecordBase.class, IgnoreSchemaProperty.class);
          return om;
    }
}