package XShockinFireX.command;

import XShockinFireX.MainClass;
import XShockinFireX.config.Configuration;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public class NoVoidCommand extends BaseCommand {

    public NoVoidCommand(MainClass plugin) {
        super("nv", plugin);
        this.setUsage("/nv");
        this.setPermission("novoid.command");
        this.setDescription("Set's the spawn to teleport upon entering the void.");
    }

    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(TextFormat.RED + "You cannot use this command here.");
            return false;
        }
        Configuration config = this.getPlugin().config;
        config.isEnabled = true;
        config.x = ((Player) sender).getFloorX();
        config.y = ((Player) sender).getFloorY();
        config.z = ((Player) sender).getFloorZ();
        config.level = ((Player) sender).getLevel().getName();
        config.save();
        sender.sendMessage(TextFormat.GREEN + "[NoVoid] Successfully set new location!");
        return true;
    }
}
