/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rems;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

/**
 *
 * @author richard.adjei-mensah
 */
public class Program {

    static RqstLstnrUpdtrfunc thread1 = null;   //Updates Process Runner Status
    static GnrtSchldRnsfunc thread2 = null;   //Thread for Generating Run Requests for Scheduled Programs/Reports
    static MntrSchdldRqtsNtRnngfunc thread3 = null; //Thread for Monitoring Scheduled Request Runs that are due but not running
    // and starting their appropriate process runners
    static MntrUsrInitRqtsNtRnngfunc thread4 = null;  //Thread for Monitoring User Request Runs that are due but not running
    // and starting their appropriate process runners
    static RunActualRqtsfunc thread5 = null;  //Thread for running the actual Code behind the Request Run if this is the
    static GnrtSchldAlertsfunc thread6 = null;  //Thread for Generating Run Requests for Alerts
    static MntrSchdldAlertsNtRnngfunc thread7 = null;  //Thread for Monitoring Alert Request Runs that are due but not running
    // and starting their appropriate process runners
    static MntrUserAlertsNtRnngfunc thread8 = null;
    static Uploadfunc thread9 = null;
    static Downloadfunc thread10 = null;

    static String runnerName = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Global.UsrsOrg_ID = 3;
            Global.dataBasDir = "C:\\1_DESIGNS\\MYAPPS\\Enterprise_Management_System\\Enterprise_Management_System\\bin\\Debug\\Images\\test_database";
            Global.rnnrsBasDir = "C:\\1_DESIGNS\\MYAPPS\\Enterprise_Management_System\\Enterprise_Management_System\\bin\\Debug\\bin";

            String pname = ManagementFactory.getRuntimeMXBean().getName();
            if (pname.contains("@")) {
                Global.pid = Integer.parseInt(pname.substring(0, pname.lastIndexOf("@")));
            } else {
                Global.pid = Thread.currentThread().getId();
            }
            Global.HostOSNme = System.getProperty("os.name");
            System.out.println(Global.pid);
            System.out.println(Global.HostOSNme);

