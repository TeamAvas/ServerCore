package skh6075.servercore

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

object EventListener : Listener {

    @EventHandler
    fun onPlayerJoinEvent(event: PlayerJoinEvent){
        val player = event.player
        if(player.isOp){
            broadcastMessage("§l§6• 관리자§r§f " + player.name + "§6님께서 서버에 접속했습니다. " + getOnlinePlayerCountFormat())
        }else if(player.hasPlayedBefore()){
            broadcastPopup("§l§6• §r§f" + player.name + "§6님께서 서버에 처음 접속했습니다." + getOnlinePlayerCountFormat())
        }else{
            broadcastPopup("§l§6• §r§f" + player.name + "§6님께서 서버에 접속했습니다." + getOnlinePlayerCountFormat())
        }
    }

    @EventHandler
    fun onPlayerQuitEvent(event: PlayerQuitEvent){
        val player = event.player
        if(player.isOp){
            broadcastMessage("§l§6• 관리자§r§f " + player.name + "§6님께서 서버에서 퇴장했습니다. " + getOnlinePlayerCountFormat())
        }else{
            broadcastPopup("§l§6• §r§f" + player.name + "§6님께서 서버에서 퇴장했습니다." + getOnlinePlayerCountFormat())
        }
    }

    private fun broadcastMessage(text: String){
        Bukkit.getServer().broadcast(Component.text(text))
    }

    private fun broadcastPopup(text: String){
        for (player in Bukkit.getOnlinePlayers()) {
            player.sendActionBar(Component.text(text))
        }
    }

    private fun getOnlinePlayerCountFormat(): String{
        return "§6(현재 접속자 §f" + Bukkit.getServer().onlinePlayers.size + "명§6)"
    }
}