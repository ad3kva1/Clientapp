package com.ad3kva1.clientapp

import kotlinx.coroutines.flow.Flow
import com.ad3kva1.clientapp.ClientDao
import com.ad3kva1.clientapp.ClientEntity

class ClientRepositoryImpl(
    private val dao: ClientDao
) : ClientRepository {
    override fun getClients(): Flow<List<ClientEntity>> = dao.getAllClients()
    override fun getArchivedClients(): Flow<List<ClientEntity>> = dao.getArchivedClients()
    override suspend fun addClient(client: ClientEntity) = dao.insertClient(client)
    override suspend fun updateClient(client: ClientEntity) = dao.updateClient(client)
    override suspend fun deleteClient(client: ClientEntity) = dao.deleteClient(client)
}