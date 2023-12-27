package com.exercise.cards.dto

import com.exercise.cards.entity.CardEntity

data class Card(

    var mobileNumber: String,

    var cardNumber: String,

    var cardType: String,

    var totalLimit: Int,

    var amountUsed: Int,

    var availableAmount: Int,
) {
    constructor(cardEntity: CardEntity) : this(
        mobileNumber = cardEntity.mobileNumber,
        cardNumber = cardEntity.cardNumber,
        cardType = cardEntity.cardType,
        totalLimit = cardEntity.totalLimit,
        amountUsed = cardEntity.amountUsed,
        availableAmount = cardEntity.availableAmount,
    )
}
