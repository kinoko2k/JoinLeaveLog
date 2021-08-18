package com.github.kinoko_team.joinleave;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Joinleave extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent p) {
        //入ってきたプレイヤーを取得
        Player e = p.getPlayer();
        //入室メッセージの変更
        p.setJoinMessage(ChatColor.YELLOW + e.getName() + "さんがサーバーに参加しました!!");
        //注意喚起メッセージの送信
        e.sendMessage(ChatColor.RED + "軽量化Modや日本語化Mod以外の仕様はBANの対象になります!!");
        //タイトルの送信
        e.sendTitle(ChatColor.BLUE + "ようこそ、Call56NetWorkへ", "こんにちは" + e.getName() + "さん!!", 10, 40, 10);
    }

    @EventHandler
    public void PlayerQuitEvent(PlayerQuitEvent p) {
        Player e = p.getPlayer();
        p.setQuitMessage(ChatColor.YELLOW + e.getName() + "さんがサーバーから退出しました");
    }
}
