package mende273.clipboardmanagerkmp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mende273.clipboardmanagerkmp.clipboard.ClipboardManager
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
fun App() {
    KoinContext {
        MaterialTheme {

            val clipboardManager: ClipboardManager = koinInject<ClipboardManager>()

            val snackbarHostState = remember { SnackbarHostState() }
            val coroutineScope = rememberCoroutineScope()

            var text by remember { mutableStateOf("") }

            Scaffold(
                snackbarHost = { SnackbarHost(snackbarHostState) }
            ) { paddingValues ->

                ColumnWithTextFieldAndButton(
                    modifier = Modifier
                        .safeContentPadding()
                        .padding(paddingValues)
                        .fillMaxSize(),
                    text = text,
                    onUpdateText = { text = it },
                    onButtonClick = {
                        coroutineScope.launch {
                            clipboardManager.copyText(text)
                            snackbarHostState.showSnackbar("$text Copied to clipboard!")
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun ColumnWithTextFieldAndButton(
    modifier: Modifier = Modifier,
    text: String,
    onUpdateText: (String) -> Unit,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        BasicTextField(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(16.dp),
            value = text,
            onValueChange = onUpdateText
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            content = {
                Text(text = "Copy to clipboard")
            },
            onClick = onButtonClick
        )
    }
}