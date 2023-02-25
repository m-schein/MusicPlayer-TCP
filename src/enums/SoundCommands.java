package enums;

public enum SoundCommands {
        DOUBLE_VOLUME("(\\+)"),
        DEFAULT_VOLUME(  "(\\-)"),
        REPEAT_NOTE(  "[OoIiUu]"),
        INC_OCTAVE("(R\\+)"),
        DEC_OCTAVE( "(R\\-)"),
        RANDOM_NOTE( "(\\?)"),
        CHANGE_INSTRUMENT("($)"), // the $ corresponds to end of line in regex
        INC_80_BPM("(BMP\\+)"),
        RANDOM_BPM("(\\;)");

        private final String value;
        private SoundCommands(String value){
            this.value = value;
        }

        public String getValue(){
            return this.value;
        }

    }


