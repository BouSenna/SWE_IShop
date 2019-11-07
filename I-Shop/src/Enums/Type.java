package Enums;

public enum Type {
    ONLINE, INSTORE;

    public String myString(){
        switch(this){
            case ONLINE: return "online";
            case INSTORE: return "instore";
        }
        return "";
    }
}
