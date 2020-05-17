package br.com.deroldo.passwordvalidator.domain.rule

import org.springframework.stereotype.Component

@Component
class PasswordSpecialCharRule : PasswordRule {

    override fun evaluate(password: String, params: Map<String, String>): PasswordRuleEvaluation = when {
        REGEX.containsMatchIn(password) -> PasswordSpecialCharEvaluation(true)
        else -> PasswordSpecialCharEvaluation(false)
    }

    companion object {
        const val VALID_SPECIAL_CHARS = "!@#$%^&*?."
        val REGEX = Regex("[$VALID_SPECIAL_CHARS]")
    }
}

private class PasswordSpecialCharEvaluation(
        override val result: Boolean
) : PasswordRuleEvaluation {
    override val ruleName = "PASSWORD_SPECIAL_CHAR_RULE"
}