package hell0hd.gateway.sound;

import hell0hd.gateway.Gateway;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GatewaySounds {
    public static SoundEvent GATEWAY_AMBIENCE = registerSound("gateway_ambience");

    static SoundEvent registerSound(String id) {
        SoundEvent sound = new SoundEvent(new Identifier(Gateway.MOD_ID, id));
        return Registry.register(Registry.SOUND_EVENT, new Identifier(Gateway.MOD_ID, id), sound);
    }

    public static void initializeSounds() {
        Gateway.LOGGER.info("Registering " + Gateway.MOD_ID + " Sounds");
    }
}
