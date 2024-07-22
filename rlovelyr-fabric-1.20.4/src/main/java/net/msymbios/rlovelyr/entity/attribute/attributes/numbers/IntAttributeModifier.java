package net.msymbios.rlovelyr.entity.attribute.attributes.numbers;

import net.msymbios.rlovelyr.entity.attribute.enums.Operation;
import net.msymbios.rlovelyr.entity.attribute.interfaces.IModifiable;
import net.msymbios.rlovelyr.entity.attribute.interfaces.IModifier;
import net.msymbios.rlovelyr.entity.internal.InterfaceEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A simple int attribute modifier.
 */
public class IntAttributeModifier extends IntAttribute implements IModifier<Integer> {
    /**
     * The attributes the modifier is associated with.
     */
    public final List<IModifiable<Integer>> attributes = new ArrayList<>();

    /**
     * The operation to be performed on the associated attribute and the modifier.
     */
    public final Operation operation;

    /**
     * @param id                         the id of the attribute.
     * @param key                        the key used to identify the attribute (for things like translation text components).
     * @param blockling                  the blockling.
     * @param initialValue               the initial value of the attribute.
     * @param operation                  the operation to be performed on the associated attribute and the modifier.
     * @param displayStringValueFunction the function used to provide the string representation of the value.
     * @param displayStringNameSupplier  the supplier used to provide the string representation of display name.
     * @param isEnabled                  whether the attribute is currently enabled.
     */
    public IntAttributeModifier(String id, String key, InterfaceEntity blockling, int initialValue, Operation operation, Function<Integer, String> displayStringValueFunction, Supplier<String> displayStringNameSupplier, boolean isEnabled) {
        super(id, key, blockling, initialValue, displayStringValueFunction, displayStringNameSupplier, isEnabled);
        this.operation = operation;
    }

    @Override
    public void setValue(Integer value, boolean sync) {
        super.setValue(value, sync);

        attributes.forEach(IModifiable::calculate);
    }


    @Override
    public List<IModifiable<Integer>> getAttributes() {
        return attributes;
    }


    @Override
    public Operation getOperation() {
        return operation;
    }

    @Override
    public boolean isEffective() {
        return !((getOperation() == Operation.ADD && getValue() == 0) || ((getOperation() == Operation.MULTIPLY_BASE || getOperation() == Operation.MULTIPLY_TOTAL) && getValue() == 1));
    }

    @Override
    public void setIsEnabled(boolean isEnabled, boolean sync) {
        super.setIsEnabled(isEnabled, sync);

        attributes.forEach(IModifiable::calculate);
    }
}
