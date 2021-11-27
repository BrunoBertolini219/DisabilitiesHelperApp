package br.com.brunoccbertolini.disabilitieshelperapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "card")
data class Card(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val imgUrl: String,
    val category: String,
    val parentCard: Boolean? = false
): Serializable