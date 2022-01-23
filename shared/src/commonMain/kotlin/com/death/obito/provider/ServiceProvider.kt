package com.death.obito.provider

import com.death.obito.db.Database
import com.death.obito.db.DatabaseDriverFactory
import com.death.obito.service.AppService

data class ServiceProvider(val appService: AppService){
    data class Builder(
        private val dbFactory: DatabaseDriverFactory
    ){
        fun build(): ServiceProvider{
            val db = Database(dbFactory)
            return ServiceProvider(AppService(db.serverDao))
        }
    }

}