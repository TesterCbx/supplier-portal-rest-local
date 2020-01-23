package com.oildex.supplierportalrest.web

//import com.oildex.supplierportalrest.model.SupplierProfile
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@Controller
class SupplierProfileController{
    @GetMapping("/supplierportal/supplierprofile")
    @ResponseBody
    fun getSupplierProfile(): String{
        return "can you see me?"
    }
}
