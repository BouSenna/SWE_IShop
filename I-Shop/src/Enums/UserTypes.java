package Enums;

public enum UserTypes {
	CUSTOMER, ADMIN, STOREOWNER, COLLABORATORS;
	public String myString(){
        switch(this){
        	case CUSTOMER: return "Customer";
            case ADMIN: return "Administrator";
            case STOREOWNER: return "StoreOwner";
            case COLLABORATORS: return "Collaborators";
        }
        return "";
    }
}
