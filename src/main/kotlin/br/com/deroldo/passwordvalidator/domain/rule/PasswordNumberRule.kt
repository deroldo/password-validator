package br.com.deroldo.passwordvalidator.domain.rule

import org.springframework.stereotype.Component

@Component
class PasswordNumberRule : PasswordRule {

    override fun evaluate(password: String, params: Map<String, String>): PasswordRuleEvaluation = when {
        REGEX.containsMatchIn(password) -> PasswordNumberEvaluation(true)
        else -> PasswordNumberEvaluation(false)
    }

    companion object {
        val REGEX = Regex("\\d")
    }
}

private class PasswordNumberEvaluation(
        override val result: Boolean
) : PasswordRuleEvaluation {
    override val ruleName = "PASSWORD_NUMBER_RULE"
}