            String[] macDet = Global.getMachDetails();
            System.out.println(Arrays.toString(macDet));
            System.out.println(args.length);
            System.out.println(Arrays.toString(args));
            Global.errorLog += Global.pid + System.getProperty("line.separator")
                    + Global.HostOSNme + System.getProperty("line.separator")
                    + Arrays.toString(Global.getMachDetails()) + System.getProperty("line.separator");
            //Global.writeToLog();
            if (args.length >= 8) {
                Global.rnnrsBasDir = StringUtils.strip(args[7], "\"");
                runnerName = StringUtils.strip(args[5], "\"");
                Global.errorLog = args[0] + System.getProperty("line.separator") + args[1] + System.getProperty("line.separator") + args[2] + System.getProperty("line.separator")
                        + "********************" + System.getProperty("line.separator") + args[4] + System.getProperty("line.separator") + args[5]
                        + System.getProperty("line.separator") + args[6] + System.getProperty("line.separator") + Global.rnnrsBasDir + System.getProperty("line.separator");

                if (args.length >= 10) {
                    Global.callngAppType = StringUtils.strip(args[8], "\"");
                    Global.dataBasDir = StringUtils.strip(args[9], "\"");
                    Global.errorLog += args[8] + System.getProperty("line.separator") + args[9] + System.getProperty("line.separator");
                    if (args.length == 11) {
                        Global.AppUrl = StringUtils.strip(args[10], "\"");
                        Global.errorLog += args[10] + System.getProperty("line.separator");
                    }
                }
                Global.errorLog += "PID: " + Global.pid + " Running on: " + macDet[0] + " / " + macDet[1] + " / " + macDet[2];
                Global.writeToLog();
                Global.runID = Long.valueOf(args[6]);
                do_connection(args[0], args[1], args[2], args[3], args[4]);
                Global.appStatPath = Global.rnnrsBasDir;
                //Program.updateRates("2015-07-02");
                if (Global.runID > 0) {
                    Global.rnUser_ID = Long.valueOf(Global.getGnrlRecNm("rpt.rpt_report_runs", "rpt_run_id", "run_by", Global.runID));
                    Global.UsrsOrg_ID = Global.getUsrOrgID(Global.rnUser_ID);
                }

                if (!Global.globalSQLConn.isClosed()) {
                    Global.globalSQLConn.close();
                    boolean isLstnrRnng = false;
                    if (Program.runnerName.equals("REQUESTS LISTENER PROGRAM")) {
                        int isIPAllwd = Global.getEnbldPssblValID(macDet[2],
                                Global.getEnbldLovID("Allowed IP Address for Request Listener"));
                        int isDBAllwd = Global.getEnbldPssblValID(Global.Dbase,
                                Global.getEnbldLovID("Allowed DB Name for Request Listener"));
                        if (isIPAllwd <= 0 || isDBAllwd <= 0) {
                            Program.killThreads();
                            Thread.currentThread().interrupt();
                            //Program.killThreads();
                            return;
                        }

                        isLstnrRnng = Global.isRunnrRnng(Program.runnerName);
                        if (isLstnrRnng == true) {
                            Program.killThreads();
                            Thread.currentThread().interrupt();
                            //Program.killThreads();
                            return;
                        }
                    }
                    Global.errorLog = "Successfully Connected to Database\r\n" + String.valueOf(isLstnrRnng) + System.getProperty("line.separator");
                    Global.writeToLog();
                    String rnnPryty = Global.getGnrlRecNm("rpt.rpt_prcss_rnnrs", "rnnr_name", "crnt_rnng_priority", Program.runnerName);

                    if (isLstnrRnng == false && Program.runnerName.equals("REQUESTS LISTENER PROGRAM")) {
                        Global.updatePrcsRnnrCmd(Program.runnerName, "0", -1);
                        thread1 = new RqstLstnrUpdtrfunc("ThreadOne");
                        thread1.setDaemon(true);
                        thread1.setName("ThreadOne");
                        thread1.setPriority(Thread.MIN_PRIORITY);
                        //System.out.println("Starting ThreadOne thread...");
                        thread1.start();
                        Global.minimizeMemory();
                        if (Program.runnerName.equals("REQUESTS LISTENER PROGRAM")) {
                            //Thread for Generating Run Requests for Scheduled Programs/Reports
                            thread2 = new GnrtSchldRnsfunc("ThreadTwo");
                            thread2.setDaemon(true);
                            thread2.setName("ThreadTwo");
                            thread2.setPriority(Thread.MIN_PRIORITY);
                            //System.out.println("Starting ThreadTwo thread...");
                            thread2.start();

                            //Thread for Generating Run Requests for Scheduled Alerts
                            thread6 = new GnrtSchldAlertsfunc("ThreadSix");
                            thread6.setDaemon(true);
                            thread6.setName("ThreadSix");
                            thread6.setPriority(Thread.MIN_PRIORITY);
                            //System.out.println("Starting ThreadSix thread...");
                            thread6.start();

                            //Thread for Monitoring Scheduled Request Runs that are due but not running
                            // and starting their appropriate process runners
                            thread3 = new MntrSchdldRqtsNtRnngfunc("ThreadThree");
                            thread3.setDaemon(true);
                            thread3.setName("ThreadThree");
                            thread3.setPriority(Thread.MIN_PRIORITY);
                            //System.out.println("Starting ThreadThree thread...");
                            thread3.start();

                            //Thread for Monitoring User Request Runs that are due but not running
                            // and starting their appropriate process runners
                            thread4.setDaemon(true);
                            thread4.setName("ThreadFour");
                            thread4.setPriority(Thread.MIN_PRIORITY);
                            //System.out.println("Starting ThreadFour thread...");
                            thread4.start();

                            //Thread for Generating Run Requests for Scheduled Alerts
                            thread7 = new MntrSchdldAlertsNtRnngfunc("ThreadSeven");
                            thread7.setDaemon(true);
                            thread7.setName("ThreadSeven");
                            thread7.setPriority(Thread.MIN_PRIORITY);
                            //System.out.println("Starting ThreadSeven thread...");
                            thread7.start();

                            //Thread for Running Requests for User Initiated Alerts
                            thread8 = new MntrUserAlertsNtRnngfunc("ThreadEight");
                            thread8.setDaemon(true);
                            thread8.setName("ThreadEight");
                            thread8.setPriority(Thread.MIN_PRIORITY);
                            //System.out.println("Starting ThreadEight thread...");
                            thread8.start();
                        }
                    } else {
                        //Thread for running the actual Code behind the Request Run if this is the
                        //Program supposed to run that request
                        //i.e. if Global.runID >0
                        Global.minimizeMemory();
                        if (Global.runID > 0) {
                            thread1 = new RqstLstnrUpdtrfunc("ThreadOne");
                            thread1.setDaemon(true);
                            thread1.setName("ThreadOne");
                            thread1.setPriority(Thread.MIN_PRIORITY);
                            //System.out.println("Starting ThreadOne thread...");
                            thread1.start();

                            thread5 = new RunActualRqtsfunc("ThreadFive");
                            thread5.setDaemon(true);
                            thread5.setName("ThreadFive");
                            //System.out.println("Starting ThreadFive thread...");
                            if (rnnPryty.equals("1-Highest")) {
                                thread1.setPriority(Thread.MAX_PRIORITY);
                            } else if (rnnPryty.equals("2-AboveNormal")) {
                                thread1.setPriority(7);
                            } else if (rnnPryty.equals("3-Normal")) {
                                thread1.setPriority(Thread.NORM_PRIORITY);
                            } else if (rnnPryty.equals("4-BelowNormal")) {
                                thread1.setPriority(3);
                            } else {
                                thread1.setPriority(1);
                            }
                            thread5.start();
                        }
                        // Allow counting for 10 seconds.
                        //Thread.Sleep(1000);
                    }
                }
            }
        } catch (NumberFormatException ex) {
            Global.errorLog = ex.getMessage() + System.getProperty("line.separator") + Arrays.toString(ex.getStackTrace());
            String fileLoc = Global.rnnrsBasDir + "/log_files/";
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("ddMMMyyyyHHmmss");
            fileLoc += "Global.errorLog" + ft.format(dNow.getTime()) + ".rho";
            PrintWriter fileWriter;
            try {
                fileWriter = new PrintWriter(fileLoc, "UTF-8");
                fileWriter.println(Global.errorLog);
                fileWriter.close();
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (UnsupportedEncodingException ex1) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex1);
            }
            killThreads();
        } catch (SQLException ex) {
            Global.errorLog = ex.getMessage() + System.getProperty("line.separator") + Arrays.toString(ex.getStackTrace());
            String fileLoc = Global.rnnrsBasDir + "/log_files/";
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("ddMMMyyyyHHmmss");
            fileLoc += "Global.errorLog" + ft.format(dNow.getTime()) + ".rho";
            PrintWriter fileWriter;
            try {
                fileWriter = new PrintWriter(fileLoc, "UTF-8");
                fileWriter.println(Global.errorLog);
                fileWriter.close();
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (UnsupportedEncodingException ex1) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex1);
            }
            killThreads();
        } finally {

        }
    }

    static void gnrtAlertMailerfunc(long rptID, long runBy, int alertID, long msgSentID,
            String prmIDs, String prmVals, String outputUsd, String orntnUsd) {
        try {
            String dateStr = Global.getDB_Date_time();
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Calendar bdte2 = Calendar.getInstance();
            bdte2.setTime(frmtr1.parse(dateStr));
            bdte2.add(Calendar.MINUTE, -1);
            bdte2.add(Calendar.SECOND, -59);
            Global.errorLog += bdte2;
            dateStr = frmtr1.format(bdte2.getTime());

            Global.createSchdldRptRn(
                    runBy, dateStr,
                    rptID, prmIDs, prmVals, outputUsd, orntnUsd, alertID, msgSentID);

            //Thread.Sleep(5000);
            long rptRunID = Global.getRptRnID(rptID, runBy, dateStr);

            long msg_id = Global.getLogMsgID("rpt.rpt_run_msgs",
                    "Process Run", rptRunID);
            if (msg_id <= 0) {
                Global.createLogMsg(dateStr
                        + " .... Alert Run is about to Start...(Being run by "
                        + Global.get_user_name(runBy) + ")",
                        "rpt.rpt_run_msgs", "Process Run", rptRunID, dateStr);
            }
        } catch (Exception ex) {
            //write to log file
            Global.errorLog += ex.getMessage() + System.getProperty("line.separator") + Arrays.toString(ex.getStackTrace()) + System.getProperty("line.separator");
            Global.writeToLog();
            if (thread6.isAlive()) {
                thread6.interrupt();
            }
        } finally {
        }
    }

    static void do_connection(String hostnm, String prtnum, String uname, String pwd, String dbase) {
        try {
            if (pwd.contains("(E)")) {
                pwd = Global.decrypt(pwd.replace("(E)", ""), Global.AppKey);
            }
            Global.connStr
                    = "jdbc:postgresql://" + hostnm + ":" + prtnum + "/" + dbase + "";

            Class.forName("org.postgresql.Driver");
            Global.globalSQLConn = DriverManager.getConnection(Global.connStr,
                    uname, pwd);
            Global.globalSQLConn.setAutoCommit(false);

            Global.Hostnme = hostnm;
            Global.Portnum = prtnum;
            Global.Uname = uname;
            Global.Pswd = pwd;
            Global.Dbase = dbase;
            int lvid = Global.getLovID("Security Keys");
            String apKey = Global.getEnbldPssblValDesc(
                    "AppKey", lvid);

            if (!apKey.equals("") && lvid > 0) {
                Global.AppKey = apKey;
            } else {
                Global.AppKey = "ROMeRRTRREMhbnsdGeneral KeyZzfor Rhomi|com Systems "
                        + "Tech. !Ltd Enterpise/Organization @763542ERPorbjkSOFTWARE"
                        + "asdbhi68103weuikTESTfjnsdfRSTLU../";
            }
        } catch (ClassNotFoundException ex) {
            Global.errorLog = ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n\r\n";
            Global.writeToLog();
            killThreads();
        } catch (SQLException ex) {
            Global.errorLog = ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n\r\n";
            Global.writeToLog();
            killThreads();
        } finally {
        }
    }

    static void checkNClosePrgrm() {
        String shdRnnrStop = Global.getGnrlRecNm("rpt.rpt_prcss_rnnrs", "rnnr_name", "shld_rnnr_stop", Program.runnerName);

        String shdRnIDStop = "0";
        if (Global.runID > 0) {
            shdRnIDStop = Global.getGnrlRecNm("rpt.rpt_report_runs",
                    "trim(to_char(rpt_run_id,'999999999999999999999'))",
                    "shld_run_stop", String.valueOf(Global.runID));
        }
        if (shdRnnrStop.equals("1") || shdRnIDStop.equals("1")) {
            Global.updateRptRn(Global.runID, "Cancelled!", 100);
            killThreads();
        }
    }

    static void updatePrgrm(long prgmID) {
        Global.minimizeMemory();

        String shdRnnrStop = Global.getGnrlRecNm("rpt.rpt_prcss_rnnrs", "rnnr_name", "shld_rnnr_stop", Program.runnerName);

        String shdRnIDStop = "0";
        int rnnrStatusPcnt = 0;
        if (Global.runID > 0) {
            shdRnIDStop = Global.getGnrlRecNm("rpt.rpt_report_runs",
                    "trim(to_char(rpt_run_id,'999999999999999999999'))",
                    "shld_run_stop", String.valueOf(Global.runID));
            rnnrStatusPcnt = Integer.parseInt(Global.getGnrlRecNm("rpt.rpt_report_runs",
                    "trim(to_char(rpt_run_id,'999999999999999999999'))",
                    "run_status_prct", String.valueOf(Global.runID)));
        }
        if (shdRnnrStop.equals("1") || shdRnIDStop.equals("1") || Global.mustStop == true) {
            Global.updateRptRn(Global.runID, "Cancelled!", 100);
            killThreads();
            return;
        }
        if (rnnrStatusPcnt >= 100) {
            killThreads();
            return;
        }

        if (prgmID > 0) {
            try {
                String dtestr = Global.getDB_Date_time();
                String[] macDet = Global.getMachDetails();
                //String hndle = System.Diagnostics.Process.GetCurrentProcess().HandlString.valueOf(e);
                //"Handle: " + hndle +
                Thread.sleep(2000);
                Global.updatePrcsRnnr(prgmID, dtestr, "PID: " + Global.pid + " Running on: " + macDet[0] + " / " + macDet[1] + " / " + macDet[2]);
                if (Global.runID > 0) {
                    Global.updateRptRnActvTme(Global.runID, dtestr);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    static void killThreads() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Global.mustStop = true;
            Global.minimizeMemory();
            if (thread1.isAlive()) {
                thread1.interrupt();
            }
            if (thread8.isAlive()) {
                thread8.interrupt();
            }
            if (thread7.isAlive()) {
                thread7.interrupt();
            }
            if (thread6.isAlive()) {
                thread6.interrupt();
            }
            if (thread5.isAlive()) {
                thread5.interrupt();
            }
            if (thread4.isAlive()) {
                thread4.interrupt();
            }
            if (thread3.isAlive()) {
                thread3.interrupt();
            }
            if (thread2.isAlive()) {
                thread2.interrupt();
            }
            if (Thread.currentThread().isAlive()) {
                Thread.currentThread().interrupt();
            }
            if (SystemUtils.IS_OS_LINUX) {
                Process rt = Runtime.getRuntime().exec("kill -9 " + String.valueOf(Global.pid));
            } else if (SystemUtils.IS_OS_WINDOWS) {
                Process rt = Runtime.getRuntime().exec("taskkill /F /PID " + String.valueOf(Global.pid));
            }
        } catch (Exception ex) {
            if (SystemUtils.IS_OS_LINUX) {
                try {
                    Process rt = Runtime.getRuntime().exec("kill -9 " + String.valueOf(Global.pid));
                } catch (IOException ex1) {
                    Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } else if (SystemUtils.IS_OS_WINDOWS) {
                try {
                    Process rt = Runtime.getRuntime().exec("taskkill /F /PID " + String.valueOf(Global.pid));
                } catch (IOException ex1) {
                    Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } finally {
            if (SystemUtils.IS_OS_LINUX) {
                try {
                    Process rt = Runtime.getRuntime().exec("kill -9 " + String.valueOf(Global.pid));
                } catch (IOException ex) {
                    Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (SystemUtils.IS_OS_WINDOWS) {
                try {
                    Process rt = Runtime.getRuntime().exec("taskkill /F /PID " + String.valueOf(Global.pid));
                } catch (IOException ex) {
                    Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static String[] breakDownStr(String inStr, int maxWidth, int maxHeight, Graphics g, float mxTxtWdth) {
        String[] nwStr = new String[maxHeight];
        int hghtCntr = 0;
        if (maxWidth < 3 && maxWidth > 1) {
            maxWidth = 3;
        } else if (maxWidth == 1) {
            maxWidth = 1;
            for (int c = 0; c < maxHeight; c++) {
                nwStr[c] += StringUtils.rightPad("", maxWidth, ' ');
            }
            return nwStr;
        }

        inStr = inStr.replace("\r\n", "");
        inStr = inStr.replace("\n", "");
        //String steps = "";
        for (int c = 0; c < maxHeight; c++) {
            nwStr[c] += StringUtils.rightPad("", maxWidth, ' ');
        }
        Font nwFont = new Font("Courier New", Font.PLAIN, 11);
        String[] mystr = Global.breakTxtDown(inStr,
                mxTxtWdth, nwFont, g);
        for (int c = 0; c < mystr.length; c++) {
            nwStr[c] = StringUtils.rightPad(mystr[c], maxWidth, ' ');
            if (c >= maxHeight - 1) {
                return nwStr;
            }
        }
        return nwStr;
    }

    private static boolean mustColBeGrpd(String colNo, String[] colsToGrp) {
        for (int i = 0; i < colsToGrp.length; i++) {
            if (colNo.equals(colsToGrp[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean mustColBeCntd(String colNo, String[] colsToCnt) {
        for (int i = 0; i < colsToCnt.length; i++) {
            if (colNo.equals(colsToCnt[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean mustColBeSumd(String colNo, String[] colsToSum) {
        for (int i = 0; i < colsToSum.length; i++) {
            if (colNo.equals(colsToSum[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean mustColBeAvrgd(String colNo, String[] colsToAvrg) {
        for (int i = 0; i < colsToAvrg.length; i++) {
            if (colNo.equals(colsToAvrg[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean mustColBeFrmtd(String colNo, String[] colsToFrmt) {
        for (int i = 0; i < colsToFrmt.length; i++) {
            if (colNo.equals(colsToFrmt[i])) {
                return true;
            }
        }
        return false;
    }

    public static String formatDtSt(ResultSet dtst, String rptTitle, String[] colsToGrp,
            String[] colsToCnt, String[] colsToSum, String[] colsToAvrg, String[] colsToFrmt) {
        try {
            DecimalFormat myFormatter = new DecimalFormat("###,##0.00");
            DecimalFormat myFormatter2 = new DecimalFormat("###,##0");
            String finalStr = rptTitle.toUpperCase();
            finalStr += "\r\n\r\n";
            ResultSetMetaData dtstmd = dtst.getMetaData();
            dtst.last();
            int ttlRws = dtst.getRow();
            dtst.beforeFirst();
            int colCnt = dtstmd.getColumnCount();

            long[] colcntVals = new long[colCnt];
            double[] colsumVals = new double[colCnt];
            double[] colavrgVals = new double[colCnt];
            finalStr += "|";
            for (int f = 0; f < colCnt; f++) {
                int colLen = dtstmd.getColumnName(f + 1).length();
                if (colLen >= 3) {
                    finalStr += StringUtils.rightPad("=", colLen, '=');
                    finalStr += "|";
                }
            }
            finalStr += "\r\n";
            finalStr += "|";
            for (int e = 0; e < colCnt; e++) {
                int colLen = dtstmd.getColumnName(e + 1).length();
                if (colLen >= 3) {
                    if (Program.mustColBeFrmtd(String.valueOf(e), colsToFrmt) == true) {
                        finalStr += StringUtils.leftPad(dtstmd.getColumnName(e + 1).substring(0, colLen - 2).trim(), colLen, ' ');
                    } else {
                        finalStr += StringUtils.leftPad(dtstmd.getColumnName(e + 1).substring(0, colLen - 2), colLen, ' ');
                    }
                    finalStr += "|";
                }
            }
            finalStr += "\r\n";
            finalStr += "|";
            for (int f = 0; f < colCnt; f++) {
                int colLen = dtstmd.getColumnName(f + 1).length();
                if (colLen >= 3) {
                    finalStr += StringUtils.rightPad("=", colLen, '=');
                    finalStr += "|";
                }
            }
            finalStr += "\r\n";
            String[][] prevRowVal = new String[ttlRws][colCnt];
            for (int i = 0; i < ttlRws; i++) {
                String[][] lineFormat = new String[colCnt][];
                dtst.next();
                for (int a = 0; a < colCnt; a++) {
                    double nwval = 0;
                    prevRowVal[i][a] = dtst.getString(a + 1);

                    boolean mstgrp = mustColBeGrpd(String.valueOf(a), colsToGrp);
                    if (mustColBeCntd(String.valueOf(a), colsToCnt) == true) {
                        if ((i > 0) && (prevRowVal[i - 1][a].equals(dtst.getString(a + 1)))
                                && (mstgrp == true)) {
                        } else {
                            colcntVals[a] += 1;
                        }
                    } else if (mustColBeSumd(String.valueOf(a), colsToSum) == true) {
                        nwval = Double.parseDouble(dtst.getString(a + 1));
                        if ((i > 0) && (prevRowVal[i - 1][a].equals(dtst.getString(a + 1)))
                                && (mstgrp == true)) {
                        } else {
                            colsumVals[a] += nwval;
                        }
                    } else if (mustColBeAvrgd(String.valueOf(a), colsToAvrg) == true) {
                        nwval = Double.parseDouble(dtst.getString(a + 1));
                        if ((i > 0) && (prevRowVal[i - 1][a].equals(dtst.getString(a + 1)))
                                && (mstgrp == true)) {
                        } else {
                            colcntVals[a] += 1;
                            colsumVals[a] += nwval;
                        }
                    }

                    int colLen = dtstmd.getColumnName(a + 1).length();
                    String[] arry;
                    BufferedImage bi;
                    Graphics g; // stands for Buffered Image Graphics
                    Toolkit toolkit;
                    MediaTracker tracker;
                    if (colLen >= 3) {
                        if ((i > 0) && (prevRowVal[i - 1][a].equals(dtst.getString(a + 1)))
                                && (mustColBeGrpd(String.valueOf(a), colsToGrp) == true)) {
                            toolkit = Toolkit.getDefaultToolkit();
                            Image img = toolkit.getImage(Global.appStatPath + "/staffs.png");
                            Font nwFont = new Font("Courier New", 11, Font.PLAIN);
                            bi = new BufferedImage(70, 70, BufferedImage.TYPE_INT_RGB);
                            g = bi.getGraphics();
                            float ght = (float) g.getFontMetrics(nwFont).stringWidth(StringUtils.rightPad(dtstmd.getColumnName(a + 1).trim(), colLen, '='));
                            float ght1 = (float) g.getFontMetrics(nwFont).stringWidth("=");
                            arry = breakDownStr("    ", colLen, 25, g, ght - ght1);
                        } else {
                            toolkit = Toolkit.getDefaultToolkit();
                            Image img = toolkit.getImage(Global.appStatPath + "/staffs.png");
                            Font nwFont = new Font("Courier New", 11, Font.PLAIN);
                            bi = new BufferedImage(70, 70, BufferedImage.TYPE_INT_RGB);
                            g = bi.getGraphics();
                            float ght = (float) g.getFontMetrics(nwFont).stringWidth(StringUtils.rightPad(dtstmd.getColumnName(a + 1).trim(), colLen, '='));
                            float ght1 = (float) g.getFontMetrics(nwFont).stringWidth("=");
                            arry = breakDownStr(dtst.getString(a + 1),
                                    colLen, 25, g, ght - ght1);
                        }
                        lineFormat[a] = arry;
                    }
                }
                String frshLn = "";
                for (int c = 0; c < 25; c++) {
                    String frsh = "|";
                    for (int b = 0; b < colCnt; b++) {
                        int colLen = dtstmd.getColumnName(b + 1).length();
                        if (colLen >= 3) {
                            if (Program.mustColBeFrmtd(String.valueOf(b), colsToFrmt) == true) {
                                double num = Double.parseDouble(lineFormat[b][c].trim());
                                if (!lineFormat[b][c].trim().equals("")) {
                                    frsh += StringUtils.leftPad(myFormatter.format(num), colLen, ' ').substring(0, colLen);//.trim().PadRight(60, ' ')
                                } else {
                                    frsh += lineFormat[b][c].substring(0, colLen); //.trim().PadRight(60, ' ')
                                }
                            } else {
                                frsh += lineFormat[b][c].substring(0, colLen); //.trim().PadRight(60, ' ')
                            }
                            frsh += "|";
                        }
                    }
                    String nwtst = frsh;
                    frsh += "\r\n";
                    if (nwtst.replace("|", " ").trim().equals("")) {
                        c = 24;
                    } else {
                        frshLn += frsh;
                    }
                }
                finalStr += frshLn;
            }
            finalStr += "\r\n";
            finalStr += "|";
            for (int f = 0; f < colCnt; f++) {
                int colLen = dtstmd.getColumnName(f + 1).length();
                if (colLen >= 3) {
                    finalStr += StringUtils.rightPad("=", colLen, '=');
                    finalStr += "|";
                }
            }
            finalStr += "\r\n";
            finalStr += "|";
            //Populate Counts/Sums/Averages
            for (int f = 0; f < colCnt; f++) {
                int colLen = dtstmd.getColumnName(f + 1).length();
                if (colLen >= 3) {
                    if (mustColBeCntd(String.valueOf(f), colsToCnt) == true) {
                        if (mustColBeFrmtd(String.valueOf(f), colsToFrmt) == true) {
                            finalStr += "Count = " + StringUtils.leftPad(myFormatter2.format(colcntVals[f]), colLen, ' ').substring(0, colLen);
                        } else {
                            finalStr += "Count = " + StringUtils.rightPad(String.valueOf(colcntVals[f]), colLen, ' ').substring(0, colLen);
                        }
                    } else if (mustColBeSumd(String.valueOf(f), colsToSum) == true) {
                        if (mustColBeFrmtd(String.valueOf(f), colsToFrmt) == true) {
                            finalStr += "Sum = " + StringUtils.leftPad(myFormatter.format(colsumVals[f]), colLen, ' ').substring(0, colLen);
                        } else {
                            finalStr += "Sum = " + StringUtils.rightPad(String.valueOf(colsumVals[f]), colLen, ' ').substring(0, colLen);
                        }
                    } else if (mustColBeAvrgd(String.valueOf(f), colsToAvrg) == true) {
                        if (mustColBeFrmtd(String.valueOf(f), colsToFrmt) == true) {
                            finalStr += "Average = " + StringUtils.leftPad((myFormatter.format(colsumVals[f] / colcntVals[f])), colLen, ' ').substring(0, colLen);
                        } else {
                            finalStr += "Average = " + StringUtils.rightPad((String.valueOf(colsumVals[f] / colcntVals[f])), colLen, ' ').substring(0, colLen);
                        }
                    } else {
                        finalStr += StringUtils.rightPad(" ", colLen, ' ').substring(0, colLen);
                    }
                    finalStr += "|";
                }
            }
            finalStr += "\r\n";
            finalStr += "|";
            for (int f = 0; f < colCnt; f++) {
                int colLen = dtstmd.getColumnName(f + 1).length();
                if (colLen >= 3) {
                    finalStr += StringUtils.rightPad("-", colLen, '-').substring(0, colLen);
                    finalStr += "|";
                }
            }
            finalStr += "\r\n";
            return finalStr;
        } catch (SQLException ex) {
            return "";
        } catch (NumberFormatException ex) {
            return "";
        }
    }

    static void writeAFile(String fullfilenm, String cntnt) {
        try {
            File file = new File(fullfilenm);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(cntnt);
            bw.close();
        } catch (Exception ex) {
        } finally {
        }
    }

    public static void validateBatchNPost(long glBatchID, String batchStatus,
            String batchSource,
            long msg_id, String log_tbl, String dateStr) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd");

            Global.updtActnPrcss(5);
            batchStatus = Global.getGnrlRecNm("accb.accb_trnsctn_batches",
                    "batch_id", "batch_status", glBatchID);
            if (batchStatus.equals("1")) {
                Global.updateLogMsg(msg_id,
                        "\r\nCannot Post an already Posted Batch of Transactions!\r\n",
                        log_tbl, dateStr, Global.rnUser_ID);

                return;
            }
            int suspns_accnt = Global.get_Suspns_Accnt(Global.UsrsOrg_ID);
            ResultSet dteDtSt = Global.get_Batch_dateSums(glBatchID);
            dteDtSt.last();
            int ttlRows = dteDtSt.getRow();
            dteDtSt.beforeFirst();
            if (ttlRows > 0 && suspns_accnt > 0) {
                String msg1 = "";
                for (int i = 0; i < ttlRows; i++) {
                    dteDtSt.next();
                    double dlyDbtAmnt = Double.parseDouble(dteDtSt.getString(2));
                    double dlyCrdtAmnt = Double.parseDouble(dteDtSt.getString(3));
                    int orgID = Global.UsrsOrg_ID;
                    if (dlyDbtAmnt != dlyCrdtAmnt) {
                        long suspns_batch_id = glBatchID;
                        int funcCurrID = Global.getOrgFuncCurID(orgID);
                        BigDecimal dffrnc = BigDecimal.valueOf(dlyDbtAmnt - dlyCrdtAmnt);
                        String incrsDcrs = "D";
                        if (dffrnc.compareTo(BigDecimal.valueOf(0.00)) < 0) {
                            incrsDcrs = "I";
                        }
                        BigDecimal imbalAmnt = dffrnc.abs();
                        double netAmnt = (double) Global.dbtOrCrdtAccntMultiplier(suspns_accnt,
                                incrsDcrs) * imbalAmnt.doubleValue();

                        String dateStr1 = frmtr.format(frmtr1.parse(dteDtSt.getString(1)).getTime()) + " 00:00:00";

                        if (Global.dbtOrCrdtAccnt(suspns_accnt, incrsDcrs).equals("Debit")) {
                            Global.createTransaction(suspns_accnt,
                                    "Correction of Imbalance in GL Batch " + Global.getGnrlRecNm("accb.accb_trnsctn_batches",
                                            "batch_id", "batch_name", glBatchID) + " as at " + dateStr1, imbalAmnt.doubleValue(),
                                    dateStr1, funcCurrID, suspns_batch_id, 0.00, netAmnt,
                                    imbalAmnt.doubleValue(),
                                    funcCurrID,
                                    imbalAmnt.doubleValue(),
                                    funcCurrID,
                                    (double) 1,
                                    (double) 1, "D");
                        } else {
                            Global.createTransaction(suspns_accnt,
                                    "Correction of Imbalance in GL Batch " + Global.getGnrlRecNm("accb.accb_trnsctn_batches",
                                            "batch_id", "batch_name", glBatchID) + " as at " + dateStr1, 0.00,
                                    dateStr1, funcCurrID,
                                    suspns_batch_id,
                                    imbalAmnt.doubleValue(),
                                    netAmnt,
                                    imbalAmnt.doubleValue(),
                                    funcCurrID,
                                    imbalAmnt.doubleValue(),
                                    funcCurrID,
                                    (double) 1,
                                    (double) 1, "C");
                        }
                    }
                }
            } else {
                //Global.mnFrm.cmCde.showMsg("There's no Imbalance to correct!", 0);
                //return;
            }

            if (Global.get_Batch_CrdtSum(glBatchID) != Global.get_Batch_DbtSum(glBatchID)) {
                Global.updateLogMsg(msg_id,
                        "\r\nCannot Post an Unbalanced Batch of Transactions!\r\n",
                        log_tbl, dateStr, Global.rnUser_ID);
                return;
            }

            Global.updtActnPrcss(5);
            ResultSet dtst = Global.get_Batch_Trns_NoStatus(glBatchID);
            dtst.last();
            long ttltrns = dtst.getRow();
            dtst.beforeFirst();
            if (ttltrns <= 0 && !batchSource.equals("Period Close Process")) {
                Global.updateLogMsg(msg_id,
                        "\r\nOnly Period Close Process Batches can be posted when the batch has no transactions!\r\n",
                        log_tbl, dateStr, Global.rnUser_ID);
                return;
            }
            int ret_accnt = Global.get_Rtnd_Erngs_Accnt(Global.UsrsOrg_ID);
            int net_accnt = Global.get_Net_Income_Accnt(Global.UsrsOrg_ID);
            if (ret_accnt == -1) {
                Global.updateLogMsg(msg_id,
                        "\r\nUntil a Retained Earnings Account is defined\r\n no Transaction can be posted into the Accounting!\r\n",
                        log_tbl, dateStr, Global.rnUser_ID);
                return;
            }
            if (net_accnt == -1) {
                Global.updateLogMsg(msg_id,
                        "\r\nUntil a Net Income Account is defined\r\n no Transaction can be posted into the Accounting!\r\n",
                        log_tbl, dateStr, Global.rnUser_ID);
                return;
            }
            Global.updtActnPrcss(5);

            ResultSet dteDtSt1 = Global.get_Batch_dateSums(glBatchID);
            dteDtSt1.last();
            int dteDtSt1Ttl = dteDtSt1.getRow();
            dteDtSt1.beforeFirst();
            if (dteDtSt1Ttl > 0) {
                String msg1 = "Your transactions will cause your Balance Sheet to become Unbalanced on some Days!"
                        + "Please make sure each day has equal debits and credits. Check the ff Days:" + "\r\n";
                for (int i = 0; i < dteDtSt1Ttl; i++) {
                    dteDtSt1.next();
                    msg1 = msg1 + dteDtSt1.getString(1) + "\t DR="
                            + dteDtSt1.getString(2) + "\t CR="
                            + dteDtSt1.getString(3) + "\r\n";
                }
                Global.updateLogMsg(msg_id,
                        "\r\n" + msg1 + "!\r\n",
                        log_tbl, dateStr, Global.rnUser_ID);
                return;
            }
            int funCurID = Global.getOrgFuncCurID(Global.UsrsOrg_ID);
            Global.updtActnPrcss(5);
            Program.postGLBatch(glBatchID,
                    batchSource,
                    msg_id, log_tbl, dateStr, net_accnt, funCurID);
        } catch (SQLException ex) {
        } catch (NumberFormatException ex) {
        } catch (ParseException ex) {
        }
    }

    private static boolean postIntoSuspnsAccnt(BigDecimal aeVal, BigDecimal crlVal, int orgID, boolean isspcl, String[] errmsg) {
        try {
            int suspns_accnt = Global.get_Suspns_Accnt(orgID);
            int net_accnt = Global.get_Net_Income_Accnt(orgID);
            int ret_accnt = Global.get_Rtnd_Erngs_Accnt(orgID);

            if (suspns_accnt == -1) {
                errmsg[0] += "Please define a suspense Account First before imbalance can be Auto-Corrected!";
                return false;
            }
            long suspns_batch_id = -999999991;
            int funcCurrID = Global.getOrgFuncCurID(orgID);
            BigDecimal dffrnc = aeVal.subtract(crlVal);
            String incrsDcrs = "D";
            if (dffrnc.compareTo(BigDecimal.valueOf(0.00)) < 0) {
                incrsDcrs = "I";
            }
            BigDecimal imbalAmnt = dffrnc.abs();
            double netAmnt = (double) Global.dbtOrCrdtAccntMultiplier(suspns_accnt,
                    incrsDcrs) * imbalAmnt.doubleValue();
            String dateStr = Global.getFrmtdDB_Date_time();
            if (!Global.isTransPrmttd(suspns_accnt, dateStr, netAmnt, errmsg)) {
                return false;
            }

            if (Global.dbtOrCrdtAccnt(suspns_accnt, incrsDcrs).equals("Debit")) {
                Global.createTransaction(suspns_accnt,
                        "Correction of Imbalance as at " + dateStr, imbalAmnt.doubleValue(),
                        dateStr, funcCurrID, suspns_batch_id, 0.00, netAmnt,
                        imbalAmnt.doubleValue(),
                        funcCurrID,
                        imbalAmnt.doubleValue(),
                        funcCurrID,
                        (double) 1,
                        (double) 1, "D");
            } else {
                Global.createTransaction(suspns_accnt,
                        "Correction of Imbalance as at " + dateStr, 0.00,
                        dateStr, funcCurrID,
                        suspns_batch_id, imbalAmnt.doubleValue(), netAmnt,
                        imbalAmnt.doubleValue(),
                        funcCurrID,
                        imbalAmnt.doubleValue(),
                        funcCurrID,
                        (double) 1,
                        (double) 1, "C");
            }

            ResultSet dtst = Global.get_Batch_Trns(suspns_batch_id);
            dtst.last();
            int dtstTtl = dtst.getRow();
            dtst.beforeFirst();

            for (int i = 0; i < dtstTtl; i++) {
                dtst.next();
                boolean hsBnUpdt = Global.hsTrnsUptdAcntBls(
                        Long.parseLong(dtst.getString(1)),
                        dtst.getString(7),
                        Integer.parseInt(dtst.getString(10)));
                if (hsBnUpdt == false) {
                    double dbt1 = Double.parseDouble(dtst.getString(5));
                    double crdt1 = Double.parseDouble(dtst.getString(6));
                    double net1 = Double.parseDouble(dtst.getString(11));

                    Global.postTransaction(
                            Integer.parseInt(dtst.getString(10)),
                            dbt1,
                            crdt1,
                            net1,
                            dtst.getString(7),
                            Long.parseLong(dtst.getString(1)));
                    Global.chngeTrnsStatus(Long.parseLong(dtst.getString(1)), "1");
                }
            }
            Program.reloadAcntChrtBals(suspns_batch_id, net_accnt);
            return true;
        } catch (SQLException ex) {
            errmsg[0] += ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace());
            return false;
        } catch (NumberFormatException ex) {
            errmsg[0] += ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace());
            return false;
        }
    }

    private static void postGLBatch(long glBatchID,
            String btchSrc,
            long msg_id, String log_tbl, String dateStr, int net_accnt, int funCurID) {
        try {
            //String dateStr1 = Global.getFrmtdDB_Date_time();
            String log_tbl1 = "accb.accb_post_trns_msgs";
            long msg_id1 = Global.getLogMsgID(log_tbl1,
                    "Posting Batch of Transactions", glBatchID);
            if (msg_id1 <= 0) {
                Global.createLogMsg(dateStr + " ....Automatic Posting Batch of Transactions is about to Start...",
                        log_tbl1, "Posting Batch of Transactions", glBatchID, dateStr);
            }
            msg_id1 = Global.getLogMsgID(log_tbl1, "Posting Batch of Transactions",
                    glBatchID);

            Global.updateLogMsg(msg_id,
                    "\r\n\r\n ....Automatic Posting Batch of Transactions is about to Start...!\r\n",
                    log_tbl, dateStr, Global.rnUser_ID);

            double aesum = Global.get_COA_AESum(Global.UsrsOrg_ID);
            double crlsum = Global.get_COA_CRLSum(Global.UsrsOrg_ID);
            if (aesum
                    != crlsum) {
                Global.updateLogMsg(msg_id1,
                        "\r\nCannot Post this Batch Since Current GL is not Balanced!Please correct the Imbalance First!\r\n",
                        log_tbl1, dateStr, Global.rnUser_ID);

                Global.updateLogMsg(msg_id,
                        "\r\nCannot Post this Batch Since Current GL is not Balanced!Please correct the Imbalance First!\r\n",
                        log_tbl, dateStr, Global.rnUser_ID);

                Program.correctImblns();

                Global.updateRptRnStopCmd(Global.runID, "1");
                Program.checkNClosePrgrm();

                return;
            }
            Global.updtActnPrcss(5);

            ResultSet dtst = Global.get_Batch_Trns(glBatchID);
            dtst.last();
            long ttltrns = dtst.getRow();
            dtst.beforeFirst();

            Global.updtActnPrcss(5);
            //Validating Entries
            if (!btchSrc.equals("Period Close Process")) {
                for (int i = 0; i < ttltrns; i++) {
                    dtst.next();
                    Global.updtActnPrcss(5);
                    int accntid = Integer.parseInt(dtst.getString(10));
                    double netAmnt = Double.parseDouble(dtst.getString(11));
                    String lnDte = dtst.getString(7);
                    String[] errmsg = new String[1];

                    if (!Global.isTransPrmttd(accntid, lnDte, netAmnt, errmsg)) {
                        Global.updateLogMsg(msg_id1,
                                "\r\n\r\n" + errmsg[0] + "\r\n\r\nOperation Cancelled because the line with the\r\n ff details was detected as an INVALID Transaction!"
                                + "\r\nACCOUNT: " + dtst.getString(2) + "." + dtst.getString(3)
                                + "\r\nAMOUNT: " + netAmnt
                                + "\r\nDATE: " + lnDte,
                                log_tbl1, dateStr, Global.rnUser_ID);

                        Global.updateLogMsg(msg_id,
                                "\r\n\r\n" + errmsg[0] + "\r\n\r\nOperation Cancelled because the line with the\r\n ff details was detected as an INVALID Transaction!"
                                + "\r\nACCOUNT: " + dtst.getString(2) + "." + dtst.getString(3)
                                + "\r\nAMOUNT: " + netAmnt
                                + "\r\nDATE: " + lnDte,
                                log_tbl, dateStr, Global.rnUser_ID);
                        return;
                    }
                }
            }
            dtst.beforeFirst();
            for (int i = 0; i < ttltrns; i++) {
                dtst.next();
                Global.updtActnPrcss(5);
                //Update the corresponding account balance and 
                //update net income balance as well if type is R or EX
                //update control account if any
                //update accnt curr bals if different from 
                int accntCurrID = Integer.parseInt(dtst.getString(18));
                int funcCurr = Integer.parseInt(dtst.getString(8));
                double accntCurrAmnt = Double.parseDouble(dtst.getString(16));

                String acctyp = Global.getAccntType(
                        Integer.parseInt(dtst.getString(10)));
                boolean hsBnUpdt = Global.hsTrnsUptdAcntBls(
                        Long.parseLong(dtst.getString(1)),
                        dtst.getString(7),
                        Integer.parseInt(dtst.getString(10)));
                if (hsBnUpdt == false) {
                    double dbt1 = Double.parseDouble(dtst.getString(5));
                    double crdt1 = Double.parseDouble(dtst.getString(6));
                    double net1 = Double.parseDouble(dtst.getString(11));

                    if (funCurID != accntCurrID) {
                        Global.postAccntCurrTransaction(Integer.parseInt(dtst.getString(10)),
                                Global.getSign(dbt1) * accntCurrAmnt,
                                Global.getSign(crdt1) * accntCurrAmnt,
                                Global.getSign(net1) * accntCurrAmnt,
                                dtst.getString(7),
                                Long.parseLong(dtst.getString(1)), accntCurrID);
                    }

                    Global.postTransaction(Integer.parseInt(dtst.getString(10)),
                            dbt1,
                            crdt1,
                            net1,
                            dtst.getString(7),
                            Long.parseLong(dtst.getString(1)));
                }

                hsBnUpdt = Global.hsTrnsUptdAcntBls(
                        Long.parseLong(dtst.getString(1)),
                        dtst.getString(7),
                        net_accnt);

                if (hsBnUpdt == false) {
                    if (acctyp.equals("R")) {
                        Global.postTransaction(net_accnt,
                                Double.parseDouble(dtst.getString(5)),
                                Double.parseDouble(dtst.getString(6)),
                                Double.parseDouble(dtst.getString(11)),
                                dtst.getString(7),
                                Long.parseLong(dtst.getString(1)));
                    } else if (acctyp.equals("EX")) {
                        Global.postTransaction(net_accnt,
                                Double.parseDouble(dtst.getString(5)),
                                Double.parseDouble(dtst.getString(6)),
                                (double) (-1) * Double.parseDouble(dtst.getString(11)),
                                dtst.getString(7),
                                Long.parseLong(dtst.getString(1)));
                    }
                }

                //get control accnt id
                int cntrlAcntID = Integer.parseInt(Global.getGnrlRecNm("accb.accb_chart_of_accnts", "accnt_id", "control_account_id", Integer.parseInt(dtst.getString(10))));
                if (cntrlAcntID > 0) {
                    hsBnUpdt = Global.hsTrnsUptdAcntBls(
                            Long.parseLong(dtst.getString(1)),
                            dtst.getString(7),
                            cntrlAcntID);

                    if (hsBnUpdt == false) {
                        int cntrlAcntCurrID = Integer.parseInt(Global.getGnrlRecNm(
                                "accb.accb_chart_of_accnts", "accnt_id", "crncy_id", cntrlAcntID));

                        double dbt1 = Double.parseDouble(dtst.getString(5));
                        double crdt1 = Double.parseDouble(dtst.getString(6));
                        double net1 = Double.parseDouble(dtst.getString(11));

                        if (funCurID != cntrlAcntCurrID && cntrlAcntCurrID == accntCurrID) {
                            Global.postAccntCurrTransaction(cntrlAcntID,
                                    Global.getSign(dbt1) * accntCurrAmnt,
                                    Global.getSign(crdt1) * accntCurrAmnt,
                                    Global.getSign(net1) * accntCurrAmnt,
                                    dtst.getString(7),
                                    Long.parseLong(dtst.getString(1)), accntCurrID);
                        }
                        Global.postTransaction(cntrlAcntID,
                                Double.parseDouble(dtst.getString(5)),
                                Double.parseDouble(dtst.getString(6)),
                                Double.parseDouble(dtst.getString(11)),
                                dtst.getString(7),
                                Long.parseLong(dtst.getString(1)));
                    }
                }
                Global.chngeTrnsStatus(Long.parseLong(dtst.getString(1)), "1");
                Global.changeReconciledStatus(Long.parseLong(dtst.getString(21)), "1");
                Global.updateLogMsg(msg_id,
                        "\r\nSuccessfully posted transaction ID= " + dtst.getString(1), log_tbl, dateStr, Global.rnUser_ID);
                Global.updateLogMsg(msg_id1,
                        "\r\nSuccessfully posted transaction ID= " + dtst.getString(1), log_tbl1, dateStr, Global.rnUser_ID);
            }
            //Call Accnts Chart Bals Update
            Program.reloadAcntChrtBals(glBatchID, net_accnt);
            Global.updateLogMsg(msg_id,
                    "\r\nSuccessfully Reloaded Chart of Account Balances!", log_tbl, dateStr, Global.rnUser_ID);

            Global.updateLogMsg(msg_id1,
                    "\r\nSuccessfully Reloaded Chart of Account Balances!", log_tbl1, dateStr, Global.rnUser_ID);

            aesum = Global.get_COA_AESum(Global.UsrsOrg_ID);
            crlsum = Global.get_COA_CRLSum(Global.UsrsOrg_ID);
            if (aesum
                    != crlsum) {
                Global.updateLogMsg(msg_id,
                        "\r\nBatch of Transactions caused an "
                        + "IMBALANCE in the Accounting! A+E=" + aesum
                        + "\r\nC+R+L=" + crlsum + "\r\nDiff=" + (aesum - crlsum) + " will be pushed to suspense Account", log_tbl, dateStr, Global.rnUser_ID);
                Program.correctImblns();
                Program.correctImblns();
            } else {
                Global.updateBatchStatus(glBatchID);
                Global.updateLogMsg(msg_id,
                        "\r\nBatch of Transactions POSTED SUCCESSFULLY!", log_tbl, dateStr, Global.rnUser_ID);
            }
        } catch (SQLException ex) {
            Global.updateLogMsg(msg_id,
                    "\r\nError!" + ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace()), log_tbl, dateStr, Global.rnUser_ID);
            Global.errorLog = "\r\nError!" + ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace());
            Global.writeToLog();
        } catch (NumberFormatException ex) {
            Global.updateLogMsg(msg_id,
                    "\r\nError!" + ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace()), log_tbl, dateStr, Global.rnUser_ID);
            Global.errorLog = "\r\nError!" + ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace());
            Global.writeToLog();
        }
    }

    private static void reloadAcntChrtBals(int netaccntid) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = frmtr.format(frmtr1.parse(Global.getDB_Date_time()).getTime());

            ResultSet dtst = Global.get_All_Chrt_Det(Global.UsrsOrg_ID);
            dtst.last();
            int ttlRws = dtst.getRow();
            dtst.beforeFirst();
            for (int a = 0; a < ttlRws; a++) {
                dtst.next();
                String[] rslt = Global.getAccntLstDailyBalsInfo(
                        Integer.parseInt(dtst.getString(1)), dateStr);
                double lstNetBals = Double.parseDouble(rslt[2]);
                double lstDbtBals = Double.parseDouble(rslt[0]);
                double lstCrdtBals = Double.parseDouble(rslt[1]);

                Global.updtAcntChrtBals(Integer.parseInt(dtst.getString(1)),
                        lstDbtBals, lstCrdtBals, lstNetBals, rslt[3]);

                //get control accnt id
                int cntrlAcntID = Integer.parseInt(Global.getGnrlRecNm("accb.accb_chart_of_accnts",
                        "accnt_id", "control_account_id", Integer.parseInt(dtst.getString(1))));
                if (cntrlAcntID > 0) {
                    rslt = Global.getAccntLstDailyBalsInfo(
                            cntrlAcntID, dateStr);
                    lstNetBals = Double.parseDouble(rslt[2]);
                    lstDbtBals = Double.parseDouble(rslt[0]);
                    lstCrdtBals = Double.parseDouble(rslt[1]);

                    //Global.showMsg("Testing!" + rslt[2] + "\r\n" + rslt[3] + "\r\n" + dateStr, 0);
                    Global.updtAcntChrtBals(cntrlAcntID,
                            lstDbtBals, lstCrdtBals, lstNetBals, rslt[3]);
                }
            }
            if (netaccntid > 0) {
                String[] rslt = Global.getAccntLstDailyBalsInfo(
                        netaccntid, dateStr);
                double lstNetBals = Double.parseDouble(rslt[2]);
                double lstDbtBals = Double.parseDouble(rslt[0]);
                double lstCrdtBals = Double.parseDouble(rslt[1]);

                //Global.showMsg("Testing!" + rslt[2] + "\r\n" + rslt[3] + "\r\n" + dateStr, 0);
                Global.updtAcntChrtBals(netaccntid,
                        lstDbtBals, lstCrdtBals, lstNetBals, rslt[3]);
            }
        } catch (ParseException ex) {

        } catch (SQLException ex) {
        } catch (NumberFormatException ex) {
        }
    }

    private static void reloadOneAcntChrtBals(int accntID, int netaccntid) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = frmtr.format(frmtr1.parse(Global.getDB_Date_time()).getTime());

            String[] rslt = Global.getAccntLstDailyBalsInfo(accntID, dateStr);
            double lstNetBals = Double.parseDouble(rslt[2]);
            double lstDbtBals = Double.parseDouble(rslt[0]);
            double lstCrdtBals = Double.parseDouble(rslt[1]);

            //Global.showMsg("Testing!" + rslt[2] + "\r\n" + rslt[3] + "\r\n" + dateStr, 0);
            Global.updtAcntChrtBals(accntID,
                    lstDbtBals, lstCrdtBals, lstNetBals, rslt[3]);

            //get control accnt id
            int cntrlAcntID = Integer.parseInt(Global.getGnrlRecNm("accb.accb_chart_of_accnts", "accnt_id", "control_account_id", accntID));
            if (cntrlAcntID > 0) {
                rslt = Global.getAccntLstDailyBalsInfo(
                        cntrlAcntID, dateStr);
                lstNetBals = Double.parseDouble(rslt[2]);
                lstDbtBals = Double.parseDouble(rslt[0]);
                lstCrdtBals = Double.parseDouble(rslt[1]);

                //Global.showMsg("Testing!" + rslt[2] + "\r\n" + rslt[3] + "\r\n" + dateStr, 0);
                Global.updtAcntChrtBals(cntrlAcntID,
                        lstDbtBals, lstCrdtBals, lstNetBals, rslt[3]);
            }
            //}
            if (netaccntid > 0) {
                rslt = Global.getAccntLstDailyBalsInfo(
                        netaccntid, dateStr);
                lstNetBals = Double.parseDouble(rslt[2]);
                lstDbtBals = Double.parseDouble(rslt[0]);
                lstCrdtBals = Double.parseDouble(rslt[1]);

                //Global.showMsg("Testing!" + rslt[2] + "\r\n" + rslt[3] + "\r\n" + dateStr, 0);
                Global.updtAcntChrtBals(netaccntid,
                        lstDbtBals, lstCrdtBals, lstNetBals, rslt[3]);
            }
        } catch (ParseException ex) {

        } catch (NumberFormatException ex) {
        }
    }

    private static void reloadAcntChrtBals(long btchid, int netaccntid) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = frmtr.format(frmtr1.parse(Global.getDB_Date_time()).getTime());

            ResultSet dtst = Global.get_Batch_Accnts(btchid);
            dtst.last();
            int ttlRws = dtst.getRow();
            dtst.beforeFirst();
            for (int a = 0; a < ttlRws; a++) {
                String[] rslt = Global.getAccntLstDailyBalsInfo(
                        Integer.parseInt(dtst.getString(1)), dateStr);
                double lstNetBals = Double.parseDouble(rslt[2]);
                double lstDbtBals = Double.parseDouble(rslt[0]);
                double lstCrdtBals = Double.parseDouble(rslt[1]);

                //Global.showMsg("Testing!" + rslt[2] + "\r\n" + rslt[3] + "\r\n" + dateStr, 0);
                Global.updtAcntChrtBals(Integer.parseInt(dtst.getString(1)),
                        lstDbtBals, lstCrdtBals, lstNetBals, rslt[3]);

                //get control accnt id
                int cntrlAcntID = Integer.parseInt(Global.getGnrlRecNm("accb.accb_chart_of_accnts",
                        "accnt_id", "control_account_id", Integer.parseInt(dtst.getString(1))));
                if (cntrlAcntID > 0) {
                    rslt = Global.getAccntLstDailyBalsInfo(cntrlAcntID, dateStr);
                    lstNetBals = Double.parseDouble(rslt[2]);
                    lstDbtBals = Double.parseDouble(rslt[0]);
                    lstCrdtBals = Double.parseDouble(rslt[1]);

                    Global.updtAcntChrtBals(cntrlAcntID,
                            lstDbtBals, lstCrdtBals, lstNetBals, rslt[3]);
                }
            }
            if (netaccntid > 0) {
                String[] rslt = Global.getAccntLstDailyBalsInfo(netaccntid, dateStr);
                double lstNetBals = Double.parseDouble(rslt[2]);
                double lstDbtBals = Double.parseDouble(rslt[0]);
                double lstCrdtBals = Double.parseDouble(rslt[1]);

                //Global.showMsg("Testing!" + rslt[2] + "\r\n" + rslt[3] + "\r\n" + dateStr, 0);
                Global.updtAcntChrtBals(netaccntid,
                        lstDbtBals, lstCrdtBals, lstNetBals, rslt[3]);
            }
        } catch (ParseException ex) {

        } catch (SQLException ex) {
        } catch (NumberFormatException ex) {
        }
    }

    public static boolean sendJournalsToGL(ResultSet dtst, String intrfcTblNme, int prcID, String[] errmsg) {
        try {
            Program.correctIntrfcImbals(intrfcTblNme);
            //Check if Dataset Trns are balanced before calling this func
            Global.updtActnPrcss(prcID);
            dtst.last();
            long cntr = dtst.getRow();
            dtst.beforeFirst();

            double dbtsum = 0;
            double crdtsum = 0;

            for (int y = 0; y < cntr; y++) {
                dtst.next();
                dbtsum += Double.parseDouble(dtst.getString(3));
                crdtsum += Double.parseDouble(dtst.getString(4));
                Global.updtActnPrcss(prcID);
            }
            dbtsum = (double) Math.round(dbtsum * 100) / 100;
            crdtsum = (double) Math.round(crdtsum * 100) / 100;

            if (cntr == 0) {
                errmsg[0] += "Cannot Transfer Transactions to GL because\r\n"
                        + " No Interface Transactions were found!";
                return false;
            }

            if (dbtsum != crdtsum) {
                errmsg[0] += "Cannot Transfer Transactions to GL because\r\n"
                        + " Transactions in the GL Interface are not Balanced! Difference=" + Math.abs(dbtsum - crdtsum);
                return false;
            }
            //Get Todays GL Batch Name
            String dateStr = Global.getFrmtdDB_Date_time();
            String btchPrfx = "Internal Payments";
            if (intrfcTblNme.equals("scm.scm_gl_interface")) {
                btchPrfx = "Inventory";
            }
            Global.updtActnPrcss(prcID);
            String todaysGlBatch = btchPrfx + " (" + dateStr + ")";
            long todbatchid = Global.getTodaysGLBatchID(
                    todaysGlBatch, Global.UsrsOrg_ID);
            if (todbatchid <= 0) {
                Global.createTodaysGLBatch(Global.UsrsOrg_ID,
                        todaysGlBatch, todaysGlBatch, btchPrfx);
                todbatchid = Global.getTodaysGLBatchID(
                        todaysGlBatch,
                        Global.UsrsOrg_ID);
                Global.updtActnPrcss(prcID);
            }
            if (todbatchid > 0) {
                todaysGlBatch = Global.get_GLBatch_Nm(todbatchid);
            }

            /*
             * 1. Get list of all accounts to transfer from the 
             * interface table and their total amounts.
             * 2. Loop through each and transfer
             */
            //ResultSet dtst = Global.getAllInGLIntrfcOrg(Global.UsrsOrg_ID);
            //dateStr = Global.getFrmtdDB_Date_time();
            Global.updtActnPrcss(prcID);
            dtst.beforeFirst();
            for (int a = 0; a < cntr; a++) {
                dtst.next();
                Global.updtActnPrcss(prcID);
                String src_ids = Global.getGLIntrfcIDs(Integer.parseInt(dtst.getString(1)),
                        dtst.getString(2),
                        Integer.parseInt(dtst.getString(6)), intrfcTblNme);

                double entrdAmnt = Double.parseDouble(dtst.getString(3)) == 0 ? Double.parseDouble(dtst.getString(4)) : Double.parseDouble(dtst.getString(3));
                String dbtCrdt = Double.parseDouble(dtst.getString(4)) == 0 ? "D" : "C";
                int accntCurrID = Integer.parseInt(Global.getGnrlRecNm(
                        "accb.accb_chart_of_accnts", "accnt_id", "crncy_id", Integer.parseInt(dtst.getString(1))));

                double accntCurrRate = Math.round(Global.get_LtstExchRate(Integer.parseInt(dtst.getString(6)),
                        accntCurrID, dtst.getString(2)) * 1000000000000000.00) / 1000000000000000.00;

                //Check if dbtsum in intrfcids matchs the dbt amount been sent to gl
                double[] actlAmnts = Global.getGLIntrfcIDAmntSum(src_ids, intrfcTblNme, Integer.parseInt(dtst.getString(1)));

                if (actlAmnts[0] == Double.parseDouble(dtst.getString(3))
                        && actlAmnts[1] == Double.parseDouble(dtst.getString(4))) {
                    Global.createPymntGLLine(Integer.parseInt(dtst.getString(1)),
                            "Lumped sum of all payments (from the " + btchPrfx + " module) to this account",
                            Double.parseDouble(dtst.getString(3)),
                            dtst.getString(2),
                            Integer.parseInt(dtst.getString(6)), todbatchid,
                            Double.parseDouble(dtst.getString(4)),
                            Double.parseDouble(dtst.getString(5)), src_ids, dateStr,
                            entrdAmnt, Integer.parseInt(dtst.getString(6)),
                            entrdAmnt * accntCurrRate, accntCurrID,
                            1, accntCurrID, dbtCrdt);
                } else {
                    errmsg[0] += "Interface Transaction Amounts DR:" + actlAmnts[0] + " CR:" + actlAmnts[1]
                            + " \r\ndo not match Amount being sent to GL DR:" + Double.parseDouble(dtst.getString(3))
                            + " CR:" + Double.parseDouble(dtst.getString(4)) + "!\r\n Interface Line IDs:" + src_ids;
                    break;
                }
            }
            if (Global.get_Batch_CrdtSum(todbatchid) == Global.get_Batch_DbtSum(todbatchid)) {
                Global.updtActnPrcss(prcID);
                Global.updtPymntAllGLIntrfcLnOrg(todbatchid, Global.UsrsOrg_ID, intrfcTblNme);
                Global.updtActnPrcss(prcID);
                Global.updtGLIntrfcLnSpclOrg(Global.UsrsOrg_ID, intrfcTblNme, btchPrfx);
                Global.updtActnPrcss(prcID);
                Global.updtTodaysGLBatchPstngAvlblty(todbatchid, "1");
                return true;
            } else {
                errmsg[0] += "The GL Batch created is not Balanced!\r\nTransactions created will be reversed and deleted!";
                Global.deleteBatchTrns(todbatchid);
                Global.deleteBatch(todbatchid, todaysGlBatch);
                return false;
            }
        } catch (Exception ex) {
            errmsg[0] += "Error Sending Payment to GL!\r\n" + ex.getMessage();
            return false;
        }
    }

    private static void correctIntrfcImbals(String intrfcTblNm) {
        try {
            int suspns_accnt = Global.get_Suspns_Accnt(Global.UsrsOrg_ID);
            ResultSet dteDtSt = Global.get_Intrfc_dateSums(intrfcTblNm, Global.UsrsOrg_ID);
            dteDtSt.last();
            int ttlRws = dteDtSt.getRow();
            dteDtSt.beforeFirst();
            if (ttlRws > 0 && suspns_accnt > 0) {
                String msg1 = "";
                for (int i = 0; i < ttlRws; i++) {
                    dteDtSt.next();
                    double dlyDbtAmnt = Double.parseDouble(dteDtSt.getString(2));
                    double dlyCrdtAmnt = Double.parseDouble(dteDtSt.getString(3));
                    int orgID = Global.UsrsOrg_ID;
                    if (dlyDbtAmnt
                            != dlyCrdtAmnt) {
                        //long suspns_batch_id = glBatchID;
                        int funcCurrID = Global.getOrgFuncCurID(orgID);
                        BigDecimal dffrnc = BigDecimal.valueOf(dlyDbtAmnt - dlyCrdtAmnt);
                        String incrsDcrs = "D";
                        if (dffrnc.compareTo(BigDecimal.valueOf(0.00)) < 0) {
                            incrsDcrs = "I";
                        }
                        BigDecimal imbalAmnt = dffrnc.abs();
                        double netAmnt = (double) Global.dbtOrCrdtAccntMultiplier(suspns_accnt, incrsDcrs) * imbalAmnt.doubleValue();

                        SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy");
                        SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd");
                        String dateStr1 = frmtr.format(frmtr1.parse(dteDtSt.getString(1)).getTime()) + " 00:00:00";

                        String dateStr = Global.getFrmtdDB_Date_time();

                        if (Global.getIntrfcTrnsID(intrfcTblNm, suspns_accnt, netAmnt,
                                dteDtSt.getString(1) + " 00:00:00") > 0) {
                            continue;
                        }

                        if (Global.dbtOrCrdtAccnt(suspns_accnt,
                                incrsDcrs).equals("Debit")) {
                            if (intrfcTblNm.equals("scm.scm_gl_interface")) {
                                Global.createScmGLIntFcLn(suspns_accnt,
                                        "Correction of Imbalance in GL Interface Table as at " + dateStr1,
                                        imbalAmnt.doubleValue(), dateStr1,
                                        funcCurrID, 0,
                                        netAmnt, "Imbalance Correction", -1, -1, dateStr, "USR");
                            } else {
                                Global.createPayGLIntFcLn(suspns_accnt,
                                        "Correction of Imbalance in GL Interface Table as at " + dateStr1,
                                        imbalAmnt.doubleValue(), dateStr1,
                                        funcCurrID, 0,
                                        netAmnt, dateStr, "USR");
                            }
                        } else if (intrfcTblNm.equals("scm.scm_gl_interface")) {
                            Global.createScmGLIntFcLn(suspns_accnt,
                                    "Correction of Imbalance in GL Interface Table as at " + dateStr1,
                                    0, dateStr1,
                                    funcCurrID, imbalAmnt.doubleValue(),
                                    netAmnt, "Imbalance Correction", -1, -1, dateStr, "USR");
                        } else {
                            Global.createPayGLIntFcLn(suspns_accnt,
                                    "Correction of Imbalance in GL Interface Table as at " + dateStr1,
                                    imbalAmnt.doubleValue(), dateStr1,
                                    funcCurrID, 0,
                                    netAmnt, dateStr, "USR");
                        }
                    }
                }
            } else {
                //Global.mnFrm.cmCde.showMsg("There's no Imbalance to correct!", 0);
                //return;
            }
        } catch (SQLException ex) {

        } catch (NumberFormatException ex) {
        } catch (ParseException ex) {
        }
    }

    public static void correctImblns() {
        try {
            int suspns_accnt = Global.get_Suspns_Accnt(Global.UsrsOrg_ID);
            if (suspns_accnt <= -1) {
                //Global.showMsg("Please define a suspense Account First!", 0);
                return;
            }
            int ret_accnt = Global.get_Rtnd_Erngs_Accnt(Global.UsrsOrg_ID);
            int net_accnt = Global.get_Net_Income_Accnt(Global.UsrsOrg_ID);
            if (ret_accnt == -1) {
                //Global.showMsg("Until a Retained Earnings Account is defined\r\n no Transaction can be posted into the Accounting!", 0);
                return;
            }
            if (net_accnt == -1) {
                //Global.showMsg("Until a Net Income Account is defined\r\n no Transaction can be posted into the Accounting!", 0);
                return;
            }
            /*PROCEDURE FOR RELOADING ACCOUNT BALANCES
             1. Correct all Trns Det Net Balance Amount
             2. Get all wrong daily bals values
             */
            Global.updtActnPrcss(5, 90);
            ResultSet dtst = Global.get_WrongNetBalncs(Global.UsrsOrg_ID);
            dtst.last();
            int ttlRws = dtst.getRow();
            dtst.beforeFirst();
            for (int i = 0; i < ttlRws; i++) {
                dtst.next();
                double netAmnt = Double.parseDouble(dtst.getString(9));
                long trnsID = Long.parseLong(dtst.getString(1));
                String updtSQL = "UPDATE accb.accb_trnsctn_details "
                        + "SET net_amount=" + netAmnt + " WHERE transctn_id=" + trnsID;
                Global.updateDataNoParams(updtSQL);
                Global.updtActnPrcss(5, 90);
            }

            dtst = Global.get_WrongBalncs(Global.UsrsOrg_ID);
            dtst.last();
            ttlRws = dtst.getRow();
            dtst.beforeFirst();
            for (int i = 0; i < ttlRws; i++) {
                dtst.next();
                Global.updtActnPrcss(5, 30);

                String acctyp = Global.getAccntType(
                        Integer.parseInt(dtst.getString(2)));

                double dbt1 = Double.parseDouble(dtst.getString(5));
                double crdt1 = Double.parseDouble(dtst.getString(6));
                double net1 = Double.parseDouble(dtst.getString(7));

                Global.postTransaction(Integer.parseInt(dtst.getString(2)),
                        dbt1,
                        crdt1,
                        net1,
                        dtst.getString(8), -993);

                if (acctyp.equals("R")) {
                    Global.postTransaction(net_accnt,
                            dbt1,
                            crdt1,
                            net1,
                            dtst.getString(8), -993);
                } else if (acctyp.equals("EX")) {
                    Global.postTransaction(net_accnt,
                            dbt1,
                            crdt1,
                            (double) (-1) * net1,
                            dtst.getString(8), -993);
                }

                //get control accnt id
                int cntrlAcntID = Integer.parseInt(Global.getGnrlRecNm("accb.accb_chart_of_accnts", "accnt_id", "control_account_id",
                        Integer.parseInt(dtst.getString(2))));
                if (cntrlAcntID > 0) {
                    Global.postTransaction(cntrlAcntID,
                            dbt1,
                            crdt1,
                            net1,
                            dtst.getString(8), -993);
                }
                //this.reloadOneAcntChrtBals(Integer.parseInt(dtst.Tables[0].Rows[i][1].ToString()), net_accnt);
            }

            Global.updtActnPrcss(5, 50);
            Program.reloadAcntChrtBals(net_accnt);

            dtst = Global.get_WrongNetIncmBalncs(Global.UsrsOrg_ID);
            dtst.last();
            ttlRws = dtst.getRow();
            dtst.beforeFirst();

            for (int i = 0; i < ttlRws; i++) {
                dtst.next();
                Global.updtActnPrcss(5, 30);
                String acctyp = Global.getAccntType(
                        Integer.parseInt(dtst.getString(2)));

                double dbt1 = Double.parseDouble(dtst.getString(5));
                double crdt1 = Double.parseDouble(dtst.getString(6));
                double net1 = Double.parseDouble(dtst.getString(7));

                Global.postTransaction(Integer.parseInt(dtst.getString(2)),
                        dbt1,
                        crdt1,
                        net1,
                        dtst.getString(8), -993);
            }

            Global.updtActnPrcss(5, 50);
            Program.reloadOneAcntChrtBals(net_accnt, net_accnt);

            String[] errmsg = new String[1];
            BigDecimal aesum = BigDecimal.valueOf(Global.get_COA_AESum(Global.UsrsOrg_ID));
            BigDecimal crlsum = BigDecimal.valueOf(Global.get_COA_CRLSum(Global.UsrsOrg_ID));
            if (aesum
                    != crlsum) {
                Global.updtActnPrcss(5, 10);
                if (Program.postIntoSuspnsAccnt(aesum,
                        crlsum, Global.UsrsOrg_ID, false, errmsg) == false
                        && !errmsg[0].equals("")) {
                    // Global.showMsg(errmsg, 0);
                }
            }

            Program.reloadOneAcntChrtBals(suspns_accnt, net_accnt);
            Global.updtActnPrcss(5, 1);
        } catch (SQLException ex) {

        } catch (NumberFormatException ex) {
        }
    }

}
