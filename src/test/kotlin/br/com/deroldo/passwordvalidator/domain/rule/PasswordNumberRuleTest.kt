package br.com.deroldo.passwordvalidator.domain.rule

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PasswordNumberRuleTest {

    private val rule = PasswordNumberRule()

    @Test
    fun `valid password for rule`(){
        val evaluation = this.rule.evaluate("abcDEF1 !@#()", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_NUMBER_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid single number assword for rule`(){
        val evaluation = this.rule.evaluate("1", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_NUMBER_RULE", evaluation.ruleName)
    }

    @Test
    fun `invalid password for rule`(){
        val evaluation = this.rule.evaluate("abcDEF !@#()", emptyMap())
        assertFalse(evaluation.result)
        assertEquals("PASSWORD_NUMBER_RULE", evaluation.ruleName)
    }

}