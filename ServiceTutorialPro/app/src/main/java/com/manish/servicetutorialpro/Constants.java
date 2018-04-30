package com.manish.servicetutorialpro;

public class Constants {
    public interface ACTION {
        public static String MAIN_ACTION = "com.manish.servicetutorialpro.action.main";
        public static String PREV_ACTION = "com.manish.servicetutorialpro.action.prev";
        public static String PLAY_ACTION = "com.manish.servicetutorialpro.action.play";
        public static String NEXT_ACTION = "com.manish.servicetutorialpro.action.next";
        public static String STARTFOREGROUND_ACTION = "com.manish.servicetutorialpro.action.startforeground";
        public static String STOPFOREGROUND_ACTION = "com.manish.servicetutorialpro.action.stopforeground";
    }

    public interface NOTIFICATION_ID {
        public static int FOREGROUND_SERVICE = 101;
    }
}
