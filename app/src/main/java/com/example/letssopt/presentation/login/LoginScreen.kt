package com.example.letssopt.presentation.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.R
import com.example.letssopt.designsystem.component.Button.WatchaButton
import com.example.letssopt.designsystem.component.Text.WatchaFormField
import com.example.letssopt.designsystem.component.Text.WatchaSemiTitle
import com.example.letssopt.designsystem.component.Text.WatchaTextField
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.PrimaryRed
import com.example.letssopt.designsystem.theme.TextSecondary


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    savedEmail: String?,
    savedPassword: String?,
    toSignUp: () -> Unit,
    toMain: () -> Unit,
    viewModel: LoginViewModel = viewModel()
) {
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
            text = "아이디",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        WatchaTextField(
            value = viewModel.id.value,
            onValueChange = viewModel::updateId,
            placeholder = "아이디를 입력하세요",
        )

        WatchaFormField(
            text = "비밀번호",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        WatchaTextField(
            value = viewModel.password.value,
            onValueChange = viewModel::updatePassword,
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
                val result = viewModel.login(
                    savedEmail,
                    savedPassword
                )

                Toast.makeText(context, result, Toast.LENGTH_SHORT).show()

                if (result == R.string.succeed_login) {
                    toMain()
                }
            }
        )

        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LETSSOPTTheme {
        LoginScreen(
            savedEmail = "email",
            savedPassword = "password",
            toSignUp = {},
            toMain = {}
        )
    }
}