package constant;

public class Query {
    public static final String R_AIRLINE = "SELECT * FROM AIRLINE";
    public static final String C_AIRLINE = "INSERT INTO AIRLINE (NAME,SHORT_NAME,STATE) VALUES (?,?,?)";
    public static final String U_AIRLINE ="UPDATE  AIRLINE SET NAME = ?,SHORT_NAME = ? WHERE ID = ?";
    public static final String D_AIRLINE = "DELETE FROM AIRLINE WHERE ID = ?";
    public static final String U_STATE_AIRLINE = "UPDATE  AIRLINE SET STATE = ? WHERE ID = ?";
    public static final String R_LIMIT_AIRLINE ="SELECT * FROM AIRLINE LIMIT ? , ?";
    public static final String R_VIEW_AIRPLANE_CHAIR ="SELECT * FROM VIEW_AIRPLANE_CHAIR";
    public static final String C_AIRPLANE_CHAIR ="INSERT INTO AIRPLANE_CHAIR (QUANTITY,PRICE,USED,PLAY_DATE,STATE,C_ID,AP_ID) VALUES (?,?,?,?,?,?,?)";
    public static final String R_AIRPLANE_CHAIR = "SELECT * FROM AIRPLANE_CHAIR";
    public static final String U_AIRPLANE_CHAIR = "UPDATE AIRPLANE_CHAIR SET QUANTITY = ?,PRICE = ?,USED = ?,PLAY_DATE = ?,C_ID= ?,AP_ID = ? WHERE ID = ?";
    public static final String U_STATE_AIRPLANE_CHAIR ="UPDATE AIRPLANE_CHAIR SET STATE = ? WHERE ID = ?";
    public static final String U_USED_AIRPLANE_CHAIR="UPDATE AIRPLANE_CHAIR SET USED = ? WHERE ID = ?";
    public static final String R_LIMIT_AIRPLANE_CHAIR = "CALL VIEW_AIRPLANE_CHAIR_PAGE (?,?)";
    public static final String R_VIEW_AIRPLANE = "SELECT * FROM VIEW_AIRPLANE";
    public static final String C_AIRPLANE = "INSERT INTO AIRPLANE (NAME,SHORT_NAME,CAPACITY,STATE,AL_ID) VALUES (?,?,?,?,?)";
    public static final String U_AIRPLANE ="UPDATE  AIRPLANE SET NAME = ?,SHORT_NAME = ?,CAPACITY = ?, AL_ID = ? WHERE ID = ?";
    public static final String D_AIRPLANE ="DELETE FROM AIRPLANE WHERE ID = ?";
    public static final String R_AIRPLANE ="SELECT * FROM AIRPLANE";
    public static final String U_STATE_AIRPLANE ="UPDATE  AIRPLANE SET STATE = ? WHERE ID = ?";
    public static final String R_LIMIT_AIRPLANE ="CALL VIEW_AIRPLANE_PAGE(?,?)";
    public static final String C_BOOKING ="INSERT INTO BOOKING (BOOKING_DATE_TIME,PRICE,AC_ID,F_ID) VALUES (?,?,?,?)";
    public static final String R_ONE_BOOKING ="SELECT * FROM BOOKING WHERE BOOKING_DATE_TIME = ? AND PRICE = ? AND AC_ID =? AND F_ID = ?";
    public static final String R_BOOKING = "SELECT * FROM BOOKING";
    public static final String R_ID_BOOKING ="SELECT * FROM BOOKING WHERE ID = ?";
    public static final String U_STATE_BOOKING ="UPDATE BOOKING SET STATE = ? WHERE ID = ?";
    public static final String R_LIMIT_BOOKING ="SELECT * FROM BOOKING LIMIT ?,?";
    public static final String R_CHAIR = "SELECT * FROM CHAIR";
    public static final String D_CHAIR ="DELETE FROM CHAIR WHERE ID = ?";
    public static final String U_CHAIR ="UPDATE  CHAIR SET NAME = ? WHERE ID = ?";
    public static final String C_CHAIR ="INSERT INTO CHAIR (NAME,STATE) VALUES (?,?)";
    public static final String U_STATE_CHAIR ="UPDATE  CHAIR SET STATE = ? WHERE ID = ?";
    public static final String R_LIMIT_CHAIR ="SELECT * FROM CHAIR LIMIT ? , ?";
    public static final String R_CITY = "SELECT * FROM CITY";
    public static final String C_CITY =  "INSERT INTO CITY (NAME,SHORT_NAME,STATE) VALUES (?,?,?)";
    public static final String U_CITY = "UPDATE  CITY SET NAME = ?,SHORT_NAME = ? WHERE ID = ?";
    public static final String D_CITY ="DELETE FROM CITY WHERE ID = ?";
    public static final String U_STATE_CITY ="UPDATE  CITY SET STATE = ? WHERE ID = ?";
    public static final String R_LIMIT_CITY ="SELECT * FROM CITY LIMIT ? , ?";
    public static final String R_VIEW_FLIGHT ="SELECT * FROM VIEW_FLIGHT";
    public static final String C_FLIGHT = "INSERT INTO FLIGHT (TO_CITY,TO_DATE_TIME,FORM_CITY,FORM_DATE_TIME,USED_CAPACITY,STATE,AP_ID) VALUES (?,?,?,?,?,?,?)";
    public static final String U_FLIGHT =  "UPDATE FLIGHT SET TO_CITY = ?,TO_DATE_TIME = ? ,FORM_CITY =? ,FORM_DATE_TIME = ?,USED_CAPACITY =?,AP_ID = ? WHERE ID = ?";
    public static final String U_STATE_FLIGHT = "UPDATE FLIGHT SET STATE = ? WHERE ID = ?";
    public static final String R_FLIGHT ="SELECT * FROM FLIGHT";
    public static final String U_USED_CAPACITY_FLIGHT = "UPDATE FLIGHT SET USED_CAPACITY = ? WHERE ID = ?";
    public static final String R_LIMIT_FLIGHT = "CALL VIEW_FLIGHT_PAGE (?,?)";
    public static final String R_ACOUNT = "SELECT * FROM ACOUNT WHERE EMAIL = ? AND PASSWORD = ?";
    public static final String C_PASSENGER ="INSERT INTO PASSENGER (B_ID,F_NAME,M_NAME,L_NAME,BIRTH,EMAIL,ADDRESS) VALUES (?,?,?,?,?,?,?)";
    public static final String R_PASSENGER = "SELECT * FROM PASSENGER WHERE B_ID = ?";
    public static final String R_VIEW_FLIGHT_DATE_CHAIR ="CALL VIEW_FLIGHT_DATE_CHAIR(?,?,?)";
    public static final String R_VIEW_FLIGHT_DATE_CHAIR_BY_ID = "CALL VIEW_FLIGHT_DATE_CHAIR_BY_ID(?)";
}