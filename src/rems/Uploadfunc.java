/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rems;

import java.net.InetAddress;
import java.util.Arrays;

/**
 *
 * @author richard.adjei-mensah
 */
public class Uploadfunc extends Thread {
    private Thread t;
    private String threadName;
    private InetAddress ftpserverurl;
    private String serverAppDirectory;
    private String PureFileName;
    private String fullLocFileUrl;
    private String userName;
    private String password;

    Uploadfunc(String name, InetAddress ftpSrvrUrl, String srvrAppDirectory, String pureFileNm, String fLocFileUrl, String usrNme, String psswrd) {
        threadName = name;
        ftpserverurl = ftpSrvrUrl;
        serverAppDirectory = srvrAppDirectory;
        PureFileName = pureFileNm;
        fullLocFileUrl = fLocFileUrl;
        userName = usrNme;
        password = psswrd;
        System.setProperty("java.net.preferIPv4Stack" , "true");
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        try {
            Global.UploadFile(ftpserverurl,
                    serverAppDirectory,
                    PureFileName,
                    fullLocFileUrl,
                    userName,
                    password);
        } catch (Exception ex) {
            //write to log file
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.writeToLog();
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            if (Program.thread1.isAlive()) {
                Program.thread1.interrupt();
            }
        } finally {
        }
    }

    @Override
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
