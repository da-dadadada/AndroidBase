package com.lht.chuangyiyun;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import com.lht.chuangyiyun.interfaces.keys.SPConstants;
import com.lht.chuangyiyun.util.SPUtil;

import java.util.ArrayList;
import java.util.Iterator;


public class ThemeManager {

    private static ThemeManager self;
    private Context mContext;
    private ArrayList<IThemeListener> iThemeListeners;

    public static int BACKGROUNDS[] = {Color.rgb(26, 89, 154),
            Color.rgb(234, 84, 84), Color.rgb(240, 90, 154),
            Color.rgb(192, 80, 26), Color.rgb(148, 83, 237),
            Color.rgb(75, 104, 228), Color.rgb(44, 162, 249),
            Color.rgb(4, 188, 205), Color.rgb(242, 116, 77),
            Color.rgb(249, 169, 42), Color.rgb(105, 200, 78),
            Color.rgb(30, 186, 118), Color.rgb(31, 190, 158),
            Color.rgb(161, 161, 161), Color.rgb(214, 117, 213),
            Color.rgb(242, 106, 138), Color.rgb(211, 173, 114),
            Color.rgb(191, 199, 112), Color.rgb(120, 213, 214),
            Color.rgb(52, 145, 120)};

    private ThemeManager(Context context) {
        this.mContext = context;
    }

    public static ThemeManager with(Context ctx) {
        if (self == null) {
            self = new ThemeManager(ctx);
        } else {
            self.mContext = ctx;
        }

        return self;
    }

    private  SharedPreferences sp;
    public int getCurrentColor() {
        if (sp == null) {
            sp = mContext.getSharedPreferences(SPConstants.Basic.SP_NAME,Context.MODE_PRIVATE);
        }
        return sp.getInt(SPConstants.Basic.KEY_THEME_COLOR,BACKGROUNDS[0]);
    }

    public void saveColor(int index) {
        if (sp == null) {
            sp = mContext.getSharedPreferences(SPConstants.Basic.SP_NAME,Context.MODE_PRIVATE);
        }
        SPUtil.modifyInt(sp, SPConstants.Basic.KEY_THEME_COLOR, BACKGROUNDS[index]);
        notifyThemeChange();
    }

    public void registerListener(IThemeListener listener) {
        if (iThemeListeners == null) {
            iThemeListeners = new ArrayList<>();
        }
        iThemeListeners.add(listener);
    }

    public void notifyThemeChange() {
        if (iThemeListeners == null) return;
        int curColor = getCurrentColor();
        Iterator<IThemeListener> iterator = iThemeListeners.iterator();
        while (iterator.hasNext()) {
            IThemeListener next = iterator.next();
            if (next == null) {
                iterator.remove();
            } else {
                next.onThemeChange(curColor);
            }
        }
    }

    public interface IThemeListener {
        void onThemeChange(int color);
    }

}
