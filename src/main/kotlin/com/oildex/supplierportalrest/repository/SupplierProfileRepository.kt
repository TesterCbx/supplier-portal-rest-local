package com.oildex.supplierportalrest.repository

import com.oildex.supplierportalrest.model.SupplierProfile
import org.springframework.data.mongodb.repository.MongoRepository

interface SupplierProfileRepository : MongoRepository<SupplierProfile, String>{
}
