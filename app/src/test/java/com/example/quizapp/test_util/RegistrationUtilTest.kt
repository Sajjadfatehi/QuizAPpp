package com.example.quizapp.test_util

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class RegistrationUtilTest {

    @Test
    fun `user name is empty return false`() {
        val result = RegistrationUtil.validRegister(
            "", "123", "123"
        )
        assertThat(result).isFalse()
    }


    @Test
    fun `password is empty return false`() {
        val result = RegistrationUtil.validRegister(
            "mamad", "", "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password is repeated incorrectly return false`() {
        val result = RegistrationUtil.validRegister(
            "ehsan", "123", "153"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `pass length is less than two digit`() {
        val result = RegistrationUtil.validRegister(
            "", "123", "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `user name  is already exist`() {
        val result = RegistrationUtil.validRegister(
            "", "123", "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `user name is valid and repeated password return true`() {
        val result = RegistrationUtil.validRegister(
            "", "123", "123"
        )
        assertThat(result).isFalse()
    }




}