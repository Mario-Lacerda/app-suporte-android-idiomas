package br.com.enricovivan.appcomsuporteavariosidiomas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.enricovivan.appcomsuporteavariosidiomas.ui.theme.AppComSuporteAVariosIdiomasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppComSuporteAVariosIdiomasTheme {

                // O desafio se consiste em criar um app internacionalizado
                // onde o app se adequa à localização do dispositivo

                // Primeiro, é criada uma superfície que preenche toda a tela do dispositivo
                TelaCheiaCentralizado {
                    Text(text = stringResource(id = R.string.text_firstScreen), color = MaterialTheme.colorScheme.primary)
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(id = R.string.button_text))
                    }
                }

            }
        }
    }
}

@Composable
fun TelaCheiaCentralizado (
    content: @Composable () -> Unit
): Unit {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun TelaCheiaCentralizadoPreview () {
    AppComSuporteAVariosIdiomasTheme {
        TelaCheiaCentralizado (content = {
            Text(text = "allalala", color = MaterialTheme.colorScheme.primary)
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Me Aperte")
            }
        })
    }
}