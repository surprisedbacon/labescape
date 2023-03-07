package org.xyrise.labescape.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpawnTube implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length != 3) {
            commandSender.sendMessage("You must input valid coordinates!");
            return true;
        }

        for (String arg : strings) {
            if (!arg.matches("-?[0-9]+")) {
                commandSender.sendMessage("You must input valid coordinates!");
                return true;
            }
        }

        Player player = (Player) commandSender;
        World world = player.getWorld();

        int x = Integer.parseInt(strings[0]);
        int y = Integer.parseInt(strings[1]);
        int z = Integer.parseInt(strings[2]);

        Location startPosition = new Location(world, x, y, z);

        List<Material> tubeList = new ArrayList<>();
        List<Material> tubeBlocks = new ArrayList<>();
        tubeBlocks.add(Material.DIRT);
        tubeBlocks.add(Material.STONE);
        tubeBlocks.add(Material.OAK_PLANKS);
        Random rng = new Random();

        System.out.println(tubeList);
//        System.out.println(tubeBlocks);

        for (int i = 0; i < 70; i++) {
            tubeList.add(tubeBlocks.get((rng.nextInt(3))));
        }

        System.out.println(tubeList);

        for (int j = 0; j < 70; j++) {
            Block block = startPosition.getBlock();
            Block glassBlockN = block.getRelative(BlockFace.NORTH);
            Block glassBlockS = block.getRelative(BlockFace.SOUTH);
            Block glassBlockE = block.getRelative(BlockFace.EAST);
            Block glassBlockW = block.getRelative(BlockFace.WEST);

            block.setType(tubeList.get(j));
            glassBlockN.setType(Material.GLASS);
            glassBlockS.setType(Material.GLASS);
            glassBlockE.setType(Material.GLASS);
            glassBlockW.setType(Material.GLASS);

            startPosition.add(0, 1, 0);
        }

        return true;
    }
}
