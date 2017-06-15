package efeitos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class LauchPad extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SLIME_BLOCK) {
		p.setVelocity(e.getPlayer().getLocation().getDirection().multiply(5));
		p.setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
		p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 50f, 50f);
		}
	
		if(e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
			p.setVelocity(e.getPlayer().getLocation().getDirection().multiply(1.1));
			p.setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 2.4D, e.getPlayer().getVelocity().getZ()));
			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 10f, 10f);
		}
		
	}	
}	
