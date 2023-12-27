package com.exercise.cards.entity

import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
data class CardEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    val cardId: Long = 0,

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
