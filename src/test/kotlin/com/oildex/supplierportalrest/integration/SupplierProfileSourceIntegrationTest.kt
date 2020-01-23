package com.oildex.supplierportalrest.integration

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.TestPropertySource

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = ["classpath:test.properties"])
class SupplierProfileSourceIntegrationTest (@Autowired val restTemplate: TestRestTemplate,
                                            @Autowired private val mongoTemplate: MongoTemplate){
//                                            @Autowired private val mongoTemplate: MongoTemplate){
//                                            private val wireMockServer: WireMockServer){

    @BeforeAll
    fun setup() = println(">>setup")

    @Test
    @DisplayName("GET /supplierportal/supplierprofile --by supplier id" )
    fun `Should return profile`(){
        val entity = restTemplate.getForEntity<String>("/supplierportal/supplierprofile")
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(entity.body).contains("can you see me?")
    }
}



