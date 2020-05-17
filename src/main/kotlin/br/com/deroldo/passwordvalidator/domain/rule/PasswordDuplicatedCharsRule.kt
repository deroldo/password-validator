package br.com.deroldo.passwordvalidator.domain.rule

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class PasswordDuplicatedCharsRule(
        @Value("\${app.password.duplicated.default}") private val defaultDuplicated: String,
        @Value("\${app.password.duplicated.param-name}") private val paramName: String
) : PasswordRule {

    override fun evaluate(password: String, params: Map<String, String>): PasswordRuleEvaluation {
        if (enabledDuplicated(params)) return PasswordDuplicatedCharEvaluation(true)

        return when (password.toSet().size) {
            password.length -> PasswordDuplicatedCharEvaluation(true)
            else -> PasswordDuplicatedCharEvaluation(false)
        }
    }

    private fun enabledDuplicated(params: Map<String, String>) = (params[this.paramName] ?: this.defaultDuplicated)
            .toBoolean()
}

private class PasswordDuplicatedCharEvaluation(
        override val result: Boolean
) : PasswordRuleEvaluation {
    override val ruleName = "PASSWORD_DUPLICATED_CHARS_RULE"
}