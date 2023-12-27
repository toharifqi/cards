package com.exercise.cards.controller

import com.exercise.cards.constant.CardConstant
import com.exercise.cards.dto.Card
import com.exercise.cards.dto.Response
import com.exercise.cards.service.CardService
import jakarta.validation.Valid
import jakarta.validation.constraints.Pattern
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Validated
class CardController(
    private val cardService: CardService
) {
    @PostMapping("/create")
    fun create(
        @RequestParam
        @Pattern(regexp = "(^$|[0-9]{12})", message = "Mobile Number must be 12 digits of number")
        mobileNumber: String
    ): ResponseEntity<Response> {
        cardService.createCard(mobileNumber)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                Response(
                    statusCode = CardConstant.STATUS_201,
                    statusMessage = CardConstant.MESSAGE_201
                )
            )
    }

    @GetMapping("/fetch")
    fun fetch(
        @RequestParam
        @Pattern(regexp = "(^$|[0-9]{12})", message = "Mobile Number must be 12 digits of number")
        mobileNumber: String
    ): ResponseEntity<Card> {
        val loan = cardService.fetchCardInfo(mobileNumber)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(loan)
    }

    @PutMapping("/update")
    fun update(@RequestBody @Valid card: Card): ResponseEntity<Response> {
        val isUpdated = cardService.updateCard(card)

        return if (isUpdated) {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    Response(
                        statusCode = CardConstant.STATUS_200,
                        statusMessage = CardConstant.MESSAGE_200
                    )
                )
        } else {
            ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(
                    Response(
                        statusCode = CardConstant.STATUS_417,
                        statusMessage = CardConstant.MESSAGE_417_UPDATE
                    )
                )
        }
    }

    @DeleteMapping("/delete")
    fun delete(
        @RequestParam
        @Pattern(regexp = "(^$|[0-9]{12})", message = "Mobile Number must be 12 digits of number")
        mobileNumber: String
    ): ResponseEntity<Response> {
        val isDeleted = cardService.deleteCard(mobileNumber)
        return if (isDeleted) {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    Response(
                        statusCode = CardConstant.STATUS_200,
                        statusMessage = CardConstant.MESSAGE_200
                    )
                )
        } else {
            ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(
                    Response(
                        statusCode = CardConstant.STATUS_417,
                        statusMessage = CardConstant.MESSAGE_417_UPDATE
                    )
                )
        }
    }
}
