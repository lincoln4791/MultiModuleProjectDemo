package com.example.mymultimoduleproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.features.login.ui.LoginMainActivity
import com.example.features.login.viewmodel.LoginViewModel
import com.example.mymultimoduleproject.ui.theme.MyMultiModuleProjectTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var loginViewModel: LoginViewModel;

    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data?.getStringExtra("login_result")
            Toast.makeText(this, "Got back: $data", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var result by remember { mutableStateOf("Click to login") }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        /*loginViewModel.doLogin { msg  ->
                            result = msg[(1..5).random()].title
                        }*/
                        val intent = Intent(this@MainActivity, LoginMainActivity::class.java)
                        //this@MainActivity.startActivity(intent)
                        launcher.launch(intent)
                    }) {
                        Text(result)
                    }
                }
            }
        }
    }
}