package br.com.deroldo.passwordvalidator.domain.rule

import org.springframework.stereotype.Component

@Component
class PasswordLowerCaseRule : PasswordRule {

    override fun evaluate(password: String, params: Map<String, String>): PasswordRuleEvaluation = when {
        REGEX.containsMatchIn(password) -> PasswordLowerCaseEvaluation(true)
        else -> PasswordLowerCaseEvaluation(false)
    }

    companion object {
        val REGEX = Regex("[a-z]")
    }
}

private class PasswordLowerCaseEvaluation(
        override val result: Boolean
) : PasswordRuleEvaluation {
    override val ruleName = "PASSWORD_LOWER_CASE_RULE"
}