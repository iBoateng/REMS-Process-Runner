/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rems;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author richard.adjei-mensah
 */
public class MntrSchdldRqtsNtRnngfunc extends Thread {

    private Thread t;
    private String threadName;

    MntrSchdldRqtsNtRnngfunc(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        try {
            do {
                //Get all rquest runs not running
                //Launch appropriate process runner
                Program.checkNClosePrgrm();
                ResultSet dtst = Global.get_SchdldRunsNtRnng();
                dtst.last();
                int ttlRws = dtst.getRow();
                dtst.beforeFirst();
                for (int i = 0; i < ttlRws; i++) {
                    dtst.next();
                    long rptid = Long.parseLong(dtst.getString(2));
                    long rptrnid = Long.parseLong(dtst.getString(1));
                    long rptrnnrid = Long.parseLong(dtst.getString(3));
                    String rptRnnrNm = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "process_runner", rptid);
                    String rnnrPrcsFile = Global.getGnrlRecNm("rpt.rpt_prcss_rnnrs", "rnnr_name", "executbl_file_nm", rptRnnrNm);
                    if (rptRnnrNm == "") {
                        rptRnnrNm = "Standard Process Runner";
                    }
                    if (rnnrPrcsFile == "") {
                        rnnrPrcsFile = "/bin/REMSProcessRunner.jar";
                    }

                    rnnrPrcsFile = rnnrPrcsFile.replace("/bin", "").replace("\\bin", "");

                    if (Global.doesLstRnTmExcdIntvl(rptid, "65 second", rptrnid) == true) {
                        Global.updatePrcsRnnrCmd(rptRnnrNm, "0", rptrnnrid);
                        Global.updateRptRnStopCmd(rptrnid, "0");
                        File file = new File(Global.appStatPath + "/" + rnnrPrcsFile);
                        String[] args = {"\"" + Global.Hostnme + "\"",
                            Global.Portnum,
                            "\"" + Global.Uname + "\"",
                            "\"" + Global.Pswd + "\"",
                            "\"" + Global.Dbase + "\"",
                            "\"" + rptRnnrNm + "\"",
                            String.valueOf(rptrnid),
                            "\"" + file.getParentFile().getParent() + "\"",
                            "WEB",
                            "\"" + Global.dataBasDir + "\""};
                        Runtime runTime = Runtime.getRuntime();
                        Process process = runTime.exec("java -jar " + Global.appStatPath + "/" + rnnrPrcsFile + " " + String.join(" ", args));
                    }

                    long mxConns = 0;
                    long curCons = 0;
                    do {
                        mxConns = Global.getMxAllwdDBConns();
                        curCons = Global.getCurDBConns();
                        Global.errorLog = "Inside Running of Scheduled Requests=> Current Connections: " + curCons + " Max Connections: " + mxConns;
                        Global.writeToLog();
                        Program.checkNClosePrgrm();
                        Thread.sleep(10000);
                    } while (curCons >= mxConns);
                }
                Thread.sleep(40000);
                long prgmID = Global.getGnrlRecID("rpt.rpt_prcss_rnnrs", "rnnr_name", "prcss_rnnr_id", Program.runnerName);
                Program.updatePrgrm(prgmID);
            } while (true);
        } catch (SQLException ex) {
            //write to log file
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.writeToLog();
            if (Program.thread3.isAlive()) {
                Program.thread3.interrupt();
            }
        } catch (NumberFormatException ex) {
            //write to log file
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.writeToLog();
            if (Program.thread3.isAlive()) {
                Program.thread3.interrupt();
            }
        } catch (IOException ex) {
            //write to log file
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.writeToLog();
            if (Program.thread3.isAlive()) {
                Program.thread3.interrupt();
            }
        } catch (InterruptedException ex) {
            //write to log file
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.writeToLog();
            if (Program.thread3.isAlive()) {
                Program.thread3.interrupt();
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
