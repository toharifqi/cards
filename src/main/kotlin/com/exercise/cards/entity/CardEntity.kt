package com.exercise.cards.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
data class CardEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    val cardId: Int,

    val mobileNumber: String,

    val cardNumber: String,

    val cardType: String,

    val totalLimit: Int,

    val amountUsed: Int,

    val availableAmount: Int,

    override var createdAt: LocalDateTime? = null,

    override var createdBy: String? = null,

    override var updatedAt: LocalDateTime? = null,

    override var updatedBy: String? = null,

) : BaseEntity
