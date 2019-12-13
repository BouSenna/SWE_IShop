package Enums;

public enum UserTypes {
	CUSTOMER, ADMIN, STOREOWNER, COLLABORATOR;
	public String myString(){
        switch(this){
        	case CUSTOMER: return "Customer";
            case ADMIN: return "Administrator";
            case STOREOWNER: return "StoreOwner";
            case COLLABORATOR: return "Collaborator";
        }
        return "";
    }
}
