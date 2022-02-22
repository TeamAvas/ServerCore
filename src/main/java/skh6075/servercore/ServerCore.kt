package skh6075.servercore

import org.bukkit.plugin.java.JavaPlugin

class ServerCore : JavaPlugin(){
    companion object{
        lateinit var instance : ServerCore
    }

    init {
        instance = this
    }

    override fun onEnable() {
        server.pluginManager.registerEvents(EventListener, this)
    }
}