package com.rex.snake;

import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

public enum Sound {
    PICKUP("sfx/pickup.wav"),
    POWERUP("sfx/powerup.wav"),
    DEATH("sfx/death.wav"),
    BREAK("sfx/cubeBreak.wav"),
    PORTAL("sfx/portal2.wav");
   
    public Clip clip;
    
    Sound(String sound) {
        try {
            URL dir = this.getClass().getResource(sound);
            AudioInputStream ais = AudioSystem.getAudioInputStream(dir);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {}
    }
   
    public void play() {
        if (clip.isRunning()) {
            clip.stop();
        }
        clip.setFramePosition(0);
        clip.start();
    }
}