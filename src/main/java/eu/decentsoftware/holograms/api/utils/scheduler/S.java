package eu.decentsoftware.holograms.api.utils.scheduler;

import com.github.Anon8281.universalScheduler.UniversalScheduler;
import com.github.Anon8281.universalScheduler.scheduling.tasks.MyScheduledTask;
import eu.decentsoftware.holograms.api.DecentHolograms;
import eu.decentsoftware.holograms.api.DecentHologramsAPI;
import eu.decentsoftware.holograms.api.utils.DExecutor;
import org.bukkit.plugin.IllegalPluginAccessException;

public class S {

    private static final DecentHolograms DECENT_HOLOGRAMS = DecentHologramsAPI.get();

    public static void stopTask(MyScheduledTask task) {
        task.cancel();
    }

    public static void sync(Runnable runnable) {
        UniversalScheduler.getScheduler(DECENT_HOLOGRAMS.getPlugin()).runTask(runnable);
        //Bukkit.getScheduler().runTask(DECENT_HOLOGRAMS.getPlugin(), runnable);
    }

    public static MyScheduledTask sync(Runnable runnable, long delay) {
        return UniversalScheduler.getScheduler(DECENT_HOLOGRAMS.getPlugin()).runTaskLater(runnable, delay);
        //return Bukkit.getScheduler().runTaskLater(DECENT_HOLOGRAMS.getPlugin(), runnable, delay);
    }

    public static MyScheduledTask syncTask(Runnable runnable, long interval) {
        return UniversalScheduler.getScheduler(DECENT_HOLOGRAMS.getPlugin()).runTaskTimer(runnable, 0, interval);
        //return Bukkit.getScheduler().runTaskTimer(DECENT_HOLOGRAMS.getPlugin(), runnable, 0, interval);
    }

    public static void async(Runnable runnable) {
        try {
            UniversalScheduler.getScheduler(DECENT_HOLOGRAMS.getPlugin()).runTaskAsynchronously(runnable);
            //Bukkit.getScheduler().runTaskAsynchronously(DECENT_HOLOGRAMS.getPlugin(), runnable);
        } catch (IllegalPluginAccessException e) {
            DExecutor.execute(runnable);
        }
    }

    public static void async(Runnable runnable, long delay) {
        try {
            UniversalScheduler.getScheduler(DECENT_HOLOGRAMS.getPlugin()).runTaskLater(runnable, delay);
            //Bukkit.getScheduler().runTaskLaterAsynchronously(DECENT_HOLOGRAMS.getPlugin(), runnable, delay);
        } catch (IllegalPluginAccessException e) {
            DExecutor.execute(runnable);
        }
    }

    public static MyScheduledTask asyncTask(Runnable runnable, long interval) {
        return asyncTask(runnable, 0, interval);
        //return Bukkit.getScheduler().runTaskTimerAsynchronously(DECENT_HOLOGRAMS.getPlugin(), runnable, 0, interval);
    }

    public static MyScheduledTask asyncTask(Runnable runnable, long interval, long delay) {
        return UniversalScheduler.getScheduler(DECENT_HOLOGRAMS.getPlugin()).runTaskTimerAsynchronously(runnable, delay, interval);
        //return Bukkit.getScheduler().runTaskTimerAsynchronously(DECENT_HOLOGRAMS.getPlugin(), runnable, delay, interval);
    }

}
