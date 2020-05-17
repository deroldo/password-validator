package br.com.deroldo.passwordvalidator.domain.rule

import org.springframework.stereotype.Component

@Component
class PasswordInvalidCharRule : PasswordRule {

    override fun evaluate(password: String, params: Map<String, String>): PasswordRuleEvaluation = when {
        !REGEX.containsMatchIn(password) -> PasswordInvalidCharEvaluation(true)
        else -> PasswordInvalidCharEvaluation(false)
    }

    companion object {
        private const val VALID_CHARS = "a-zA-Z\\d${PasswordSpecialCharRule.VALID_SPECIAL_CHARS}"
        val REGEX = Regex("[^$VALID_CHARS]")
    }
}

private class PasswordInvalidCharEvaluation(
        override val result: Boolean
) : PasswordRuleEvaluation {
    override val ruleName = "PASSWORD_INVALID_CHARACTER_RULE"
}