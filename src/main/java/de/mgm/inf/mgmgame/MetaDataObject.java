package de.mgm.inf.mgmgame;

import de.mgm.inf.mgmgame.entity.Player;

import java.awt.*;

public class MetaDataObject extends GameObject{

    Dimension dimension;
    Player player;

    public MetaDataObject(Dimension dimension, Player player, int worldX, int worldY){
        this.setWorldX(worldX);
        this.setWorldY(worldY);
        this.dimension = dimension;
        this.player = player;
    }

    public boolean isColliding() {
        int rightX = (int) (this.getWorldX() + this.dimension.getWidth() / 2);
        int leftX = (int) (this.getWorldX() - this.dimension.getWidth() / 2);
        int topY = (int) (this.getWorldY() + this.dimension.getHeight() / 2);
        int bottomY = (int) (this.getWorldY() - this.dimension.getHeight() / 2);

        int playerRightX = (int) (this.player.getWorldX() + this.player.getHitbox().getWidth() / 2);
        int playerLeftX = (int) (this.player.getWorldX() - this.player.getHitbox().getWidth() / 2);
        int playerTopY = (int) (this.player.getWorldY() + this.player.getHitbox().getHeight() / 2);
        int playerBottomY = (int) (this.player.getWorldY() - this.player.getHitbox().getHeight() / 2);

        boolean worldXIsMatching = (rightX >= playerLeftX && playerLeftX >= leftX)  || (leftX <= playerRightX && playerRightX <= rightX);
        boolean worldYIsMatching = (topY >= playerTopY && playerTopY >= bottomY) || (topY >= playerBottomY && playerBottomY >= bottomY);

        return worldXIsMatching && worldYIsMatching;
    }
}
