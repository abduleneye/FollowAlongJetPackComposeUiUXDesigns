package com.example.jetpackcomposeuiuxdesigns.features.BankingAppUI.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeuiuxdesigns.R
import com.example.jetpackcomposeuiuxdesigns.ui.theme.BlueEnd
import com.example.jetpackcomposeuiuxdesigns.ui.theme.BlueStart
import com.example.jetpackcomposeuiuxdesigns.ui.theme.GreenEnd
import com.example.jetpackcomposeuiuxdesigns.ui.theme.GreenStart
import com.example.jetpackcomposeuiuxdesigns.ui.theme.OrangeEnd
import com.example.jetpackcomposeuiuxdesigns.ui.theme.OrangeStart
import com.example.jetpackcomposeuiuxdesigns.ui.theme.PurpleEnd
import com.example.jetpackcomposeuiuxdesigns.ui.theme.PurpleStart

val cardz = listOf(
    CardModelClass(
        cardType = "VISA",
        cardNumber = "3664 7865 4786 3976",
        cardName = "Business",
        balance = 46.467,
        color = getGradient(startColor = PurpleStart, endColor = PurpleEnd)
    ),
    CardModelClass(
        cardType = "MASTER CARD",
        cardNumber = "2345 7833 9034 6273",
        cardName = "Savings",
        balance = 500.467,
        color = getGradient(startColor = BlueStart, endColor = BlueEnd)
    ),
    CardModelClass(
        cardType = "VISA",
        cardNumber = "3322 7223 9022 3321",
        cardName = "School",
        balance = 92.467,
        color = getGradient(startColor = OrangeStart, endColor = OrangeEnd)
    ),
    CardModelClass(
        cardType = "MASTER CARD",
        cardNumber = "4543 7332 9101 3123",
        cardName = "Trips",
        balance = 200.34,
        color = getGradient(startColor = GreenStart, endColor = GreenEnd)
    )

)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {

    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )



}

@Preview
@Composable
fun CardSection(){

    LazyRow {
        items(count = cardz.size){index ->

            CardItem(index = index)

        }
    }

}


@Composable
fun CardItem(index: Int){
    val card = cardz[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cardz.size - 1){
        lastItemPaddingEnd = 16.dp

    }

    var image = painterResource(id = R.drawable.ic_visa)

    if (card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    
    Box(modifier = Modifier
        .padding(start = 16.dp, end = lastItemPaddingEnd)){

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(16.dp)
                )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

           // Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )



        }

    }


}
