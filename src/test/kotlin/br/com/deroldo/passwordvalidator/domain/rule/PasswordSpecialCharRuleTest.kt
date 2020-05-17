package br.com.deroldo.passwordvalidator.domain.rule

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PasswordSpecialCharRuleTest {

    private val rule = PasswordSpecialCharRule()

    @Test
    fun `valid password for rule`(){
        val evaluation = this.rule.evaluate("abcDEF123! ()", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid ! password for rule`(){
        val evaluation = this.rule.evaluate("!", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid @ password for rule`(){
        val evaluation = this.rule.evaluate("@", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid # password for rule`(){
        val evaluation = this.rule.evaluate("#", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid $ password for rule`(){
        val evaluation = this.rule.evaluate("$", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid % password for rule`(){
        val evaluation = this.rule.evaluate("%", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid ^ password for rule`(){
        val evaluation = this.rule.evaluate("^", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid & password for rule`(){
        val evaluation = this.rule.evaluate("&", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid * password for rule`(){
        val evaluation = this.rule.evaluate("*", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid ? password for rule`(){
        val evaluation = this.rule.evaluate("?", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `valid dot password for rule`(){
        val evaluation = this.rule.evaluate(".", emptyMap())
        assertTrue(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

    @Test
    fun `invalid password for rule`(){
        val evaluation = this.rule.evaluate("abcDEF123 ()", emptyMap())
        assertFalse(evaluation.result)
        assertEquals("PASSWORD_SPECIAL_CHAR_RULE", evaluation.ruleName)
    }

}