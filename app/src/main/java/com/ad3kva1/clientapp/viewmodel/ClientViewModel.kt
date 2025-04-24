package com.ad3kva1.clientapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.ad3kva1.clientapp.ClientEntity
import com.ad3kva1.clientapp.ClientRepository

class ClientViewModel(
    private val repository: ClientRepository
) : ViewModel() {

    private val _clients = MutableStateFlow<List<ClientEntity>>(emptyList())
    val clients: StateFlow<List<ClientEntity>> = _clients.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getClients().collectLatest {
                _clients.value = it
            }
        }
    }

    fun addClient(client: ClientEntity) {
        viewModelScope.launch {
            repository.addClient(client)
        }
    }

    fun archiveClient(client: ClientEntity) {
        viewModelScope.launch {
            repository.updateClient(client.copy(isArchived = true))
        }
    }

    fun deleteClient(client: ClientEntity) {
        viewModelScope.launch {
            repository.deleteClient(client)
        }
    }
}