package com.example.nano_rfid.network

import com.google.gson.annotations.SerializedName

//Tady naprogramujem jaku ocekavam odpoved z API


/* Z CRM dorazi takato odpoved

 */

data class CRMResponseModel(
    @SerializedName("@odata.etag") val odata: String?,
    @SerializedName("firstname") val userFirstName: String?,
    @SerializedName("contactid") val userID: String?,
    @SerializedName("fullname") val userFullName: String?,
    @SerializedName("lastname") val userLastName: String?,
    @SerializedName("full_name") val userFull_Name: String?,
    @SerializedName("fullname_non_dia") val userFullNameNonDia: String?,
    @SerializedName("tipred") val userTitleBefore: String?,
    @SerializedName("tiza") val userTitleAfter: String?,
    @SerializedName("primary_rg") val primaryRg: String?,
)

class CRMResponseList : ArrayList<CRMResponseModel>()

data class BookingResponse (
    @SerializedName("guid") val reservationGUID: String?,
        )






