package com.example.letssopt.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.letssopt.common.util.isLoginValid
import com.example.letssopt.designsystem.component.WatchaButton
import com.example.letssopt.designsystem.component.WatchaFormField
import com.example.letssopt.designsystem.component.WatchaSemiTitle
import com.example.letssopt.designsystem.component.WatchaTextField
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.PrimaryRed
import com.example.letssopt.designsystem.theme.TextSecondary

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val sharedPreferences = getSharedPreferences("login_preferences", MODE_PRIVATE)

        if (sharedPreferences.getBoolean("auto_login", false)) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding),
                        savedEmail = intent.getStringExtra("email"),
                        savedPassword = intent.getStringExtra("password"),
                        toSignUp = {
                            val intent = Intent(this, SignUpActivity::class.java)
                            startActivity(intent)
                        },
                        toMain = {
                            sharedPreferences.edit()
                                .putBoolean("auto_login", true)
                                .apply()

                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    savedEmail: String?,
    savedPassword: String?,
    toSignUp: () -> Unit,
    toMain: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
            .padding(horizontal = 20.dp),
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

        WatchaSemiTitle(
            text = "이메일로 로그인",
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

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "아직 계정이 없으신가요? 회원가입",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight.Normal,
            color = TextSecondary,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(10.dp)
                .clickable { toSignUp() }
        )

        WatchaButton(
            text = "로그인",
            modifier = Modifier.padding(bottom = 50.dp),
            onClick = {
                val result = isLoginValid(email, password, savedEmail, savedPassword)

                Toast.makeText(context, result, Toast.LENGTH_SHORT).show()

                if (result == R.string.succeed_login) {
                    toMain()
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LETSSOPTTheme {
        LoginScreen(savedEmail = "email",
            savedPassword = "password",
            toSignUp = {},
            toMain = {}
        )
    }
}