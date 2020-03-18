package com.focamacho.mysticaladaptations.lib;

import com.blakebr0.mysticalagriculture.api.IMysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.MysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.registry.IAugmentRegistry;
import com.focamacho.mysticaladaptations.init.ModAugments;

@MysticalAgriculturePlugin
public class ModCorePlugin implements IMysticalAgriculturePlugin {

    @Override
    public void onRegisterAugments(IAugmentRegistry registry) {
        ModAugments.registerAugments(registry);
    }

}