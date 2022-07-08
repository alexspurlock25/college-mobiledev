package com.medprompt.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.medprompt.ui.theme.MedpromptTheme

@Composable
fun DateTimePicker (label: String) {
    var day by remember { mutableStateOf("") }

    val monthList = listOf("Jan", "Feb")
    var monthDropDownOpen by remember { mutableStateOf(false) }
    var selectedMonthIndex by remember { mutableStateOf(0) }

    val yearList = listOf("2000", "2001", "2002")
    var yearDropDownOpen by remember { mutableStateOf(false) }
    var selectedYearIndex by remember { mutableStateOf(0) }

    val timeList = listOf("8:00", "9:00")
    var timeDropDownOpen by remember { mutableStateOf(false) }
    var selectedTimeIndex by remember { mutableStateOf(0) }

    val pmAmList = listOf("PM", "AM")
    var pmAmDropDownOpen by remember { mutableStateOf(false) }
    var selectedPmAmIndex by remember { mutableStateOf(0) }

    Column {
        Text(text = label)
        Row(modifier = Modifier
            .padding(5.dp)
            .height(50.dp)) {
            Box(modifier = Modifier.weight(3f)) {
                TextField(
                    value = day,
                    onValueChange = { day = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
            Box(modifier = Modifier.weight(3f)) {
                Text(
                    monthList[selectedMonthIndex],
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(onClick = { monthDropDownOpen = true })
                        .background(Color.Gray))
                DropdownMenu(
                    expanded = monthDropDownOpen,
                    onDismissRequest = { monthDropDownOpen = false }
                ) {
                    monthList.forEachIndexed { index, month ->
                        DropdownMenuItem(onClick = {
                            selectedMonthIndex = index
                            monthDropDownOpen = false
                        }) {
                            Text(text = month, textAlign = TextAlign.Center)
                        }
                    }
                }
            }
            Box(modifier = Modifier.weight(3f)) {
                Text(
                    yearList[selectedYearIndex],
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(onClick = { yearDropDownOpen = true })
                        .background(Color.Gray))
                DropdownMenu(
                    expanded = yearDropDownOpen,
                    onDismissRequest = { yearDropDownOpen = false }
                ) {
                    yearList.forEachIndexed { index, year ->
                        DropdownMenuItem(onClick = {
                            selectedYearIndex = index
                            yearDropDownOpen = false
                        }) {
                            Text(text = year, textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }

        Row(modifier = Modifier
            .padding(5.dp)
            .height(50.dp)) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    timeList[selectedTimeIndex],
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(onClick = { timeDropDownOpen = true })
                        .background(Color.Gray)
                )
                DropdownMenu(
                    expanded = timeDropDownOpen,
                    onDismissRequest = { timeDropDownOpen = false }
                ) {
                    timeList.forEachIndexed { index, time ->
                        DropdownMenuItem(onClick = {
                            selectedTimeIndex = index
                            timeDropDownOpen = false
                        }) {
                            Text(text = time)
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    pmAmList[selectedPmAmIndex],
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(onClick = { pmAmDropDownOpen = true })
                        .background(Color.Gray)
                )
                DropdownMenu(
                    expanded = pmAmDropDownOpen,
                    onDismissRequest = { pmAmDropDownOpen = false }
                ) {
                    pmAmList.forEachIndexed { index, pmAm ->
                        DropdownMenuItem(onClick = {
                            selectedPmAmIndex = index
                            pmAmDropDownOpen = false
                        }) {
                            Text(text = pmAm)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MedicationScreen_Preview() {
    MedpromptTheme {
        DateTimePicker(label = "Label in context here...")
    }
}