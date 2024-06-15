package org.d3if3053.ass3.ui.model

data class Outfit(
    val outfit_id: Int,
    val user_email: String,
    val outfit_style: String,
    val deskripsi: String,
    val image_id: String,
    val delete_hash: String,
    val created_at: String
)

data class OutfitCreate(
    val user_email: String,
    val image_id: String,
    val outfit_style: String,
    val deskripsi: String,
    val delete_hash: String
)
