package com.example.spinnertutorial.network

import com.google.gson.annotations.SerializedName

class CRMReqM(
    @SerializedName("rfid") val rfid: String?
)

class BookingReqM(
    @SerializedName("from") val timeFrom: String?,
    @SerializedName("to") val timeTo: String?,
    @SerializedName("equipment") val equipment: List<String?>,
    @SerializedName("research_group") val researchGroup: String?,
    @SerializedName("realised_for") val userID: String?,
    @SerializedName("time_requirement") val timeRequirement: Int?,
    @SerializedName("status_code") val statusCode: Int?,
    @SerializedName ("description") val description: String?

    )
