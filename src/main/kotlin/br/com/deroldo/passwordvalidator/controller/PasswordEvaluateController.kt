package br.com.deroldo.passwordvalidator.controller

import br.com.deroldo.passwordvalidator.controller.model.PasswordEvaluationFailureModel
import br.com.deroldo.passwordvalidator.controller.model.PasswordEvaluationReason
import br.com.deroldo.passwordvalidator.controller.model.PasswordEvaluationSuccessModel
import br.com.deroldo.passwordvalidator.service.PasswordEvaluateService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["evaluate"])
class PasswordEvaluateController(
        private val passwordEvaluateService: PasswordEvaluateService
) {

    @PostMapping(consumes = [MediaType.TEXT_PLAIN_VALUE], produces = [MediaType.TEXT_PLAIN_VALUE])
    fun evaluate(
            @RequestBody password: String,
            @RequestParam params: Map<String, String>
    ): ResponseEntity<String> {
        val passwordEvaluationModel = this.passwordEvaluateService
                .evaluate(password, params)
                .result(
                        success = { PasswordEvaluationSuccessModel.create(it) },
                        failure = { PasswordEvaluationFailureModel.create(it) }
                )

        return ResponseEntity
                .status(passwordEvaluationModel.reason.toHttpStatus())
                .body(passwordEvaluationModel.result.toString())
    }
}

private fun PasswordEvaluationReason.toHttpStatus() = when (this) {
    PasswordEvaluationReason.VALID -> HttpStatus.OK
    PasswordEvaluationReason.INVALID -> HttpStatus.BAD_REQUEST
}