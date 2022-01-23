package com.death.obito.db

import com.death.obito.AppDatabase
import com.death.obito.db.DatabaseConstants.DB_NAME
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, DB_NAME)
    }
}