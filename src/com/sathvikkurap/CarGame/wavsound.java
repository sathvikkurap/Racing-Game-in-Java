package com.sathvikkurap.CarGame;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class wavsound
{
public static void main (String[] args) {
	
}
static void gamemusic()
{
	  //File levelup
  try{
  	File gamemusic = new File(".//images//Twin Musicom - Digital Voyage.wav");
    Clip clip = AudioSystem.getClip();
    clip.open(AudioSystem.getAudioInputStream(gamemusic));
    clip.start();

    Thread.sleep(clip.getMicrosecondLength()/1000);
  }catch(Exception e)
  {

  }
  gamemusic();
}
  static void PlaySound(File gameover)
  {
		
    try{
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(gameover));
      clip.start();

      Thread.sleep(clip.getMicrosecondLength()/1000);
    }catch(Exception e)
    {

    }
  }
  static void PlaySoundRev(File rev)
  {
	  //File levelup
    try{
    	
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(rev));
      clip.start();

      Thread.sleep(clip.getMicrosecondLength()/1000);
    }catch(Exception e)
    {

    }
    
  }
}