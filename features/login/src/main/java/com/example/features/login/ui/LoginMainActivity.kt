package com.example.features.login.ui

import com.example.core.db.UserRepository
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.core.db.DatabaseProvider
import com.example.core.network.NetworkModule
import com.example.features.login.datasource.LoginDataSourceImpl
import com.example.features.login.repository.LoginRepositoryImpl
import com.example.features.login.viewmodel.LoginViewModel

class LoginMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = NetworkModule.provideAuthApi()
        val dataSource = LoginDataSourceImpl(api)
        val repo = LoginRepositoryImpl(dataSource)
        val userRepo = UserRepository(DatabaseProvider.getDatabase(this@LoginMainActivity));
        val viewmodel = LoginViewModel(repo,userRepo)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                LoginScreen(viewmodel, onLoginClick = { username, password ->
                }, onNavigateClick = {
                    val intent = Intent(this@LoginMainActivity, Class.forName("com.example.features.registration.RegistrationMainActivity"))
                    startActivity(intent)
                }, onNavigateBackWithResultClick = {
                    val resultIntent = Intent().apply {
                        putExtra("login_result", "LoggedInUser123")
                    }
                    setResult(RESULT_OK, resultIntent)
                    finish()
                })
            }
        }
    }
}

@Composable
fun LoginScreen(
    viewmodel: LoginViewModel,
    onLoginClick: (String, String) -> Unit,
    onNavigateClick: () -> Unit,
    onNavigateBackWithResultClick: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("Login") } // <-- keep this


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = result,
                style = MaterialTheme.typography.headlineMedium
            )

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    viewmodel.doLogin("emilys","emilyspass") { res ->
                        result = res.username?:""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }

            Button(
                onClick = {
                    onNavigateClick();
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Navigate to Registration")
            }

            Button(
                onClick = {
                    onNavigateBackWithResultClick();
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Navigate Back With Result")
            }

            Button(
                onClick = {
                    viewmodel.insertTestDataInRoom()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("insert User")
            }
        }
    }
}
