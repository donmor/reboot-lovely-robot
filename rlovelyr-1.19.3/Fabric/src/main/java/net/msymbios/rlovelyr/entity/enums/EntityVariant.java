package net.msymbios.rlovelyr.entity.enums;

import net.minecraft.util.StringIdentifiable;

import java.util.Arrays;
import java.util.Comparator;

public enum EntityVariant implements StringIdentifiable {

    // -- Enum --
    Bunny(0, "bunny"),
    Bunny2(1, "bunny2"),
    Honey(2, "honey"),
    Vanilla(3, "vanilla");


    // -- Variables --
    private static final EntityVariant[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(EntityVariant::getId)).toArray(EntityVariant[]::new);

    private final int m_id;
    private final String m_name;


    // -- Constructor --
    EntityVariant(int id, String name) {
        this.m_id = id;
        this.m_name = name;
    } // Constructor VanillaVariant


    // -- Methods --
    public static EntityVariant byId(int id) {
        if (id < 0 || id >= CODEC.length) id = 0;
        return CODEC[id];
    } // byId ()

    public int getId() {
        return this.m_id;
    } // getId ()

    public String getName() {
        return this.m_name;
    } // getId ()

    @Override
    public String asString() {
        return this.m_name;
    } // asString ()

} // Enum RobotVariant