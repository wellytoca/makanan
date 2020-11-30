package com.example.makanansederhana;

import android.content.Context;

import com.example.makanansederhana.model.Daging;
import com.example.makanansederhana.model.Menu;
import com.example.makanansederhana.model.Sayuran;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataProvider {

    private static List<Menu> menus = new ArrayList<>();

    private static List<Sayuran>initDataSayuran(Context ctx) {
        List<Sayuran> sayurans = new ArrayList<>();
        sayurans.add(new Sayuran("Gadogado","Jakarta","Merupakan kuliner khas Indonesia terkenal dan berasal dari Jakarta",R.drawable.gadogado));
        sayurans.add(new Sayuran("Pecel","Padang","Merupakan kuliner khas Indonesia terkenal dan berasal dari Jawa Timur",R.drawable.pecel));
        sayurans.add(new Sayuran("Karedok","Sunda","Merupakan kuliner khas Indonesia terkenal dan berasal dari Sunda",R.drawable.karedok));
        sayurans.add(new Sayuran("Pelencing Kangkung","Lombok","Merupakan kuliner khas Indonesia terkenal dan berasal dari Lombok",R.drawable.pelecingkangkung));
        return sayurans;
    }

    private static List<Daging> initDataDaging(Context ctx) {
        List<Daging> dagings = new ArrayList<>();
        dagings.add(new Daging("Rendang","Padang","Merupakan kuliner khas Indonesia terkenal dan berasal dari Padang",R.drawable.rendang));
        dagings.add(new Daging("SopBuntut","NTT","Merupakan kuliner khas Indonesia terkenal dan berasal dari NTT",R.drawable.sopbuntut));
        dagings.add(new Daging("Soto","Solo","Merupakan kuliner khas Indonesia terkenal dan berasal dari Solo",R.drawable.soto));
        dagings.add(new Daging("Krengsengan","Jawa","Merupakan kuliner khas Indonesia terkenal dan berasal dari Jawa",R.drawable.krengsengan));
        return dagings;
    }

    private static void initAllMenus(Context ctx) {
        menus.addAll(initDataSayuran(ctx));
        menus.addAll(initDataDaging(ctx));

    }

    public static List<Menu> getAllOrgan(Context ctx) {
        if (menus.size() == 0) {
            initAllMenus(ctx);
        }
        return menus;
    }

    public static List<Menu> getMenusByTipe(Context ctx, String jenis) {
        List<Menu> menusByType = new ArrayList<>();
        if (menus.size() == 0) {
            initAllMenus(ctx);
        }
        for (Menu o : menus) {
            if (o.getJenis().equals(jenis)) {
                menusByType.add(o);
            }
        }
        return menusByType;
    }
}

