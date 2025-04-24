package com.ad3kva1.clientapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ad3kva1.clientapp.ClientEntity
import com.ad3kva1.clientapp.viewmodel.ClientViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ClientsScreen(
    viewModel: ClientViewModel = koinViewModel()
) {
    val clientList by viewModel.clients.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Список клиентов") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(clientList) { client ->
                ClientItem(
                    client = client,
                    onArchiveClick = { viewModel.archiveClient(client) }
                )
                Divider()
            }
        }
    }
}

@Composable
fun ClientItem(client: ClientEntity, onArchiveClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* можно потом открыть детали */ }
            .padding(8.dp)
    ) {
        Text(text = client.name, style = MaterialTheme.typography.h6)
        Text(text = "Посещений: ${client.visits}")
        Text(text = "Дата: ${client.date}")
        Text(text = "Заметки: ${client.notes}")
        Text(text = "Д/з: ${client.homework}")
        Button(
            onClick = onArchiveClick,
            modifier = Modifier.padding(top = 4.dp)
        ) {
            Text("В архив")
        }
    }
}