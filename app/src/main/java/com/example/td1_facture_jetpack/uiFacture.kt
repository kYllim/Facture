import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Facture(navController: NavHostController) {
    val modifier = Modifier
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var quantiteValue by remember { mutableStateOf("") }
        var prixValue by remember { mutableStateOf("") }
        var montantValue by remember { mutableStateOf("") }
        var tvaValue by remember { mutableStateOf("") }
        val radioValue = remember { mutableStateOf("") }
        var remiseValue by remember { mutableStateOf("") }

        Text(
            text = "FACTURE",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )

        Row {
            Text(
                text = "Quantité",
                fontSize = 15.sp,
            )

            TextField(
                value = quantiteValue,
                onValueChange = { quantiteValue = it },
                modifier = modifier.padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Row {
            Text(
                text = "Prix unitaire",
                fontSize = 15.sp,
            )

            TextField(
                value = prixValue,
                onValueChange = { prixValue = it },
                modifier = modifier.padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Row {
            Text(
                text = "Montant HT",
                fontSize = 15.sp,
            )

            TextField(
                value = montantValue,
                onValueChange = { montantValue = it },
                modifier = modifier.padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Row {
            Text(
                text = "Taux TVA",
                fontSize = 15.sp,
            )

            TextField(
                value = tvaValue,
                onValueChange = { tvaValue = it },
                modifier = modifier.padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Row {
            Text(text = "Client Fidèle")
            Spacer(modifier = modifier.width(8.dp))
            RadioButton(
                selected = radioValue.value == "Client Fidèle",
                onClick = { radioValue.value = "Client Fidèle" },
            )

            Text(text = "Client Non Fidèle")
            Spacer(modifier = modifier.width(8.dp))
            RadioButton(
                selected = radioValue.value == "Client Non Fidèle",
                onClick = { radioValue.value = "Client Non Fidèle" },
            )
        }

        Row {
            Text(
                text = "Remise",
                fontSize = 15.sp,
            )

            TextField(
                value = remiseValue,
                onValueChange = { remiseValue = it },
                modifier = modifier.padding(5.dp),
                enabled = radioValue.value == "Client Fidèle",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Spacer(modifier = modifier.height(25.dp))

        Row {
            Button(
                onClick = {
                    if (quantiteValue.isNotBlank() && prixValue.isNotBlank() &&
                        montantValue.isNotBlank() && tvaValue.isNotBlank()
                    ) {
                        val prixHT = quantiteValue.toFloat() * prixValue.toFloat()
                        if(remiseValue.isNotBlank()){
                            val prixTTC = prixHT + prixHT * tvaValue.toFloat() / 100 - prixHT * remiseValue.toFloat() / 100
                            navController.navigate("montant/$prixHT/$prixTTC")
                        }else{
                            val prixTTC = prixHT + prixHT * tvaValue.toFloat() / 100
                            navController.navigate("montant/$prixHT/$prixTTC")

                        }
                    }
                },
                enabled = quantiteValue.isNotBlank() && prixValue.isNotBlank() &&
                        montantValue.isNotBlank() && tvaValue.isNotBlank()
            ) {
                Text(text = "Calculer TTC", fontSize = 17.sp)
            }

            Spacer(modifier = modifier.width(16.dp))

            Button(
                onClick = {
                    quantiteValue = ""
                    prixValue = ""
                    montantValue = ""
                    tvaValue = ""
                    remiseValue = ""
                    radioValue.value = ""
                },
                enabled = quantiteValue.isNotBlank() || prixValue.isNotBlank() ||
                        montantValue.isNotBlank() || tvaValue.isNotBlank() ||
                        remiseValue.isNotBlank() || radioValue.value.isNotBlank()
            ) {
                Text(text = "Remise à zéro", fontSize = 17.sp)
            }
        }
    }
}