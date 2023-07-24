package com.example.spinnertutorial.network

import com.google.gson.annotations.SerializedName


// models which I am sending to the APIs
class CRMRequestModel(
    @SerializedName("rfid") val rfid: String?
)

class BookingRequestModel(
    @SerializedName("from") val timeFrom: String?,
    @SerializedName("to") val timeTo: String?,
    @SerializedName("equipment") val equipment: List<String?>,
    @SerializedName("research_group") val researchGroup: String?,
    @SerializedName("status_code") val statusCode: Int?,
    @SerializedName("time_requirement") val timeRequirement: Int?,
    @SerializedName("realised_for") val userID: String?,
    @SerializedName ("description") val description: String?,
    @SerializedName ("fields") val fields: MutableMap<String, MutableMap<String, Any>>

    )

