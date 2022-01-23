package com.death.obito.db

import com.death.obito.Server
import com.death.obito.ServerQueries

class ServerDao(private val serverQuery: ServerQueries) {
    fun saveServer(serverName:String, serverKey:String){
        serverQuery.transaction {
            serverQuery.addServer(serverName, serverKey)
        }
    }

    fun getServers(): List<Server>{
        return serverQuery.getServers().executeAsList()
    }

    fun deleteServerById(id: Long){
        return serverQuery.removeServerById(id)
    }
}