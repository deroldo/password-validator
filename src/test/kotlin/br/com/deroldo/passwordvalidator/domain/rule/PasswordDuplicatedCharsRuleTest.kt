package br.com.deroldo.passwordvalidator.domain.rule

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

const val DUPLICATED_PARAM_NAME = "duplicated"

internal class PasswordDuplicatedCharsRuleTest {

    private val rule = PasswordDuplicatedCharsRule("false", DUPLICATED_PARAM_NAME)

    @Test
    fun `valid unique chars`(){
        val evaluation = this.rule.evaluate("aAdf123", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_DUPLICATED_CHARS_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid single chars`(){
        val evaluation = this.rule.evaluate("a", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_DUPLICATED_CHARS_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid duplicated chars`(){
        val params = mapOf( DUPLICATED_PARAM_NAME to "true")
        val evaluation = this.rule.evaluate("aSdEa", params)
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_DUPLICATED_CHARS_RULE", evaluation.ruleName)
    }

    @Test
    fun `invalid duplicated chars`(){
        val evaluation = this.rule.evaluate("aSdEa", emptyMap())
        assertFalse(evaluation.result)
        assertEquals("PASSWORD_DUPLICATED_CHARS_RULE", evaluation.ruleName)
    }

    @Test
    fun `invalid duplicated chars when there is not a correct param`(){
        val params = mapOf( "xpto" to "true")
        val evaluation = this.rule.evaluate("aSdEa", params)
        assertFalse(evaluation.result)
        assertEquals("PASSWORD_DUPLICATED_CHARS_RULE", evaluation.ruleName)
    }

}