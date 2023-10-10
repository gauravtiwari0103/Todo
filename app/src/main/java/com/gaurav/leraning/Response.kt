package com.gaurav.leraning

import com.google.gson.annotations.SerializedName

data class Response (

    @SerializedName("LeaveAssignedHDRID" ) var LeaveAssignedHDRID : Int?    = null,
    @SerializedName("LeaveAssignedDTLID" ) var LeaveAssignedDTLID : Int?    = null,
    @SerializedName("Leave"              ) var Leave              : Int?    = null,
    @SerializedName("LeaveName"          ) var LeaveName          : String? = null,
    @SerializedName("LeaveType"          ) var LeaveType          : String? = null,
    @SerializedName("FromDate"           ) var FromDate           : String? = null,
    @SerializedName("ToDate"             ) var ToDate             : String? = null,
    @SerializedName("Status"             ) var Status             : String? = null

)