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
 * A modifiable float attribute modifier.
 * Used to create trees of modifiers with a single root attribute.
 */
public class ModifiableFloatAttributeModifier extends ModifiableFloatAttribute implements IModifier<Float> {
    /**
     * The attributes the modifier is associated with.
     */
    public final List<IModifiable<Float>> attributes = new ArrayList<>();

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
     * @param modifiers                  the initial list of modifiers associated with the attribute.
     */
    public ModifiableFloatAttributeModifier(String id, String key, InterfaceEntity blockling, float initialValue, Operation operation, Function<Float, String> displayStringValueFunction, Supplier<String> displayStringNameSupplier, boolean isEnabled, IModifier<Float>... modifiers) {
        super(id, key, blockling, initialValue, displayStringValueFunction, displayStringNameSupplier, isEnabled, modifiers);
        this.operation = operation;
    }

    @Override
    public void calculate() {
        super.calculate();

        attributes.forEach(IModifiable::calculate);
    }

    @Override
    public void setBaseValue(Float baseValue, boolean sync) {
        super.setBaseValue(value, sync);

        attributes.forEach(IModifiable::calculate);
    }

    @Override
    public List<IModifiable<Float>> getAttributes() {
        return attributes;
    }

    @Override
    public Operation getOperation() {
        return operation;
    }

    @Override
    public boolean isEffective() {
        return !((getOperation() == Operation.ADD && getValue() == 0.0f) || ((getOperation() == Operation.MULTIPLY_BASE || getOperation() == Operation.MULTIPLY_TOTAL) && getValue() == 1.0f));
    }

    @Override
    public void setIsEnabled(boolean isEnabled, boolean sync) {
        super.setIsEnabled(isEnabled, sync);

        attributes.forEach(IModifiable::calculate);
    }
}
