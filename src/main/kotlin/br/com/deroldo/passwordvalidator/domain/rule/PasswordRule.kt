package br.com.deroldo.passwordvalidator.domain.rule

interface PasswordRule {

    fun evaluate(password: String, params: Map<String, String>): PasswordRuleEvaluation
}

interface PasswordRuleEvaluation {

    val result: Boolean
    val ruleName: String
}