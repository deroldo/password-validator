package br.com.deroldo.passwordvalidator.domain.rule

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PasswordUpperCaseRuleTest {

    private val rule = PasswordUpperCaseRule()

    @Test
    fun `valid password for rule`(){
        val evaluation = this.rule.evaluate("abcD123! (){}", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_UPPER_CASE_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid single upper case char password for rule`(){
        val evaluation = this.rule.evaluate("H", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_UPPER_CASE_RULE", evaluation.ruleName)
    }

    @Test
    fun `invalid password for rule`(){
        val evaluation = this.rule.evaluate("abc123! (){}", emptyMap())
        assertFalse(evaluation.result)
        assertEquals("PASSWORD_UPPER_CASE_RULE", evaluation.ruleName)
    }

}