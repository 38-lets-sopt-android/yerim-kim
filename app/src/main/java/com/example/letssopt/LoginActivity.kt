package com.example.letssopt

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.BackgroundBlack
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.PrimaryRed
import com.example.letssopt.ui.theme.SurfaceGrey
import com.example.letssopt.ui.theme.TextPrimary
import com.example.letssopt.ui.theme.TextSecondaryGrey

class loginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    var context = LocalContext.current
    val intent = Intent(context, SignupActivity::class.java).apply {}

    Column(
        modifier = modifier
            .background(BackgroundBlack)
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
            color = TextSecondaryGrey,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )
        TextField(
            value = id,
            onValueChange = { id = it },
            placeholder = { Text("이메일 주소를 입력하세요") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = SurfaceGrey,
                disabledContainerColor = SurfaceGrey,
                errorContainerColor = SurfaceGrey,
                unfocusedContainerColor = SurfaceGrey),
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
            color = TextSecondaryGrey,
            modifier = Modifier
                .align(Alignment.Start)
        )
        TextField(
            value = pw,
            onValueChange = { pw = it },
            placeholder = { Text("비밀번호를 입력하세요") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = SurfaceGrey,
                disabledContainerColor = SurfaceGrey,
                errorContainerColor = SurfaceGrey,
                unfocusedContainerColor = SurfaceGrey),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "아직 계정이 없으신가요? 회원가입",
//            textDecoration = TextDecoration.Underline,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight.Normal,
            color = TextSecondaryGrey,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(10.dp)
                .clickable {
                    context.startActivity(intent)
                }
        )
        Button(
            onClick = {
//                if ( id.length >= 6 ) {
//                    Toast.makeText(context, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
//                }
//                else Toast.makeText(context, "로그인 실패! 6글자 이상 입력하세요.", Toast.LENGTH_SHORT).show()
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
fun GreetingPreview2() {
    LETSSOPTTheme {
        Greeting2("Android")
    }
}