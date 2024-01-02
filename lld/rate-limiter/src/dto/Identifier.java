package dto;

import constant.Type;

public class Identifier {
    public Type type;
    public String value;
    public Identifier(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return  type.name() + "_" + value;
    }
}
