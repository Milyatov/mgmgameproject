package de.mgm.inf.mgmgame.entity;

import de.mgm.inf.mgmgame.ImageUtils;

import java.awt.image.BufferedImage;

public class State {

    private final BufferedImage[] sprites;
    public int currentSpriteNumber = 0;

    private final String direction;
    private final String movingType;

    public State(String path, int spriteNumber, String direction, String movingType){
        this.movingType = movingType;
        this.direction = direction;
        sprites = new BufferedImage[spriteNumber];
        for (int i = 0; i < spriteNumber; i++) {
            sprites[i] = ImageUtils.load(path + this.direction + "_" + this.movingType + i + ".png");
        }
    }

    public BufferedImage getCurrentSprite(){
        return sprites[this.currentSpriteNumber];
    }

    public int getSpritesNumber(){
        return this.sprites.length;
    }

    public String getDirection(){
        return this.direction;
    }

    public String getMovingType(){
        return this.movingType;
    }
}
