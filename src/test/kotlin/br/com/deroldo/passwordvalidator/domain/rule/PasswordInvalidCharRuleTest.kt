package br.com.deroldo.passwordvalidator.domain.rule

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PasswordInvalidCharRuleTest {

    private val rule = PasswordInvalidCharRule()

    @Test
    fun `valid characters`() {
        val evaluation = rule.evaluate("A!@$%^&*asd6382", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_INVALID_CHARACTER_RULE", evaluation.ruleName)
    }

    @Test
    fun `invalid characters`(){
        val evaluation = rule.evaluate("A!@a sd6382", emptyMap())
        assertFalse(evaluation.result)
        assertEquals("PASSWORD_INVALID_CHARACTER_RULE", evaluation.ruleName)
    }

}