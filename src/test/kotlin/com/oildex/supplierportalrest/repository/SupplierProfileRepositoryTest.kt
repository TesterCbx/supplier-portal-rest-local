package com.oildex.supplierportalrest.repository

import com.fasterxml.jackson.databind.ObjectMapper
import com.oildex.supplierportalrest.model.ErpCSVSettings
import com.oildex.supplierportalrest.model.ErpQuickBooksDesktopSettings
import com.oildex.supplierportalrest.model.ErpQuickbooksCloudSettings
import com.oildex.supplierportalrest.model.SupplierProfile
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.TestPropertySource
import java.nio.file.Paths
import java.time.Instant
import java.util.*

@DataMongoTest
@TestPropertySource(locations = ["classpath:test.properties"])
class SupplierProfileRepositoryTest @Autowired constructor(
        val mongoTemplate: MongoTemplate, val supplierProfileRepository: SupplierProfileRepository
) {
    private val SAMPLE_JSON = Paths.get("src", "test", "resources", "data", "sampleSupplier.json").toFile()
    private val mapper = ObjectMapper()

    @BeforeEach
    @Throws(Exception::class)
    fun beforeEach() { // Deserialize our JSON file to an array of reviews
//        val objects: Array<SupplierProfile> = mapper.readValue(SAMPLE_JSON, Array<SupplierProfile>::class.java)
        // Load each review into MongoDB
//       objects.forEach { mongoTemplate.save(it) }
    }

    @AfterEach
    fun afterEach() { // Drop the reviews collection so we can start fresh
        //mongoTemplate.dropCollection("Reviews")
    }

    @Test
    fun `When findByIdOrNull then return SupplierProfile`() {
//        val reviews: List<SupplierProfile> = supplierProfileRepository.findAll()
//        Assertions.assertEquals(1, reviews.size, "Should be two reviews in the database")
        val profile = SupplierProfile(supplierId = "1234",
                erpTypeQuickbooksCloud = ErpQuickbooksCloudSettings(active = false),
                erpTypeQuickbooksDesktop = ErpQuickBooksDesktopSettings(active = false),
                erpTypeCSV = ErpCSVSettings(active = true, isFileUploaded = true),
                invoiceHeadersUpdateDate = Date())

        var result = supplierProfileRepository.save(profile)
        Assertions.assertNotNull(result)

    }


}
