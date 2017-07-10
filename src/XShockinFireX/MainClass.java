package XShockinFireX;

import XShockinFireX.command.NoVoidCommand;
import XShockinFireX.command.SetHeartsCommand;
import cn.nukkit.plugin.PluginBase;
import XShockinFireX.config.Configuration;

public class MainClass extends PluginBase {

    public Configuration config;

    public void onEnable() {
        this.initConfig();
        this.registerCommands();
        this.getLogger().notice("NoVoid by XShockinFireX has been successfully enabled.");
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
    }

    private void initConfig() {
        config = new Configuration(this);
        config.load();
        config.save();
    }

    private void registerCommands() {
        this.getServer().getCommandMap().register("nv", new NoVoidCommand(this));
        this.getServer().getCommandMap().register("sethearts", new SetHeartsCommand(this));
    }
}
