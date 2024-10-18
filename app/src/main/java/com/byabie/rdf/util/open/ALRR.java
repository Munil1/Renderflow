package com.byabie.rdf.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector3;

import static com.byabie.rdf.util.GLUtil.*;

import java.util.HashMap;
import java.io.File;

public class ALRR {
	private HashMap<Integer, Sound> sounds = new HashMap<>();
	public void registerSound(int fileId, File soundFile) {
        if (soundFile.exists()) {
            Sound sound = Gdx.audio.newSound(Gdx.files.absolute(soundFile.getAbsolutePath()));
            sounds.put(fileId, sound);
        } else {
            Gdx.app.error("ALRR", "Sound file not found: " + soundFile.getAbsolutePath());
        }
    }

    public void removeSound(int fileId) {
        Sound sound = sounds.remove(fileId);
        if (sound != null) {
            sound.stop();
            sound.dispose();
        }
    }
	public void loadSound(Vec3<Float> pos, Vec3<Float> listenerPos, Integer fileid, Vec4<Float> attenuation) {
		Sound sound = sounds.get(fileid);
        if (sound == null) {
            Gdx.app.error("ALRR", "Sound not found for file ID:" + fileid);
            return;
        }
		float initialVolume = attenuation.x;
		float minDistance = attenuation.y;
		float maxDistance = attenuation.z;
		float pitch = attenuation.w;
		Vector3 soundPosition = new Vector3(pos.x, pos.y, pos.z);
        Vector3 listenerPosition = new Vector3(listenerPos.x, listenerPos.y, listenerPos.z);
		float distance = soundPosition.dst(listenerPosition);
        float volume = initialVolume;
        if (distance <= minDistance) {
            volume = initialVolume; // Full volume if within min distance
        } else if (distance >= maxDistance) {
            volume = 0; // No sound if beyond max distance
        } else {
            volume *= (1 - (distance - minDistance) / (maxDistance - minDistance));
        }
        volume = Math.max(volume, 0);
        sound.play(volume, pitch, 0.0f);
	}
}