package draylar.tiered.reforge.widget;

import org.jetbrains.annotations.Nullable;

import draylar.tiered.network.TieredClientPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.libz.api.InventoryTab;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ReforgeTab extends InventoryTab {

    public ReforgeTab(Text title, @Nullable Identifier texture, int preferedPos, Class<?>... screenClasses) {
        super(title, texture, preferedPos, screenClasses);
    }

    @Override
    public void onClick(MinecraftClient client) {
        if (client.player.getScoreboardTeam() == null) {TieredClientPacket.writeC2SScreenPacket((int) client.mouse.getX(), (int) client.mouse.getY(), false);}
        else if (client.player.getScoreboardTeam().getName().equals("Blacksmith")) {TieredClientPacket.writeC2SScreenPacket((int) client.mouse.getX(), (int) client.mouse.getY(), true);}
        else {TieredClientPacket.writeC2SScreenPacket((int) client.mouse.getX(), (int) client.mouse.getY(), false);}
    }
}
