package com.example.letssopt

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

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding),
                        savedEmail = intent.getStringExtra("email"),
                        savedPw = intent.getStringExtra("pw")
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier, savedEmail: String?, savedPw: String?) {
    var email by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    var context = LocalContext.current
    val toSignUp = Intent(context, SignUpActivity::class.java).apply {}
    val toMain = Intent(context, MainActivity::class.java).apply {}

    Column(
        modifier = modifier
            .background(Background)
            .padding(horizontal = 20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text (
            text = "watcha",
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            color = PrimaryRed,
            modifier = Modifier
                .padding(top = 60.dp)
        )

        Text (
            text = "이메일로 로그인",
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = TextPrimary,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 60.dp)
        )

        Text (
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

        Text (
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
            visualTransformation = PasswordVisualTransformation(), // 비밀번호 안 보이게
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
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
                .clickable {
                    context.startActivity(toSignUp)
                }
        )

        Button(
            onClick = {
                if ( savedEmail == null || savedPw == null ) {
                    Toast.makeText(context, "회원가입을 해주세요.", Toast.LENGTH_SHORT).show()
                } else if ( email == savedEmail && pw == savedPw ) {
                    Toast.makeText(context, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show()
                    context.startActivity(toMain)
                } else {
                    Toast.makeText(context, "로그인 실패. 확인 후 다시 시도하세요.", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(PrimaryRed),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxWidth()
                .height(52.dp)
        ){
            Text(text = "로그인",
                color = TextPrimary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    LETSSOPTTheme {
        LoginScreen(savedEmail = "email", savedPw = "pw")
    }
}