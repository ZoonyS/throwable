package zoony.throwable.entities.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

@Mixin(Entity.class)
public abstract class LivingEntityMixin {
    
    private PlayerEntity player;
    private boolean held;

    @Inject(method = "interact", at = @At("HEAD"), cancellable = true)
    public void interact(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        // Entity entity = (Entity) (Object) this;
        this.player = player;
        
        this.held = true;

        cir.setReturnValue(ActionResult.PASS);
    }

    @Inject(method = "baseTick", at = @At("HEAD"))
    public void baseTick(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;

        if (this.player == null) return;

        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) (Object) this;
            Vec3d lookVector = Vec3d.fromPolar(0, this.player.getYaw());

            if (livingEntity.hurtTime > 0) {
                float g = MathHelper.sin(this.player.getPitch() * ((float)Math.PI / 180));
                float h = MathHelper.cos(this.player.getPitch() * ((float)Math.PI / 180));
                float i = MathHelper.sin(this.player.getYaw() * ((float)Math.PI / 180));
                float j = MathHelper.cos(this.player.getYaw() * ((float)Math.PI / 180));
                float k = 1 * ((float)Math.PI * 2);
                float l = 0.02f * 1;

                double x = (double)(-i * h * 0.3f) + Math.cos(k) * (double)l; 
                double y = -g * 0.3f + 0.1f + 0.05 * 0.1;
                double z = (double)(j * h * 0.3f) + Math.sin(k) * (double)l;

                this.held = false;
                livingEntity.setHealth(10);
                livingEntity.setNoGravity(false);
                
                livingEntity.setVelocity(x * 10, y * 10, z * 10);
            } else if (this.held == true) {

                livingEntity.setPosition(this.player.getPos().add(lookVector).add(0, 0.5, 0));
                livingEntity.setHealth(2147483647);
                livingEntity.setNoGravity(true);
            }
        }
    }
}
