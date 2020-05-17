package br.com.deroldo.passwordvalidator.domain

import br.com.deroldo.passwordvalidator.domain.rule.PasswordRuleEvaluation

class PasswordEvaluation(
        ruleEvaluations: List<PasswordRuleEvaluation>
) {

    val result: Boolean
    private val constraintViolations: List<PasswordRuleEvaluation>

    init {
        constraintViolations = ruleEvaluations.filter { ruleEvaluation -> !ruleEvaluation.result }
        result = constraintViolations.isEmpty()
    }

    fun <T, X : T, Y : T> result(
            success: (PasswordEvaluation) -> X,
            failure: (PasswordEvaluation) -> Y
    ) = when (result) {
        true -> success(this)
        false -> failure(this)
    }

}