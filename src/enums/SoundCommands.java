package enums;

public enum SoundCommands {
        AGOGO(1,"(\\!)"), //changes the instrument to general instrument that is AGOGO
        HARPSICHORD(1,"[OoIiUu]"),
//        REPEAT_NOTE('')

        TUBULAR_BELLS(1,"($)|(\n)"),
        PAN_FLUTE(1,"(\\;)"),
        CHURCH_ORGAN(1,"(\\,)"),
        CHANGE_INSTRUMENT(2,"([0-9])"),
        INC_OCTAVE(3,"(\\?)|(\\.)");

        private final String value;
        private final int commandType;

        //TODO: change commandType to string and define different
        // categories of commands, instead of using numbers
        SoundCommands( int commandType, String value){
            this.value = value;
            this.commandType = commandType;
        }

        public String getValue(){
            return this.value;
        }
        public int getCommandType(){return this.commandType;}

    }


