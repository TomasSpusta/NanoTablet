package com.example.spinnertutorial.network

import com.google.gson.annotations.SerializedName

//Tady naprogramujem jaku ocekavam odpoved z API


/* Z CRM dorazi takato odpoved

 */

data class ResponseModel(
    @SerializedName("@odata.etag") val odata: String?,
    @SerializedName("firstname") val userFirstName: String?,
    @SerializedName("contactid") val userID: String?,
    @SerializedName("fullname") val userFullName: String?,
    @SerializedName("lastname") val userLastName: String?,
    @SerializedName("full_name") val userFull_Name: String?,
    @SerializedName("fullname_non_dia") val userFullNameNonDia: String?,
    @SerializedName("tipred") val userTitleBefore: String?,
    @SerializedName("tiza") val userTitleAfter: String?)

class ResponseModelList : ArrayList<ResponseModel>()








