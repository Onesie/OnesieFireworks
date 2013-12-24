package me.OnesRodriguez.OnesieFireworks;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Main extends JavaPlugin implements Listener {
       
        public void onEnable(){
        	PluginDescriptionFile pdfFile = this.getDescription();
        	getLogger().info("OnesieFireworks version " + pdfFile.getVersion() + " has been enabled.");
                Bukkit.getServer().getPluginManager().registerEvents(this, this);
        }
        
        public void onDisable(){
        	PluginDescriptionFile pdfFile = this.getDescription();
        	getLogger().info("OnesieFireworks version " + pdfFile.getVersion() + " has been disabled.");
        }
       
        @EventHandler
        public void onPlayerJoin (final PlayerJoinEvent pje) {
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                                public void run(){
                                       
                                        Firework f = (Firework) pje.getPlayer().getWorld().spawn(pje.getPlayer().getLocation(), Firework.class);
                                       
                                        FireworkMeta fm = f.getFireworkMeta();
                                        fm.addEffect(FireworkEffect.builder()
                                                        .flicker(true)
                                                        .trail(true)
                                                        .with(Type.BALL)
                                                        .with(Type.CREEPER)
                                                        .with(Type.STAR)
                                                        .withColor(Color.OLIVE)
                                                        .withColor(Color.FUCHSIA)
                                                        .withFade(Color.PURPLE)
                                                        .withFade(Color.BLUE)
                                                        .build());
                                        fm.setPower(2);
                                        f.setFireworkMeta(fm);
                                       
                                }
                        }, 20);
        }
       
}