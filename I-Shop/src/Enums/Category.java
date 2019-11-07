package Enums;

public enum Category {
	ELECTORINCS, BOOKS, FURNITURE, CLOTHING;

    public String myString(){
        switch(this){
            case ELECTORINCS: return "electronics";
            case BOOKS: return "books";
            case FURNITURE: return "furniture";
            case CLOTHING: return "clothing";
        }
        return "";
    }
}
