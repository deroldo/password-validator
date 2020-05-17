package br.com.deroldo.passwordvalidator.controller.model

import br.com.deroldo.passwordvalidator.domain.PasswordEvaluation

interface PasswordEvaluationModel {

    val result: Boolean
    val reason: PasswordEvaluationReason
}

enum class PasswordEvaluationReason {
    VALID,
    INVALID
}

data class PasswordEvaluationSuccessModel(
        override val result: Boolean
) : PasswordEvaluationModel {

    override val reason = PasswordEvaluationReason.VALID

    companion object {
        fun create(evaluation: PasswordEvaluation) = PasswordEvaluationSuccessModel(evaluation.result)
    }
}

data class PasswordEvaluationFailureModel(
        override val result: Boolean
) : PasswordEvaluationModel {


    override val reason = PasswordEvaluationReason.INVALID


    companion object {
        fun create(evaluation: PasswordEvaluation) = PasswordEvaluationFailureModel(evaluation.result)
    }
}
