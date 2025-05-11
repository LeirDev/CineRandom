package com.example.cinemaapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemaapp.R
import com.example.cinemaapp.ui.theme.BackgroundColor


@Composable
fun RandomMovieScreen(genre: String) {
    val movies = mapOf(
        "Ação" to listOf(
            "Mad Max" to Pair("Em um mundo pós-apocalíptico, Max luta para sobreviver contra gangues violentas.", R.drawable.mad_max),
            "John Wick" to Pair("Um assassino aposentado busca vingança após a morte de seu cachorro.", R.drawable.john_wick),
            "Gladiador" to Pair("Um general romano é traído e busca vingança como gladiador.", R.drawable.gladiator),
            "Velozes e Furiosos" to Pair("Corridas de rua e ação explosiva em uma trama cheia de adrenalina.", R.drawable.velozes_furiosos),
            "O Protetor" to Pair("Um ex-agente da CIA ajuda pessoas em perigo enquanto enfrenta seu passado.", R.drawable.o_protetor),
            "Missão Impossível" to Pair("Ethan Hunt enfrenta missões perigosas para salvar o mundo.", R.drawable.missao_impossivel),
            "Os Mercenários" to Pair("Um grupo de mercenários enfrenta missões perigosas e explosivas.", R.drawable.os_mercenarios),
            "Duro de Matar" to Pair("Um policial enfrenta terroristas em um arranha-céu.", R.drawable.duro_de_matar),
            "Rambo" to Pair("Um veterano de guerra enfrenta desafios em missões perigosas.", R.drawable.rambo),
            "O Exterminador do Futuro" to Pair("Um ciborgue é enviado para proteger o futuro da humanidade.", R.drawable.o_exterminador_do_futuro),
            "Homem de Ferro" to Pair("Um bilionário cria uma armadura para combater o crime.", R.drawable.homem_de_ferro),
            "Capitão América" to Pair("Um soldado se torna um herói durante a Segunda Guerra Mundial.", R.drawable.capitao_america),
            "Thor" to Pair("O deus do trovão enfrenta desafios para proteger Asgard e a Terra.", R.drawable.thor),
            "Pantera Negra" to Pair("O rei de Wakanda luta para proteger seu povo.", R.drawable.pantera_negra),
            "Vingadores: Ultimato" to Pair("Heróis se unem para derrotar Thanos e salvar o universo.", R.drawable.vingadores_ultimato),
            "Matrix" to Pair("Um hacker descobre a verdade sobre a realidade e lidera uma rebelião contra as máquinas.", R.drawable.matrix),
            "Coração Valente" to Pair("William Wallace lidera uma revolta pela liberdade da Escócia.", R.drawable.coracao_valente),
            "300" to Pair("Um pequeno exército espartano enfrenta milhares de soldados persas.", R.drawable.trezentos),
            "Kill Bill" to Pair("Uma assassina busca vingança contra aqueles que a traíram.", R.drawable.kill_bill),
            "O Resgate do Soldado Ryan" to Pair("Soldados enfrentam perigos para resgatar um companheiro durante a Segunda Guerra Mundial.", R.drawable.o_resgate_do_soldado_ryan)
        ),
        "Terror" to listOf(
            "Invocação do Mal" to Pair("Baseado em eventos reais, um casal investiga uma casa assombrada.", R.drawable.invocacao_do_mal),
            "It: A Coisa" to Pair("Um grupo de crianças enfrenta um palhaço demoníaco que aterroriza sua cidade.", R.drawable.it),
            "Corra!" to Pair("Um jovem descobre segredos perturbadores ao visitar a família de sua namorada.", R.drawable.corra),
            "Hereditário" to Pair("Uma família enfrenta eventos sobrenaturais após a morte da avó.", R.drawable.hereditario),
            "O Exorcista" to Pair("Uma jovem é possuída por um demônio, e um padre tenta salvá-la.", R.drawable.o_exorcista),
            "Halloween" to Pair("Michael Myers retorna para aterrorizar uma cidade em uma noite de Halloween.", R.drawable.halloween)
        ),
        "Comédia" to listOf(
            "Superbad" to Pair("Dois amigos tentam organizar a festa perfeita antes de se separarem na faculdade.", R.drawable.superbad),
            "Se Beber, Não Case" to Pair("Um grupo de amigos enfrenta situações hilárias após uma despedida de solteiro.", R.drawable.se_beber_nao_case),
            "Deadpool" to Pair("Um anti-herói sarcástico busca vingança com muito humor e ação.", R.drawable.deadpool),
            "As Branquelas" to Pair("Dois agentes disfarçados se passam por socialites em uma comédia hilária.", R.drawable.as_branquelas),
            "Click" to Pair("Um homem descobre um controle remoto que pode controlar sua vida.", R.drawable.click),
            "Zumbilândia" to Pair("Um grupo de sobreviventes enfrenta zumbis com muito humor.", R.drawable.zumbilandia)
        ),
        "Romance" to listOf(
            "Titanic" to Pair("Um romance épico entre dois jovens de classes sociais diferentes no famoso navio.", R.drawable.titanic),
            "Diário de uma Paixão" to Pair("Um casal enfrenta desafios ao longo de décadas em uma história de amor inesquecível.", R.drawable.diario_de_uma_paixao),
            "La La Land" to Pair("Dois artistas apaixonados tentam equilibrar amor e carreira em Los Angeles.", R.drawable.la_la_land),
            "Orgulho e Preconceito" to Pair("Elizabeth Bennet enfrenta o amor e os preconceitos da sociedade inglesa.", R.drawable.orgulho_e_preconceito),
            "Como Eu Era Antes de Você" to Pair("Uma jovem cuida de um homem tetraplégico e muda sua vida para sempre.", R.drawable.como_eu_era_antes_de_voce),
            "Um Lugar Chamado Notting Hill" to Pair("Um livreiro e uma estrela de cinema vivem um romance improvável.", R.drawable.um_lugar_chamado_notting_hill)
        )
    )

    val randomMovie = remember {
        mutableStateOf(
            movies[genre]?.random()
                ?: ("Nenhum filme encontrado" to ("Sinopse não disponível" to R.drawable.placeholder))
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 100.dp, vertical = 50.dp,)
                .height(300.dp)
                .align(Alignment.TopCenter)
        ) {
            Image(
                painter = painterResource(id = randomMovie.value.second.second),
                contentDescription = "Poster do filme",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Image(
            painter = painterResource(R.drawable.cinema_chair),
            contentDescription = "cadeiras de cinema para design",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(577.dp)
                .height(400.dp)
                .align(Alignment.BottomEnd)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(R.drawable.cinema_poster),
                contentDescription = "Moldura em vermelhor com luzes amarelas",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(400.dp)
                    .width(300.dp)
                    .align(Alignment.CenterHorizontally)
                    .height(200.dp)
            )
            Text(
                text = randomMovie.value.first,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Box(
                modifier = Modifier
                    .padding(30.dp)
            ) {
                Text(
                    text = randomMovie.value.second.first,
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.padding(14.dp))

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 240.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = {
                    randomMovie.value = movies[genre]?.random()
                        ?: ("Nenhum filme encontrado" to ("Sinopse não disponível" to R.drawable.placeholder))
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA1D21)),
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
            ) {
                Text(text = "Escolher outro filme", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRandomMovieScreen() {
    RandomMovieScreen(genre = "Ação")
}