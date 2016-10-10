/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author richard.adjei-mensah
 */
public class RunActualRqtsfunc extends Thread {

    private Thread t;
    private String threadName;

    RunActualRqtsfunc(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        String dateStr = Global.getDB_Date_time();
        //String dateStr = Global.getDB_Date_time();
        String log_tbl = "rpt.rpt_run_msgs";
        try {
            long prgmID = Global.getGnrlRecID("rpt.rpt_prcss_rnnrs", "rnnr_name", "prcss_rnnr_id", Program.runnerName);
            Global.errorLog = "Successfully Started Thread Five\r\nProgram ID:" + prgmID + ": Program Name: " + Program.runnerName + "\r\n";
            String[] macDet = Global.getMachDetails();
            Global.errorLog += "PID: " + Global.pid + " Running on: " + macDet[0] + " / " + macDet[1] + " / " + macDet[2];
            Global.writeToLog();

            String rptTitle = "";
            String jsprFileName = "";
            String[] colsToGrp = {""};
            String[] colsToCnt = {""};
            String[] colsToSum = {""};
            String[] colsToAvrg = {""};
            String[] colsToFrmt = {""};
            String toMails = "";
            String ccMails = "";
            String bccMails = "";
            String sbjct = "";
            String msgBdy = "";
            String attchMns = "";
            long nwMsgSntID = -1;
            long toPrsnID = -1;
            long toCstmrSpplrID = -1;
            String[] errMsg = new String[1];

            if (Global.runID > 0) {
                ResultSet runDtSt = Global.get_RptRun_Det(Global.runID);
                int alertID = -1;
                long locRptID = -1;
                long msgSentID = -1;
                String paramIDs = "";
                String paramVals = "";
                String outputUsd = "";
                String orntnUsd = "";
                String imgCols = "";
                String rptLyout = "";
                String rptOutpt = "";
                String rptdlmtr = "";
                //String rptType = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "rpt_or_sys_prcs", rpt_id);
                String rptType = "";
                while (runDtSt.next()) {
                    locRptID = runDtSt.getLong(6);
                    alertID = runDtSt.getInt(14);
                    msgSentID = runDtSt.getInt(15);
                    Global.rnUser_ID = runDtSt.getLong(1);
                    paramIDs = runDtSt.getString(7);
                    paramVals = runDtSt.getString(8);
                    outputUsd = runDtSt.getString(9);
                    orntnUsd = runDtSt.getString(10);
                }

                ResultSet rptDtSt = Global.get_RptDet(locRptID);
                ResultSet alrtDtSt = Global.get_AlertDet(alertID);

                while (rptDtSt.next()) {
                    imgCols = rptDtSt.getString(16);
                    jsprFileName = rptDtSt.getString(20);
                    rptLyout = rptDtSt.getString(15);
                    rptOutpt = "";
                    rptdlmtr = rptDtSt.getString(17);
                    //String rptType = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "rpt_or_sys_prcs", rpt_id);
                    rptType = rptDtSt.getString(6);
                }

                String alertType = "";
                if (alertID > 0) {
                    while (alrtDtSt.next()) {
                        alertType = alrtDtSt.getString(6);
                    }
                    alrtDtSt.beforeFirst();
                }
                ResultSet prgmUntsDtSt = Global.get_AllPrgmUnts(locRptID);
                prgmUntsDtSt.last();
                long prgUntsCnt = prgmUntsDtSt.getRow();
                prgmUntsDtSt.beforeFirst();

                Global.errorLog += "\r\nRun ID: " + Global.runID + " Report ID:" + locRptID + "\r\n";
                Global.writeToLog();
                long msg_id = Global.getGnrlRecID("rpt.rpt_run_msgs", "process_typ", "process_id", "msg_id", "Process Run", Global.runID);

                Global.updateLogMsg(msg_id,
                        "\r\n\r\n\r\nLog Messages ==>\r\n\r\n" + Global.errorLog,
                        log_tbl, dateStr, Global.rnUser_ID);

                Global.updateRptRn(Global.runID, "Preparing to Start...", 20);

                Global.logMsgID = msg_id;
                Global.logTbl = log_tbl;
                Global.gnrlDateStr = dateStr;

                long rpt_run_id = Global.runID;
                long rpt_id = locRptID;

                String w = "\\|";
                String seps = "\\,";
                String seps1 = "\\;";

                String[] arry1 = paramIDs.split(w);
                String[] arry2 = paramVals.split(w);
                System.out.println(paramIDs);
                Global.ovrllDataCnt = 0;
                Global.strSB = new StringBuilder("");
                //Program.updatePrgrm(prgmID);
                for (int q = 0; q < prgUntsCnt + 1; q++) {
                    boolean isfirst = true;
                    boolean islast = true;
                    boolean shdAppnd = false;
                    String rqrdParamVal = "";
                    String exclFileName = "";
                    if (q == prgUntsCnt) {
                        islast = true;
                    } else {
                        islast = false;
                    }
                    if (prgUntsCnt > 0) {
                        shdAppnd = true;
                    } else {
                        shdAppnd = false;
                    }
                    if (q == 0) {
                        isfirst = true;
                        //rpt_id = rpt_id;
                    } else {
                        isfirst = false;
                        prgmUntsDtSt.next();
                        rpt_id = prgmUntsDtSt.getLong(1);
                        rptDtSt = Global.get_RptDet(rpt_id);
                        while (rptDtSt.next()) {
                            outputUsd = rptDtSt.getString(13);
                            orntnUsd = rptDtSt.getString(14);
                            jsprFileName = rptDtSt.getString(20);
                            //rptdlmtr = Global.getGnrlRecNm("rpt.rpt_reports", "report_id", "csv_delimiter", rpt_id);
                            rptLyout = rptDtSt.getString(15);
                            rptType = rptDtSt.getString(6);
                            colsToGrp = rptDtSt.getString(8).split(seps);
                            colsToCnt = rptDtSt.getString(9).split(seps);
                            colsToSum = rptDtSt.getString(10).split(seps);
                            colsToAvrg = rptDtSt.getString(11).split(seps);
                            colsToFrmt = rptDtSt.getString(12).split(seps);
                        }
                        rptDtSt.beforeFirst();
                    }
                    if (Global.callngAppType.equals("DESKTOP")) {
                        if (!jsprFileName.equals("")) {
                            Global.dwnldImgsFTP(15, Global.getRptDrctry() + "/jrxmls", jsprFileName);
                        }
                    }
                    String rpt_SQL = "";
                    if (alertID > 0 && msgSentID <= 0) {
                        rpt_SQL = Global.get_Alert_SQL(alertID);
                    } else {
                        rpt_SQL = Global.get_Rpt_SQL(rpt_id);
                    }
                    for (int i = 0; i < arry1.length; i++) {
                        long pID = Long.parseLong(arry1[i]);
                        int h1 = Global.findArryIdx(Global.sysParaIDs, arry1[i]);
                        if (h1 >= 0) {
                            if (arry1[i].equals("-130") && i < arry2.length) {
                                rptTitle = arry2[i];
                            } else if (arry1[i].equals("-140") && i < arry2.length) {
                                if (q == 0) {
                                    colsToGrp = arry2[i].split(seps);
                                }
                            } else if (arry1[i].equals("-150") && i < arry2.length) {
                                if (q == 0) {
                                    colsToCnt = arry2[i].split(seps);
                                }
                            } else if (arry1[i].equals("-160") && i < arry2.length) {
                                if (q == 0) {
                                    colsToSum = arry2[i].split(seps);
                                }
                            } else if (arry1[i].equals("-170") && i < arry2.length) {
                                if (q == 0) {
                                    colsToAvrg = arry2[i].split(seps);
                                }
                            } else if (arry1[i].equals("-180") && i < arry2.length) {
                                if (q == 0) {
                                    colsToFrmt = arry2[i].split(seps);
                                }
                            } else if (arry1[i].equals("-190") && i < arry2.length) {
                                //colsToGrp = arry2[i].Split(seps);
                            } else if (arry1[i].equals("-200") && i < arry2.length) {
                                //colsToGrp = arry2[i].Split(seps);
                            }
                        } else if (pID > 0 && i < arry2.length - 1) {
                            String paramSqlRep = Global.getGnrlRecNm("rpt.rpt_report_parameters",
                                    "parameter_id", "paramtr_rprstn_nm_in_query", pID);
                            rpt_SQL = rpt_SQL.replace(paramSqlRep, arry2[i]);
                            if (paramSqlRep.equals("{:alert_type}") && rptType.contains("Alert")) {
                                //alertType = arry2[i];
                            }
                            if (paramSqlRep.equals("{:msg_body}") && rptType.equals("Alert(SQL Mail List)")) {
                                rqrdParamVal = arry2[i];
                            } else if (paramSqlRep.equals("{:to_mail_list}") && rptType.equals("Alert(SQL Message)")) {
                                rqrdParamVal = arry2[i];
                            } else if (paramSqlRep.equals("{:intrfc_tbl_name}") && rptType.equals("Journal Import")) {
                                rqrdParamVal = arry2[i];
                            } else if (paramSqlRep.equals("{:orgID}")) {
                                if (Integer.parseInt(arry2[i]) > 0) {
                                    Global.UsrsOrg_ID = Integer.parseInt(arry2[i]);
                                }
                            } else if (paramSqlRep.equals("{:alert_type}")) {
                                //alertType = arry2[i];
                            } else if (paramSqlRep.equals("{:excl_file_name}")) {
                                exclFileName = arry2[i];
                            } else if (paramSqlRep.equals("{:documentTitle}")) {
                                rptTitle = arry2[i];
                            }
                        }
                    }

                    rpt_SQL = rpt_SQL.replace("{:usrID}", String.valueOf(Global.rnUser_ID));
                    rpt_SQL = rpt_SQL.replace("{:msgID}", String.valueOf(msg_id));
                    rpt_SQL = rpt_SQL.replace("{:orgID}", String.valueOf(Global.UsrsOrg_ID));

                    if (rptType.equals("Command Line Script")) {
                        rpt_SQL = rpt_SQL.replace("{:host_name}", Global.Hostnme);
                        rpt_SQL = rpt_SQL.replace("{:portnum}", Global.Portnum);
                    }
                    //NB. Be updating all report run statuses and percentages in the table
                    Global.updateLogMsg(msg_id,
                            "\r\n\r\n\r\nReport/Process SQL being executed is ==>\r\n\r\n" + rpt_SQL,
                            log_tbl, dateStr, Global.rnUser_ID);
                    //1. Execute SQL to get a dataset
                    Global.updateRptRn(rpt_run_id, "Running SQL...", 40);
                    //Program.updatePrgrm(prgmID);
                    //worker.ReportProgress(40);
                    ResultSet dtst = null;
                    if (rptType.equals("Database Function")) {
                        Global.executeGnrlSQL(rpt_SQL.replace("\r\n", " ").replace("\n", " ").replace("\r", " "));
                    } else if (rptType.equals("Command Line Script")) {
                        rpt_SQL = rpt_SQL.replace("{:db_password}", Global.Pswd);
                        String batchFilnm = Global.appStatPath + "/" + "REM_DBBackup" + String.valueOf(rpt_run_id) + ".bat";
                        PrintWriter fileWriter;
                        fileWriter = new PrintWriter(batchFilnm, "UTF-8");
                        StringBuilder strSB = new StringBuilder(System.getProperty("line.separator"))
                                .append(System.getProperty("line.separator"));
                        strSB.append(rpt_SQL);
                        fileWriter.println(strSB);
                        fileWriter.close();

                        Runtime runTime = Runtime.getRuntime();
                        Process process = runTime.exec(batchFilnm);
                        process.destroy();
                        Global.updateLogMsg(msg_id,
                                "\r\n\r\nCommand Line Script Successfully Run!\r\n\r\n",
                                log_tbl, dateStr, Global.rnUser_ID);
                        boolean success = (new java.io.File(batchFilnm)).delete();
                    } else if (rptType.equals("Import/Overwrite Data from Excel")
                            && !exclFileName.equals("")) {
                        //Check if  {:alert_type} EMAIL/SMS parameter was set
                        //NB sql first column is address and 2nd col is message body
                        //Global.imprtTrnsTmp(exclFileName, rpt_SQL.replace("\r\n", " ").replace("\n", " ").replace("\r", " "));
                        rpt_SQL = rpt_SQL.replace("{:orgnValColA}", "");
                    } else {
                        dtst = Global.selectDataNoParams(rpt_SQL.replace("\r\n", " ").replace("\n", " ").replace("\r", " "));
                    }
                    //Report Title is Message Title if Alert
                    String uptFileUrl = "";
                    if (alertID > 0 && msgSentID <= 0) {
                        alrtDtSt.next();
                        ResultSet dtstPrm = Global.get_RptParams(rpt_id);
                        ResultSetMetaData dtstmd = dtst.getMetaData();
                        dtst.last();
                        int ttlRws = dtst.getRow();
                        dtst.beforeFirst();
                        int ttlCols = dtstmd.getColumnCount();
                        for (int z = 0; z < ttlRws; z++) {
                            dtst.next();
                            toPrsnID = -1;
                            toCstmrSpplrID = -1;
                            toMails = alrtDtSt.getString(3);
                            ccMails = alrtDtSt.getString(4);
                            bccMails = alrtDtSt.getString(10);
                            sbjct = alrtDtSt.getString(9);
                            msgBdy = alrtDtSt.getString(5);
                            attchMns = alrtDtSt.getString(18);

                            for (int y = 0; y < ttlCols; y++) {
                                toMails = toMails.replace("{:" + dtstmd.getColumnName(y + 1) + "}", dtst.getString(y + 1));
                                ccMails = ccMails.replace("{:" + dtstmd.getColumnName(y + 1) + "}", dtst.getString(y + 1));
                                bccMails = bccMails.replace("{:" + dtstmd.getColumnName(y + 1) + "}", dtst.getString(y + 1));
                                sbjct = sbjct.replace("{:" + dtstmd.getColumnName(y + 1) + "}", dtst.getString(y + 1));
                                msgBdy = msgBdy.replace("{:" + dtstmd.getColumnName(y + 1) + "}", dtst.getString(y + 1));
                                attchMns = attchMns.replace("{:" + dtstmd.getColumnName(y + 1) + "}", dtst.getString(y + 1));

                                if (dtstmd.getColumnName(y + 1).equals("toPrsnID")) {
                                    toPrsnID = Long.parseLong(dtst.getString(y + 1));
                                }
                                if (dtstmd.getColumnName(y + 1).equals("toCstmrSpplrID")) {
                                    toCstmrSpplrID = Long.parseLong(dtst.getString(y + 1));
                                }
                            }

                            Thread.sleep(1000);
                            nwMsgSntID = Global.getNewMsgSentID();
                            Global.createAlertMsgSent(nwMsgSntID, toMails, ccMails, msgBdy, dateStr,
                                    sbjct, rpt_id, bccMails, toPrsnID, toCstmrSpplrID, alertID,
                                    attchMns, alertType);
                            if (alrtDtSt.getString(13).equals("1")) {
                                String prmIDs = "";
                                String prmVals = "";
                                String prmValsFnd = "";
                                dtstPrm.last();
                                int ttldtstPrm = dtstPrm.getRow();
                                dtstPrm.beforeFirst();
                                for (int x = 0; x < ttldtstPrm; x++) {
                                    dtstPrm.next();
                                    prmIDs += dtstPrm.getString(1) + "|";
                                    prmValsFnd = "";
                                    for (int r = 0; r < ttlCols; r++) {
                                        if (dtstPrm.getString(3).equals("{:" + dtstmd.getColumnName(r + 1) + "}")) {
                                            prmValsFnd = dtst.getString(r + 1);
                                            break;
                                        }
                                    }
                                    prmVals += prmValsFnd + "|";
                                }
                                rptDtSt.next();
                                String colsToGrp1 = rptDtSt.getString(8);
                                String colsToCnt1 = rptDtSt.getString(9);
                                String colsToSum1 = rptDtSt.getString(10);
                                String colsToAvrg1 = rptDtSt.getString(11);
                                String colsToFrmt1 = rptDtSt.getString(12);
                                String rpTitle = rptDtSt.getString(1);

                                //Report Title
                                prmVals += rpTitle + "|";
                                prmIDs += Global.sysParaIDs[0] + "|";
                                //Cols To Group
                                prmVals += colsToGrp1 + "|";
                                prmIDs += Global.sysParaIDs[1] + "|";
                                //Cols To Count
                                prmVals += colsToCnt1 + "|";
                                prmIDs += Global.sysParaIDs[2] + "|";
                                //Cols To Sum
                                prmVals += colsToSum1 + "|";
                                prmIDs += Global.sysParaIDs[3] + "|";
                                //colsToAvrg
                                prmVals += colsToAvrg1 + "|";
                                prmIDs += Global.sysParaIDs[4] + "|";
                                //colsToFrmt
                                prmVals += colsToFrmt1 + "|";
                                prmIDs += Global.sysParaIDs[5] + "|";

                                //outputUsd
                                prmVals += outputUsd + "|";
                                prmIDs += Global.sysParaIDs[6] + "|";

                                //orntnUsd
                                prmVals += orntnUsd + "|";
                                prmIDs += Global.sysParaIDs[7] + "|";

                                Program.gnrtAlertMailerfunc(rpt_id, Global.rnUser_ID, alertID, nwMsgSntID, prmIDs, prmVals, outputUsd, orntnUsd);
                            } else if (alertType.equals("Email")) {
                                errMsg = new String[1];
                                if (Global.sendEmail(StringUtils.strip(toMails.replace(",", ";"), seps1),
                                        StringUtils.strip(ccMails.replace(",", ";"), seps1),
                                        StringUtils.strip(bccMails.replace(",", ";"), seps1),
                                        StringUtils.strip(attchMns.replace(",", ";"), seps1),
                                        sbjct, msgBdy, errMsg) == false) {
                                    Global.updateAlertMsgSent(nwMsgSntID, dateStr, "0", Arrays.toString(errMsg));
                                } else {
                                    Global.updateAlertMsgSent(nwMsgSntID, dateStr, "1", "");
                                }
                            } else if (alertType.equals("SMS")) {
                                errMsg = new String[1];
                                if (Global.sendSMS(msgBdy,
                                        StringUtils.strip((toMails + ";" + ccMails + ";" + bccMails).replace(";", ","), seps),
                                        errMsg) == false) {
                                    Global.updateAlertMsgSent(nwMsgSntID, dateStr, "0", Arrays.toString(errMsg));
                                } else {
                                    Global.updateAlertMsgSent(nwMsgSntID, dateStr, "1", "");
                                }
                            } else {

                            }
                            if ((z % 100) == 0) {
                                Thread.sleep(60000);
                            }
                        }
                    } else if (rptType.equals("System Process")) {

                    } else if (rptType.equals("Alert(SQL Mail List)")) {
                        //check if {:msg_body} and {:alert_type} parameter was set
                        //NB sql first column must be valid email address
                    } else if (rptType.equals("Alert(SQL Mail List & Message)")) {
                        //Check if  {:alert_type} EMAIL/SMS parameter was set
                        //NB sql first column is address and 2nd col is message body
                    } else if (rptType.equals("Posting of GL Trns. Batches")) {
                        //NB sql col0=batch_id, col1=batch_name, col2=batch_source, col3=batch_status, col4=batch_status_meaning
                        //i.e SQL Must Contain accb.accb_trnsctn_batches and all the colnames above
                        //
                        ResultSet wrngDtst = Global.get_WrongBalncs(Global.UsrsOrg_ID);
                        wrngDtst.last();
                        int rwCnt = wrngDtst.getRow();
                        wrngDtst.beforeFirst();
                        if (rwCnt > 0) {
                            wrngDtst.next();
                            Global.updateLogMsg(msg_id,
                                    "\r\n\r\nCannot Post this Batch Since Some Accounts have wrong Balances!"
                                    + "\r\nPlease correct the Imbalance First!!\r\nUser Org ID=" + Global.UsrsOrg_ID
                                    + "\r\nNumber of Records Involved=" + rwCnt + "\r\n\r\n",
                                    log_tbl, dateStr, Global.rnUser_ID);
                            Program.correctImblns();
                            Global.updateRptRnStopCmd(Global.runID, "1");
                            Program.checkNClosePrgrm();
                            return;
                        } else {
                            //Check if no other accounting process is running
                            boolean isAnyRnng = true;
                            int witcntr = 0;
                            do {
                                witcntr++;
                                isAnyRnng = Global.isThereANActvActnPrcss("1,2,3,4,5,6", "10 second");
                                if (witcntr > 8) {
                                    Global.updateRptRnStopCmd(Global.runID, "1");
                                }
                                Program.checkNClosePrgrm();
                                Thread.sleep(5000);
                            } while (isAnyRnng == true);

                            dtst.beforeFirst();
                            dtst.last();
                            int rwsTtl = dtst.getRow();
                            dtst.beforeFirst();
                            for (int rh = 0; rh < rwsTtl; rh++) {
                                dtst.next();
                                Global.updtActnPrcss(5);
                                Program.validateBatchNPost(Long.parseLong(dtst.getString(1)),
                                        dtst.getString(4), dtst.getString(3),
                                        msg_id, log_tbl, dateStr);
                                Thread.sleep(200);
                            }
                        }
                    } else if (rptType.equals("Journal Import")) {
                        //check if {:intrfc_tbl_name} parameter was set
                        /*NB sql col0=accnt_id, col1=trnsctn_date(DD-Mon-YYYY HH24:MI:SS), 
                         * col2=dbt_amount, col3=crdt_amount, col4=net_amount, col5=func_cur_id*/
                        //
                        String[] errmsg = new String[1];
                        int prcID = 8;//Internal Payments Import Process
                        if (rqrdParamVal.equals("scm.scm_gl_interface")) {
                            prcID = 7;
                        }
                        boolean isAnyRnng = true;
                        int witcntr = 0;
                        do {
                            witcntr++;
                            isAnyRnng = Global.isThereANActvActnPrcss(String.valueOf(prcID), "10 second");
                            if (witcntr > 8) {
                                Global.updateRptRnStopCmd(Global.runID, "1");
                                Program.killThreads();
                            }
                            Program.updatePrgrm(prgmID);
                            Thread.sleep(5000);
                        } while (isAnyRnng == true);

                        Global.updtActnPrcss(prcID);
                        if (Program.sendJournalsToGL(dtst, rqrdParamVal, prcID, errmsg)) {
                            Global.updateLogMsg(msg_id,
                                    "\r\n\r\nJournals Successfully Sent to GL!\r\n" + errmsg, log_tbl, dateStr, Global.rnUser_ID);
                        } else {
                            Global.updateLogMsg(msg_id,
                                    "\r\n\r\nFailed to send Journals to GL!\r\n" + errmsg, log_tbl, dateStr, Global.rnUser_ID);
                        }
                    }
                    int totl = 0;
                    ResultSetMetaData dtstmd = null;
                    if (dtst != null) {
                        dtst.beforeFirst();
                        dtst.last();
                        totl = dtst.getRow();
                        dtst.beforeFirst();
                        dtstmd = dtst.getMetaData();
                    }
                    if (totl > 0) {
                        Global.updateLogMsg(msg_id, "\r\n\r\nSQL Statement successfully run! Total Records = " + totl, log_tbl, dateStr, Global.rnUser_ID);
                        //2. Check and Format Output in the dataset if Required
                        //Based on the 4 Output types decide what to do
                        //None|MICROSOFT EXCEL|HTML|STANDARD
                        Global.updateRptRn(rpt_run_id, "Formatting Output...", 60);
                        //Program.updatePrgrm(prgmID);
                        //worker.ReportProgress(60);
                        //String outputFileName = "";
                        rpt_SQL = rpt_SQL.replace("\r\n", " ").replace("\n", " ").replace("\r", " ");
                        if (!jsprFileName.equals("")) {
                            jsprFileName = Global.getRptDrctry() + "/jrxmls/" + jsprFileName;
                            String outFlNmOnly = "";
                            if (outputUsd.equals("MICROSOFT EXCEL")) {
                                uptFileUrl = Global.getRptDrctry() + "/" + String.valueOf(rpt_run_id) + ".xls";
                                outFlNmOnly = "/" + String.valueOf(rpt_run_id) + ".xls";
                                Global.runReport(outputUsd, uptFileUrl, jsprFileName, rptTitle, rpt_SQL);
                            } else if (outputUsd.equals("PDF")) {
                                uptFileUrl = Global.getRptDrctry() + "/" + String.valueOf(rpt_run_id) + ".pdf";
                                outFlNmOnly = "/" + String.valueOf(rpt_run_id) + ".pdf";
                                Global.updateLogMsg(Global.logMsgID, "\r\nBefore Jasper..." + uptFileUrl,
                                        Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
                                Global.runReport(outputUsd, uptFileUrl, jsprFileName, rptTitle, rpt_SQL);
                            } else if (outputUsd.equals("HTML")) {
                                uptFileUrl = Global.getRptDrctry() + "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html";
                                outFlNmOnly = "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html";
                                Global.runReport(outputUsd, uptFileUrl, jsprFileName, rptTitle, rpt_SQL);
                            } else if (outputUsd.equals("STANDARD")) {
                                uptFileUrl = Global.getRptDrctry() + "/" + String.valueOf(rpt_run_id) + ".pdf";
                                outFlNmOnly = "/" + String.valueOf(rpt_run_id) + ".pdf";
                                Global.runReport(outputUsd, uptFileUrl, jsprFileName, rptTitle, rpt_SQL);
                            } else if (outputUsd.equals("MICROSOFT WORD")) {
                                uptFileUrl = Global.getRptDrctry() + "/" + String.valueOf(rpt_run_id) + ".rtf";
                                outFlNmOnly = "/" + String.valueOf(rpt_run_id) + ".rtf";
                                Global.runReport(outputUsd, uptFileUrl, jsprFileName, rptTitle, rpt_SQL);
                            } else if (outputUsd.equals("CHARACTER SEPARATED FILE (CSV)")) {
                                uptFileUrl = Global.getRptDrctry() + "/" + String.valueOf(rpt_run_id) + ".csv";
                                outFlNmOnly = "/" + String.valueOf(rpt_run_id) + ".csv";
                                Global.runReport(outputUsd, uptFileUrl, jsprFileName, rptTitle, rpt_SQL);
                            } else {
                                outputUsd = "PDF";
                                uptFileUrl = Global.getRptDrctry() + "/" + String.valueOf(rpt_run_id) + ".pdf";
                                outFlNmOnly = "/" + String.valueOf(rpt_run_id) + ".pdf";
                                Global.runReport(outputUsd, uptFileUrl, jsprFileName, rptTitle, rpt_SQL);
                            }

                            System.out.println("Finished and Opening report...");
                            if (Global.callngAppType.equals("DESKTOP")) {
                                Global.upldImgsFTP(9, Global.getRptDrctry(), outFlNmOnly);
                            }
                        } else if (outputUsd.equals("CHARACTER SEPARATED FILE (CSV)")) {
                            Global.exprtDtStToCSV(dtst, Global.getRptDrctry() + "/" + String.valueOf(rpt_run_id) + ".csv", isfirst, islast, shdAppnd, rptdlmtr);
                            uptFileUrl = Global.getRptDrctry() + "/" + String.valueOf(rpt_run_id) + ".csv";
                        } else if (outputUsd.equals("COLUMN CHART")) {
                            Global.exprtToHTMLSCC(dtst,
                                    Global.getRptDrctry()
                                    + "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html",
                                    rptTitle, colsToGrp, colsToCnt, isfirst, islast, shdAppnd
                            );
                            uptFileUrl = Global.getRptDrctry()
                                    + "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html";
                        } else if (outputUsd.equals("PIE CHART"))//
                        {
                            Global.exprtToHTMLPC(dtst,
                                    Global.getRptDrctry()
                                    + "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html",
                                    rptTitle, colsToGrp, colsToCnt, isfirst, islast, shdAppnd
                            );
                            uptFileUrl = Global.getRptDrctry()
                                    + "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html";
                        } else if (outputUsd.equals("LINE CHART"))//
                        {
                            Global.exprtToHTMLLC(dtst,
                                    Global.getRptDrctry()
                                    + "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html",
                                    rptTitle, colsToGrp, colsToCnt, isfirst, islast, shdAppnd);
                            uptFileUrl = Global.getRptDrctry()
                                    + "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html";
                        } else if (outputUsd.equals("STANDARD")) {
                            if (rptLyout.equals("None") || rptLyout.equals("TABULAR")) {
                                if (totl == 1 && dtstmd.getColumnCount() == 1) {
                                    rptOutpt += dtst.getString(1);
                                } else {
                                    rptOutpt += Program.formatDtSt(dtst, rptTitle, colsToGrp, colsToCnt,
                                            colsToSum, colsToAvrg, colsToFrmt);
                                }
                            } else if (rptLyout.equals("DETAIL")) {
                                //Show detail STANDARD Report
                            }
                            if (islast) {
                                Program.writeAFile(Global.getRptDrctry() + "/" + String.valueOf(rpt_run_id) + ".txt", rptOutpt);
                                if (Global.callngAppType.equals("DESKTOP")) {
                                    Global.upldImgsFTP(9, Global.getRptDrctry(), String.valueOf(Global.runID) + ".txt");
                                }
                                uptFileUrl = Global.getRptDrctry() + "/" + String.valueOf(rpt_run_id)
                                        + ".txt";
                            }
                        } else {
                            Global.updateRptRnOutptUsd(rpt_run_id, "HTML");
                            if (rptLyout.equals("None") || rptLyout.equals("TABULAR")) {
                                Global.exprtToHTMLTblr(dtst,
                                        Global.getRptDrctry() + "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html",
                                        rptTitle, colsToGrp, colsToCnt, colsToSum, colsToAvrg, colsToFrmt, isfirst, islast, shdAppnd);
                            } else if (rptLyout.equals("DETAIL")) {
                                //Show detail HTML Report
                                ResultSet grpngsDtSt = Global.get_AllGrpngs(rpt_id);
                                Global.exprtToHTMLDet(dtst, grpngsDtSt,
                                        Global.getRptDrctry()
                                        + "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html",
                                        rptTitle, isfirst, islast, shdAppnd, orntnUsd, imgCols
                                );
                            }
                            uptFileUrl = Global.getRptDrctry()
                                    + "/amcharts_2100/samples/" + String.valueOf(rpt_run_id) + ".html";
                        }

                        Global.updateRptRn(rpt_run_id, "Storing Output...", 80);
                        //worker.ReportProgress(80);
                        Global.updateLogMsg(msg_id,
                                "\r\n\r\nSaving Report Output...", log_tbl, dateStr, Global.rnUser_ID);
                        Global.updateRptRnOutpt(rpt_run_id, rptOutpt);
                        Global.updateLogMsg(msg_id,
                                "\r\n\r\nSuccessfully Saved Report Output...", log_tbl, dateStr, Global.rnUser_ID);

                        if (msgSentID > 0) {
                            Global.updateRptRn(rpt_run_id, "Sending Output...", 81);
                            Global.updateLogMsg(msg_id,
                                    "\r\n\r\nSending Report Via Mail/SMS...", log_tbl, dateStr, Global.rnUser_ID);
                            ResultSet msgDtSt = Global.get_MsgSentDet(msgSentID);
                            msgDtSt.next();

                            toMails = msgDtSt.getString(1);
                            ccMails = msgDtSt.getString(2);
                            bccMails = msgDtSt.getString(7);
                            sbjct = msgDtSt.getString(5);
                            msgBdy = msgDtSt.getString(3);
                            attchMns = msgDtSt.getString(15) + ";" + uptFileUrl;
                            toPrsnID = Long.parseLong(msgDtSt.getString(8));
                            toCstmrSpplrID = Long.parseLong(msgDtSt.getString(9));
                            alertType = msgDtSt.getString(16);
                            errMsg = new String[1];
                            if (alertType.equals("Email")) {
                                if (Global.sendEmail(StringUtils.strip(toMails.replace(",", ";"), seps1),
                                        StringUtils.strip(ccMails.replace(",", ";"), seps1),
                                        StringUtils.strip(bccMails.replace(",", ";"), seps1),
                                        StringUtils.strip(attchMns.replace(",", ";"), seps1),
                                        sbjct, msgBdy,
                                        errMsg) == false) {
                                    Global.updateAlertMsgSent(nwMsgSntID, dateStr, "0", Arrays.toString(errMsg));
                                } else {
                                    Global.updateAlertMsgSent(nwMsgSntID, dateStr, "1", "");
                                }
                            } else if (alertType.equals("SMS")) {
                                if (Global.sendSMS(msgBdy, StringUtils.strip((toMails + ";" + ccMails + ";" + bccMails).replace(";", ","), seps), errMsg) == false) {
                                    Global.updateAlertMsgSent(nwMsgSntID, dateStr, "0", Arrays.toString(errMsg));
                                } else {
                                    Global.updateAlertMsgSent(nwMsgSntID, dateStr, "1", "");
                                }
                            } else {
                            }
                            Thread.sleep(1500);
                        }
                        Global.updateLogMsg(msg_id,
                                "\r\n\r\nSuccessfully Completed Process/Report Run...", log_tbl, dateStr, Global.rnUser_ID);
                        Global.updateRptRn(rpt_run_id, "Completed!", 100);

                        if (rptType.equals("Alert(SQL Message)")) {
                            //check if {:to_mail_list} and {:alert_type}  parameter was set
                            //NB entire sql output is message body 
                            //Report Output file must be added as attachment
                        }
                    } else {
                        Global.updateLogMsg(msg_id,
                                "\r\n\r\nSQL Statement yielded no Results!", log_tbl, dateStr, Global.rnUser_ID);
                        Global.updateLogMsg(msg_id,
                                "\r\n\r\nSuccessfully Completed Process/Report Run...", log_tbl, dateStr, Global.rnUser_ID);
                        Global.updateRptRn(rpt_run_id, "Completed!", 100);
                    }
                }
                Program.killThreads();
            }
            Program.killThreads();
        } catch (SQLException ex) {
            Global.errorLog = ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n\r\n";
            Global.writeToLog();
            Global.updateRptRn(Global.runID, "Error!", 100);

            long msg_id = Global.getGnrlRecID("rpt.rpt_run_msgs", "process_typ", "process_id", "msg_id", "Process Run", Global.runID);
            Global.updateLogMsg(msg_id,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    log_tbl, dateStr, Global.rnUser_ID);
            Program.killThreads();
        } catch (NumberFormatException ex) {
            Global.errorLog = ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n\r\n";
            Global.writeToLog();
            Global.updateRptRn(Global.runID, "Error!", 100);

            long msg_id = Global.getGnrlRecID("rpt.rpt_run_msgs", "process_typ", "process_id", "msg_id", "Process Run", Global.runID);
            Global.updateLogMsg(msg_id,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    log_tbl, dateStr, Global.rnUser_ID);
            Program.killThreads();
        } catch (IOException ex) {
            Global.errorLog = ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n\r\n";
            Global.writeToLog();
            Global.updateRptRn(Global.runID, "Error!", 100);

            long msg_id = Global.getGnrlRecID("rpt.rpt_run_msgs", "process_typ", "process_id", "msg_id", "Process Run", Global.runID);
            Global.updateLogMsg(msg_id,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    log_tbl, dateStr, Global.rnUser_ID);
            Program.killThreads();
        } catch (InterruptedException ex) {
            Global.errorLog = ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n\r\n";
            Global.writeToLog();
            Global.updateRptRn(Global.runID, "Error!", 100);

            long msg_id = Global.getGnrlRecID("rpt.rpt_run_msgs", "process_typ", "process_id", "msg_id", "Process Run", Global.runID);
            Global.updateLogMsg(msg_id,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    log_tbl, dateStr, Global.rnUser_ID);
            Program.killThreads();
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
