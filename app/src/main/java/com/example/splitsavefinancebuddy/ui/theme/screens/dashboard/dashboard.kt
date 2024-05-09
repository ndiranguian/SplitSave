package com.example.splitsavefinancebuddy.ui.theme.screens.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splitsavefinancebuddy.ui.theme.SplitSaveFinanceBuddyTheme


enum class Category(val label: String) {
    TRANSPORT("Transport"),
    FOOD("Food"),
    LEISURE("Leisure"),
    FAMILY_AND_FRIENDS("Family and Friends")
}
@Composable
    fun DashboardScreen(onTransactionAdded: (Double, Category) -> Unit) {
        var amount by remember { mutableStateOf("") }
        var selectedCategory by remember { mutableStateOf(Category.TRANSPORT) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                label = { Text("Amount spent") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Select Category", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            RadioButtonGroup(
                options = Category.values().toList(),
                selectedOption = selectedCategory,
                onOptionSelected = { selectedCategory = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                val spentAmount = amount.toDoubleOrNull()
                if (spentAmount != null) {
                    onTransactionAdded(spentAmount, selectedCategory)
                    amount = ""
                }
            }) {
                Text("Add Transaction")
            }
        }
    }

@Composable
fun RadioButtonGroup(
        options: List<Category>,
        selectedOption: Category,
        onOptionSelected: (Category) -> Unit
    ) {
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = option == selectedOption,
                    onClick = { onOptionSelected(option) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option.label)
            }
        }
    }
@Preview(showBackground = true)
@Composable
fun SpendTrackerPreview() {
    SplitSaveFinanceBuddyTheme {
        DashboardScreen { amount, category ->
            // This is just a placeholder action for the preview
            println("Preview: Spent $amount on ${category.label}")
        }
    }
}