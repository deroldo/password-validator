package br.com.deroldo.passwordvalidator.domain.rule

import org.springframework.stereotype.Component

@Component
class PasswordUpperCaseRule : PasswordRule {

    override fun evaluate(password: String, params: Map<String, String>): PasswordRuleEvaluation = when {
        REGEX.containsMatchIn(password) -> PasswordUpperCaseEvaluation(true)
        else -> PasswordUpperCaseEvaluation(false)
    }

    companion object {
        val REGEX = Regex("[A-Z]")
    }
}

private class PasswordUpperCaseEvaluation(
        override val result: Boolean
) : PasswordRuleEvaluation {
    override val ruleName = "PASSWORD_UPPER_CASE_RULE"
}