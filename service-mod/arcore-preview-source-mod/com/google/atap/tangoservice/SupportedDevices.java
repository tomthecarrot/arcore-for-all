/*    */ package com.google.atap.tangoservice;
/*    */ 
/*    */ import android.content.Context;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SupportedDevices
/*    */ {
/* 23 */   private static final String TAG = SupportedDevices.class.getSimpleName();
/*    */   
/*    */   private static boolean deviceCalibrationAvailable() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public static boolean isSupported(Context paramContext) {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public static boolean isSupportedExynosDevice() {
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/SupportedDevices.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */