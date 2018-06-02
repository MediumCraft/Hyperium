package cc.hyperium.gui.main.tabs;

import cc.hyperium.gui.GuiBlock;
import cc.hyperium.gui.Icons;
import cc.hyperium.gui.main.components.AbstractTab;
import cc.hyperium.gui.main.components.SettingItem;
import cc.hyperium.internal.addons.AddonBootstrap;
import cc.hyperium.internal.addons.AddonManifest;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

/*
 * Created by Cubxity on 29/05/2018
 */
public class AddonsTab extends AbstractTab {
    private GuiBlock block;
    private int y, w;

    public AddonsTab(int y, int w) {
        block = new GuiBlock(0, w, y, y + w);
        this.y = y;
        this.w = w;
        int yi = 0, xi = 0;
        for (AddonManifest a : AddonBootstrap.INSTANCE.getAddonManifests()) {
            items.add(new SettingItem(() -> {
                //TODO: show the addon config overlay
            }, Icons.EXTENSION.getResource(), a.getName(), "", "Configure addon", xi, yi));
            if (xi == 3) {
                xi = 0;
                yi++;
            } else
                xi++;
        }
    }

    @Override
    public void drawTabIcon() {
        Icons.EXTENSION.bind();
        Gui.drawScaledCustomSizeModalRect(5, y + 5, 0, 0, 144, 144, w - 10, w - 10, 144, 144);
    }

    @Override
    public GuiBlock getBlock() {
        return block;
    }

    @Override
    public void drawHighlight() {
        GlStateManager.disableBlend();
        Gui.drawRect(0, y, 3, y + w, new Color(255, 255, 255, 100).getRGB());
        GlStateManager.enableBlend();
    }

    @Override
    public void draw(int mouseX, int mouseY, int topX, int topY, int containerWidth, int containerHeight) {

    }
}
