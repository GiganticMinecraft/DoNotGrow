package click.seichi.donotgrow

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class DoNotGrow : JavaPlugin() {
    companion object {
        var PLUGIN: DoNotGrow? = null
            private set
    }

    override fun onEnable() {
        PLUGIN = this
        Bukkit.getPluginManager().registerEvents(BlockGrowListener, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}