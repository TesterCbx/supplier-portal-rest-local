package com.oildex.supplierportalrest.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.annotation.Generated

@Document(collection = "SupplierProfile")
class SupplierProfile(
        @Id
        @Generated
        var id: String? = null,
        var supplierId: String? = null,
        var erpTypeQuickbooksCloud: ErpQuickbooksCloudSettings? = null,
        var erpTypeQuickbooksDesktop: ErpQuickBooksDesktopSettings? = null,
        var erpTypeCSV: ErpCSVSettings? = null,
        var invoiceHeadersUpdateDate: Date? = null
)


class ErpQuickbooksCloudSettings(
        var active: Boolean = false,
        var accessToken: String? = null,
        var realmId: String? = null,
        var companyInfo: String? = null,
        var tokenStatus: String? = null,
        var refreshToken: String? = null
)


class ErpQuickBooksDesktopSettings(
        var active: Boolean = false,
        var attachmentsPath: String? = null,
        var companyName: String? = null
)


class ErpCSVSettings(
        var active: Boolean = false,
        var csvTemplateType: String? = null,
        var customerData: String? = null,
        var invoiceDataFile: String? = null,
        var isFileUploaded: Boolean = false
)
