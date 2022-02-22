package skh6075.servercore.utils

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object Message{

    fun broadcastActionBar(text: String, targets: MutableCollection<out Player>){
        for (player in targets) {
            player.sendActionBar(Component.text(text))
        }
    }

    fun broadcastMessage(text: String){
        Bukkit.getServer().broadcast(Component.text(text))
    }
}