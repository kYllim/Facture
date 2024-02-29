import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Montant(navController: NavHostController, ht: Float?, ttc: Float?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = "Montant",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Row {
            Text(text = "HT : ${ht ?: ""}")

            TextField(
                value = ht?.toString() ?: "",
                onValueChange = { },
                readOnly = true,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Row {
            Text(text = "TTC : ${ttc ?: ""}")

            TextField(
                value = ht?.toString() ?: "",
                onValueChange = { },
                readOnly = true,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(65.dp))

        Button(onClick = {
            navController.navigate("Facture")
        }) {
            Text(text = "Retour")
        }
    }
}
