package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.Background
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.PrimaryRed
import com.example.letssopt.ui.theme.Surface
import com.example.letssopt.ui.theme.TextPrimary
import com.example.letssopt.ui.theme.TextSecondary
import java.util.regex.Pattern

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * @param email 회원가입 시 입력하는 이메일
 * @return email이 옳은 형식인지에 대한 참거짓 반환 */
fun isEmailValid(email: String): Boolean {
    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)

    return pattern.matcher(email).matches()
}

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    var pwCheck by remember { mutableStateOf("") }
    var context = LocalContext.current
    val intent = Intent(context, LoginActivity::class.java).apply {}

    Column(
        modifier = modifier
            .background(Background)
            .padding(horizontal = 20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "watcha",
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            color = PrimaryRed,
            modifier = Modifier
                .padding(top = 60.dp)
        )

        Text(
            text = "회원가입",
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = TextPrimary,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 60.dp)
        )

        Text(
            text = "이메일",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = TextSecondary,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("이메일 주소를 입력하세요") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Surface,
                disabledContainerColor = Surface,
                unfocusedContainerColor = Surface,
                focusedTextColor = TextPrimary,
                disabledTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary
            ),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        Text(
            text = "비밀번호",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = TextSecondary,
            modifier = Modifier
                .align(Alignment.Start)
        )

        TextField(
            value = pw,
            onValueChange = { pw = it },
            placeholder = { Text("비밀번호를 입력하세요") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Surface,
                disabledContainerColor = Surface,
                unfocusedContainerColor = Surface,
                focusedTextColor = TextPrimary,
                disabledTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary
            ),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        Text(
            text = "비밀번호 확인",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = TextSecondary,
            modifier = Modifier
                .align(Alignment.Start)
        )

        TextField(
            value = pwCheck,
            onValueChange = { pwCheck = it },
            placeholder = { Text("비밀번호를 다시 입력하세요") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Surface,
                disabledContainerColor = Surface,
                unfocusedContainerColor = Surface,
                focusedTextColor = TextPrimary,
                disabledTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary
            ),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                if (email.isEmpty() || pw.isEmpty() || pwCheck.isEmpty()) {
                    Toast.makeText(context, "전부 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else if (!isEmailValid(email)) {
                    Toast.makeText(context, "이메일 형식을 지켜주세요.", Toast.LENGTH_SHORT).show()
                } else if (pw.length < 8) {
                    Toast.makeText(context, "비밀번호는 8자 이상으로 설정해주세요.", Toast.LENGTH_SHORT).show()
                } else if (pw.length > 12) {
                    Toast.makeText(context, "비밀번호는 12자 이하로 설정해주세요.", Toast.LENGTH_SHORT).show()
                } else if (pwCheck != pw) {
                    Toast.makeText(context, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                    intent.putExtra("email", email)
                    intent.putExtra("pw", pw)
                    context.startActivity(intent)
                }
            },
            colors = ButtonDefaults.buttonColors(PrimaryRed),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text(
                text = "로그인",
                color = TextPrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    LETSSOPTTheme {
        SignUpScreen()
    }
}