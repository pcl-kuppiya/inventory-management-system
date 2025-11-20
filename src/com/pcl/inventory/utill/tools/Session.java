package com.pcl.inventory.utill.tools;

public class Session {
   private  static String loggedUserId;
   public static void setLoggedUserId(String loggedUserId) {
       Session.loggedUserId = loggedUserId;
   }
   public static String getLoggedUserId() {
       return loggedUserId;
   }
}
