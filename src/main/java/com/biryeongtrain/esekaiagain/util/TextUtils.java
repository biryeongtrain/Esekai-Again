package com.biryeongtrain.esekaiagain.util;

import com.biryeongtrain.esekaiagain.ESekai;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class TextUtils {
    public static MutableText getTranslation(String s) {
        return Text.translatable(ESekai.MOD_ID + "." + s);
    }
}
