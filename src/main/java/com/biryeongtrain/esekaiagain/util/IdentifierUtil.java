package com.biryeongtrain.esekaiagain.util;

import com.biryeongtrain.esekaiagain.ESekai;
import net.minecraft.util.Identifier;

public class IdentifierUtil {
    public static Identifier toId(String name) {
        return new Identifier(ESekai.MOD_ID, name);
    }
}
