package com.ad3kva1.clientapp

import android.app.Application
import androidx.room.Room
import org.koin.dsl.module
import com.ad3kva1.clientapp.AppDatabase
import com.ad3kva1.clientapp.ClientRepository
import com.ad3kva1.clientapp.ClientRepositoryImpl
import com.ad3kva1.clientapp.viewmodel.ClientViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {

    single {
        Room.databaseBuilder(
            get<Application>(),
            AppDatabase::class.java,
            "clients.db"
        ).build()
    }

    single { get<AppDatabase>().clientDao() }

    single<ClientRepository> { ClientRepositoryImpl(get()) }

    viewModel { ClientViewModel(get()) }
}