package Enums;

public enum ItemNames {
	LAPTOP, TABLE , ENCLOPEDIA, CHAIR, JACKET, PANTS, SOFA;

    public String myString(){
        switch(this){
            case LAPTOP: return "laptop";
            case TABLE: return "table";
            case ENCLOPEDIA: return "encyclopedia";
            case CHAIR: return "chair";
            case JACKET: return "jacket";
            case PANTS: return "pants";
            case SOFA: return "sofa";
        }
        return "";
    }
}
