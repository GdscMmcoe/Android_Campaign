package com.example.listview


import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.listview.ui.theme.ListViewTheme


data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String
)

val movies: List<Movie> = createMovieList()


fun createMovieList(): List<Movie> {
    return listOf(
        Movie(
            id = 695721,
            title = "The Hunger Games: The Ballad of Songbirds & Snakes",
            overview = "64 years before he becomes the tyrannical president of Panem, Coriolanus Snow sees a chance for a change in fortunes when he mentors Lucy Gray Baird, the female tribute from District 12.",
            posterPath = "/mBaXZ95R2OxueZhvQbcEWy2DqyO.jpg"
        ),
        Movie(
            id = 572802,
            title = "Aquaman and the Lost Kingdom",
            overview = "Black Manta, still driven by the need to avenge his father's death and wielding the power of the mythic Black Trident, will stop at nothing to take Aquaman down once and for all. To defeat him, Aquaman must turn to his imprisoned brother Orm, the former King of Atlantis, to forge an unlikely alliance in order to save the world from irreversible destruction.",
            posterPath = "/8xV47NDrjdZDpkVcCFqkdHa3T0C.jpg"
        ),
        Movie(
            id = 1029575,
            title = "The Family Plan",
            overview = "Dan Morgan is many things: a devoted husband, a loving father, a celebrated car salesman. He's also a former assassin. And when his past catches up to his present, he's forced to take his unsuspecting family on a road trip unlike any other.",
            posterPath = "/jLLtx3nTRSLGPAKl4RoIv1FbEBr.jpg"
        ),
        Movie(
            id = 787699,
            title = "Wonka",
            overview = "Willy Wonka – chock-full of ideas and determined to change the world one delectable bite at a time – is proof that the best things in life begin with a dream, and if you’re lucky enough to meet Willy Wonka, anything is possible.",
            posterPath = "/qhb1qOilapbapxWQn9jtRCMwXJF.jpg"
        ),
        Movie(
            id = 520758,
            title = "Chicken Run: Dawn of the Nugget",
            overview = "A band of fearless chickens flock together to save poultry-kind from an unsettling new threat: a nearby farm that's cooking up something suspicious.",
            posterPath = "/exNtEY8QUuQh9e23wSQjkPxKIU3.jpg"
        ),
        Movie(
            id = 1118595,
            title = "The Jester",
            overview = "A malevolent being known as The Jester terrorizes the inhabitants of a small town on Halloween night, including two estranged sisters who must come together to find a way to defeat this evil entity.",
            posterPath = "/jsOaCojcuxktg8w1UQkoFfn1y1g.jpg"
        ),
        Movie(
            id = 891699,
            title = "Silent Night",
            overview = "A tormented father witnesses his young son die when caught in a gang's crossfire on Christmas Eve. While recovering from a wound that costs him his voice, he makes vengeance his life's mission and embarks on a punishing training regimen in order to avenge his son's death.",
            posterPath = "/tlcuhdNMKNGEVpGqBZrAaOOf1A6.jpg"
        ),
        Movie(
            id = 872585,
            title = "Oppenheimer",
            overview = "The story of J. Robert Oppenheimer's role in the development of the atomic bomb during World War II.",
            posterPath = "/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg"
        ),
        Movie(
            id = 901362,
            title = "Trolls Band Together",
            overview = "When Branch's brother, Floyd, is kidnapped for his musical talents by a pair of nefarious pop-star villains, Branch and Poppy embark on a harrowing and emotional journey to reunite the other brothers and rescue Floyd from a fate even worse than pop-culture obscurity.",
            posterPath = "/bkpPTZUdq31UGDovmszsg2CchiI.jpg"
        ),
        Movie(
            id = 897087,
            title = "Freelance",
            overview = "An ex-special forces operative takes a job to provide security for a journalist as she interviews a dictator, but a military coup breaks out in the middle of the interview, they are forced to escape into the jungle where they must survive.",
            posterPath = "/7Bd4EUOqQDKZXA6Od5gkfzRNb0.jpg"
        ),
        Movie(
            id = 466420,
            title = "Killers of the Flower Moon",
            overview = "When oil is discovered in 1920s Oklahoma under Osage Nation land, the Osage people are murdered one by one—until the FBI steps in to unravel the mystery.",
            posterPath = "/dB6Krk806zeqd0YNp2ngQ9zXteH.jpg"
        ),
        Movie(
            id = 726209,
            title = "Leave the World Behind",
            overview = "A family's getaway to a luxurious rental home takes an ominous turn when a cyberattack knocks out their devices—and two strangers appear at their door.",
            posterPath = "/29rhl1xopxA7JlGVVsf1UHfYPvN.jpg"
        ),
        Movie(
            id = 920081,
            title = "Megaboa",
            overview = "On a trip to Colombia, a group of college students encounter a fifty-foot boa constrictor, hungry for blood.",
            posterPath = "/sAnAMv3eyQiGI1z2k8NsvH0Y6r5.jpg"
        ),
        Movie(
            id = 1075794,
            title = "Leo",
            overview = "Jaded 74-year-old lizard Leo has been stuck in the same Florida classroom for decades with his terrarium-mate turtle. When he learns he only has one year left to live, he plans to escape to experience life on the outside but instead gets caught up in the problems of his anxious students — including an impossibly mean substitute teacher.",
            posterPath = "/pD6sL4vntUOXHmuvJPPZAgvyfd9.jpg"
        ),
        Movie(
            id = 507089,
            title = "Five Nights at Freddy's",
            overview = "Recently fired and desperate for work, a troubled young man named Mike agrees to take a position as a night security guard at an abandoned theme restaurant: Freddy Fazbear's Pizzeria. But he soon discovers that nothing at Freddy's is what it seems.",
            posterPath = "/7BpNtNfxuocYEVREzVMO75hso1l.jpg"
        ),
        Movie(
            id = 1071215,
            title = "Thanksgiving",
            overview = "After a Black Friday riot ends in tragedy, a mysterious Thanksgiving-inspired killer terrorizes Plymouth, Massachusetts - the birthplace of the holiday. Picking off residents one by one, what begins as random revenge killings are soon revealed to be part of a larger, sinister holiday plan.",
            posterPath = "/1QiGcvzh225Kk9N0OMtlWjTcsie.jpg"
        ),
        Movie(
            id = 385687,
            title = "Fast X",
            overview = "Over many missions and against impossible odds, Dom Toretto and his family have outsmarted, out-nerved and outdriven every foe in their path. Now, they confront the most lethal opponent they've ever faced: A terrifying threat emerging from the shadows of the past who's fueled by blood revenge, and who is determined to shatter this family and destroy everything—and everyone—that Dom loves, forever.",
            posterPath = "/fiVW06jE7z9YnO4trhaMEdclSiC.jpg"
        ),
        Movie(
            id = 8871,
            title = "How the Grinch Stole Christmas",
            overview = "The Grinch decides to rob Whoville of Christmas - but a dash of kindness from little Cindy Lou Who and her family may be enough to melt his heart...",
            posterPath = "/52EpMoLTTbKAkM6rSrnNHV2mpLF.jpg"
        ),
        Movie(
            id = 670292,
            title = "The Creator",
            overview = "Amid a future war between the human race and the forces of artificial intelligence, a hardened ex-special forces agent grieving the disappearance of his wife, is recruited to hunt down and kill the Creator, the elusive architect of advanced AI who has developed a mysterious weapon with the power to end the war—and mankind itself.",
            posterPath = "/vBZ0qvaRxqEhZwl6LWmruJqWE8Z.jpg"
        ),
        Movie(
            id = 299054,
            title = "Expend4bles",
            overview = "Armed with every weapon they can get their hands on and the skills to use them, The Expendables are the world’s last line of defense and the team that gets called when all other options are off the table. But new team members with new styles and tactics are going to give “new blood” a whole new meaning.",
            posterPath = "/iwsMu0ehRPbtaSxqiaUDQB9qMWT.jpg"
        )
    )
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ListViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     App(movies = movies)
                }
            }
        }
    }
}

@Composable
fun App(movies: List<Movie>){

   LazyColumn(){
       items(movies) { movie ->
           MovieItem(movie = movie)
           Spacer(modifier = Modifier.height(16.dp))
       }
   }
}

@Composable
fun MovieItem(movie: Movie) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {

        Image(

            painter = rememberImagePainter("https://image.tmdb.org/t/p/w500${movie.posterPath}"),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = movie.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = movie.overview, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ListViewTheme {
        App(movies = movies)
    }
}