package br.com.deroldo.passwordvalidator.domain.rule

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PasswordLowerCaseRuleTest {

    private val rule = PasswordLowerCaseRule()

    @Test
    fun `valid password for rule`() {
        val evaluation = rule.evaluate("A!@ ()371a2931{}", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_LOWER_CASE_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid single lower char password for rule`() {
        val evaluation = rule.evaluate("h", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_LOWER_CASE_RULE", evaluation.ruleName)
    }

    @Test
    fun `invalid password for rule`() {
        val evaluation = rule.evaluate("A!@ ()3712931{}", emptyMap())
        assertFalse(evaluation.result)
        assertEquals("PASSWORD_LOWER_CASE_RULE", evaluation.ruleName)
    }

}