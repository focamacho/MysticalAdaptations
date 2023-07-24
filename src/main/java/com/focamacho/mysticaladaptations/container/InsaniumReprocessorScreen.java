package com.focamacho.mysticaladaptations.container;

import com.blakebr0.cucumber.client.screen.BaseContainerScreen;
import com.blakebr0.cucumber.util.Formatting;
import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.focamacho.mysticaladaptations.tiles.InsaniumReprocessorTileEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class InsaniumReprocessorScreen extends BaseContainerScreen<InsaniumReprocessorContainer> {

    private static final ResourceLocation BACKGROUND = new ResourceLocation(MysticalAgriculture.MOD_ID, "textures/gui/reprocessor.png");
    private InsaniumReprocessorTileEntity tile;

    public InsaniumReprocessorScreen(InsaniumReprocessorContainer container, Inventory inv, Component title) {
        super(container, inv, title, BACKGROUND, 176, 194);
    }

    @Override
    protected void init() {
        super.init();

        this.tile = this.getTileEntity();
    }

    @Override
    protected void renderLabels(GuiGraphics stack, int mouseX, int mouseY) {
        var title = this.getTitle().getString();

        stack.drawString(this.font, title, (this.imageWidth / 2 - this.font.width(title) / 2), 6, 4210752);
        stack.drawString(this.font, this.playerInventoryTitle, 8, (this.imageHeight - 96 + 2), 4210752);
    }

    @Override
    protected void renderBg(GuiGraphics stack, float partialTicks, int mouseX, int mouseY) {
        this.renderDefaultBg(stack, partialTicks, mouseX, mouseY);

        int x = this.getGuiLeft();
        int y = this.getGuiTop();

        int i1 = this.getEnergyBarScaled(78);

        stack.blit(BACKGROUND, x + 7, y + 95 - i1, 176, 109 - i1, 15, i1);

        if (this.getFuelItemValue() > 0) {
            int lol = this.getBurnLeftScaled(13);
            stack.blit(BACKGROUND, x + 31, y + 52 - lol, 176, 12 - lol, 14, lol + 1);
        }

        if (this.getProgress() > 0) {
            int i2 = this.getProgressScaled(24);
            stack.blit(BACKGROUND, x + 98, y + 51, 176, 14, i2 + 1, 16);
        }
    }

    @Override
    protected void renderTooltip(GuiGraphics stack, int mouseX, int mouseY) {
        int x = this.getGuiLeft();
        int y = this.getGuiTop();

        super.renderTooltip(stack, mouseX, mouseY);

        if (mouseX > x + 7 && mouseX < x + 20 && mouseY > y + 17 && mouseY < y + 94) {
            var text = Component.literal(number(this.getEnergyStored()) + " / " + number(this.getMaxEnergyStored()) + " FE");
            stack.renderTooltip(font, text, mouseX, mouseY);
        }

        if (this.getFuelLeft() > 0 && mouseX > x + 30 && mouseX < x + 45 && mouseY > y + 39 && mouseY < y + 53) {
            stack.renderTooltip(font, Formatting.energy(this.getFuelLeft()), mouseX, mouseY);
        }
    }

    private InsaniumReprocessorTileEntity getTileEntity() {
        var level = this.getMinecraft().level;

        if (level != null) {
            var tile = level.getBlockEntity(this.getMenu().getPos());

            if (tile instanceof InsaniumReprocessorTileEntity reprocessor) {
                return reprocessor;
            }
        }

        return null;
    }

    public int getProgress() {
        if (this.tile == null)
            return 0;

        return this.tile.getProgress();
    }

    public int getFuelLeft() {
        if (this.tile == null)
            return 0;

        return this.tile.getFuelLeft();
    }

    public int getFuelItemValue() {
        if (this.tile == null)
            return 0;

        return this.tile.getFuelItemValue();
    }

    public int getEnergyStored() {
        if (this.tile == null)
            return 0;

        return this.tile.getEnergy().getEnergyStored();
    }

    public int getMaxEnergyStored() {
        if (this.tile == null)
            return 0;

        return this.tile.getEnergy().getMaxEnergyStored();
    }

    public int getProgressScaled(int pixels) {
        return pixels;
    }

    public int getEnergyBarScaled(int pixels) {
        int i = this.getEnergyStored();
        int j = this.getMaxEnergyStored();
        return (int) (j != 0 && i != 0 ? (long) i * pixels / j : 0);
    }

    public int getBurnLeftScaled(int pixels) {
        int i = this.getFuelLeft();
        int j = this.getFuelItemValue();
        return (int) (j != 0 && i != 0 ? (long) i * pixels / j : 0);
    }
}