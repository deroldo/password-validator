package br.com.deroldo.passwordvalidator.service

import br.com.deroldo.passwordvalidator.domain.PasswordEvaluation
import br.com.deroldo.passwordvalidator.domain.rule.PasswordRule
import org.springframework.stereotype.Service

@Service
class PasswordEvaluateService(
        val rules: List<PasswordRule>
) {

    fun evaluate(password: String, params: Map<String, String>): PasswordEvaluation {
        val evaluations = this.rules.map { rule -> rule.evaluate(password, params) }
        return PasswordEvaluation(evaluations)
    }
}