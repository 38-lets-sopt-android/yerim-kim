package com.example.letssopt.common.util

import java.util.regex.Pattern

/**
 * @param email 회원가입 시 입력하는 이메일
 * @return email이 옳은 형식인지에 대한 참거짓 반환 */
fun isEmailValid(email: String): Boolean {
    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)

    return pattern.matcher(email).matches()
}