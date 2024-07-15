package com.conymind.backend.externalapi

import com.google.gson.annotations.SerializedName

data class GeocodeResponse(
    @SerializedName("plus_code")
    val plusCode: PlusCode,
    val results: List<GeocodeResult>,
    val status: String
) {
    val formattedAddress: String?
        get() {
            val firstResult = results.firstOrNull()
            val sublocality1 = firstResult?.getSublocality1()
            val sublocality2 = firstResult?.getSublocality2()
            return listOfNotNull(sublocality1, sublocality2).joinToString(" ")
        }
}

data class PlusCode(
    @SerializedName("compound_code")
    val compoundCode: String,
    @SerializedName("global_code")
    val globalCode: String
)

data class GeocodeResult(
    @SerializedName("address_components")
    val addressComponents: List<AddressComponent>,
    @SerializedName("formatted_address")
    val formattedAddress: String,
    val geometry: Geometry,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("plus_code")
    val plusCode: PlusCode,
    val types: List<String>
)

data class AddressComponent(
    @SerializedName("long_name")
    val longName: String,
    @SerializedName("short_name")
    val shortName: String,
    val types: List<String>
)

data class Geometry(
    val location: LatLng,
    @SerializedName("location_type")
    val locationType: String,
    val viewport: GeocodeViewport,
    val bounds: GeocodeViewport? = null
)

data class LatLng(
    val lat: Double,
    val lng: Double
)

data class GeocodeViewport(
    val northeast: LatLng,
    val southwest: LatLng
)

fun GeocodeResult.getSublocality1(): String? {
    return addressComponents.find { it.types.contains("sublocality_level_1") }?.longName
}

fun GeocodeResult.getSublocality2(): String? {
    return addressComponents.find { it.types.contains("sublocality_level_2") }?.longName
}