package com.example.hackittiesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hackittiesapp.navigation.DetailScreenPath
import com.example.hackittiesapp.navigation.Screen

@Composable
fun HomeScreen(navController: NavController){
    var name by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableStateOf("")
    }



    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = name, onValueChange = {
            name = it
        }, label = {
            //I Changed "name" to "Username"
            Text(text = "Username")
        })
        OutlinedTextField(value = age, onValueChange = {
            age = it
        }, label = {
            //I Changed "age" to "pin"
            Text(text = "PIN")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        Spacer(modifier = Modifier.padding(10.dp))
        // Did a change below this comment line where "" was initially "Home Screen"
        Text(text = "", fontSize = 40.sp)
        Button(onClick = {
            if(name.isNotEmpty() && age.isNotEmpty()){
                navController.navigate("$DetailScreenPath/$name/${age.toInt()}")
            }
        }) {
            Text(text = "Login", fontSize = 30.sp)
        }
    }
}