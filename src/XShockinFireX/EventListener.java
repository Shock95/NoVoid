package XShockinFireX;

import XShockinFireX.config.Configuration;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.level.Location;

public class EventListener implements Listener {

    private MainClass plugin;

    public EventListener(MainClass plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Configuration config = this.plugin.config;
        if(event.getFrom().equals(event.getTo())) {
            return;
        }
        if(event.getTo().getFloorY() < 2) {
            if(config.isEnabled) {
                player.teleport(new Location(config.x, config.y + 4, config.z, plugin.getServer().getLevelByName(config.level)));
            } else {
                player.teleport(plugin.getServer().getDefaultLevel().getSafeSpawn().add(0.5, 0, 0.5));
            }
            player.setHealth(player.getHealth() - config.hearts);
        }
    }
}
