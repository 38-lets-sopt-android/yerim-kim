package com.example.letssopt.presentation.signup

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onSignUpSuccess: (String, String) -> Unit,
    viewModel: SignUpViewModel = viewModel()
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .background(Background)
            .padding(horizontal = 20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
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
            text = "회원가입",
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
            value = viewModel.userId.value,
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
            value = viewModel.userPassword.value,
            onValueChange = viewModel::updatePassword,
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
            value = viewModel.userPasswordCheck.value,
            onValueChange = viewModel::updatePasswordCheck,
            placeholder = "비밀번호를 다시 입력하세요",
            isPassword = true
        )

        WatchaFormField(
            text = "이름",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        WatchaTextField(
            value = viewModel.userName.value,
            onValueChange = viewModel::updateName,
            placeholder = "이름을 입력하세요",
        )

        WatchaFormField(
            text = "이메일",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        WatchaTextField(
            value = viewModel.userEmail.value,
            onValueChange = viewModel::updateEmail,
            placeholder = "이메일 주소를 입력하세요",
        )

        WatchaFormField(
            text = "나이",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        WatchaTextField(
            value = viewModel.userAge.value,
            onValueChange = viewModel::updateAge,
            placeholder = "나이를 입력하세요"
        )

        WatchaFormField(
            text = "파트",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        WatchaTextField(
            value = viewModel.userPart.value,
            onValueChange = viewModel::updatePart,
            placeholder = "파트를 입력하세요."
        )

        Spacer(modifier = Modifier.weight(1f))

        WatchaButton(
            text = "회원가입",
            modifier = Modifier.padding(bottom = 50.dp),
            onClick = {
                val result = viewModel.signUp()

                Toast.makeText(context, result, Toast.LENGTH_SHORT).show()

                if (result == R.string.succeed_signup) {
                    onSignUpSuccess(
                        viewModel.userEmail.value,
                        viewModel.userPassword.value
                    )
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