package click.seichi.donotgrow

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockGrowEvent

object BlockGrowListener : Listener {
    @EventHandler
    fun onCactusGrow(event: BlockGrowEvent) {
        // サボテンの場合、event.getBlockで得られるのはMaterial.AIRなので、そのY座標を負の方向に1ずらしてMaterial.CACTUSかどうかを判定
        val loc = event.block.location.apply { this.y -= 1 }
        val block = loc.block

        if (block.type == Material.CACTUS) {
            event.isCancelled = true
            Bukkit.getServer().logger.info("CACTUS!")
            Bukkit.getServer().logger.info(event.isCancelled.toString())
        }
    }
}