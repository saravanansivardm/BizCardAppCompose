package com.example.bizcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizcardapp.ui.theme.BizCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(), color = Color.White
            ) {
                CreateBizCard()
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickState = remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CreateProfileImage()
            CreateProfileInformation()
            Button(
                onClick = {
                    buttonClickState.value = !buttonClickState.value
                },
                modifier = Modifier
                    .size(width = 80.dp, height = 30.dp),
                shape = RectangleShape,
            ) {
                Text(
                    text = "Portfolio",
                    color = Color.White,
                    fontSize = 8.sp,
                )
            }
            CreateListOfProfileInformation(buttonClickState.value)
        }
    }
}

@Composable
fun CreateListOfProfileInformation(value: Boolean) {
    val data = arrayListOf<ProfessionalsDetails>()
    data.add(
        ProfessionalsDetails(
            R.drawable.ic_launcher_background,
            "Siva",
            "Senior Software Engineer"
        )
    )
    data.add(
        ProfessionalsDetails(
            R.drawable.ic_launcher_background,
            "Saravanan",
            "Senior Android Developer"
        )
    )
    data.add(
        ProfessionalsDetails(
            R.drawable.ic_launcher_background,
            "Siva",
            "Senior Software Engineer"
        )
    )
    data.add(
        ProfessionalsDetails(
            R.drawable.ic_launcher_background,
            "Saravanan",
            "Senior Android Developer"
        )
    )
    data.add(
        ProfessionalsDetails(
            R.drawable.ic_launcher_background,
            "Siva",
            "Senior Software Engineer"
        )
    )
    data.add(
        ProfessionalsDetails(
            R.drawable.ic_launcher_background,
            "Saravanan",
            "Senior Android Developer"
        )
    )
    data.add(ProfessionalsDetails(R.drawable.ic_launcher_background, "Sam", "Software Engineer II"))
    if (value) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .border(width = 0.5.dp, color = Color.Red),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp, start = 4.dp, end = 4.dp)
                    .background(Color.Transparent)
            ) {
                items(data.size) {
                    Row {
                        Surface(
                            modifier = Modifier
                                .size(50.dp)
                                .padding(5.dp),
                        ) {
                            Image(
                                painter = painterResource(data[it].profileImage),
                                contentDescription = "Profile Image",
                                modifier = Modifier.size(55.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Column {
                            Text(
                                text = data[it].name,
                                modifier = Modifier.padding(3.dp),
                                color = Color.Black,
                                fontSize = 12.sp,
                            )
                            Text(
                                text = data[it].designation,
                                modifier = Modifier
                                    .padding(3.dp)
                                    .fillMaxWidth(),
                                color = Color.Black,
                                fontSize = 8.sp,
                            )
                        }
                    }
                    Divider()
                }
            }
        }
    }
}

@Composable
fun CreateProfileInformation() {
    Column(
        modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Miles.P",
            modifier = Modifier.padding(3.dp),
            color = Color.Blue,
            fontSize = 18.sp,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth(),
            color = Color.Black,
            fontSize = 8.sp,
        )
        Text(
            text = "@themilesCompose", modifier = Modifier.padding(3.dp),
            color = Color.Black,
            fontSize = 8.sp,
        )
    }
}

@Composable
fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(width = 0.5.dp, color = Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.01f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
    Divider()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardAppTheme {
        CreateBizCard()
    }
}