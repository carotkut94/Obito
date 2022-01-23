package com.death.obito.db

import com.death.obito.AppDatabase

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val serverQuery = database.serverQueries

    internal fun clearDatabase(){
        serverQuery.transaction {
            serverQuery.removeAllServers()
        }
    }
    val serverDao = ServerDao(serverQuery)
}