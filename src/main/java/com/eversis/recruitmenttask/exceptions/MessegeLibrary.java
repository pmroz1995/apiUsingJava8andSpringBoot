package com.eversis.recruitmenttask.exceptions;

public enum  MessegeLibrary {

    INVALID_MISSION_NAME {
        public String format(){
            return "You pointed invalid mission name";
        }
    },
    INVALID_INDEX {
        public String format(){
            return "Product id which You want to delete does not exist";
        }
    },
    MISSION_ALREADY_EXISTS{
        public String format(){
            return "Mission with givean name already exists";
        }
    },
    INVALID_DATE_FORM{
        public String format(){
            return "you entered the wrong date format, try YYYY-MM-DD";
        }
    },INVALID_CUSTOMER_ID{
        public String format(){
            return "Invalid customer Id";
        }
    },INVALID_CUSTOMER_OR_PRODUCT_ID{
        public String format(){
            return "There is no product, or customer od this id";
        }
    }
    ;



    public abstract String format();
}
