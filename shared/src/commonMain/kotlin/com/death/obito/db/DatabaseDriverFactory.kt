package com.death.obito.db

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

object DatabaseConstants{
    const val DB_NAME = "obito.db"
}