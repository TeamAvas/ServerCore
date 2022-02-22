package skh6075.servercore

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import skh6075.servercore.utils.Message

object EventListener : Listener {

    @EventHandler
    fun onPlayerJoinEvent(event: PlayerJoinEvent){
        val player = event.player
        if(player.isOp){
            Message.broadcastMessage("§l§6• 관리자§r§f " + player.name + "§6님께서 서버에 접속했습니다. (현재 접속자 §f" + Bukkit.getServer().onlinePlayers.size + "명§6)")
        }else if(player.hasPlayedBefore()){
            Message.broadcastActionBar("§l§6• §r§f" + player.name + "§6님께서 서버에 처음 접속했습니다. (현재 접속자 §f" + Bukkit.getServer().onlinePlayers.size + "명§6)", Bukkit.getServer().onlinePlayers)
        }else{
            Message.broadcastActionBar("§l§6• §r§f" + player.name + "§6님께서 서버에 접속했습니다. (현재 접속자 §f" + Bukkit.getServer().onlinePlayers.size + "명§6)", Bukkit.getServer().onlinePlayers)
        }
    }

    @EventHandler
    fun onPlayerQuitEvent(event: PlayerQuitEvent){
        val player = event.player
        if(player.isOp){
            Message.broadcastMessage("§l§6• 관리자§r§f " + player.name + "§6님께서 서버에서 퇴장했습니다. (현재 접속자 §f" + Bukkit.getServer().onlinePlayers.size + "명§6)")
        }else{
            Message.broadcastActionBar("§l§6• §r§f" + player.name + "§6님께서 서버에서 퇴장했습니다. (현재 접속자 §f" + Bukkit.getServer().onlinePlayers.size + "명§6)", Bukkit.getServer().onlinePlayers)
        }
    }
}