package com.example.letssopt.presentation.signup

import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.R
import com.example.letssopt.common.util.isSignUpValid
import com.example.letssopt.designsystem.component.Button.WatchaButton
import com.example.letssopt.designsystem.component.Text.WatchaFormField
import com.example.letssopt.designsystem.component.Text.WatchaSemiTitle
import com.example.letssopt.designsystem.component.Text.WatchaTextField
import com.example.letssopt.designsystem.theme.Background
import com.example.letssopt.designsystem.theme.PrimaryRed
import com.example.letssopt.presentation.signup.SignUpViewModel

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

        WatchaSemiTitle(
            text = "회원가입",
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
            value = viewModel.email.value,
            onValueChange = viewModel::updateEmail,
            placeholder = "이메일 주소를 입력하세요",
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

        WatchaFormField(
            text = "비밀번호 확인",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 30.dp)
        )

        WatchaTextField(
            value = viewModel.passwordCheck.value,
            onValueChange = viewModel::updatePasswordCheck,
            placeholder = "비밀번호를 다시 입력하세요",
            isPassword = true
        )

        Spacer(modifier = Modifier.weight(1f))

        WatchaButton(
            text = "회원가입",
            modifier = Modifier.padding(bottom = 50.dp),
            onClick = {
                val result = isSignUpValid(
                    viewModel.email.value,
                    viewModel.password.value,
                    viewModel.passwordCheck.value
                )

                Toast.makeText(context, result, Toast.LENGTH_SHORT).show()

                if (result == R.string.succeed_signup) {
                    onSignUpSuccess(
                        viewModel.email.value,
                        viewModel.password.value
                    )
                }
            }
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun SignUpScreenPreview() {
//    LETSSOPTTheme {
//        SignUpScreen(
//            email = "test@email.com",
//            password = "12345678",
//            passwordCheck = "12345678",
//            onEmailChange = {},
//            onPasswordChange = {},
//            onPasswordCheckChange = {},
//            onSignUpSuccess = { _, _ -> }
//        )
//    }
//}