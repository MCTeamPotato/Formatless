package me.kall.formatless.mixin;

import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.PackCompatibility;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PackCompatibility.class)
public abstract class PackCompatibilityMixin {
    @Inject(method = "forFormat", at = @At("HEAD"), cancellable = true)
    private static void checkCompatibility(int version, PackType type, CallbackInfoReturnable<PackCompatibility> cir) {
        cir.setReturnValue(PackCompatibility.COMPATIBLE);
    }
}
