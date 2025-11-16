package me.kall.formatless.mixin;

import net.minecraft.server.packs.repository.PackCompatibility;
import net.minecraft.util.InclusiveRange;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PackCompatibility.class)
public abstract class PackCompatibilityMixin {
    @Inject(method = "forVersion", at = @At("HEAD"), cancellable = true)
    private static void checkCompatibility(InclusiveRange<Integer> range, int version, @NotNull CallbackInfoReturnable<PackCompatibility> cir) {
        cir.setReturnValue(PackCompatibility.COMPATIBLE);
    }
}
