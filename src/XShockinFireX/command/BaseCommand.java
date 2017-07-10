package XShockinFireX.command;

import XShockinFireX.MainClass;
import cn.nukkit.command.Command;
import cn.nukkit.command.PluginIdentifiableCommand;

public abstract class BaseCommand extends Command implements PluginIdentifiableCommand {

    private MainClass plugin;

    public BaseCommand(String name, MainClass plugin) {
        super(name);
        this.plugin = plugin;
    }

    public MainClass getPlugin() {
        return plugin;
    }
}

