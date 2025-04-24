package com.ad3kva1.clientapp

import kotlinx.coroutines.flow.Flow
import com.ad3kva1.clientapp.ClientEntity

interface ClientRepository {
    fun getClients(): Flow<List<ClientEntity>>
    fun getArchivedClients(): Flow<List<ClientEntity>>
    suspend fun addClient(client: ClientEntity)
    suspend fun updateClient(client: ClientEntity)
    suspend fun deleteClient(client: ClientEntity)
}