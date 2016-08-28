/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rems;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author richard.adjei-mensah
 */
public class GnrtSchldAlertsfunc extends Thread {
    
    private Thread t;
    private String threadName;
    
    GnrtSchldAlertsfunc(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }
    
    @Override
    public void run() {
        
        try {
            do {
                //1. Get all enabled schedules
                //2. for each enabled schedule check last time it was run
                // if difference between last_time_active is >= schedule interval 
                //and time component is >= current time then generate another schedule run
                Program.checkNClosePrgrm();
                ResultSet dtst = Global.get_AlertSchdules();
                dtst.last();
                int ttlRws = dtst.getRow();
                dtst.beforeFirst();
                
                for (int i = 0; i < ttlRws; i++) {
                    dtst.next();
                    long rpt_id = Long.parseLong(dtst.getString(2));
                    long alertID = Long.parseLong(dtst.getString(1));
                    
                    if (Global.doesLstRnTmExcdIntvl(rpt_id,
                            dtst.getString(5) + " " + dtst.getString(6), -1) == true) {
                        String dateStr = Global.getDB_Date_time();
                        
                        SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        
                        Calendar bdte2 = Calendar.getInstance();
                        bdte2.setTime(frmtr1.parse(dateStr));
                        bdte2.add(Calendar.MINUTE, -1);
                        bdte2.add(Calendar.SECOND, -59);
                        dateStr = frmtr1.format(bdte2);
                        
                        String outputUsd = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "output_type", rpt_id);
                        String orntnUsd = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "portrait_lndscp", rpt_id);
                        String prmIDs = "";
                        String prmVals = "";
                        ResultSet dtstPrm = Global.get_AlertParams(alertID);
                        dtstPrm.last();
                        int dtstPrmTtl = dtstPrm.getRow();
                        dtstPrm.beforeFirst();
                        for (int y = 0; y < dtstPrmTtl; y++) {
                            dtstPrm.next();
                            prmVals += dtstPrm.getString(4) + "|";
                            prmIDs += dtstPrm.getString(2) + "|";
                        }
                        String colsToGrp = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "cols_to_group", rpt_id);
                        String colsToCnt = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "cols_to_count", rpt_id);
                        String colsToSu = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "cols_to_sum", rpt_id);
                        String colsToAvrg = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "cols_to_average", rpt_id);
                        String colsToFrmt = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "cols_to_no_frmt", rpt_id);
                        String rpTitle = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "report_name", rpt_id);

                        //Report Title
                        prmVals += rpTitle + "|";
                        prmIDs += Global.sysParaIDs[0] + "|";
                        //Cols To Group
                        prmVals += colsToGrp + "|";
                        prmIDs += Global.sysParaIDs[1] + "|";
                        //Cols To Count
                        prmVals += colsToCnt + "|";
                        prmIDs += Global.sysParaIDs[2] + "|";
                        //Cols To Sum
                        prmVals += colsToSu + "|";
                        prmIDs += Global.sysParaIDs[3] + "|";
                        //colsToAvrg
                        prmVals += colsToAvrg + "|";
                        prmIDs += Global.sysParaIDs[4] + "|";
                        //colsToFrmt
                        prmVals += colsToFrmt + "|";
                        prmIDs += Global.sysParaIDs[5] + "|";

                        //outputUsd
                        prmVals += outputUsd + "|";
                        prmIDs += Global.sysParaIDs[6] + "|";

                        //orntnUsd
                        prmVals += orntnUsd + "|";
                        prmIDs += Global.sysParaIDs[7] + "|";
                        
                        Global.createSchdldRptRn(
                                Long.parseLong(dtst.getString(7)), dateStr,
                                rpt_id, prmIDs, prmVals, outputUsd, orntnUsd,
                                Integer.parseInt(dtst.getString(1)), -1);
                        
                        Thread.sleep(5000);
                        
                        long rptRunID = Global.getRptRnID(rpt_id,
                                Long.parseLong(dtst.getString(7)), dateStr);
                        
                        long msg_id = Global.getLogMsgID("rpt.rpt_run_msgs",
                                "Process Run", rptRunID);
                        if (msg_id <= 0) {
                            Global.createLogMsg(dateStr
                                    + " .... Alert Run is about to Start...(Being run by "
                                    + Global.get_user_name(Long.parseLong(dtst.getString(7))) + ")",
                                    "rpt.rpt_run_msgs", "Process Run", rptRunID, dateStr);
                        }
                        //msg_id = Global.getLogMsgID("rpt.rpt_run_msgs", "Process Run", rptRunID);
                    }
                }
                long mxConns = 0;
                long curCons = 0;
                do {
                    mxConns = Global.getMxAllwdDBConns();
                    curCons = Global.getCurDBConns();
                    Global.errorLog = "Inside Generation of Scheduled Requests=> Current Connections: " + curCons + " Max Connections: " + mxConns;
                    Global.writeToLog();
                    
                    Thread.sleep(30000);
                    long prgmID = Global.getGnrlRecID("rpt.rpt_prcss_rnnrs", "rnnr_name", "prcss_rnnr_id", Program.runnerName);
                    Program.updatePrgrm(prgmID);
                } while (curCons >= mxConns);
            } while (true);
        } catch (SQLException ex) {
            //write to log file
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.writeToLog();
            if (Program.thread6.isAlive()) {
                Program.thread6.interrupt();
            }
        } catch (NumberFormatException ex) {
            //write to log file
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.writeToLog();
            if (Program.thread6.isAlive()) {
                Program.thread6.interrupt();
            }
        } catch (ParseException ex) {
            //write to log file
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.writeToLog();
            if (Program.thread6.isAlive()) {
                Program.thread6.interrupt();
            }
        } catch (InterruptedException ex) {
            //write to log file
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.writeToLog();
            if (Program.thread6.isAlive()) {
                Program.thread6.interrupt();
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
