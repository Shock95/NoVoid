package XShockinFireX.config;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.SimpleConfig;

public class Configuration extends SimpleConfig {

    public Configuration(PluginBase plugin) {
        super(plugin);
    }

    @Path (value = "enable-configuration")
    public boolean isEnabled = false;

    @Path (value = "hearts")
    public int hearts = 0;

    @Path (value = "x")
    public double x = 0;

    @Path (value = "y")
    public double y = 0;

    @Path (value = "z")
    public double z = 0;

    @Path (value = "level")
    public String level = "";
}
