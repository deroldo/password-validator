package br.com.deroldo.passwordvalidator.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class PasswordEvaluateControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should return true when receive a valid password`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("AbTp9!fok")

        this.mockMvc.perform(request)
                .andExpect { status().isOk }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("true") }
    }

    @Test
    fun `should return true when receive a valid password with custom length`() {
        val request = post("/evaluate&PASSWORD_LENGTH_RULE=5")
                .contentType(MediaType.TEXT_PLAIN)
                .content("AbT3!")

        this.mockMvc.perform(request)
                .andExpect { status().isOk }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("true") }
    }

    @Test
    fun `should return true when receive a valid long password`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("AbTp9!fok7aj.dba%\$kda730nc^n")

        this.mockMvc.perform(request)
                .andExpect { status().isOk }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("true") }
    }

    @Test
    fun `should return error when content-type is invalid`() {
        val request = post("/evaluate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("AbTp9!fok")

        this.mockMvc.perform(request)
                .andExpect { status().isUnsupportedMediaType }
    }


    @Test
    fun `should return false when there is a duplicated char`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("AbTp9!foo")

        this.mockMvc.perform(request)
                .andExpect { status().isBadRequest }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("false") }
    }
    @Test
    fun `should return false when receive an empty password`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("")

        this.mockMvc.perform(request)
                .andExpect { status().isBadRequest }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("false") }
    }

    @Test
    fun `should return false when receive a null password`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)

        this.mockMvc.perform(request)
                .andExpect { status().isBadRequest }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("false") }
    }

    @Test
    fun `should return false when receive a password with invalid length`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("A!1ab")

        this.mockMvc.perform(request)
                .andExpect { status().isBadRequest }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("false") }
    }

    @Test
    fun `should return false when receive a password without upper case`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("a!1bcd")

        this.mockMvc.perform(request)
                .andExpect { status().isBadRequest }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("false") }
    }

    @Test
    fun `should return false when receive a password without lower case`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("A!1BCD")

        this.mockMvc.perform(request)
                .andExpect { status().isBadRequest }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("false") }
    }

    @Test
    fun `should return false when receive a password without number`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("A!bcde")

        this.mockMvc.perform(request)
                .andExpect { status().isBadRequest }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("false") }
    }

    @Test
    fun `should return false when receive a password without valid special character`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("A9bcde")

        this.mockMvc.perform(request)
                .andExpect { status().isBadRequest }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("false") }
    }

    @Test
    fun `should return false when receive a password with invalid special character`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("A!9bc(")

        this.mockMvc.perform(request)
                .andExpect { status().isBadRequest }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("false") }
    }

    @Test
    fun `should return false when receive a password with black space`() {
        val request = post("/evaluate")
                .contentType(MediaType.TEXT_PLAIN)
                .content("A!9b c")

        this.mockMvc.perform(request)
                .andExpect { status().isBadRequest }
                .andExpect { content().contentType(MediaType.TEXT_PLAIN) }
                .andExpect { content().string("false") }
    }

}