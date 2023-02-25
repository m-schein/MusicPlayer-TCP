package enums;

import java.lang.invoke.MutableCallSite;

public enum MusicalNotes {
    LA("(A)"),
    SI("(B)"),
    DO("(C)"),
    RE("(D)"),
    MI("(E)"),
    FA("(F)"),
    SOL("(G)"),
    DOUBLE_VOLUME("( )"),
    REPEAT_NOTE("[abcdefg]");

    private final String value;
    private MusicalNotes(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }

}
