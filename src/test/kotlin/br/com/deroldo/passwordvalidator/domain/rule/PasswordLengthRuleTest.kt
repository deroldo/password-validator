package br.com.deroldo.passwordvalidator.domain.rule

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

const val LEGNTH_PARAM_NAME = "length"

internal class PasswordLengthRuleTest {

    private val rule = PasswordLengthRule("9", LEGNTH_PARAM_NAME)

    @Test
    fun `valid password length`() {
        val evaluation = this.rule.evaluate("123456789", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_LENGTH_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid password custom length`() {
        val params = mapOf( LEGNTH_PARAM_NAME to "3" )
        val evaluation = this.rule.evaluate("123", params)
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_LENGTH_RULE", evaluation.ruleName)
    }

    @Test
    fun `invalid password when there is not a correct param`() {
        val params = mapOf( "xpto" to "3" )
        val evaluation = this.rule.evaluate("123", params)
        assertFalse(evaluation.result)
        assertEquals("PASSWORD_LENGTH_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid long password length`() {
        val evaluation = this.rule.evaluate("1234567890123456789012345678901234567890", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_LENGTH_RULE", evaluation.ruleName)
    }

    @Test
    fun `invalid password length`() {
        val evaluation = this.rule.evaluate("12345", emptyMap())
        assertFalse(evaluation.result)
        assertEquals("PASSWORD_LENGTH_RULE", evaluation.ruleName)
    }

    @Test
    fun `invalid empty password`() {
        val evaluation = this.rule.evaluate("", emptyMap())
        assertFalse(evaluation.result)
        assertEquals("PASSWORD_LENGTH_RULE", evaluation.ruleName)
    }

}