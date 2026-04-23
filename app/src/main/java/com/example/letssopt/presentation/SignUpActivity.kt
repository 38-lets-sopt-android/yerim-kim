package com.example.letssopt.presentation

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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.common.util.isSignUpValid
import com.example.letssopt.designsystem.component.WatchaButton
import com.example.letssopt.designsystem.component.WatchaFormField
import com.example.letssopt.designsystem.component.WatchaTextField
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.PrimaryRed
import com.example.letssopt.designsystem.theme.TextPrimary

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(
                        modifier = Modifier.padding(innerPadding),
                        onSignUpSuccess = { email, password ->
                            val intent = Intent(this, LoginActivity::class.java).apply {
                                putExtra("email", email)
                                putExtra("password", password)
                            }
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}
@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
     onSignUpSuccess: (String, String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordCheck by remember { mutableStateOf("") }
    val context = LocalContext.current

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

        WatchaFormField(
            text = "이메일",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        WatchaTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "이메일 주소를 입력하세요",
        )

        WatchaFormField(
            text = "비밀번호",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        WatchaTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "비밀번호를 입력하세요",
            isPassword = true
        )

        WatchaFormField(
            text = "비밀번호 확인",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        WatchaTextField(
            value = passwordCheck,
            onValueChange = { passwordCheck = it },
            placeholder = "비밀번호를 다시 입력하세요",
            isPassword = true
        )

        Spacer(modifier = Modifier.weight(1f))

        WatchaButton(
            text = "회원가입",
            modifier = Modifier.padding(bottom = 50.dp),
            onClick = {
                val result = isSignUpValid(email, password, passwordCheck)

                Toast.makeText(context, result, Toast.LENGTH_SHORT).show()

                if (result == R.string.succeed_signup) {
                    onSignUpSuccess(email, password)
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    LETSSOPTTheme {
        SignUpScreen(
            onSignUpSuccess = { _, _ -> }
        )
    }
}