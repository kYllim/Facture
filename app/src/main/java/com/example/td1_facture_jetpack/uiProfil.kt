import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Profil(navController: NavHostController, login: String?, mdp: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Bienvenue sur votre application",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Black

        )
        Spacer(
            modifier = Modifier.height(35.dp)
        )
        Text(
            text = "login : $login",
            )

        Text(
            text = "mdp : $mdp",
        )

        Spacer(
            modifier = Modifier.height(65.dp)
        )

        Button(onClick = {
            navController.navigate("Login")
        }) {
            Text(
                text="Page Login",
            )
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Button(onClick = {
            navController.navigate("Facture")
        }) {
            Text(
                text="Page Facture"
            )
        }
    }
}