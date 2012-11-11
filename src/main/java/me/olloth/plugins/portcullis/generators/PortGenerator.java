package me.olloth.plugins.portcullis.generators;

import java.util.Random;

import me.olloth.plugins.portcullis.blocks.Blocks;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.ChunkGenerator;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.inventory.MaterialManager;

public class PortGenerator extends ChunkGenerator {

	MaterialManager mm;

	public PortGenerator() {
		mm = SpoutManager.getMaterialManager();
	}

	public void setBlock(byte[][] result, int x, int y, int z, int blkid) {
		if (result[y >> 4] == null) {
			result[y >> 4] = new byte[4096];
		}
		result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = (byte) blkid;
	}

	@Override
	public byte[][] generateBlockSections(World world, Random random,
			int chunkX, int chunkZ, BiomeGrid biomes) {
		byte[][] result = new byte[16][];
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				setBlock(result, x, 0, z, Material.BEDROCK.getId());
				int y = 1;
				for (y = 1; y < (Math.sin((chunkX * 16 + x) * (Math.PI / 64)) * 12 + 12); y++) {
					setBlock(result, x, y, z, Material.DIRT.getId());
					Block b = world.getBlockAt(x + chunkX * 16, y, z + chunkZ
							* 16);
					mm.overrideBlock(b, Blocks.highlandDust);
					SpoutBlock sb = (SpoutBlock) b;
					sb.setCustomBlock(Blocks.highlandDust);
				}
				setBlock(result, x, y, z, Material.GRASS.getId());
				Block b = world.getBlockAt(x + chunkX * 16, y, z + chunkZ * 16);
				mm.overrideBlock(b, Blocks.moonrock);
				SpoutBlock sb = (SpoutBlock) b;
				sb.setCustomBlock(Blocks.moonrock);
			}
		}
		return result;
	}

	// @Override
	// public List<BlockPopulator> getDefaultPopulators(World world) {
	// List<BlockPopulator> list = new ArrayList<BlockPopulator>(); //
	// list.add(new SlowTerrainPopulator());
	// list.add(new CraterPopulator());
	// list.add(new SilicatePopulator());
	// return list;
	// }
}
