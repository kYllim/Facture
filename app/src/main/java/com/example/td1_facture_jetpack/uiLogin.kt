import androidx.compose.ui.text.input.PasswordVisualTransformation
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Login(navController: NavHostController){
    val modifier = Modifier
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        var loginValue by remember {
            mutableStateOf("")
        }
        var mdpValue by remember {
            mutableStateOf("")
        }

        val context = LocalContext.current



        Text(
            text = "Authentification",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black

        )
        Text(
            text = "Votre login",
            fontSize = 15.sp,

        )
        TextField(
            value = loginValue,
            onValueChange = { loginValue = it },
            modifier = Modifier.padding(5.dp),
            placeholder = {
                Text(
                    text = "Login ...",
                    fontSize = 15.sp,
                )
            }
        )


        Text(
            text = "Votre mdp",
            fontSize = 15.sp,

            )

        TextField(
            value = mdpValue,
            onValueChange = { mdpValue = it},
            visualTransformation = PasswordVisualTransformation(), //masque le mdp
            modifier = Modifier.padding(5.dp),
            placeholder = {
                Text(
                    text = "MDP ...",
                    fontSize = 15.sp,

                    )
            }
        )

        Spacer(
                    modifier
                        .height(25.dp)
        )

        Button(onClick = {

            //if (loginValue == "etudiant" && mdpValue == "AzertY") {
                Toast.makeText(context, "Connexion réussie", Toast.LENGTH_SHORT).show()
                navController.navigate("profil/$loginValue/$mdpValue")
            //} else {
               // Toast.makeText(context, "Identifiants incorrects", Toast.LENGTH_SHORT).show()
            //}
        }) {
            Text(text = "Valider", fontSize = 17.sp)
        }
        
    }
}