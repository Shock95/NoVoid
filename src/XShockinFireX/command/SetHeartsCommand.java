package XShockinFireX.command;

import XShockinFireX.MainClass;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public class SetHeartsCommand extends BaseCommand {

    public SetHeartsCommand(MainClass plugin) {
        super("sethearts", plugin);
        this.setUsage("/sethearts <hearts>");
        this.setPermission("novoid.command");
        this.setDescription("Set's the amount of hearts lost upon entering the void.");
    }

    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(TextFormat.RED + "You cannot use this command here.");
            return false;
        }
        if(args[0] == null) {
            sender.sendMessage(TextFormat.RED + "Usage: " + this.getUsage());
            return false;
        }
        if(!(args[0].chars().allMatch(Character::isDigit))) {
            sender.sendMessage(TextFormat.RED + "Hearts value must be numeric.");
            return false;
        }
        this.getPlugin().config.hearts = Integer.parseInt(args[0]);
        this.getPlugin().config.save();
        sender.sendMessage(TextFormat.GREEN + "Successfully set lost hearts to " + args[0] + "!");
        return true;
    }
}