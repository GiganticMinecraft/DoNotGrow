package click.seichi.donotgrow

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockGrowEvent

object BlockGrowListener : Listener {
    @EventHandler
    fun onCactusGrow(event: BlockGrowEvent) {
        // event.getBlockで得られるのはMaterial.AIR（=成長するサボテンが出現する座標のブロック）なので、Y座標を-1してMaterial.CACTUSかどうかを判定
        val loc = event.block.location.apply { this.y -= 1 }
        val block = loc.block

        if (block.type == Material.CACTUS) event.isCancelled = true
    }
}