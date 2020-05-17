package br.com.deroldo.passwordvalidator.domain.rule

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class PasswordLengthRule(
        @Value("\${app.password.length.default}") private val defaultLength: String,
        @Value("\${app.password.length.param-name}") private val paramName: String
) : PasswordRule {

    override fun evaluate(password: String, params: Map<String, String>): PasswordRuleEvaluation = when {
        password.length >= length(params) -> PasswordLengthEvaluation(true)
        else -> PasswordLengthEvaluation(false)
    }

    private fun length(params: Map<String, String>) = (params[this.paramName] ?: this.defaultLength).toInt()
}

private class PasswordLengthEvaluation(
        override val result: Boolean
) : PasswordRuleEvaluation {
    override val ruleName = "PASSWORD_LENGTH_RULE"
}