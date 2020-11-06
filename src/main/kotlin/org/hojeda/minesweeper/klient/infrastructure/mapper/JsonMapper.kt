package org.hojeda.minesweeper.klient.infrastructure.mapper

import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule

object JsonMapper {
    private lateinit var objectMapper: ObjectMapper

    fun get(): ObjectMapper {
        if (!this::objectMapper.isInitialized) {
            objectMapper = ObjectMapper().apply {
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
                configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
                configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                registerModule(JavaTimeModule())
                registerModule(KotlinModule())
                propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
            }
        }
        return objectMapper
    }
}