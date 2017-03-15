/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rems;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;
import javax.activation.URLDataSource;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
//import org.apache.commons.mail.settings.EmailConfiguration;
//import org.junit.Before;
//import org.junit.Test;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.*;
//import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import net.sf.jasperreports.engine.JRAlignment;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignImage;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.design.JRDesignLine;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleCsvReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleRtfReportConfiguration;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.*;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
//import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author richard.adjei-mensah
 */
public class Global {

    public static String HostOSNme = "windows";
    public static String Hostnme = "localhost";
    public static String Portnum = "5433";
    public static String Uname = "postgres";
    public static String Pswd = "Rho201410p";
    public static String Dbase = "test_database";
    public static long pid = -1;
    public static boolean mustStop = false;

    public static String errorLog = "";
    public static String rnnrsBasDir = "";//home/portaladmin/bin
    public static String dataBasDir = "";
    public static String callngAppType = "DESKTOP";
    public static Connection globalSQLConn = null;
    public static String AppKey = "ROMeRRTRREMhbnsdGeneral KeyZzfor Rhomi|com Systems "
            + "Tech. !Ltd Enterpise/Organization @763542ERPorbjkSOFTWARE"
            + "asdbhi68103weuikTESTfjnsdfRSTLU../";
    public static String AppUrl = "http://www.rhomicom.com";
    public static int UsrsOrg_ID = -1;
    public static long runID = -1;
    public static long rnUser_ID = -1;
    public static long ovrllDataCnt = 0;
    public static float oldoffsetY = 0;
    public static float hgstOffsetY = 0;
    public static int pageNo = 1;

    public static long logMsgID = -1;
    public static String logTbl = "";
    public static String gnrlDateStr = "";

    public static StringBuilder strSB = new StringBuilder("");
    public static String connStr = "jdbc:postgresql://" + Global.Hostnme + ":" + Global.Portnum + "/" + Global.Dbase + "";
    public static String appStatPath = "";
    public static String[] sysParaIDs = {"-130", "-140", "-150", "-160", "-170", "-180", "-190", "-200"};
    public static String[] sysParaNames = {"Report Title:", "Cols Nos To Group or Width & Height (Px) for Charts:",
        "Cols Nos To Count or Use in Charts:", "Columns To Sum:", "Columns To Average:",
        "Columns To Format Numerically:", "Report Output Formats", "Report Orientations"};

    public static ResultSet selectDataNoParams(String selSql) {
        ResultSet selDtSt = null;
        Statement stmt = null;
        try {
            Connection mycon = null;
            Class.forName("org.postgresql.Driver");
            mycon = DriverManager.getConnection(Global.connStr,
                    Global.Uname, Global.Pswd);
            mycon.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = mycon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            selDtSt = stmt.executeQuery(selSql);
            //stmt.close();
            //mycon.close();
            return selDtSt;
        } catch (Exception ex) {
            Global.errorLog = selSql + "\r\n" + ex.getMessage();
            Global.writeToLog();
            return selDtSt;
        } finally {
        }
    }

    public static void deleteDataNoParams(String delSql) {
        Statement stmt = null;
        try {
            Connection mycon = null;
            Class.forName("org.postgresql.Driver");
            mycon = DriverManager.getConnection(Global.connStr,
                    Global.Uname, Global.Pswd);
            mycon.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = mycon.createStatement();
            stmt.executeUpdate(delSql);
            mycon.commit();
            stmt.close();
            mycon.close();
        } catch (Exception ex) {
            Global.errorLog = delSql + "\r\n" + ex.getMessage();
            Global.writeToLog();
        } finally {

        }
    }

    public static void insertDataNoParams(String insSql) {
        Statement stmt = null;
        try {
            Connection mycon = null;
            Class.forName("org.postgresql.Driver");
            mycon = DriverManager.getConnection(Global.connStr,
                    Global.Uname, Global.Pswd);
            mycon.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = mycon.createStatement();
            stmt.executeUpdate(insSql);
            mycon.commit();
            stmt.close();
            mycon.close();
        } catch (Exception ex) {
            Global.errorLog = insSql + "\r\n" + ex.getMessage();
            Global.writeToLog();
        } finally {

        }
    }

    public static void updateDataNoParams(String updtSql) {
        Statement stmt = null;
        try {
            Connection mycon = null;
            Class.forName("org.postgresql.Driver");
            mycon = DriverManager.getConnection(Global.connStr,
                    Global.Uname, Global.Pswd);
            mycon.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = mycon.createStatement();
            stmt.executeUpdate(updtSql);
            mycon.commit();
            stmt.close();
            mycon.close();
        } catch (Exception ex) {
            Global.errorLog = updtSql + "\r\n" + ex.getMessage();
            Global.writeToLog();
        } finally {

        }
    }

    public static void executeGnrlSQL(String genSql) {
        Statement stmt = null;
        try {
            Connection mycon = null;
            Class.forName("org.postgresql.Driver");
            mycon = DriverManager.getConnection(Global.connStr,
                    Global.Uname, Global.Pswd);
            mycon.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = mycon.createStatement();
            stmt.executeUpdate(genSql);
            mycon.commit();
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n" + stmt.getWarnings().toString() + ": " + mycon.getWarnings().toString() + "\r\n",
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            stmt.close();
            mycon.close();
        } catch (Exception ex) {
            Global.errorLog = genSql + "\r\n" + ex.getMessage();
            Global.writeToLog();
        } finally {

        }
    }

    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void writeToLog() {
        try {
            String fileLoc = Global.rnnrsBasDir + "/log_files/";
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH");
            Date d = new Date();
            fileLoc += "ErrorLog" + String.valueOf(Global.runID).replace("-", "Neg") + "_" + df.format(d.getTime()) + ".rho";

            File file = new File(fileLoc);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Global.errorLog);
            bw.close();
            //System.out.println("Done");
        } catch (IOException e) {
            //e.printStackTrace();
        } finally {
        }
    }

    public static void updateLogMsg(long msgid, String logmsg,
            String logTblNm, String dateStr, long userID) {
        String updtSQL = "UPDATE " + logTblNm + " "
                + "SET log_messages=log_messages || '" + logmsg.replace("'", "''")
                + "', last_update_by=" + String.valueOf(userID)
                + ", last_update_date='" + dateStr
                + "' WHERE msg_id = " + String.valueOf(msgid);
        Global.updateDataNoParams(updtSQL);
    }

    static void MinimizeFootprint() {
//      EmptyWorkingSet(Process.GetCurrentProcess().Handle);
    }

    public static void minimizeMemory() {
        try {
//        GC.Collect(GC.MaxGeneration);
//        GC.WaitForPendingFinalizers();
//        SetProcessWorkingSetSize(Process.GetCurrentProcess().Handle,
//            (UIntPtr)0xFFFFFFFF, (UIntPtr)0xFFFFFFFF);
//        MinimizeFootprint();
        } catch (Exception ex) {
        }
    }

    public static void runSalesInvoice(String outputUsd, String outfileName, String jsprReportPath, String reportTitle, String rptSQL) {
        //String reportPath = "C:/1_DESIGNS/MYAPPS/REMSProcessRunner/reports/jasper2.jrxml";
        try {
            //Compile jrxml file.
            //System.out.println("Inside Jasper");
            //System.in.read();
            String orgNm = Global.getOrgName(Global.UsrsOrg_ID).replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
            String pstl = Global.getOrgPstlAddrs(Global.UsrsOrg_ID).replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
            //Contacts Nos
            String cntcts = Global.getOrgContactNos(Global.UsrsOrg_ID).replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
            //Email Address
            String email = Global.getOrgEmailAddrs(Global.UsrsOrg_ID).replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
            String website = Global.getOrgWebsite(Global.UsrsOrg_ID).replace("\r\n", " ").replace("\r", " ").replace("\n", " ");

            String online = "";
            if (!email.trim().equals("")) {
                online += "Email: " + email;
                if (!website.equals("")) {
                    online += " Website: " + website;
                }
            }
            String fileName = jsprReportPath;
            File theFile = new File(fileName);
            JasperDesign jasperDesign = JRXmlLoader.load(theFile);

            JRDesignBand band = new JRDesignBand();
            band.setHeight(90);

            JRDesignImage image = new JRDesignImage(jasperDesign);
            image.setX(1);
            image.setY(0);
            image.setHeight(70);
            image.setWidth(70);
            JRDesignExpression expression = new JRDesignExpression();
            //expression.setValueClass(java.lang.String.class);
            //C:/Users/richard.adjei-mensah/JaspersoftWorkspace/MyReports/1.png
            expression.setText("$P{ImageUrl}");
            image.setExpression(expression);
            band.addElement(image);

            JRDesignStaticText staticText = new JRDesignStaticText();
            staticText.setX(90);
            staticText.setY(2);
            staticText.setWidth(465);
            staticText.setHeight(15);
            //staticText.setHorizontalAlignment(JRAlignment.HORIZONTAL_ALIGN_CENTER);
            staticText.setText(orgNm);
            band.addElement(staticText);

            staticText = new JRDesignStaticText();
            staticText.setX(90);
            staticText.setY(16);
            staticText.setWidth(465);
            staticText.setHeight(15);
            //staticText.setHorizontalAlignment(JRAlignment.HORIZONTAL_ALIGN_CENTER);
            staticText.setText(pstl);
            band.addElement(staticText);

            staticText = new JRDesignStaticText();
            staticText.setX(90);
            staticText.setY(30);
            staticText.setWidth(465);
            staticText.setHeight(15);
            //staticText.setHorizontalAlignment(JRAlignment.HORIZONTAL_ALIGN_CENTER);
            staticText.setText(cntcts);
            band.addElement(staticText);

            staticText = new JRDesignStaticText();
            staticText.setX(90);
            staticText.setY(45);
            staticText.setWidth(465);
            staticText.setHeight(15);
            //staticText.setHorizontalAlignment(JRAlignment.HORIZONTAL_ALIGN_CENTER);
            staticText.setText(online);
            band.addElement(staticText);

            staticText = new JRDesignStaticText();
            staticText.setX(0);
            staticText.setY(73);
            staticText.setWidth(555);
            staticText.setHeight(15);
            staticText.setBold(true);
            staticText.setFontName("Arial");
            staticText.setUnderline(false);
            staticText.setFontSize(12F);
            staticText.setForecolor(Color.BLUE);
            staticText.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
            staticText.setText(reportTitle);
            band.addElement(staticText);

            JRDesignLine nwLine = new JRDesignLine();
            nwLine.setX(0);
            nwLine.setY(72);
            nwLine.setWidth(555);
            nwLine.setHeight(0);
            band.addElement(nwLine);

            nwLine = new JRDesignLine();
            nwLine.setX(0);
            nwLine.setY(88);
            nwLine.setWidth(555);
            nwLine.setHeight(0);
            band.addElement(nwLine);
            jasperDesign.setTitle(band);//setPageHeader

            //Build a new query
            //rptSQL
            String theQuery = "SELECT * FROM org.org_details WHERE org_name ilike '%%'";
            System.out.println(rptSQL);
            // update the data query
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(theQuery);
            jasperDesign.setQuery(newQuery);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            //JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);            
            Map<String, Object> params = new HashMap<String, Object>();
            //"C:/Users/richard.adjei-mensah/JaspersoftWorkspace/MyReports/1.png"
            params.put("ImageUrl", Global.getOrgImgsDrctry() + "/" + String.valueOf(Global.UsrsOrg_ID) + ".png");
            Connection connection;

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + Global.Hostnme + ":" + Global.Portnum + "/" + Global.Dbase,
                    Global.Uname, Global.Pswd);

            System.out.println("Filling report...");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);

            if (outputUsd.equals("MICROSOFT EXCEL")) {
                JRXlsExporter xlsExporter = new JRXlsExporter();

                xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outfileName));
                SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
                //SimpleXlsExporterConfiguration xlsExporterConfiguration = new SimpleXlsExporterConfiguration();
                xlsReportConfiguration.setOnePagePerSheet(false);
                xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
                xlsReportConfiguration.setDetectCellType(true);
                xlsReportConfiguration.setWhitePageBackground(false);
                xlsExporter.setConfiguration(xlsReportConfiguration);
                xlsExporter.exportReport();
            } else if (outputUsd.equals("PDF")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, outfileName);
            } else if (outputUsd.equals("HTML")) {
                JasperExportManager.exportReportToHtmlFile(jasperPrint, outfileName);
            } else if (outputUsd.equals("STANDARD")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, outfileName);
            } else if (outputUsd.equals("MICROSOFT WORD")) {
                JRRtfExporter rtfExporter = new JRRtfExporter();
                rtfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                rtfExporter.setExporterOutput(new SimpleWriterExporterOutput(outfileName));
                SimpleRtfReportConfiguration rtfReportConfiguration = new SimpleRtfReportConfiguration();
                //SimpleRtfExporterConfiguration xlsExporterConfiguration = new SimpleRtfExporterConfiguration();              
                rtfExporter.setConfiguration(rtfReportConfiguration);
                rtfExporter.exportReport();
            } else if (outputUsd.equals("CHARACTER SEPARATED FILE (CSV)")) {
                JRCsvExporter exporter = new JRCsvExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleWriterExporterOutput(outfileName));
                SimpleCsvReportConfiguration rtfReportConfiguration = new SimpleCsvReportConfiguration();
                //SimpleCsvExporterConfiguration xlsExporterConfiguration = new SimpleCsvExporterConfiguration();              
                exporter.setConfiguration(rtfReportConfiguration);
                exporter.exportReport();
            } else {
                JasperExportManager.exportReportToPdfFile(jasperPrint, outfileName);
            }

            //JasperViewer.viewReport(jasperPrint, false);
            System.out.println("Opening report");
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(outfileName);
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    // no application registered for PDFs
                }
            }
//            Runtime runTime = Runtime.getRuntime();
//            Process process = runTime
//            .exec("C:/Users/richard.adjei-mensah/Desktop/Test1.pdf");
//
//            System.out.println("Closing report");
//            process.destroy();
            connection.close();
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void runReport(String outputUsd, String outfileName, String jsprReportPath, String reportTitle, String rptSQL) {
        try {
            //Compile jrxml file. 
            System.out.println("Inside Jasper:" + jsprReportPath);
            Global.updateLogMsg(Global.logMsgID, "\r\nInside Jasper:" + jsprReportPath,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            //System.in.read();
            String orgNm = Global.getOrgName(Global.UsrsOrg_ID).replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
            String pstl = Global.getOrgPstlAddrs(Global.UsrsOrg_ID).replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
            //Contacts Nos
            String cntcts = Global.getOrgContactNos(Global.UsrsOrg_ID).replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
            //Email Address
            String email = Global.getOrgEmailAddrs(Global.UsrsOrg_ID).replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
            String website = Global.getOrgWebsite(Global.UsrsOrg_ID).replace("\r\n", " ").replace("\r", " ").replace("\n", " ");

            String online = "";
            if (!email.trim().equals("")) {
                online += "Email: " + email;
                if (!website.equals("")) {
                    online += " Website: " + website;
                }
            }
            String fileName = jsprReportPath;
            File theFile = new File(fileName);
            JasperDesign jasperDesign = JRXmlLoader.load(theFile);
            //Build a new query
            //rptSQL
            String theQuery = rptSQL;
            //System.out.println(rptSQL);
            // update the data query
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(theQuery);
            jasperDesign.setQuery(newQuery);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            System.out.println("Compiled Successfully");
            Global.updateLogMsg(Global.logMsgID, "\r\nCompiled Successfully",
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            //JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);            
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("P_ImageUrl", Global.getOrgImgsDrctry() + "/" + String.valueOf(Global.UsrsOrg_ID) + ".png");
            params.put("P_ReportTitle", reportTitle);
            params.put("P_OrgName", orgNm);
            params.put("P_OrgAddress", pstl);
            params.put("P_ContactInfo", cntcts);
            params.put("P_WebEmail", online);
            Connection connection;

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + Global.Hostnme + ":" + Global.Portnum + "/" + Global.Dbase, Global.Uname, Global.Pswd);

            System.out.println("Filling report...");
            Global.updateLogMsg(Global.logMsgID, "\r\nFilling report...",
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);

            if (outputUsd.equals("MICROSOFT EXCEL")) {
                JRXlsExporter xlsExporter = new JRXlsExporter();

                xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outfileName));
                SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
                //SimpleXlsExporterConfiguration xlsExporterConfiguration = new SimpleXlsExporterConfiguration();
                xlsReportConfiguration.setOnePagePerSheet(false);
                xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
                xlsReportConfiguration.setDetectCellType(true);
                xlsReportConfiguration.setWhitePageBackground(false);
                xlsExporter.setConfiguration(xlsReportConfiguration);
                xlsExporter.exportReport();
            } else if (outputUsd.equals("PDF")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, outfileName);
            } else if (outputUsd.equals("HTML")) {
                JasperExportManager.exportReportToHtmlFile(jasperPrint, outfileName);
            } else if (outputUsd.equals("STANDARD")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, outfileName);
            } else if (outputUsd.equals("MICROSOFT WORD")) {
                JRRtfExporter rtfExporter = new JRRtfExporter();
                rtfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                rtfExporter.setExporterOutput(new SimpleWriterExporterOutput(outfileName));
                SimpleRtfReportConfiguration rtfReportConfiguration = new SimpleRtfReportConfiguration();
                //SimpleRtfExporterConfiguration xlsExporterConfiguration = new SimpleRtfExporterConfiguration();              
                rtfExporter.setConfiguration(rtfReportConfiguration);
                rtfExporter.exportReport();
            } else if (outputUsd.equals("CHARACTER SEPARATED FILE (CSV)")) {
                JRCsvExporter exporter = new JRCsvExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleWriterExporterOutput(outfileName));
                SimpleCsvReportConfiguration rtfReportConfiguration = new SimpleCsvReportConfiguration();
                //SimpleCsvExporterConfiguration xlsExporterConfiguration = new SimpleCsvExporterConfiguration();              
                exporter.setConfiguration(rtfReportConfiguration);
                exporter.exportReport();
            } else {
                JasperExportManager.exportReportToPdfFile(jasperPrint, outfileName);
            }

            //JasperViewer.viewReport(jasperPrint, false);
//            if (Desktop.isDesktopSupported() && Global.callngAppType.equals("DESKTOP")) {
//                try {
//                    File myFile = new File(outfileName);
//                    Desktop.getDesktop().open(myFile);
//                } catch (IOException ex) {
//                    // no application registered for PDFs
//                }
//            }
//            Runtime runTime = Runtime.getRuntime();
//            Process process = runTime
//            .exec("C:/Users/richard.adjei-mensah/Desktop/Test1.pdf");
//
//            System.out.println("Closing report");
//            process.destroy();
            connection.close();
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
            Global.errorLog += ex.getMessage() + System.getProperty("line.separator") + ex.toString() + Arrays.toString(ex.getStackTrace());
            Global.writeToLog();
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nLog Messages ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            Global.errorLog += e.getMessage() + System.getProperty("line.separator") + Arrays.toString(e.getStackTrace());
            Global.writeToLog();
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nLog Messages ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Global.errorLog += e.getMessage() + System.getProperty("line.separator") + Arrays.toString(e.getStackTrace());
            Global.writeToLog();
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nLog Messages ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Global.errorLog += ex.getMessage() + System.getProperty("line.separator") + Arrays.toString(ex.getStackTrace());
            Global.writeToLog();
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nLog Messages ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
        } finally {
            //System.out.println(ex.getMessage());
            //Global.errorLog += ex.getMessage();
            Global.writeToLog();
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nLog Messages ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Global.errorLog += e.getMessage() + System.getProperty("line.separator") + Arrays.toString(e.getStackTrace());
            Global.writeToLog();
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nLog Messages ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
        }
    }

    public static long getNewMsgSentID() throws SQLException {
        //String strSql = "select nextval('accb.accb_trnsctn_batches_batch_id_seq'::regclass);";
        String strSql = "select nextval('alrt.alrt_msgs_sent_msg_sent_id_seq')";
        ResultSet dtst = Global.selectDataNoParams(strSql);
        while (dtst.next()) {
            return dtst.getLong(1);
        }
        return -1;
    }

    public static ResultSet get_RptRun_Det(long rptRunID) {
        String strSql = "SELECT run_by, run_date, rpt_run_output, run_status_txt, "
                + "run_status_prct, report_id, rpt_rn_param_ids, rpt_rn_param_vals, "
                + "output_used, orntn_used, last_actv_date_tme, is_this_from_schdler, "
                + "shld_run_stop, alert_id, msg_sent_id "
                + "FROM rpt.rpt_report_runs WHERE rpt_run_id = " + String.valueOf(rptRunID);
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static ResultSet get_RptDet(long rptID) {
        String strSql = "SELECT report_name, report_desc, rpt_sql_query, owner_module, "
                + "created_by, rpt_or_sys_prcs, is_enabled, cols_to_group, cols_to_count, cols_to_sum,"
                + "cols_to_average, cols_to_no_frmt, output_type, portrait_lndscp, "
                + "rpt_layout, imgs_col_nos, csv_delimiter, process_runner, is_seeded_rpt, jrxml_file_name "
                + "FROM rpt.rpt_reports WHERE report_id = " + String.valueOf(rptID);
        //System.out.println(strSql);
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static ResultSet get_AlertDet(long alertID) {
        String strSql = "SELECT alert_name, alert_desc, to_mail_num_list_mnl, cc_mail_num_list_mnl, "
                + "alert_msg_body_mnl, alert_type, created_by, is_enabled, msg_sbjct_mnl, bcc_mail_num_list_mnl, "
                + "paramtr_sets_gnrtn_sql, report_id, shd_rpt_be_run, start_dte_tme, "
                + "repeat_uom, repeat_every, run_at_spcfd_hour, attchment_urls, "
                + "end_hour "
                + "FROM alrt.alrt_alerts WHERE alert_id = " + String.valueOf(alertID);
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static ResultSet get_MsgSentDet(long msgSentID) {
        String strSql = "SELECT to_list, cc_list, msg_body, date_sent, msg_sbjct, "
                + "report_id, bcc_list, person_id, cstmr_spplr_id, created_by, creation_date,"
                + "alert_id, sending_status, err_msg, attch_urls"
                + ", msg_type FROM alrt.alrt_msgs_sent WHERE msg_sent_id = " + String.valueOf(msgSentID);
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static String get_Rpt_SQL(long rptID) throws SQLException {
        String strSql = "SELECT rpt_sql_query "
                + "FROM rpt.rpt_reports WHERE report_id = " + String.valueOf(rptID);

        ResultSet dtst = Global.selectDataNoParams(strSql);
        while (dtst.next()) {
            return dtst.getString(1);
        }
        return "";
    }

    public static String get_Alert_SQL(long alertID) {
        try {
            String strSql = "SELECT paramtr_sets_gnrtn_sql "
                    + "FROM alrt.alrt_alerts WHERE alert_id = " + alertID;

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static void updateRptRn(long rptrnid, String statustxt, int statusprcnt) {
        //String dateStr = Global.getDB_Date_time();
        String updtSQL = "UPDATE rpt.rpt_report_runs SET "
                + "run_status_txt = '" + statustxt.replace("'", "''")
                + "', run_status_prct = " + String.valueOf(statusprcnt)
                + " WHERE (rpt_run_id = " + String.valueOf(rptrnid) + ")";
        Global.updateDataNoParams(updtSQL);
    }

    public static void updateRptRnActvTme(long rptrnid, String lstAtvTme) {
        //String dateStr = Global.getDB_Date_time();
        String updtSQL = "UPDATE rpt.rpt_report_runs SET "
                + "last_actv_date_tme = '" + lstAtvTme.replace("'", "''")
                + "' WHERE (rpt_run_id = " + rptrnid + ")";
        Global.updateDataNoParams(updtSQL);
    }

    public static void updateRptRnOutpt(long rptrnid, String outputTxt) {
        //String dateStr = Global.getDB_Date_time();
        String updtSQL = "UPDATE rpt.rpt_report_runs SET "
                + "rpt_run_output = '" + outputTxt.replace("'", "''")
                + "' WHERE (rpt_run_id = " + String.valueOf(rptrnid) + ")";
        Global.updateDataNoParams(updtSQL);
    }

    public static void updateRptRnOutptUsd(long rptrnid, String outputUsd) {
        //String dateStr = Global.getDB_Date_time();
        String updtSQL = "UPDATE rpt.rpt_report_runs SET "
                + "output_used = '" + outputUsd.replace("'", "''")
                + "' WHERE (rpt_run_id = " + String.valueOf(rptrnid) + ")";
        Global.updateDataNoParams(updtSQL);
    }

    public static int getLovID(String lovName) {
        try {
            String sqlStr = "SELECT value_list_id from gst.gen_stp_lov_names "
                    + "where(value_list_name = '"
                    + lovName.replace("'", "''") + "')";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static String getOrgName(int orgid) {
        try {
            //Example username 'admin'
            String sqlStr = "select org_name from org.org_details where org_id = "
                    + String.valueOf(orgid) + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String getOrgPstlAddrs(int orgid) {
        try {
            //Example username 'admin'
            String sqlStr = "select pstl_addrs from org.org_details where org_id = "
                    + String.valueOf(orgid) + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String getOrgEmailAddrs(int orgid) {
        try {
//Example username 'admin'
            String sqlStr = "select email_addrsses from org.org_details where org_id = "
                    + String.valueOf(orgid) + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String getOrgContactNos(int orgid) {
        try {
//Example username 'admin'
            String sqlStr = "select cntct_nos from org.org_details where org_id = "
                    + String.valueOf(orgid) + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String getOrgWebsite(int orgid) {
        try {
            String sqlStr = "select websites from org.org_details where org_id = "
                    + String.valueOf(orgid) + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String getOrgSlogan(int orgid) {
        try {
            String sqlStr = "select org_slogan from org.org_details where org_id = "
                    + String.valueOf(orgid) + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static int getOrgFuncCurID(int orgid) {
        try {
            String sqlStr = "select oprtnl_crncy_id from org.org_details where org_id = "
                    + String.valueOf(orgid) + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static String getOrgImgsDrctry() {
        return Global.dataBasDir + "/Org";
    }

    public static String getRptDrctry() {
        return Global.dataBasDir + "/Rpts";
    }

    public static int getRptID(String rptNm) {
        int res = -1;
        try {
            String strSql = "SELECT report_id "
                    + "FROM rpt.rpt_reports WHERE report_name = '" + rptNm.replace("'", "''") + "'";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                res = dtst.getInt(1);
                dtst.close();
                return res;
            }
            return res;
        } catch (SQLException ex) {
            return res;
        }
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

    public static String breakTxtDownHTML(String inptTxt, int allwdWidth) {
        String res = "";
        int strtIdx = 0;
        for (int i = 0; i < inptTxt.length(); i++) {
            if (strtIdx >= allwdWidth - 1 && String.valueOf(inptTxt.charAt(i)).equals(" ")) {
                res = res + String.valueOf(inptTxt.charAt(i)) + "<br/>";
                strtIdx = 0;
            } else {
                res = res + String.valueOf(inptTxt.charAt(i));
                strtIdx++;
            }
        }
        return res;
    }

    public String insrtSpaces(String inptTxt, int allwdWidth) {
        String nwstr = "";
        for (int i = 0; i < inptTxt.length(); i++) {
            nwstr = nwstr + String.valueOf(inptTxt.charAt(i));
            if ((nwstr.length() >= allwdWidth) && (i % allwdWidth) == 0) {
                nwstr = nwstr + " ";
            }
        }
        return nwstr;
    }

    public static String[] breakTxtDown(String inptTxt, float allwdWidth, Font fnt, Graphics g) {
        List<String> nwstr = new ArrayList<String>();
        String nwln = "";
        float lnWidth = 0;
        int lnCntr = 0;
        inptTxt = inptTxt.replace("\r\n", "").replace("\n", "").replace("\r", "");
        String chstr = "\\ ";
        String[] nwInpt = inptTxt.split(chstr);
        for (int i = 0; i < nwInpt.length; i++) {
            int szeWdth = g.getFontMetrics(fnt).stringWidth(nwInpt[i] + " ");
            lnWidth += (float) szeWdth;
            if (lnWidth > allwdWidth) {
                nwstr.add(nwln);
                nwln = nwInpt[i] + " ";
                //nwln = "";
                lnWidth = (float) szeWdth;
            } else {
                nwln = nwln + nwInpt[i] + " ";
            }
            lnCntr++;
            if ((i == nwInpt.length - 1)
                    && (lnWidth <= allwdWidth)
                    && (!nwln.equals(""))) {
                nwstr.add(nwln);
            }
        }
        String[] rslts = new String[nwstr.size()];
        rslts = (String[]) nwstr.toArray();
        return rslts;
    }

    public static String get_user_name(long userID) {
        try {
            //Gets the last password change date
            String sqlStr = "SELECT user_name FROM "
                    + "sec.sec_users WHERE user_id = " + String.valueOf(userID) + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String get_Gnrl_Rec_Hstry(long rowID, String tblnm, String id_col_nm) {
        try {
            String strSQL = "SELECT a.created_by,"
                    + "to_char(to_timestamp(a.creation_date,'YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS'), "
                    + "a.last_update_by, "
                    + "to_char(to_timestamp(a.last_update_date,'YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS') "
                    + "FROM " + tblnm + " a WHERE(a." + id_col_nm + " = " + String.valueOf(rowID) + ")";
            String fnl_str = "";
            ResultSet dtst = Global.selectDataNoParams(strSQL);
            while (dtst.next()) {
                fnl_str = "CREATED BY: " + Global.get_user_name(dtst.getLong(1))
                        + "\r\nCREATION DATE: " + dtst.getString(2) + "\r\nLAST UPDATE BY:"
                        + Global.get_user_name(dtst.getLong(3))
                        + "\r\nLAST UPDATE DATE: " + dtst.getString(4);
                return fnl_str;
            }
            return fnl_str;
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String get_Gnrl_Create_Hstry(long rowID, String tblnm, String id_col_nm) {
        try {
            String strSQL = "SELECT a.created_by, "
                    + "to_char(to_timestamp(a.creation_date,'YYYY-MM-DD HH24:MI:SS'"
                    + "),'DD-Mon-YYYY HH24:MI:SS') "
                    + "FROM " + tblnm + " a WHERE(a." + id_col_nm + " = " + String.valueOf(rowID) + ")";
            String fnl_str = "";
            ResultSet dtst = Global.selectDataNoParams(strSQL);
            while (dtst.next()) {
                fnl_str = "CREATED BY: " + Global.get_user_name(dtst.getLong(1))
                        + "\r\nCREATION DATE: " + dtst.getString(2);
                return fnl_str;
            }
            return fnl_str;
        } catch (SQLException ex) {
            return "";
        }
    }

    public static int getUsrOrgID(long usrID) {
        try {
            //sec.get_usr_prsn_id(
            String sqlStr = "SELECT org_id FROM "
                    + "prs.prsn_names_nos WHERE person_id = sec.get_usr_prsn_id(" + String.valueOf(usrID) + ")";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static long getGnrlRecID(String tblNm, String srchcol, String rtrnCol,
            String recname, int orgid) {
        try {
            String sqlStr = "select " + rtrnCol + " from " + tblNm + " where lower(" + srchcol + ") = '"
                    + recname.replace("'", "''").toLowerCase() + "' and org_id = " + String.valueOf(orgid);
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static long getGnrlRecID(String tblNm, String srchcol, String rtrnCol, String recname) {
        try {
            String sqlStr = "select " + rtrnCol + " from " + tblNm + " where lower(" + srchcol + ") = '"
                    + recname.replace("'", "''").toLowerCase() + "'";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static long getGnrlRecID(String tblNm, String srchcolForNM, String srchcolForID, String rtrnCol, String recname, long recID) {
        try {
            String sqlStr = "select " + rtrnCol + " from " + tblNm + " where lower(" + srchcolForNM + ") = '"
                    + recname.replace("'", "''").toLowerCase() + "' and " + srchcolForID + " = " + String.valueOf(recID);
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static String getGnrlRecNm(String tblNm, String srchcol, String rtrnCol, long recid) {
        try {
            String sqlStr = "select " + rtrnCol + " from " + tblNm + " where " + srchcol + " = " + String.valueOf(recid);
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String getGnrlRecNm(String tblNm, String srchcol, String rtrnCol, String srchword) {
        String res = "";
        try {
            String sqlStr = "select " + rtrnCol + " from " + tblNm + " where " + srchcol + " = '" + srchword.replace("'", "''") + "'";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                res = dtst.getString(1);
                dtst.close();
                return res;
            }
            return res;
        } catch (SQLException ex) {
            return res;
        }
    }

    public static String getDB_Date_time() {
        String res = "";
        try {
            String sqlStr = "select to_char(now(), 'YYYY-MM-DD HH24:MI:SS')";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                res = dtst.getString(1);
                dtst.close();
                return res;
            }
            return res;
        } catch (SQLException ex) {
            return res;
        }
    }

    public static String getFrmtdDB_Date_time() {
        String res = "";
        try {
            String sqlStr = "select to_char(now(), 'DD-Mon-YYYY HH24:MI:SS')";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                res = dtst.getString(1);
                dtst.close();
                return res;
            }
            return res;
        } catch (SQLException ex) {
            return res;
        }
    }

    public static String[] getMachDetails() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        String[] nameIP = new String[3];
        nameIP[0] = "";
        nameIP[1] = "";
        nameIP[2] = "";
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            /*Enumeration e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                //
                if (n.isLoopback() || n.isVirtual() || !n.isUp()) {

                } else if (n.isUp()) {
                    Enumeration ee = n.getInetAddresses();
                    while (ee.hasMoreElements()) {
                        InetAddress i = (InetAddress) ee.nextElement();
                        //System.out.println(i.getHostAddress());
                        //nameIP[2] = i.getHostAddress();
                        ip = i;
                        //break;
                    }
                    //break;
                }
            }*/
            nameIP[2] = ip.getHostAddress();
            hostname = ip.getHostName();
            nameIP[0] = hostname;
            //System.out.println("Current IP address : " + ip.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            //System.out.print("Current MAC address : ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            //System.out.println(sb.toString());
            nameIP[1] = sb.toString();
            return nameIP;
        } catch (SocketException e) {
            return nameIP;
        } catch (UnknownHostException ex) {
            return nameIP;
        } catch (Exception ex) {
            return nameIP;
        }
    }

    public static void updatePrcsRnnr(long rnnrID, String lstActvTm, String stats) {
        //String dateStr = Global.getDB_Date_time();
        String insSQL = "UPDATE rpt.rpt_prcss_rnnrs SET "
                + "rnnr_lst_actv_dtetme ='" + lstActvTm.replace("'", " ''")
                + "', last_update_by=-1, last_update_date='" + lstActvTm
                + "', rnnr_status='" + stats.replace("'", "''")
                + "' WHERE prcss_rnnr_id = " + String.valueOf(rnnrID);
        Global.updateDataNoParams(insSQL);
    }

    public static boolean isRunnrRnng(String rnnrNm) {
        try {
            String selSQL = "SELECT 1 FROM rpt.rpt_prcss_rnnrs WHERE rnnr_name ='"
                    + rnnrNm.replace("'", " ''") + "' and age(now(), to_timestamp(CASE WHEN rnnr_lst_actv_dtetme ='' "
                    + "THEN '2013-01-01 00:00:00' ELSE rnnr_lst_actv_dtetme END, 'YYYY-MM-DD HH24:MI:SS')) "
                    + "<= interval '300 second'";
            ResultSet dtst = Global.selectDataNoParams(selSQL);
            while (dtst.next()) {
                dtst.close();
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static boolean isRunnrRnngOnThsMch(String rnnrNm, String macAddrs, String ipAddrs) {
        try {
            String selSQL = "SELECT prcss_rnnr_id "
                    + "FROM rpt.rpt_prcss_rnnrs WHERE rnnr_name ='" + rnnrNm.replace("'", " ''")
                    + "' and rnnr_status ilike '%" + macAddrs + "%' and rnnr_status ilike '%" + ipAddrs + "%'";
            ResultSet dtst = Global.selectDataNoParams(selSQL);
            while (dtst.next()) {
                dtst.close();
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static ResultSet get_AllPrgmUnts(long rptID) {
        String strSql = "SELECT program_unit_id, "
                + "rpt.get_rpt_name(program_unit_id) prg_nm FROM rpt.rpt_set_prgrm_units "
                + "WHERE report_set_id = " + rptID + "";

        //Global.mnFrm.roles_SQL = strSql;
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static ResultSet get_AllGrpngs(long rptID) {
        String strSql = "SELECT title, grp_width_desc, grp_min_height_px, grp_border, "
                + "grp_dsply_type, nof_cols_wthn, col_nos, label_max_width, "
                + "column_hdr_names, delimiter_col_vals, delimiter_row_vals, "
                + "grp_order, group_id FROM rpt.rpt_det_rpt_grps WHERE report_id = " + rptID
                + " ORDER BY grp_order, group_id";
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static void updatePrcsRnnrCmd(String rnnrNm, String cmdStr, long uid) {
        String dateStr = Global.getDB_Date_time();
        String insSQL = "UPDATE rpt.rpt_prcss_rnnrs SET "
                + "shld_rnnr_stop ='" + cmdStr.replace("'", " ''")
                + "', last_update_by=" + uid + ", last_update_date='" + dateStr
                + "' WHERE rnnr_name = '" + rnnrNm.replace("'", "''") + "'";
        Global.insertDataNoParams(insSQL);
    }

    public static void updateRptRnStopCmd(long rptrnid, String cmdStr) {
        //String dateStr = Global.getDB_Date_time();
        String updtSQL = "UPDATE rpt.rpt_report_runs SET "
                + "shld_run_stop = '" + cmdStr.replace("'", "''")
                + "' WHERE (rpt_run_id = " + rptrnid + ")";
        Global.updateDataNoParams(updtSQL);
    }

    public static ResultSet get_UsrRunsNtRnng() {
        String selSQL = "SELECT MIN(a.rpt_run_id), a.report_id, a.run_by"
                + "FROM rpt.rpt_report_runs a "
                + "WHERE a.is_this_from_schdler = '0' and a.run_status_txt != 'Completed!'"
                + " and a.run_status_txt != 'Error!'"
                + " and a.shld_run_stop = '0' "
                + "and a.run_status_prct< 100 and a.last_actv_date_tme != ''"
                + " and age(now(), to_timestamp(a.last_actv_date_tme, 'YYYY-MM-DD HH24:MI:SS'))"
                + "> interval '50 second'"
                + " GROUP BY a.report_id, a.run_by ORDER BY 1 ASC";
        ResultSet dtst = Global.selectDataNoParams(selSQL);
        return dtst;
    }

    public static ResultSet get_SchdldRunsNtRnng() {
        String selSQL = "SELECT MIN(a.rpt_run_id), a.report_id, a.run_by "
                + "FROM rpt.rpt_report_runs a "
                + "WHERE a.is_this_from_schdler = '1' and a.alert_id <= 0 and a.run_status_txt != 'Completed!' "
                + "and a.run_status_txt != 'Error!' "
                + "and a.shld_run_stop = '0' "
                + "and a.run_status_prct< 100 and a.last_actv_date_tme != '' "
                + "and age(now(), to_timestamp(a.last_actv_date_tme, 'YYYY-MM-DD HH24:MI:SS')) "
                + "> interval '50 second' "
                + "and a.report_id IN (SELECT a.report_id FROM rpt.rpt_run_schdules a, rpt.rpt_reports b "
                + "WHERE a.report_id = b.report_id and a.repeat_every > 0 and(CASE WHEN run_at_spcfd_hour = '0' and age(now() "
                + ", to_timestamp(to_char(now(),'YYYY-MM-DD')|| ' ' ||  "
                + "to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS' "
                + "))>= interval '1 second' THEN 1  "
                + "WHEN run_at_spcfd_hour = '1' and to_char(now(), 'HH24:00:00') = to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24:00:00') THEN 1  ELSE 0 END) =1) "
                + "GROUP BY a.report_id, a.run_by ORDER BY 1 ASC";
        ResultSet dtst = Global.selectDataNoParams(selSQL);
        return dtst;
    }

    public static ResultSet get_SchdldAlertsNtRnng() {
        String selSQL = "SELECT MIN(a.rpt_run_id), a.report_id, a.run_by "
                + "FROM rpt.rpt_report_runs a "
                + "WHERE /*a.is_this_from_schdler = '1' and*/ a.alert_id > 0 and a.run_status_txt != 'Completed!' "
                + "and a.run_status_txt != 'Error!' "
                + "and a.shld_run_stop = '0' "
                + "and a.run_status_prct< 100 and a.last_actv_date_tme != '' "
                + "and age(now(), to_timestamp(a.last_actv_date_tme, 'YYYY-MM-DD HH24:MI:SS')) > interval '50 second' "
                + "and a.report_id IN (SELECT a.report_id FROM alrt.alrt_alerts a, rpt.rpt_reports b "
                + "WHERE a.report_id = b.report_id and a.repeat_every > 0 and(CASE WHEN run_at_spcfd_hour = '0' "
                + " and age(now(), to_timestamp(to_char(now(),'YYYY-MM-DD')|| ' ' || "
                + "to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS'))>= interval '1 second' THEN 1 "
                + "WHEN run_at_spcfd_hour = '1' and chartoint(to_char(now(),'HH24')) >= chartoint(to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24')) "
                + "and chartoint(to_char(now(),'HH24'))< end_hour THEN 1 ELSE 0 END) =1) "
                + "GROUP BY a.report_id, a.run_by ORDER BY 1 ASC";
        ResultSet dtst = Global.selectDataNoParams(selSQL);
        return dtst;
    }

    public static ResultSet get_UserAlertsNtRnng() {
        String selSQL = "SELECT MIN(a.rpt_run_id), a.report_id, a.run_by "
                + "FROM rpt.rpt_report_runs a "
                + "WHERE /*a.is_this_from_schdler = '1' and*/ a.alert_id > 0 and a.run_status_txt != 'Completed!' "
                + "and a.run_status_txt != 'Error!' "
                + "and a.shld_run_stop = '0' "
                + "and a.run_status_prct< 100 and a.last_actv_date_tme != '' "
                + "and age(now(), to_timestamp(a.last_actv_date_tme, 'YYYY-MM-DD HH24:MI:SS')) > interval '50 second' "
                + "and a.report_id NOT IN(SELECT  a.report_id FROM alrt.alrt_alerts a, rpt.rpt_reports b "
                + "WHERE a.report_id = b.report_id and a.repeat_every > 0 and(CASE WHEN run_at_spcfd_hour = '0' "
                + "and age(now(), to_timestamp(to_char(now(),'YYYY-MM-DD')|| ' ' || "
                + "to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS'))>= interval '1 second' THEN 1 "
                + "WHEN run_at_spcfd_hour = '1' and chartoint(to_char(now(),'HH24')) >= chartoint(to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24')) "
                + "and chartoint(to_char(now(),'HH24'))<end_hour THEN 1 ELSE 0 END) =1) "
                + "GROUP BY a.report_id, a.run_by ORDER BY 1 ASC";
        ResultSet dtst = Global.selectDataNoParams(selSQL);
        return dtst;
    }

    public static ResultSet get_Schdules() {
        String selSQL = "SELECT a.schedule_id, a.report_id, b.report_name, a.start_dte_tme, "
                + "a.repeat_every, trim(lower(trim(both '(s)' from a.repeat_uom))) uom, a.created_by "
                + "FROM rpt.rpt_run_schdules a, rpt.rpt_reports b "
                + "WHERE a.report_id = b.report_id and a.repeat_every > 0 and(CASE WHEN run_at_spcfd_hour = '0' "
                + "and age(now(), to_timestamp(to_char(now(),'YYYY-MM-DD')|| ' ' || "
                + "to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS'))>= interval '1 second' THEN 1 "
                + "WHEN run_at_spcfd_hour = '1' and to_char(now(),'HH24:00:00')=to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24:00:00') THEN 1 ELSE 0 END) =1"
                + " ORDER BY a.schedule_id DESC";
        ResultSet dtst = Global.selectDataNoParams(selSQL);
        return dtst;
    }

    public static ResultSet get_AlertSchdules() {
        String selSQL = "SELECT a.alert_id, a.report_id, b.report_name, "
                + "a.start_dte_tme, a.repeat_every, trim(lower(trim(both '(s)' from a.repeat_uom))) uom, "
                + "a.created_by, a.to_mail_num_list_mnl, a.cc_mail_num_list_mnl, a.bcc_mail_num_list_mnl, "
                + "a.msg_sbjct_mnl, a.alert_msg_body_mnl, a.attchment_urls, a.alert_type"
                + ", a.end_hour FROM alrt.alrt_alerts a, rpt.rpt_reports b "
                + "WHERE a.report_id = b.report_id and a.repeat_every > 0 and(CASE WHEN run_at_spcfd_hour = '0' "
                + "and age(now(), to_timestamp(to_char(now(),'YYYY-MM-DD')|| ' ' || "
                + "to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS'))>= interval '1 second' THEN 1 "
                + "WHEN run_at_spcfd_hour = '1' and to_char(now(),'HH24:00:00')=to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24:00:00') THEN 1 ELSE 0 END) =1 "
                + "ORDER BY a.alert_id DESC";
        ResultSet dtst = Global.selectDataNoParams(selSQL);
        return dtst;
    }

    public static ResultSet get_AlertSchdules(long rptID) {
        String selSQL = "SELECT a.alert_id, a.report_id, b.report_name, a.start_dte_tme, "
                + "a.repeat_every, trim(lower(trim(both '(s)' from a.repeat_uom))) uom, a.created_by, "
                + "a.to_mail_num_list_mnl, a.cc_mail_num_list_mnl, a.bcc_mail_num_list_mnl, "
                + "a.msg_sbjct_mnl, a.alert_msg_body_mnl, a.attchment_urls, a.alert_type, a.end_hour "
                + "FROM alrt.alrt_alerts a, rpt.rpt_reports b "
                + "WHERE a.report_id = b.report_id and a.repeat_every > 0 and (CASE WHEN run_at_spcfd_hour = '0' "
                + "and age(now(), to_timestamp(to_char(now(),'YYYY-MM-DD')|| ' ' || "
                + "to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS'))>= interval '1 second' THEN 1 "
                + "WHEN run_at_spcfd_hour = '1' and to_char(now(),'HH24:00:00')=to_char(to_timestamp(start_dte_tme, 'YYYY-MM-DD HH24:MI:SS'),'HH24:00:00') THEN 1 ELSE 0 END) =1 "
                + "and a.report_id = " + String.valueOf(rptID) + " ORDER BY a.alert_id DESC";
        ResultSet dtst = Global.selectDataNoParams(selSQL);
        return dtst;
    }

    public static long getCurDBConns() {
        try {
            String selSQL = "select count(1) from pg_stat_activity";
            ResultSet dtst = Global.selectDataNoParams(selSQL);

            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return 0;
        } catch (SQLException ex) {
            return 0;
        }
    }

    public static long getMxAllwdDBConns() {
        try {
            int lovID = Global.getLovID("Max Allowed Concurrent Connections");
            long rslt = Long.valueOf(Global.getEnbldPssblVal(lovID));
            return rslt;
        } catch (NumberFormatException ex) {
            return 4;
        }
    }

    public static long getRptRnID(long rptID, long runBy, String runDate) {
        try {
            String sqlStr = "select rpt_run_id from rpt.rpt_report_runs where run_by = "
                    + runBy + " and report_id = " + rptID + " and run_date = '"
                    + runDate + "' order by rpt_run_id DESC";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static ResultSet get_SchdulesParams(long schdlID) {
        String selSQL = "SELECT a.schdl_param_id, a.parameter_id, b.parameter_name, a.parameter_value "
                + "FROM rpt.rpt_run_schdule_params a, rpt.rpt_report_parameters b "
                + "WHERE a.parameter_id = b.parameter_id and a.schedule_id = " + schdlID
                + " ORDER BY a.parameter_id";
        ResultSet dtst = Global.selectDataNoParams(selSQL);
        return dtst;
    }

    public static ResultSet get_AlertParams(long alertID) {
        String selSQL = "SELECT a.schdl_param_id, a.parameter_id, b.parameter_name, a.parameter_value "
                + "FROM rpt.rpt_run_schdule_params a, rpt.rpt_report_parameters b "
                + "WHERE a.parameter_id = b.parameter_id and a.alert_id = " + alertID
                + " ORDER BY a.parameter_id";
        ResultSet dtst = Global.selectDataNoParams(selSQL);
        return dtst;
    }

    public static ResultSet get_RptParams(long rptID) {
        String selSQL = "SELECT a.parameter_id, a.parameter_name, a.paramtr_rprstn_nm_in_query, a.default_value "
                + "FROM rpt.rpt_report_parameters a WHERE a.report_id = " + rptID + " ORDER BY a.parameter_id";
        ResultSet dtst = Global.selectDataNoParams(selSQL);
        return dtst;
    }

    public static void createSchdldRptRn(long runBy, String runDate,
            long rptID, String paramIDs, String paramVals,
            String outptUsd, String orntUsd, int alertID, long msgSentID) {
        String insSQL = "INSERT INTO rpt.rpt_report_runs("
                + "run_by, run_date, rpt_run_output, run_status_txt, "
                + "run_status_prct, report_id, rpt_rn_param_ids, rpt_rn_param_vals, "
                + "output_used, orntn_used, last_actv_date_tme, is_this_from_schdler, alert_id, msg_sent_id) "
                + "VALUES (" + runBy + ", '" + runDate
                + "', '', 'Not Started!', 0, " + rptID + ", '" + paramIDs.replace("'", "''")
                + "', '" + paramVals.replace("'", "''")
                + "', '" + outptUsd.replace("'", "''")
                + "', '" + orntUsd.replace("'", "''")
                + "', '" + runDate + "', '1'," + alertID + "," + msgSentID + ")";
        Global.insertDataNoParams(insSQL);
    }

    public static void createAlertMsgSent(long msgSntID, String toList,
            String ccLst, String msgBdy, String dteSent,
            String sbjct, long rptID, String bccLst,
            long prsnID, long cstmrSupID, int alertID, String attchMns, String msg_type) {
        String runDate = Global.getDB_Date_time();
        String insSQL = "INSERT INTO alrt.alrt_msgs_sent("
                + "msg_sent_id, to_list, cc_list, msg_body, date_sent, msg_sbjct, "
                + "report_id, bcc_list, person_id, cstmr_spplr_id, created_by, creation_date, "
                + "alert_id, sending_status, err_msg, attch_urls, msg_type) "
                + "VALUES (" + msgSntID + ", '" + toList.replace("'", "''")
                + "', '" + ccLst.replace("'", "''")
                + "', '" + msgBdy.replace("'", "''")
                + "', '" + runDate.replace("'", "''")
                + "', '" + sbjct.replace("'", "''")
                + "', " + rptID
                + ", '" + bccLst.replace("'", "''")
                + "', " + prsnID
                + ", " + cstmrSupID
                + ", " + Global.rnUser_ID
                + ", '" + runDate.replace("'", "''")
                + "', " + alertID + ",'0','','" + attchMns.replace("'", "''") + "','" + msg_type.replace("'", "''") + "')";
        Global.insertDataNoParams(insSQL);
    }

    public static void updateAlertMsgSent(long msgSntID, String dteSent,
            String sentStatus, String errMsg) {
        //String runDate = Global.getDB_Date_time();
        String updateSQL = "UPDATE alrt.alrt_msgs_sent SET date_sent ='" + dteSent.replace("'", " ''")
                + "', sending_status='" + sentStatus + "', err_msg='" + errMsg + "' "
                + "WHERE msg_sent_id = " + msgSntID + "";
        Global.updateDataNoParams(updateSQL);
    }

    public static boolean doesLstRnTmExcdIntvl(long rptID, String intrvl, long rn_ID) {
        boolean res = true;
        try {
            String sqlStr = "select age(now(), to_timestamp(CASE WHEN last_actv_date_tme='' "
                    + "THEN '2013-01-01 00:00:00' ELSE last_actv_date_tme END, 'YYYY-MM-DD HH24:MI:SS'))"
                    + ">= interval '" + intrvl + "'  from rpt.rpt_report_runs where report_id = " + rptID
                    + " and rpt_run_id != " + rn_ID + " and last_actv_date_tme !='' "
                    + "ORDER BY last_actv_date_tme DESC, rpt_run_id DESC LIMIT 1 OFFSET 0";
            //and is_this_from_schdler = '1' and is_this_from_schdler='1'
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                res = dtst.getBoolean(1);
                dtst.close();
                return res;
            }
            return res;
        } catch (SQLException ex) {
            return res;
        }
    }

    public static void updateBulkMsgSent(long msgSntID, String dteSent,
            String sentStatus, String errMsg) {
        //string runDate = Global.getDB_Date_time();
        String updateSQL = "UPDATE alrt.bulk_msgs_sent SET "
                + "date_sent='" + dteSent.replace("'", "''")
                + "', sending_status='" + sentStatus + "', err_msg='" + errMsg + "' "
                + "WHERE msg_sent_id = " + msgSntID + "";
        Global.updateDataNoParams(updateSQL);
    }

    public static boolean doesDteTmExcdIntvl(String intrvl, String dteTme) {
        boolean res = true;
        try {
            String sqlStr = "select age(now(), to_timestamp('" + dteTme + "', 'YYYY-MM-DD HH24:MI:SS')) "
                    + ">= interval '" + intrvl + "'";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                res = dtst.getBoolean(1);
                dtst.close();
                return res;
            }
            return res;
        } catch (SQLException ex) {
            return res;
        }
    }

    public static String[] getFTPServerDet() {
        String[] str = new String[6];
        str[0] = "";
        str[1] = "";
        str[2] = "";
        str[3] = "";
        str[4] = "";
        str[5] = "0";
        try {
            String selSQL = "select a.ftp_server_url, a.ftp_user_start_directory||a.ftp_app_sub_directory, "
                    + "a.ftp_user_name, a.ftp_user_pswd, a.ftp_port, a.enforce_ftp "
                    + "from sec.sec_email_servers a where a.is_default='t'";
            ResultSet dtst = Global.selectDataNoParams(selSQL);

            while (dtst.next()) {
                str[0] = dtst.getString(1);
                str[1] = dtst.getString(2);
                str[2] = dtst.getString(3);
                str[3] = dtst.getString(4);
                str[4] = dtst.getString(5);
                str[5] = dtst.getString(6);
            }
            return str;
        } catch (SQLException ex) {
            return str;
        }
    }

    public static void dwnldImgsFTP(int folderTyp, String locfolderNm, String locfileNm) {
        String[] srvr = Global.getFTPServerDet();
        String subdir = "";
        if (srvr[5].equals("0") || locfileNm.equals("")) {
            return;
        }
        if (folderTyp == 0) {
            subdir = "/Org";
        } else if (folderTyp == 1) {
            subdir = "/Divs";
        } else if (folderTyp == 2) {
            subdir = "/Person";
        } else if (folderTyp == 3) {
            subdir = "/Inv";
        } else if (folderTyp == 4) {
            subdir = "/PrsnDocs";
        } else if (folderTyp == 5) {
            subdir = "/Accntn";
        } else if (folderTyp == 6) {
            subdir = "/Prchs";
        } else if (folderTyp == 7) {
            subdir = "/Sales";
        } else if (folderTyp == 8) {
            subdir = "/Rcpts";
        } else if (folderTyp == 9) {
            subdir = "/Rpts";
        } else if (folderTyp == 15) {
            subdir = "/Rpts/jrxmls";
        } else if (folderTyp == 10) {
            subdir = "/AttnDocs";
        } else if (folderTyp == 11) {
            subdir = "/AssetDocs";
        } else if (folderTyp == 12) {
            subdir = "/PyblDocs";
        } else if (folderTyp == 13) {
            subdir = "/RcvblDocs";
        } else if (folderTyp == 14) {
            subdir = "/FirmsDocs";
        }
        try {
            String srvrIP = srvr[0].replace("ftp://", "");
            srvrIP = srvrIP.replace("/", "");
            Program.thread10 = new Downloadfunc("ThreadNine",
                    InetAddress.getByName(srvrIP),
                    srvr[1] + subdir + "/",
                    locfileNm,
                    locfolderNm + "/" + locfileNm,
                    srvr[2],
                    Global.decrypt(srvr[3], Global.AppKey));
            Program.thread10.setDaemon(true);
            Program.thread10.setName("ThreadNine");
            Program.thread10.setPriority(Thread.MIN_PRIORITY);
            Program.thread10.start();
        } catch (UnknownHostException ex) {
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            Global.writeToLog();
        }
//        try {
//            Global.DownloadFile(InetAddress.getByName(srvr[0]), 
//                    srvr[1] + subdir + "/", 
//                    locfileNm,
//                    locfolderNm + "/" + locfileNm, 
//                    srvr[2],
//                    Global.decrypt(srvr[3], Global.AppKey));
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public static void upldImgsFTP(int folderTyp, String locfolderNm, String locfileNm) {
        String subdir = "";
        String[] srvr = Global.getFTPServerDet();
        if (srvr[5].equals("0") || locfileNm.equals("")) {
            return;
        }
        if (folderTyp == 0) {
            subdir = "/Org";
        } else if (folderTyp == 1) {
            subdir = "/Divs";
        } else if (folderTyp == 2) {
            subdir = "/Person";
        } else if (folderTyp == 3) {
            subdir = "/Inv";
        } else if (folderTyp == 4) {
            subdir = "/PrsnDocs";
        } else if (folderTyp == 5) {
            subdir = "/Accntn";
        } else if (folderTyp == 6) {
            subdir = "/Prchs";
        } else if (folderTyp == 7) {
            subdir = "/Sales";
        } else if (folderTyp == 8) {
            subdir = "/Rcpts";
        } else if (folderTyp == 9) {
            subdir = "/Rpts";
        } else if (folderTyp == 15) {
            subdir = "/Rpts/jrxmls";
        } else if (folderTyp == 10) {
            subdir = "/AttnDocs";
        } else if (folderTyp == 11) {
            subdir = "/AssetDocs";
        } else if (folderTyp == 12) {
            subdir = "/PyblDocs";
        } else if (folderTyp == 13) {
            subdir = "/RcvblDocs";
        } else if (folderTyp == 14) {
            subdir = "/FirmsDocs";
        }

        try {
//            Global.UploadFile(
//                    InetAddress.getByName(srvr[0]), srvr[1] + subdir + "/", locfileNm,
//                    locfolderNm + "/" + locfileNm, srvr[2],
//                    Global.decrypt(srvr[3], Global.AppKey));
            String srvrIP = srvr[0].replace("ftp://", "");
            srvrIP = srvrIP.replace("/", "");
            Program.thread9 = new Uploadfunc("ThreadNine",
                    InetAddress.getByName(srvrIP),
                    srvr[1] + subdir + "/",
                    locfileNm,
                    locfolderNm + "/" + locfileNm,
                    srvr[2],
                    Global.decrypt(srvr[3], Global.AppKey));
            Program.thread9.setDaemon(true);
            Program.thread9.setName("ThreadNine");
            Program.thread9.setPriority(Thread.MIN_PRIORITY);
            Program.thread9.start();
        } catch (UnknownHostException ex) {
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n";
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            Global.writeToLog();
        }
    }

    public static void dwnldImgsDir(int folderTyp, String in_dir) {
        String[] srvr = Global.getFTPServerDet();
        if (srvr[5].equals("0")) {
            return;
        }
        String subdir = "";
        String locfolderNm = "";
        if (folderTyp == 9) {
            subdir = "/Rpts";
        }
        String[] files;
        try {
            files = Global.GetFileList(InetAddress.getByName(srvr[0]),
                    srvr[1] + subdir + "/", in_dir, srvr[2],
                    Global.decrypt(srvr[3], Global.AppKey));

            for (String file : files) {
                //Global.showMsg(in_dir + file, 0);
                if (folderTyp == 9) {
                    locfolderNm = Global.getRptDrctry();
                }
                Global.dwnldImgsFTP(folderTyp, locfolderNm, in_dir + file);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String UploadFile(InetAddress ftpserverurl, String serverAppDirectory,
            String PureFileName, String fullLocFileUrl,
            String userName, String password) {
        // get an ftpClient object  
        FTPClient ftpClient = new FTPClient();
        FileInputStream inputStream = null;
        String responsTxt = "";
        try {
            // pass directory path on server to connect
            // pass username and password, returned true if authentication is  
            // successful  
            ftpClient.connect(ftpserverurl, 21);
            boolean login = ftpClient.login(userName, password);
            ftpClient.setKeepAlive(false);
            ftpClient.setPassiveNatWorkaround(true);
            if (login) {
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                File firstLocalFile = new File(fullLocFileUrl);
                inputStream = new FileInputStream(firstLocalFile);
                //inputStream.reset();
                boolean uploaded = ftpClient.storeFile(serverAppDirectory + PureFileName,
                        inputStream);
                inputStream.close();
                responsTxt = ftpClient.getReplyString();
                if (uploaded) {
                    responsTxt += "File uploaded successfully !";
                } else {
                    responsTxt += "Error in uploading file !::" + serverAppDirectory + PureFileName;
                }

                Global.updateLogMsg(Global.logMsgID,
                        "\r\n\r\n\r\nUpload Response ==>\r\n" + responsTxt,
                        Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
                // logout the user, returned true if logout successfully  
                boolean logout = ftpClient.logout();
                if (logout) {
                    //System.out.println("Connection close...");
                }
            } else {
                Global.errorLog += "Connection Failed..." + responsTxt;
                Global.updateLogMsg(Global.logMsgID,
                        "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                        Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
                Global.writeToLog();
            }
            return responsTxt;
        } catch (SocketException e) {
            Global.errorLog += e.getMessage() + "\r\n" + Arrays.toString(e.getStackTrace());
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            Global.writeToLog();
        } catch (IOException e) {
            Global.errorLog += e.getMessage() + "\r\n" + Arrays.toString(e.getStackTrace());
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            Global.writeToLog();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                Global.errorLog += e.getMessage() + "\r\n" + Arrays.toString(e.getStackTrace());
                Global.updateLogMsg(Global.logMsgID,
                        "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                        Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
                Global.writeToLog();
            } finally {

            }
        }
        return "";
    }

    public static String DownloadFile(InetAddress ftpserverurl, String serverAppDirectory,
            String PureFileName, String fullLocFileUrl,
            String userName, String password) {

        File f = new File(fullLocFileUrl);
        // get an ftpClient object  
        FTPClient ftpClient = new FTPClient();
        String responsTxt = "";
        try {
            // pass directory path on server to connect  
            ftpClient.connect(ftpserverurl, 21);
            // pass username and password, returned true if authentication is  
            // successful  
            boolean login = ftpClient.login(userName, password);
            if (login) {
                ftpClient.enterLocalPassiveMode();
                //ftpClient.setFileTransferMode(FTP.BLOCK_TRANSFER_MODE);
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(f));
                boolean download = ftpClient.retrieveFile(serverAppDirectory + PureFileName, outputStream1);
                outputStream1.close();

                //fos = new FileOutputStream(fullLocFileUrl);
                //boolean download = ftpClient.retrieveFile(serverAppDirectory + PureFileName, fos);
                responsTxt = ftpClient.getReplyString();
                if (download) {
                    responsTxt += "File downloaded successfully !";
                } else {
                    responsTxt += "Error in downloading file !::" + serverAppDirectory + PureFileName;
                }
                Global.updateLogMsg(Global.logMsgID,
                        "\r\n\r\nDownload Response ==>\r\n" + responsTxt,
                        Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
                Global.writeToLog();
                // logout the user, returned true if logout successfully  
                boolean logout = ftpClient.logout();
                if (logout) {
                    //System.out.println("Connection close...");
                }
            } else {
                Global.errorLog += "Connection Failed..." + responsTxt;
                Global.updateLogMsg(Global.logMsgID,
                        "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                        Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
                Global.writeToLog();
            }
            return responsTxt;
        } catch (SocketException e) {
            Global.errorLog += Arrays.toString(e.getStackTrace());
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            Global.writeToLog();
        } catch (IOException e) {
            Global.errorLog += Arrays.toString(e.getStackTrace());
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            Global.writeToLog();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                Global.errorLog += Arrays.toString(e.getStackTrace());
                Global.updateLogMsg(Global.logMsgID,
                        "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                        Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
                Global.writeToLog();
            } finally {

            }
        }
        Global.updateLogMsg(Global.logMsgID,
                "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + responsTxt,
                Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
        return responsTxt;
    }

    public static String[] GetFileList(InetAddress ftpServerAddrs, String serverAppDirectory, String dirName, String userName, String password) {
        String[] downloadFiles = new String[1];
        StringBuilder result = new StringBuilder();
        FTPClient ftpClient = new FTPClient();
        try {
            // pass directory path on server to connect  
            ftpClient.connect(ftpServerAddrs);
            // pass username and password, returned true if authentication is  
            // successful  
            boolean login = ftpClient.login(userName, password);
            if (login) {
                //System.out.println("Connection established...");
                // get all files from server and store them in an array of  
                // FTPFiles  
                FTPFile[] files = ftpClient.listFiles();
                for (FTPFile file : files) {
                    if (file.getType() == FTPFile.FILE_TYPE) {
                        result.append(file.getName());
                        result.append("\n");
                    }
                }
                result.replace(result.toString().lastIndexOf("\n"),
                        result.toString().length(), "");
                // logout the user, returned true if logout successfully  
                boolean logout = ftpClient.logout();
                if (logout) {
                    System.out.println("Connection close...");
                }
            } else {
                System.out.println("Connection fail...");
            }
            return result.toString().split("\\\n");
        } catch (SocketException e) {
            Global.errorLog += Arrays.toString(e.getStackTrace());
            Global.writeToLog();
        } catch (IOException e) {
            Global.errorLog += Arrays.toString(e.getStackTrace());
            Global.writeToLog();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                Global.errorLog += Arrays.toString(e.getStackTrace());
                Global.writeToLog();
            }
        }
        return downloadFiles;
    }

    public static int findCharIndx(String inp_char, String[] inpArry) {
        for (int i = 0; i < inpArry.length; i++) {
            if (inpArry[i].equals(inp_char)) {
                return i;
            }
        }
        return -1;
    }

    public static int findArryIdx(String[] in_arry1, String srch) {
        for (int i = 0; i < in_arry1.length; i++) {
            if (in_arry1[i].equals(srch)) {
                return i;
            }
        }
        return -1;
    }

    public static String dBEncrypt(String inpt) {
        try {
            String sqlStr = "SELECT MD5('" + inpt + "')";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String getNewKey(String key) {
        String[] charset1 = new String[key.length()];
        int cntr = key.length();
        for (int i = 0; i < cntr; i++) {
            charset1[i] = String.valueOf(key.charAt(i));
        }
        String[] charset2 = {
            "e", "q", "0", "P", "3", "i", "D", "O", "V", "8", "E", "6",
            "B", "Z", "A", "W", "5", "g", "G", "F", "H", "u", "t", "s",
            "C", "K", "d", "p", "r", "w", "z", "x", "a", "c", "1", "m",
            "I", "f", "Q", "L", "v", "Y", "j", "S", "R", "o", "J", "4",
            "9", "h", "7", "M", "b", "X", "k", "N", "l", "n", "2", "y",
            "T", "U"};
        String[] wldChars = {"`", "¬", "!", "\"", "£", "$", "%", "^", "&", "*", "(", ")",
            "-", "_", "=", "+", "{", "[", "]", "}", ":", ";", "@", "'",
            "#", "~", "/", "?", ">", ".", "<", ",", "\\", "|", " "};
        int keyLength = charset1.length;
        String newKey = "";
        for (int i = keyLength - 1; i >= 0; i--) {
            if (findCharIndx(charset1[i], wldChars) > -1) {
                continue;
            }
            if (newKey.contains(charset1[i]) == false) {
                newKey += charset1[i];
            }
            if (newKey.length() >= 62) {
                break;
            }
        }

        if (newKey.length() < 62) {
            keyLength = charset2.length;
            for (int i = keyLength - 1; i >= 0; i--) {
                if (newKey.contains(charset2[i]) == false) {
                    newKey += charset2[i];
                }
                if (newKey.length() >= 62) {
                    break;
                }
            }
        }
        return newKey;
    }

    public static String decrypt(String inpt, String key) {
        try {
            String fnl_str = "";
            String[] charset1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z"};
            String keyString = Global.getNewKey(key);
            String[] charset2 = new String[keyString.length()];
            int cntr = keyString.length();
            for (int i = 0; i < cntr; i++) {
                charset2[i] = String.valueOf(keyString.charAt(i));
            }

            String[] wldChars = {"`", "¬", "!", "\"", "£", "$", "%", "^", "&", "*", "(", ")",
                "-", "_", "=", "+", "{", "[", "]", "}", ":", ";", "@", "'",
                "#", "~", "/", "?", ">", ".", "<", ",", "\\", "|"};
            int wldCharsLen = wldChars.length;

            for (int i = inpt.length() - 1; i >= 0; i--) {
                String tst_str = String.valueOf(inpt.charAt(i));
                if (tst_str.equals("_")) {
                    continue;
                }
                int j = Global.findCharIndx(tst_str, charset2);
                if (j == -1) {
                    fnl_str += tst_str;
                } else if (i < inpt.length() - 1) {
                    if (String.valueOf(inpt.charAt(i + 1)).equals("_") && j < wldCharsLen) {
                        fnl_str += wldChars[j];
                    } else {
                        fnl_str += charset1[j];
                    }
                } else {
                    fnl_str += charset1[j];
                }
            }
            String nwStr1 = fnl_str.substring(0, 4);
            String nwStr2 = fnl_str.substring(4, 8);
            int StringLn = Integer.valueOf(nwStr2) - Integer.valueOf(nwStr1);
            String nwStr3 = fnl_str.substring(8, StringLn + 8);
            return nwStr3;
        } catch (Exception ex) {
            Global.errorLog = ex.getMessage() + "\r\n" + Arrays.toString(ex.getStackTrace());
            Global.updateLogMsg(Global.logMsgID,
                    "\r\n\r\n\r\nThe Program has Errored Out ==>\r\n\r\n" + Global.errorLog,
                    Global.logTbl, Global.gnrlDateStr, Global.rnUser_ID);
            return inpt;
        }
    }

    public static String removeDplctChars(String s) {
        s = s + " "; // Adding a space at the end of the word
        int l = s.length(); // Finding the length of the word
        String ans = ""; // Variable to store the final result
        char ch1, ch2;

        for (int i = 0; i < l - 1; i++) {
            ch1 = s.charAt(i); // Extracting the first character
            ch2 = s.charAt(i + 1); // Extracting the next character

// Adding the first extracted character to the result if the current and the next characters are different
            if (ch1 == ch2 && (ch1 == ';' || ch1 == ',')) {
//Do Nothing
            } else {
                ans = ans + ch1;
            }
        }
        return ans;
    }

    public static String encodeURIComponent(String s) {
        String result;
        try {
            result = URLEncoder.encode(s, "UTF-8")
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\%21", "!")
                    .replaceAll("\\%27", "'")
                    .replaceAll("\\%28", "(")
                    .replaceAll("\\%29", ")")
                    .replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException e) {
            result = s;
        }
        return result;
    }

    public static boolean CheckForInternetConnection() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            return true;
        } catch (IOException ex) {
            Global.errorLog = "\r\nError Checking for Internet!\r\n" + ex.getMessage();
            Global.writeToLog();
            return false;
        }
    }

    private static boolean isEmailValid(String email, int lovID) {
        if (email == null || "".equals(email)) {
            return false;
        }
        email = email.trim();
        EmailValidator ev = EmailValidator.getInstance();
        boolean isEmailValid = ev.isValid(email);
        if (isEmailValid == false) {
            Global.createSysLovsPssblVals1(email, lovID);
        }
        return isEmailValid;
    }

    public static void createSysLovsPssblVals1(String pssblVals, int lovID) {
        if (Global.getPssblValID(pssblVals, lovID) <= 0) {
            Global.createPssblValsForLov1(lovID, pssblVals, pssblVals, "1", "");
        }
    }

    public static void createPssblValsForLov1(int lovID, String pssblVal,
            String pssblValDesc, String isEnbld, String allwd) {
        String dateStr = Global.getDB_Date_time();
        String sqlStr = "INSERT INTO gst.gen_stp_lov_values("
                + "value_list_id, pssbl_value, pssbl_value_desc, "
                + "created_by, creation_date, last_update_by, "
                + "last_update_date, is_enabled, allowed_org_ids) "
                + "VALUES (" + lovID + ", '" + pssblVal.replace("'", "''") + "', '"
                + pssblValDesc.replace("'", "''")
                + "', " + Global.rnUser_ID + ", '" + dateStr + "', " + Global.rnUser_ID
                + ", '" + dateStr + "', '" + isEnbld.replace("'", "''")
                + "', '" + allwd.replace("'", "''") + "')";
        Global.insertDataNoParams(sqlStr);
    }

    public static boolean sendEmail(String toEml, String ccEml, String bccEml, String attchmnt, String sbjct, String bdyTxt, String[] errMsgs) {
        try {
            String selSql = "SELECT smtp_client, mail_user_name, mail_password, smtp_port FROM sec.sec_email_servers WHERE (is_default = 't')";
            ResultSet selDtSt = Global.selectDataNoParams(selSql);
            selDtSt.last();
            int m = selDtSt.getRow();
            String smtpClnt = "";
            String fromEmlNm = "";
            String fromPswd = "";
            errMsgs[0] = "";
            int portNo = 0;
            if (m > 0) {
                selDtSt.beforeFirst();
                selDtSt.next();
                smtpClnt = selDtSt.getString(1);
                fromEmlNm = selDtSt.getString(2);
                fromPswd = selDtSt.getString(3);
                portNo = selDtSt.getInt(4);
            }
            selDtSt.close();
            String fromPassword = Global.decrypt(fromPswd, Global.AppKey);
            // load your HTML email template
            if (bdyTxt.contains("<body") == false
                    || bdyTxt.contains("</body>") == false) {
                bdyTxt = "<body>" + bdyTxt + "</body>";
            }
            if (bdyTxt.contains("<html") == false
                    || bdyTxt.contains("</html>") == false) {
                bdyTxt = "<!DOCTYPE html><html lang=\"en\">" + bdyTxt + "</html>";
            }
            String htmlEmailTemplate = bdyTxt;
            // define you base URL to resolve relative resource locations
            URL url = new URL(Global.AppUrl);
            // create the email message
            ImageHtmlEmail email = new ImageHtmlEmail();
            email.setDataSourceResolver(new DataSourceUrlResolver(url));
            email.setHostName(smtpClnt);
            email.setSmtpPort(portNo);
            email.setAuthentication(fromEmlNm, fromPassword);
            email.setDebug(true);
            email.setStartTLSEnabled(true);
            email.setStartTLSRequired(true);

            String spltChars = "\\s*;\\s*";
            String[] toEmails = removeDplctChars(toEml).trim().split(spltChars);
            String[] ccEmails = removeDplctChars(ccEml).trim().split(spltChars);
            String[] bccEmails = removeDplctChars(bccEml).trim().split(spltChars);
            String[] attchMnts = removeDplctChars(attchmnt).trim().split(spltChars);
            for (int i = 0; i < attchMnts.length; i++) {
                if (attchMnts[i].equals("")) {
                    continue;
                }
                EmailAttachment attachment = new EmailAttachment();
                if (attchMnts[i].startsWith("http://") || attchMnts[i].startsWith("https://")) {
                    attachment.setURL(new URL(attchMnts[i].replaceAll(" ", "%20")));
                    //"http://www.apache.org/images/asf_logo_wide.gif"
                } else {
                    attachment.setPath(attchMnts[i].replaceAll(" ", "%20"));
                }
                attachment.setDisposition(EmailAttachment.ATTACHMENT);
                //attachment.setDescription("Picture of John");
                //attachment.setName("John");
                // add the attachment
                email.attach(attachment);
            }
            int lovID = Global.getLovID("Email Addresses to Ignore");
            for (int i = 0; i < toEmails.length; i++) {
                if (Global.isEmailValid(toEmails[i], lovID)) {
                    if (Global.getEnbldPssblValID(toEmails[i], lovID) <= 0) {
                        //DO Nothing
                    } else {
                        toEmails[i] = "ToBeRemoved";
                        errMsgs[0] += "Address:" + toEmails[i] + " blacklisted by you!\r\n";
                    }
                } else {
                    errMsgs[0] += "Address:" + toEmails[i] + " is Invalid!\r\n";
                }
            }
            for (int i = 0; i < toEmails.length; i++) {
                if (toEmails[i].equals("ToBeRemoved")) {
                    toEmails = (String[]) ArrayUtils.remove(toEmails, i);
                }
            }
            if (toEmails.length > 0) {
                if (toEmails[0].equals("") == false) {
                    email.addTo(toEmails);
                }
            }
            for (int i = 0; i < ccEmails.length; i++) {
                if (Global.isEmailValid(ccEmails[i], lovID)) {
                    if (Global.getEnbldPssblValID(ccEmails[i], lovID) <= 0) {
                        //DO Nothing
                    } else {
                        ccEmails[i] = "ToBeRemoved";
                        errMsgs[0] += "Address:" + ccEmails[i] + " blacklisted by you!\r\n";
                    }
                } else {
                    errMsgs[0] += "Address:" + ccEmails[i] + " is Invalid!\r\n";
                }
            }
            for (int i = 0; i < ccEmails.length; i++) {
                if (ccEmails[i].equals("ToBeRemoved")) {
                    ccEmails = (String[]) ArrayUtils.remove(ccEmails, i);
                }
            }
            if (ccEmails.length > 0) {
                if (ccEmails[0].equals("") == false) {
                    email.addCc(ccEmails);
                }
            }
            for (int i = 0; i < bccEmails.length; i++) {
                if (Global.isEmailValid(bccEmails[i], lovID)) {
                    if (Global.getEnbldPssblValID(bccEmails[i], lovID) <= 0) {
                        //DO Nothing
                    } else {
                        bccEmails[i] = "ToBeRemoved";
                        errMsgs[0] += "Address:" + bccEmails[i] + " blacklisted by you!\r\n";
                    }
                } else {
                    errMsgs[0] += "Address:" + bccEmails[i] + " is Invalid!\r\n";
                }
            }
            for (int i = 0; i < bccEmails.length; i++) {
                if (bccEmails[i].equals("ToBeRemoved")) {
                    bccEmails = (String[]) ArrayUtils.remove(bccEmails, i);
                }
            }
            if (bccEmails.length > 0) {
                if (bccEmails[0].equals("") == false) {
                    email.addBcc(bccEmails);
                }
            }
            email.setFrom(fromEmlNm.trim());
            email.setSubject(sbjct);
            // set the html message
            email.setHtmlMsg(htmlEmailTemplate);
            // set the alternative message
            email.setTextMsg("Your email client does not support HTML messages");
            // send the email
            if (Global.CheckForInternetConnection()) {
                email.send();
                return true;
            }
            errMsgs[0] += "No Internet Connection";
            return false;
        } catch (SQLException ex) {
            Global.errorLog = "\r\nFailed to send Email!\r\n" + ex.getMessage();
            Global.writeToLog();
            errMsgs[0] += "Failed to send Email!\r\n" + ex.getMessage();
            return false;
        } catch (MalformedURLException ex) {
            Global.errorLog = "\r\nFailed to send Email!\r\n" + ex.getMessage();
            Global.writeToLog();
            errMsgs[0] += "Failed to send Email!\r\n" + ex.getMessage();
            return false;
        } catch (EmailException ex) {
            Global.errorLog = "\r\nFailed to send Email!\r\n" + ex.getMessage();
            Global.writeToLog();
            errMsgs[0] += "Failed to send Email!\r\n" + ex.getMessage();
            return false;
        } catch (Exception ex) {
            Global.errorLog = "\r\nFailed to send Email!\r\n" + ex.getMessage();
            Global.writeToLog();
            errMsgs[0] += "Failed to send Email!\r\n" + ex.getMessage();
            return false;
        }
    }

    public static boolean sendSMS(String msgBody, String rcpntNo, String[] errMsg) {
        try {
            if (!Global.CheckForInternetConnection()) {
                errMsg[0] = "No Internet Connection";
                return false;
            }
            HttpResponse response = null;
            String responseTxt = "";
            msgBody = msgBody.replace("\r\n", " ").replace("\r", " ").replace("\n", " ").replace("|", "/");
            String succsTxt = "";
            String y = "\\|";

            HttpClient client;
            client = HttpClients.createDefault();
            List<NameValuePair> postData = new ArrayList<NameValuePair>();

            String url = "";// "http://txtconnect.co/api/send/";
            ResultSet dtst = Global.selectDataNoParams("select sms_param1, sms_param2, sms_param3,"
                    + "sms_param4, sms_param5, sms_param6,sms_param7, sms_param8, sms_param9"
                    + ", sms_param10 from sec.sec_email_servers where is_default = 't'");
            String[] nwMsgBdy;
            String rvsdMsgBdy = "";
            for (int z = 0; z < msgBody.length(); z++) {
                if (z > 0 && (z % 160) == 0) {
                    rvsdMsgBdy += String.valueOf(msgBody.charAt(z)) + "|";
                } else {
                    rvsdMsgBdy += String.valueOf(msgBody.charAt(z));
                }
            }
            nwMsgBdy = rvsdMsgBdy.split(y);
            for (int z = 0; z < nwMsgBdy.length; z++) {
                client = HttpClients.createDefault();
                postData = new ArrayList<NameValuePair>();
                String[] paramNms = new String[10];
                String[] paramVals = new String[10];
                String tmpStr = "";
                responseTxt = "";
                String[] tmpArry;
                dtst.last();
                int cntr = dtst.getRow();
                if (cntr >= 1) {
                    for (int i = 0; i < 10; i++) {
                        tmpStr = dtst.getString(i + 1).trim();
                        tmpArry = tmpStr.split(y);
                        if (tmpStr.equals("")
                                || tmpArry.length != 2) {
                            paramNms[i] = "";
                            paramVals[i] = "";
                        } else {
                            paramNms[i] = tmpArry[0];
                            paramVals[i] = tmpArry[1];
                        }
                        if (paramNms[i].equals("url")) {
                            url = paramVals[i];
                        } else if (paramNms[i].equals("success txt")) {
                            succsTxt = paramVals[i];
                        } else if (!paramNms[i].equals("") && !paramVals[i].equals("")) {
                            postData.add(new BasicNameValuePair(paramNms[i], paramVals[i].replace("{:msg}", nwMsgBdy[z]).replace("{:to}", rcpntNo)));
                        }
                    }

                    UrlEncodedFormEntity url_entity = new UrlEncodedFormEntity(postData, Consts.UTF_8);
                    HttpPost httppost = new HttpPost(url);
                    httppost.setEntity(url_entity);
                    response = client.execute(httppost);
                    if (response.getStatusLine().getStatusCode() != 200) {
                        throw new RuntimeException("Failed : HTTP error code : "
                                + response.getStatusLine().getStatusCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            (response.getEntity().getContent())));

                    String output;
                    //System.out.println("Output from Server .... \n");
                    while ((output = br.readLine()) != null) {
                        responseTxt += output;
                    }
                    //byte[] responseBytes = client.UploadValues(url, "POST", postData);
                    //System.Threading.Thread.Sleep(500);
                    //response += System.Text.Encoding.ASCII.GetString(responseBytes);
                }
                if (responseTxt.toLowerCase().contains(succsTxt.toLowerCase())) {
                    errMsg[0] = "SMS Successful";
                    return true;
                }
                errMsg[0] = responseTxt;
                return false;
            }
        } catch (SQLException ex) {
            errMsg[0] += ex.getMessage();
            return false;
        } catch (IOException ex) {
            errMsg[0] += ex.getMessage();
            return false;
        } catch (RuntimeException ex) {
            errMsg[0] += ex.getMessage();
            return false;
        }
        return false;
    }

    public static void createLogMsg(String logmsg, String logTblNm,
            String procstyp, long procsID, String dateStr) {
        String insSQL = "INSERT INTO " + logTblNm + "("
                + "log_messages, process_typ, process_id, created_by, creation_date, "
                + "last_update_by, last_update_date) "
                + "VALUES ('" + logmsg.replace("'", "''")
                + "','" + procstyp.replace("'", "''") + "'," + procsID
                + ", " + Global.rnUser_ID + ", '" + dateStr
                + "', " + Global.rnUser_ID + ", '" + dateStr
                + "')";
        Global.insertDataNoParams(insSQL);
    }

    public static long getLogMsgID(String logTblNm, String procstyp, long procsID) {
        try {
            String sqlStr = "select msg_id from " + logTblNm
                    + " where process_typ = '" + procstyp.replace("'", "''")
                    + "' and process_id = " + procsID + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static boolean isThereANActvActnPrcss(String prcsIDs, String prcsIntrvl) {
        boolean res = true;
        try {
            String strSql = "SELECT age(now(), to_timestamp(last_active_time,'YYYY-MM-DD HH24:MI:SS')) <= interval '" + prcsIntrvl
                    + "' FROM accb.accb_running_prcses WHERE which_process_is_rnng IN (" + prcsIDs
                    + ") and age(now(), to_timestamp(last_active_time,'YYYY-MM-DD HH24:MI:SS')) <= interval '" + prcsIntrvl
                    + "'";

            //Global.showMsg(strSql, 0);
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                res = dtst.getBoolean(1);
                dtst.close();
                return res;
            }
            return res;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static void updtActnPrcss(int prcsID, int secondsAhead) {
        String dtestr = Global.getDB_Date_time();
        String strSql = "UPDATE accb.accb_running_prcses SET "
                + "last_active_time = to_char(to_timestamp('" + dtestr + "'  ,'YYYY-MM-DD HH24:MI:SS') + interval '" + secondsAhead + " second'  ,'YYYY-MM-DD HH24:MI:SS') "
                + "WHERE which_process_is_rnng = " + prcsID + " ";
        Global.updateDataNoParams(strSql);
    }

    public static void updtActnPrcss(int prcsID) {
        String dtestr = Global.getDB_Date_time();
        String strSql = "UPDATE accb.accb_running_prcses SET "
                + "last_active_time ='" + dtestr + "'  "
                + "WHERE which_process_is_rnng = " + prcsID + " ";
        Global.updateDataNoParams(strSql);
    }

    public static ResultSet get_All_Chrt_Det(int orgid) {
        String strSql = "";
        strSql = "SELECT a.accnt_id, a.debit_balance , a.credit_balance , a.net_balance , "
                + "to_char(to_timestamp(a.balance_date,'YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS') bsldte "
                + "FROM accb.accb_chart_of_accnts a WHERE a.org_id = " + orgid + " ORDER BY a.accnt_typ_id, a.report_line_no, a.accnt_num";
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static boolean isTransPrmttd(int accntID, String trnsdate, double amnt, String outptMsg[]) {
        try {
            //trnsdate = DateTime.ParseExact(
            //trnsdate, "dd-MMM-yyyy HH:mm:ss",
            //System.Globalization.CultureInfo.InvariantCulture).ToString("yyyy-MM-dd HH:mm:ss");
            //Transaction date must be >= the latest prd start date
            if (accntID <= 0 || trnsdate.equals("")) {
                return false;
            }

            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat frmtr2 = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat frmtr3 = new SimpleDateFormat("dddd");
            Calendar trnsDte = Calendar.getInstance();
            trnsDte.setTime(frmtr.parse(trnsdate));
            Calendar dte1 = Calendar.getInstance();
            dte1.setTime(frmtr.parse(Global.getLtstPrdStrtDate()));
            Calendar dte1Or = Calendar.getInstance();
            dte1Or.setTime(frmtr.parse(Global.getLastPrdClseDate()));
            Calendar dte2 = Calendar.getInstance();
            dte2.setTime(frmtr.parse(Global.getLtstPrdEndDate()));

            if (trnsDte.equals(dte1Or) || trnsDte.before(dte1Or)) {
                outptMsg[0] += "Transaction Date cannot be On or Before " + frmtr.format(dte1Or);
                return false;
            }
            if (trnsDte.before(dte1)) {
                outptMsg[0] += "Transaction Date cannot be before " + frmtr.format(dte1);
                return false;
            }
            if (trnsDte.after(dte2)) {
                outptMsg[0] += "Transaction Date cannot be after " + frmtr.format(dte2);
                return false;
            }
            //Check if trnsDate exists in an Open Period
            long prdHdrID = Global.getPrdHdrID(Global.UsrsOrg_ID);
            //Global.showMsg(Global.Org_iString.valueOf(d) + "-" + prdHdrID.ToString(), 0);
            if (prdHdrID > 0) {
                //Global.showMsg(trnsDte.ToString("yyyy-MM-dd HH:mm:ss") + "-" + prdHdrID.ToString(), 0);
                if (Global.getTrnsDteOpenPrdLnID(prdHdrID, frmtr1.format(trnsDte)) < 0) {
                    outptMsg[0] += "Cannot use a Transaction Date (" + frmtr.format(trnsDte) + ") which does not exist in any OPEN period!";
                    return false;
                }
                //Check if Date is not in Disallowed Dates
                String noTrnsDatesLov = Global.getGnrlRecNm("accb.accb_periods_hdr", "periods_hdr_id", "no_trns_dates_lov_nm", prdHdrID);
                String noTrnsDayLov = Global.getGnrlRecNm("accb.accb_periods_hdr", "periods_hdr_id", "no_trns_wk_days_lov_nm", prdHdrID);
                //Global.showMsg(noTrnsDatesLov + "-" + noTrnsDayLov + "-" + trnsDte.ToString("dddd").ToUpper() + "-" + trnsDte.ToString("dd-MMM-yyyy").ToUpper(), 0);

                if (!noTrnsDatesLov.equals("")) {
                    if (Global.getEnbldPssblValID(frmtr2.format(trnsDte).toUpperCase(), Global.getEnbldLovID(noTrnsDatesLov)) > 0) {
                        outptMsg[0] += "Transactions on this Date (" + frmtr.format(trnsDte) + ") have been banned on this system!";
                        return false;
                    }
                }
                //Check if Day of Week is not in Disaalowed days
                if (!noTrnsDatesLov.equals("")) {
                    if (Global.getEnbldPssblValID(frmtr3.format(trnsDte).toUpperCase(), Global.getEnbldLovID(noTrnsDayLov)) > 0) {
                        outptMsg[0] += "Transactions on this Day of Week (" + frmtr3.format(trnsDte) + ") have been banned on this system!";
                        return false;
                    }
                }
            }

            //Amount must not disobey budget settings on that account
            long actvBdgtID = Global.getActiveBdgtID(Global.UsrsOrg_ID);
            double amntLmt = Global.getAcntsBdgtdAmnt(actvBdgtID,
                    accntID, frmtr.format(trnsDte));

            Calendar bdte1 = Calendar.getInstance();
            bdte1.setTime(frmtr.parse(Global.getAcntsBdgtStrtDte(actvBdgtID, accntID, frmtr.format(trnsDte))));

            Calendar bdte2 = Calendar.getInstance();
            bdte2.setTime(frmtr.parse(Global.getAcntsBdgtEndDte(actvBdgtID, accntID, frmtr.format(trnsDte))));

            double crntBals = Global.getTrnsSum(accntID, frmtr.format(bdte1), frmtr.format(bdte2), "1");

            String actn = Global.getAcntsBdgtLmtActn(actvBdgtID, accntID, trnsdate);

            if ((amnt + crntBals) > amntLmt) {
                if (actn.equals("Disallow")) {
                    outptMsg[0] += "This transaction will cause budget on \r\nthe chosen account to be exceeded! ";
                    return false;
                } else if (actn.equals("Warn")) {
                    outptMsg[0] += "This is just to WARN you that the budget on \r\nthe chosen account will be exceeded!";
                    return true;
                } else if (actn.equals("Congratulate")) {
                    outptMsg[0] += "This is just to CONGRATULATE you for exceeding the targetted Amount! ";
                    return true;
                } else {
                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            outptMsg[0] += Arrays.toString(ex.getStackTrace()) + "\r\n" + ex.getMessage();
            return false;
        }
    }

    public static int getEnbldLovID(String lovName) {
        try {
            String sqlStr = "SELECT value_list_id from gst.gen_stp_lov_names where (upper(value_list_name) = upper('"
                    + lovName.replace("'", "''") + "') and is_enabled='1')";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static int getEnbldPssblValID(String pssblVal, int lovID) {
        try {
            String sqlStr = "SELECT pssbl_value_id from gst.gen_stp_lov_values "
                    + "where ((upper(pssbl_value) = upper('"
                    + pssblVal.replace("'", "''") + "')) AND (value_list_id = " + lovID
                    + ") AND (is_enabled='1')) ORDER BY pssbl_value_id LIMIT 1";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static String getEnbldPssblVal(int lovID) {
        try {
            String sqlStr = "SELECT pssbl_value from gst.gen_stp_lov_values "
                    + "where ((value_list_id = " + lovID
                    + ") AND (is_enabled='1')) ORDER BY pssbl_value_id DESC LIMIT 1 OFFSET 0";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String getEnbldPssblValDesc(String pssblVal, int lovID) {
        try {
            String sqlStr = "SELECT pssbl_value_desc from gst.gen_stp_lov_values "
                    + "where ((upper(pssbl_value) = upper('"
                    + pssblVal.replace("'", "''") + "')) AND (value_list_id = " + lovID
                    + ") AND (is_enabled='1')) ORDER BY pssbl_value_id LIMIT 1";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static double getTrnsSum(int accntid, String strDte, String endDte, String ispsted) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            strDte = frmtr1.format(frmtr.parse(strDte));
            endDte = frmtr1.format(frmtr.parse(endDte));

            String strSql = "";
            strSql = "SELECT SUM(a.net_amount) "
                    + "FROM accb.accb_trnsctn_details a "
                    + "WHERE(a.trns_status='" + ispsted + "' and a.accnt_id = "
                    + accntid + " and (to_timestamp(a.trnsctn_date,'YYYY-MM-DD HH24:MI:SS') "
                    + "between to_timestamp('" + strDte + "','YYYY-MM-DD HH24:MI:SS')"
                    + " AND to_timestamp('" + endDte + "','YYYY-MM-DD HH24:MI:SS')))";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0;
        } catch (ParseException ex) {
            return 0;
        } catch (SQLException ex) {
            return 0;
        }
    }

    public static long getTrnsDteOpenPrdLnID(long prdHdrID, String trnsDte) {
        try {
            String strSql = "SELECT a.period_det_id "
                    + "FROM accb.accb_periods_det a "
                    + "WHERE((a.period_hdr_id = " + prdHdrID
                    + ") and (a.period_status='Open') and (to_timestamp('" + trnsDte + "','YYYY-MM-DD HH24:MI:SS') "
                    + "between to_timestamp(a.period_start_date,'YYYY-MM-DD HH24:MI:SS') "
                    + "and to_timestamp(a.period_end_date,'YYYY-MM-DD HH24:MI:SS')))";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static long getPrdHdrID(int orgId) {
        try {
            String strSql = "SELECT a.periods_hdr_id "
                    + "FROM accb.accb_periods_hdr a "
                    + "WHERE(a.use_periods_for_org = '1' and a.org_id = " + orgId + ")";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static long getActiveBdgtID(int orgId) {
        try {
            String strSql = "SELECT a.budget_id "
                    + "FROM accb.accb_budget_header a "
                    + "WHERE(a.is_the_active_one = '1' and a.org_id = " + orgId + ")";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static String getAcntsBdgtdAmnt(long bdgtID, int accntID, String strtdate, String enddate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            strtdate = frmtr1.format(frmtr.parse(strtdate));
            enddate = frmtr1.format(frmtr.parse(enddate));

            String strSql = "SELECT a.limit_amount "
                    + "FROM accb.accb_budget_details a "
                    + "WHERE((a.budget_id = " + bdgtID
                    + ") and (a.accnt_id = " + accntID + ") and (a.start_date = '" + strtdate + "')"
                    + " and (a.end_date = '" + enddate + "'))";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return String.valueOf(dtst.getDouble(1));
            }
            return "0.00";
        } catch (ParseException ex) {
            return "0.00";
        } catch (SQLException ex) {
            return "0.00";
        }
    }

    public static double getAcntsBdgtdAmnt(long bdgtID, int accntID, String trnsdate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trnsdate = frmtr1.format(frmtr.parse(trnsdate));
            String strSql = "SELECT a.limit_amount "
                    + "FROM accb.accb_budget_details a "
                    + "WHERE((a.budget_id = " + bdgtID
                    + ") and (a.accnt_id = " + accntID + ") and (to_timestamp('" + trnsdate
                    + "','YYYY-MM-DD HH24:MI:SS') between to_timestamp(a.start_date,'YYYY-MM-DD HH24:MI:SS')"
                    + " AND to_timestamp(a.end_date,'YYYY-MM-DD HH24:MI:SS')))";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (ParseException ex) {
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        }
    }

    public static String getAcntsBdgtLmtActn(long bdgtID, int accntID, String trnsdate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trnsdate = frmtr1.format(frmtr.parse(trnsdate));
            String strSql = "SELECT a.action_if_limit_excded "
                    + "FROM accb.accb_budget_details a "
                    + "WHERE((a.budget_id = " + bdgtID
                    + ") and (a.accnt_id = " + accntID + ") and (to_timestamp('" + trnsdate
                    + "','YYYY-MM-DD HH24:MI:SS') between to_timestamp(a.start_date,'YYYY-MM-DD HH24:MI:SS')"
                    + " AND to_timestamp(a.end_date,'YYYY-MM-DD HH24:MI:SS')))";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "None";
        } catch (ParseException ex) {
            return "None";
        } catch (SQLException ex) {
            return "None";
        }
    }

    public static String getAcntsBdgtStrtDte(long bdgtID, int accntID, String trnsdate) {
        SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        SimpleDateFormat frmtr2 = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nw = "";
        try {
            nw = frmtr2.format(frmtr1.parse(Global.getDB_Date_time())) + " 00:00:00";
            trnsdate = frmtr1.format(frmtr.parse(trnsdate));
            String strSql = "SELECT to_char(to_timestamp(a.start_date,'YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS') "
                    + "FROM accb.accb_budget_details a "
                    + "WHERE((a.budget_id = " + bdgtID
                    + ") and (a.accnt_id = " + accntID + ") and (to_timestamp('" + trnsdate
                    + "','YYYY-MM-DD HH24:MI:SS') between to_timestamp(a.start_date,'YYYY-MM-DD HH24:MI:SS')"
                    + " AND to_timestamp(a.end_date,'YYYY-MM-DD HH24:MI:SS')))";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return nw;
        } catch (ParseException ex) {
            return nw;
        } catch (SQLException ex) {
            return nw;
        }
    }

    public static String getAcntsBdgtEndDte(long bdgtID, int accntID, String trnsdate) {
        SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat frmtr2 = new SimpleDateFormat("dd-MMM-yyyy");
        String nw = "";
        try {
            nw = frmtr2.format(frmtr1.parse(Global.getDB_Date_time())) + " 23:59:59";
            trnsdate = frmtr1.format(frmtr.parse(trnsdate));
            String strSql = "SELECT to_char(to_timestamp(a.end_date,'YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS') "
                    + "FROM accb.accb_budget_details a "
                    + "WHERE((a.budget_id = " + bdgtID
                    + ") and (a.accnt_id = " + accntID + ") and (to_timestamp('" + trnsdate
                    + "','YYYY-MM-DD HH24:MI:SS') between to_timestamp(a.start_date,'YYYY-MM-DD HH24:MI:SS')"
                    + " AND to_timestamp(a.end_date,'YYYY-MM-DD HH24:MI:SS')))";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return nw;
        } catch (ParseException ex) {
            return nw;
        } catch (SQLException ex) {
            return nw;
        }
    }

    public static String getLastPrdClseDate() {
        try {
            String strSql = "SELECT to_char(to_timestamp(period_close_date,'YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS') "
                    + "FROM accb.accb_period_close_dates "
                    + "WHERE org_id = " + Global.UsrsOrg_ID
                    + " ORDER BY period_close_id DESC LIMIT 1 OFFSET 0";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "01-Jan-1900 00:00:00";
        } catch (SQLException ex) {
            return "01-Jan-1900 00:00:00";
        }
    }

    public static String getLtstPrdStrtDate() {
        SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat frmtr2 = new SimpleDateFormat("dd-MMM-yyyy");
        String nw = "";
        try {
            nw = frmtr2.format(frmtr1.parse(Global.getDB_Date_time())) + " 00:00:00";
            String strSql = "SELECT b.pssbl_value "
                    + "FROM gst.gen_stp_lov_names a, gst.gen_stp_lov_values b "
                    + "WHERE(a.value_list_id = b.value_list_id and b.is_enabled = '1'"
                    + " and  a.value_list_name= 'Transactions Date Limit 1') "
                    + "ORDER BY b.pssbl_value_id DESC LIMIT 1 OFFSET 0";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                String rs = dtst.getString(1);
                if (rs.length() <= 11) {
                    rs = rs + " 00:00:00";
                }
                return rs;
            }
            return nw;
        } catch (ParseException ex) {
            return nw;
        } catch (SQLException ex) {
            return nw;
        }
    }

    public static String getLtstPrdEndDate() {
        SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat frmtr2 = new SimpleDateFormat("dd-MMM-yyyy");
        String nw = "";
        try {
            nw = frmtr2.format(frmtr1.parse(Global.getDB_Date_time())) + " 23:59:59";
            String strSql = "SELECT b.pssbl_value "
                    + "FROM gst.gen_stp_lov_names a, gst.gen_stp_lov_values b "
                    + "WHERE(a.value_list_id = b.value_list_id and b.is_enabled = '1'"
                    + " and  a.value_list_name= 'Transactions Date Limit 2') "
                    + "ORDER BY b.pssbl_value_id DESC LIMIT 1 OFFSET 0";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                String rs = dtst.getString(1);
                if (rs.length() <= 11) {
                    rs = rs + " 23:59:59";
                }
                return rs;
            }
            return nw;
        } catch (ParseException ex) {
            return nw;
        } catch (SQLException ex) {
            return nw;
        }
    }

    public static ResultSet get_Batch_Trns(long batchID) {
        String strSql = "";
        strSql = "SELECT a.transctn_id, b.accnt_num, b.accnt_name, "
                + "a.transaction_desc, a.dbt_amount, a.crdt_amount, "
                + "to_char(to_timestamp(a.trnsctn_date,'YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS'), a.func_cur_id, "
                + "a.batch_id, a.accnt_id, a.net_amount, a.trns_status, a.entered_amnt, gst.get_pssbl_val(a.entered_amt_crncy_id), a.entered_amt_crncy_id, "
                + "a.accnt_crncy_amnt, gst.get_pssbl_val(a.accnt_crncy_id), a.accnt_crncy_id, a.func_cur_exchng_rate, a.accnt_cur_exchng_rate, a.src_trns_id_reconciled "
                + "FROM accb.accb_trnsctn_details a LEFT OUTER JOIN "
                + "accb.accb_chart_of_accnts b on a.accnt_id = b.accnt_id "
                + "WHERE(a.batch_id = " + batchID + " and a.trns_status='0') ORDER BY a.transctn_id";

        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static int get_Rtnd_Erngs_Accnt(int orgid) {
        try {
            String strSql = "SELECT a.accnt_id "
                    + "FROM accb.accb_chart_of_accnts a "
                    + "WHERE(a.is_retained_earnings = '1' and a.org_id = " + orgid + ")";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static int get_Net_Income_Accnt(int orgid) {
        try {
            String strSql = "SELECT a.accnt_id "
                    + "FROM accb.accb_chart_of_accnts a "
                    + "WHERE(a.is_net_income = '1' and a.org_id = " + orgid + ")";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static ResultSet get_Batch_Accnts(long batchID) {
        String strSql = "SELECT a.accnt_id "
                + "FROM accb.accb_trnsctn_details a LEFT OUTER JOIN "
                + "accb.accb_chart_of_accnts b on a.accnt_id = b.accnt_id "
                + "WHERE(a.batch_id = " + batchID + ") ORDER BY a.transctn_id";

        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static void updateBatchStatus(long batchid) {
        String dateStr = Global.getDB_Date_time();
        String updtSQL = "UPDATE accb.accb_trnsctn_batches "
                + "SET batch_status='1', avlbl_for_postng='0', last_update_by=" + Global.rnUser_ID + ", last_update_date='" + dateStr
                + "' WHERE batch_id = " + batchid;
        Global.updateDataNoParams(updtSQL);
    }

    public static ResultSet get_Batch_Trns_NoStatus(long batchID) {
        String strSql = "SELECT a.transctn_id, b.accnt_num, b.accnt_name, "
                + "a.transaction_desc, a.dbt_amount, a.crdt_amount, "
                + "to_char(to_timestamp(a.trnsctn_date,'YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS'), a.func_cur_id, "
                + "a.batch_id, a.accnt_id, a.net_amount, a.trns_status, a.entered_amnt, a.entered_amt_crncy_id, "
                + "a.accnt_crncy_amnt, a.accnt_crncy_id, a.func_cur_exchng_rate, a.accnt_cur_exchng_rate, a.dbt_or_crdt "
                + "FROM accb.accb_trnsctn_details a LEFT OUTER JOIN "
                + "accb.accb_chart_of_accnts b on a.accnt_id = b.accnt_id "
                + "WHERE(a.batch_id = " + batchID + ") ORDER BY a.transctn_id";
        //Global.errorLog = strSql;
        //Global.writeToLog();
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static void createScmGLIntFcLn(int accntid, String trnsdesc, double dbtamnt,
            String trnsdte, int crncyid, double crdtamnt, double netamnt, String srcDocTyp,
            long srcDocID, long srcDocLnID, String dateStr, String trnsSrc) {
        try {
            if (accntid <= 0) {
                return;
            }
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trnsdte = frmtr1.format(frmtr.parse(trnsdte));
            dateStr = frmtr1.format(frmtr.parse(dateStr));

            String insSQL = "INSERT INTO scm.scm_gl_interface ("
                    + "accnt_id, transaction_desc, dbt_amount, trnsctn_date, "
                    + "func_cur_id, created_by, creation_date, crdt_amount, last_update_by, "
                    + "last_update_date, net_amount, gl_batch_id, src_doc_typ, src_doc_id, "
                    + "src_doc_line_id, trns_source) "
                    + "VALUES (" + accntid + ", '" + trnsdesc.replace("'", "''") + "', " + dbtamnt
                    + ", '" + trnsdte.replace("'", "''") + "', " + crncyid + ", " + Global.rnUser_ID
                    + ", '" + dateStr + "', " + crdtamnt + ", "
                    + Global.rnUser_ID + ", '" + dateStr + "', " + netamnt
                    + ", -1, '" + srcDocTyp.replace("'", "''") + "', "
                    + srcDocID + ", " + srcDocLnID + ", '" + trnsSrc + "')";
            Global.insertDataNoParams(insSQL);
        } catch (Exception ex) {

        }
    }

    public static void createPayGLIntFcLn(int accntid, String trnsdesc, double dbtamnt,
            String trnsdte, int crncyid, double crdtamnt, double netamnt, String dateStr, String trnsSrc) {
        try {
            if (accntid <= 0) {
                return;
            }
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trnsdte = frmtr1.format(frmtr.parse(trnsdte));
            dateStr = frmtr1.format(frmtr.parse(dateStr));

            String insSQL = "INSERT INTO pay.pay_gl_interface ("
                    + "accnt_id, transaction_desc, dbt_amount, trnsctn_date, "
                    + "func_cur_id, created_by, creation_date, crdt_amount, last_update_by, "
                    + "last_update_date, net_amount, gl_batch_id, trns_source) "
                    + "VALUES (" + accntid + ", '" + trnsdesc.replace("'", "''") + "', " + dbtamnt
                    + ", '" + trnsdte.replace("'", "''") + "', " + crncyid + ", " + Global.rnUser_ID
                    + ", '" + dateStr + "', " + crdtamnt + ", "
                    + Global.rnUser_ID + ", '" + dateStr + "', " + netamnt
                    + ", -1, '" + trnsSrc + "')";
            Global.insertDataNoParams(insSQL);
        } catch (Exception ex) {

        }
    }

    public static long getIntrfcTrnsID(String intrfcTblNm, int accntID, double netAmnt, String trnsDte) {
        try {
            String selSQL = "SELECT interface_id FROM " + intrfcTblNm
                    + " WHERE accnt_id = " + accntID + " and net_amount =" + netAmnt
                    + " and trnsctn_date = '" + trnsDte + "'";
            ResultSet dtst = Global.selectDataNoParams(selSQL);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static ResultSet get_Intrfc_dateSums(String intrfcTblNm, int orgID) {
        String updtSQL = "UPDATE " + intrfcTblNm + " SET dbt_amount = round(dbt_amount,2), "
                + "crdt_amount = round(dbt_amount, 2) , net_amount = round(net_amount, 2) "
                + "WHERE round(crdt_amount - round(crdt_amount, 2))!=0 "
                + "or round(dbt_amount - round(dbt_amount, 2))!=0";
        Global.updateDataNoParams(updtSQL);

        String strSql = "SELECT substring(a.trnsctn_date from 1 for 10), "
                + "round(SUM(a.dbt_amount), 2), round(SUM(a.crdt_amount), 2) FROM " + intrfcTblNm
                + " a, accb.accb_chart_of_accnts b WHERE(a.gl_batch_id <= 0 and a.accnt_id = b.accnt_id and b.org_id = " + orgID
                + " and age(now(), to_timestamp(a.last_update_date,'YYYY-MM-DD HH24:MI:SS')) > interval '5 minute') "
                + "GROUP BY substring(a.trnsctn_date from 1 for 10 "
                + "HAVING SUM(a.dbt_amount) != SUM(a.crdt_amount) "
                + "ORDER BY 1";
        /**/
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static ResultSet get_Batch_dateSums(long batchID) {
        String strSql = "SELECT substring(a.trnsctn_date from 1 for 10), "
                + "SUM(a.dbt_amount), SUM(a.crdt_amount) "
                + "FROM accb.accb_trnsctn_details a "
                + "WHERE(a.batch_id = " + batchID + ") "
                + "GROUP BY substring(a.trnsctn_date from 1 for 10) "
                + "HAVING round(SUM(a.dbt_amount),2) != round(SUM(a.crdt_amount),2) "
                + "ORDER BY 1";

        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static double get_Batch_DbtSum(long batchID) {
        double sumRes = 0.00;
        try {
            String strSql = "SELECT SUM(a.dbt_amount)"
                    + "FROM accb.accb_trnsctn_details a "
                    + "WHERE(a.batch_id = " + batchID + ")";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                sumRes = (double) Math.round(dtst.getDouble(1) * 100) / 100;
            }
            return sumRes;
        } catch (SQLException ex) {
            return sumRes;
        }
    }

    public static double get_Batch_CrdtSum(long batchID) {
        double sumRes = 0.00;
        try {
            String strSql = "SELECT SUM(a.crdt_amount)"
                    + "FROM accb.accb_trnsctn_details a "
                    + "WHERE(a.batch_id = " + batchID + ")";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                sumRes = (double) Math.round(dtst.getDouble(1) * 100) / 100;
            }
            return sumRes;
        } catch (SQLException ex) {
            return sumRes;
        }
    }

    public static boolean hsTrnsUptdAcntBls(long actrnsid,
            String trnsdate, int accnt_id) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trnsdate = frmtr1.format(frmtr.parse(trnsdate));
            trnsdate = trnsdate.substring(0, 10);

            String strSql = "SELECT a.daily_bals_id FROM accb.accb_accnt_daily_bals a "
                    + "WHERE a.accnt_id = " + accnt_id
                    + " and a.as_at_date = '" + trnsdate + "' and a.src_trns_ids like '%," + actrnsid + ",%'";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return true;
            }
            return false;
        } catch (ParseException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static double get_Accnt_BalsTrnsSum(int accntID, String amntCol, String balsDte) {
        double sumRes = 0.00;
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDte = frmtr1.format(frmtr.parse(balsDte));

            String strSql = "SELECT SUM(a." + amntCol + ") "
                    + "FROM accb.accb_trnsctn_details a, accb.accb_chart_of_accnts b "
                    + "WHERE ((a.accnt_id=b.accnt_id) and (a.accnt_id = " + accntID + " or b.control_account_id=" + accntID + ") and (to_timestamp(a.trnsctn_date, "
                    + "'YYYY-MM-DD HH24:MI:SS') <= to_timestamp('" + balsDte
                    + "', 'YYYY-MM-DD HH24:MI:SS')) and "
                    + "(a.trns_status = '1'))";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                sumRes = (double) Math.round(dtst.getDouble(1) * 100) / 100;
            }
            return sumRes;
        } catch (ParseException ex) {
            return sumRes;
        } catch (SQLException ex) {
            return sumRes;
        }
    }

    public static ResultSet get_WrongNetBalncs(int orgID) {
        String updtSQL = "UPDATE accb.accb_trnsctn_details "
                + "SET dbt_amount = round(dbt_amount, 2), crdt_amount = round(crdt_amount, 2) "
                + "WHERE dbt_amount != round(dbt_amount, 2) or crdt_amount != round(crdt_amount, 2)";
        Global.updateDataNoParams(updtSQL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        }
        String selSQL = "select a.transctn_id, a.accnt_id, b.accnt_type, a.transaction_desc, a.trnsctn_date, "
                + "a.dbt_amount, a.crdt_amount, a.net_amount"
                + ", CASE WHEN b.accnt_type = 'A' or b.accnt_type ='EX' "
                + "THEN(dbt_amount - crdt_amount)  "
                + "ELSE(crdt_amount - dbt_amount) END actual_net "
                + "from accb.accb_trnsctn_details a, accb.accb_chart_of_accnts b "
                + "where a.accnt_id = b.accnt_id and a.trns_status = '1' and b.org_id = " + orgID
                + " and CASE WHEN b.accnt_type = 'A' or b.accnt_type ='EX' "
                + "THEN(dbt_amount - crdt_amount) "
                + "ELSE(crdt_amount - dbt_amount) END<> (net_amount)";
        return Global.selectDataNoParams(selSQL);
    }

    public static ResultSet get_WrongBalncs(int orgID) {
        String selSQL = "SELECT * FROM (SELECT a.daily_bals_id, a.accnt_id, b.accnt_name, b.accnt_type, "
                + "round(accb.get_accnt_trnsSum(a.accnt_id,'dbt_amount',as_at_date || ' 23:59:59'),2)-a.dbt_bal nw_dbbt_diff,"
                + "round(accb.get_accnt_trnsSum(a.accnt_id,'crdt_amount',as_at_date || ' 23:59:59'),2)-a.crdt_bal nw_crdt_diff,"
                + "round(accb.get_accnt_trnsSum(a.accnt_id,'net_amount',as_at_date || ' 23:59:59'),2)-a.net_balance nw_net_diff,"
                + "to_char(to_timestamp(a.as_at_date ||' 23:59:00','YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS') trns_date "
                + "FROM accb.accb_accnt_daily_bals a, accb.accb_chart_of_accnts b "
                + "where a.accnt_id = b.accnt_id and b.org_id = " + orgID + " and b.is_net_income != '1' and b.has_sub_ledgers != '1' "
                + "and a.as_at_date = (SELECT MAX  (as_at_date) FROM accb.accb_accnt_daily_bals d where d.accnt_id = a.accnt_id)) tbl1 "
                + "WHERE tbl1.nw_dbbt_diff != 0 or tbl1.nw_crdt_diff != 0 or tbl1.nw_net_diff != 0";
        //  and b.is_retained_earnings!='1'
        //Global.errorLog = "Wrong Balances SQL = " + selSQL;
        //Global.writeToLog();
        return Global.selectDataNoParams(selSQL);
    }

    public static ResultSet get_WrongNetIncmBalncs(int orgID) {
        String selSQL = "SELECT a.daily_bals_id, a.accnt_id, b.accnt_name, b.accnt_type, "
                + "round(accb.get_accnttype_trnsSum(" + orgID + ", 'R','dbt_amount',as_at_date || ' 23:59:59'),2) + "
                + "round(accb.get_accnttype_trnsSum(" + orgID + ",'EX','dbt_amount',as_at_date || ' 23:59:59'),2)-a.dbt_bal nw_dbbt_diff,"
                + "round(accb.get_accnttype_trnsSum(" + orgID + ", 'R','crdt_amount',as_at_date || ' 23:59:59'),2)+round(accb.get_accnttype_trnsSum(" + orgID
                + ",'EX','crdt_amount',as_at_date || ' 23:59:59'),2)-a.crdt_bal nw_crdt_diff,"
                + "round(accb.get_accnttype_trnsSum(" + orgID + ", 'R','net_amount',as_at_date || ' 23:59:59'),2)-round(accb.get_accnttype_trnsSum(" + orgID
                + ",'EX','net_amount',as_at_date || ' 23:59:59'),2)-a.net_balance nw_net_diff,"
                + "to_char(to_timestamp(a.as_at_date ||' 23:59:00','YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS') trns_date "
                + "FROM accb.accb_accnt_daily_bals a, accb.accb_chart_of_accnts b "
                + "where a.accnt_id = b.accnt_id and b.org_id = " + orgID
                + " and b.is_net_income = '1' and b.has_sub_ledgers != '1' and "
                + "a.as_at_date = (SELECT MAX  (as_at_date) FROM accb.accb_accnt_daily_bals d "
                + "where d.accnt_id = a.accnt_id)";
        //  and b.is_retained_earnings!='1'
        return Global.selectDataNoParams(selSQL);
    }

    public static boolean hsTrnsUptdAcntCurrBls(long actrnsid,
            String trnsdate, int accnt_id) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trnsdate = frmtr1.format(frmtr.parse(trnsdate));
            trnsdate = trnsdate.substring(0, 10);

            String strSql = "SELECT a.daily_cbals_id FROM accb.accb_accnt_crncy_daily_bals a "
                    + "WHERE a.accnt_id = " + accnt_id
                    + " and a.as_at_date = '" + trnsdate + "' and a.src_trns_ids like '%," + actrnsid + ",%'";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return true;
            }
            return false;
        } catch (ParseException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static void updtAcntChrtBals(int accntid,
            double dbtAmnt, double crdtAmnt, double netAmnt, String trnsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trnsDate = frmtr1.format(frmtr.parse(trnsDate));
            trnsDate = trnsDate.substring(0, 10);

            String dateStr = Global.getDB_Date_time();
            String updtSQL = "UPDATE accb.accb_chart_of_accnts "
                    + "SET last_update_by = " + Global.rnUser_ID
                    + ", last_update_date = '" + dateStr
                    + "', balance_date = '" + trnsDate + "', "
                    + "debit_balance = " + dbtAmnt
                    + ", credit_balance = " + crdtAmnt
                    + ", net_balance = " + netAmnt
                    + " WHERE accnt_id = " + accntid;
            Global.updateDataNoParams(updtSQL);
        } catch (ParseException ex) {
        }
    }

    public static void createDailyBals(int accntid, double netbals,
            double dbtbals, double crdtbals, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String dateStr = Global.getDB_Date_time();
            String insSQL = "INSERT INTO accb.accb_accnt_daily_bals("
                    + "accnt_id, net_balance, dbt_bal, crdt_bal, as_at_date, "
                    + "created_by, creation_date, last_update_by, last_update_date, src_trns_ids) "
                    + "VALUES (" + accntid
                    + ", " + netbals + ", " + dbtbals + ", " + crdtbals + ", '" + balsDate
                    + "', " + Global.rnUser_ID + ", '" + dateStr
                    + "', " + Global.rnUser_ID + ", '" + dateStr + "', ',')";
            Global.insertDataNoParams(insSQL);
        } catch (ParseException ex) {
        }
    }

    public static void createDailyAccntCurrBals(int accntid, double netbals,
            double dbtbals, double crdtbals, String balsDate, int currID) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String dateStr = Global.getDB_Date_time();
            String insSQL = "INSERT INTO accb.accb_accnt_crncy_daily_bals("
                    + "accnt_id, net_balance, dbt_bal, crdt_bal, as_at_date, "
                    + "created_by, creation_date, last_update_by, last_update_date, src_trns_ids, crncy_id) "
                    + "VALUES (" + accntid
                    + ", " + netbals + ", " + dbtbals + ", " + crdtbals + ", '" + balsDate + "', " + Global.rnUser_ID + ", '" + dateStr
                    + "', " + Global.rnUser_ID + ", '" + dateStr + "', ',', " + currID + ")";
            Global.insertDataNoParams(insSQL);
        } catch (ParseException ex) {
        }
    }

    public static double getSign(double inptAMnt) {
        if (inptAMnt != 0) {
            return inptAMnt / Math.abs(inptAMnt);
        }
        return 0;
    }

    public static void postTransaction(int accntid,
            double dbtAmnt, double crdtAmnt, double netAmnt,
            String trnsDate, long src_trsID) {
        long dailybalID = Global.getAccntDailyBalsID(accntid, trnsDate);
        //Get dailybalid for accnt on this date
        //if doesn't exist get last accnt bals be4 this date
        //add new amount to it and insert record
        if (dailybalID <= 0) {
            double lstNetBals = Global.getAccntLstDailyNetBals(accntid, trnsDate);
            double lstDbtBals = Global.getAccntLstDailyDbtBals(accntid, trnsDate);
            double lstCrdtBals = Global.getAccntLstDailyCrdtBals(accntid, trnsDate);
            Global.createDailyBals(accntid, lstNetBals, lstDbtBals, lstCrdtBals, trnsDate);
            Global.updtAccntDailyBals(trnsDate, accntid, dbtAmnt,
                    crdtAmnt, netAmnt, src_trsID, "Do");
        } else {
            Global.updtAccntDailyBals(trnsDate, accntid, dbtAmnt,
                    crdtAmnt, netAmnt, src_trsID, "Do");
        }
    }

    public static void updtAccntDailyBals(String balsDate, int accntID,
            double dbtAmnt, double crdtAmnt, double netAmnt, long src_trnsID,
            String act_typ) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String dateStr = Global.getDB_Date_time();
            String updtSQL = "";
            if (act_typ.equals("Undo")) {
                updtSQL = "UPDATE accb.accb_accnt_daily_bals "
                        + "SET last_update_by = " + Global.rnUser_ID
                        + ", last_update_date = '" + dateStr
                        + "', dbt_bal = dbt_bal - " + dbtAmnt
                        + ", crdt_bal = crdt_bal - " + crdtAmnt
                        + ", net_balance = net_balance - " + netAmnt
                        + ", src_trns_ids = replace(src_trns_ids, '," + src_trnsID + ",', ',')"
                        + " WHERE (to_timestamp(as_at_date,'YYYY-MM-DD') >=  to_timestamp('" + balsDate
                        + "','YYYY-MM-DD') and accnt_id = " + accntID + ")";
            } else {
                updtSQL = "UPDATE accb.accb_accnt_daily_bals "
                        + "SET last_update_by = " + Global.rnUser_ID
                        + ", last_update_date = '" + dateStr
                        + "', dbt_bal = dbt_bal + " + dbtAmnt
                        + ", crdt_bal = crdt_bal + " + crdtAmnt
                        + ", net_balance = net_balance +" + netAmnt
                        + ", src_trns_ids = src_trns_ids || '" + src_trnsID + ",'"
                        + " WHERE (to_timestamp(as_at_date,'YYYY-MM-DD') >=  to_timestamp('" + balsDate
                        + "','YYYY-MM-DD') and accnt_id = " + accntID + ")";
            }
            Global.updateDataNoParams(updtSQL);
        } catch (ParseException ex) {
        }
    }

    public static void undoPostTransaction(int accntid, double dbtAmnt,
            double crdtAmnt, double netAmnt, String trnsDate, long src_trsID) {
        long dailybalID = Global.getAccntDailyBalsID(accntid, trnsDate);
        //Get dailybalid for accnt on this date
        //if doesn't exist get last accnt bals be4 this date
        //subtract new amount from it and insert record
        if (dailybalID <= 0) {
            //double lstNetBals = Global.getAccntLstDailyNetBals(accntid, trnsDate);
            //double lstDbtBals = Global.getAccntLstDailyDbtBals(accntid, trnsDate);
            //double lstCrdtBals = Global.getAccntLstDailyCrdtBals(accntid, trnsDate);
            //Global.createDailyBals(accntid, lstNetBals, lstDbtBals, lstCrdtBals, trnsDate);
            //Global.updtAccntDailyBals(trnsDate, accntid, dbtAmnt,
            //  crdtAmnt, netAmnt, src_trsID, "Undo");
        } else {
            Global.updtAccntDailyBals(trnsDate, accntid, dbtAmnt,
                    crdtAmnt, netAmnt, src_trsID, "Undo");
        }
    }

    public static void postAccntCurrTransaction(int accntid,
            double dbtAmnt, double crdtAmnt, double netAmnt,
            String trnsDate, long src_trsID, int currID) {
        if (dbtAmnt == 0 && crdtAmnt == 0 && netAmnt == 0) {
            double acntCurrAmnt = Double.parseDouble(Global.getGnrlRecNm(
                    "accb.accb_trnsctn_details", "transctn_id", "accnt_crncy_amnt", src_trsID));
            String dbtCrdt = Global.getGnrlRecNm(
                    "accb.accb_trnsctn_details", "transctn_id", "dbt_or_crdt", src_trsID);
            String incrdcrs = "";
            if (dbtCrdt.equals("C")) {
                incrdcrs = Global.incrsOrDcrsAccnt(accntid, "Credit");
                dbtAmnt = 0;
                crdtAmnt = acntCurrAmnt;
                netAmnt = (double) Global.dbtOrCrdtAccntMultiplier(accntid,
                        incrdcrs.substring(0, 1)) * acntCurrAmnt;

            } else {
                incrdcrs = Global.incrsOrDcrsAccnt(accntid, "Debit");
                dbtAmnt = acntCurrAmnt;
                crdtAmnt = 0;
                netAmnt = (double) Global.dbtOrCrdtAccntMultiplier(accntid,
                        incrdcrs.substring(0, 1)) * acntCurrAmnt;
            }
        }
        long dailybalID = Global.getAccntDailyCurrBalsID(accntid, trnsDate);
        //Get dailybalid for accnt on this date
        //if doesn't exist get last accnt bals be4 this date
        //add new amount to it and insert record
        if (dailybalID <= 0) {
            double lstNetBals = Global.getAccntLstDailyNetCurrBals(accntid, trnsDate);
            double lstDbtBals = Global.getAccntLstDailyDbtCurrBals(accntid, trnsDate);
            double lstCrdtBals = Global.getAccntLstDailyCrdtCurrBals(accntid, trnsDate);
            Global.createDailyAccntCurrBals(accntid, lstNetBals, lstDbtBals, lstCrdtBals, trnsDate, currID);
            Global.updtAccntDailyCurrBals(trnsDate, accntid, dbtAmnt,
                    crdtAmnt, netAmnt, src_trsID, "Do", currID);
        } else {
            Global.updtAccntDailyCurrBals(trnsDate, accntid, dbtAmnt,
                    crdtAmnt, netAmnt, src_trsID, "Do", currID);
        }
    }

    public static void updtAccntDailyCurrBals(String balsDate, int accntID,
            double dbtAmnt, double crdtAmnt, double netAmnt, long src_trnsID,
            String act_typ, int currID) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String dateStr = Global.getDB_Date_time();
            String updtSQL = "";
            if (act_typ.equals("Undo")) {
                updtSQL = "UPDATE accb.accb_accnt_crncy_daily_bals "
                        + "SET last_update_by = " + Global.rnUser_ID
                        + ", last_update_date = '" + dateStr
                        + "', dbt_bal = dbt_bal - " + dbtAmnt
                        + ", crdt_bal = crdt_bal - " + crdtAmnt
                        + ", net_balance = net_balance - " + netAmnt
                        + ", src_trns_ids = replace(src_trns_ids, '," + src_trnsID + ",', ',')"
                        + ", crncy_id = " + currID + " "
                        + " WHERE (to_timestamp(as_at_date,'YYYY-MM-DD') >=  to_timestamp('" + balsDate
                        + "','YYYY-MM-DD') and accnt_id = " + accntID + ")";
            } else {
                updtSQL = "UPDATE accb.accb_accnt_crncy_daily_bals "
                        + "SET last_update_by = " + Global.rnUser_ID
                        + ", last_update_date = '" + dateStr
                        + "', dbt_bal = dbt_bal + " + dbtAmnt
                        + ", crdt_bal = crdt_bal + " + crdtAmnt
                        + ", net_balance = net_balance +" + netAmnt
                        + ", src_trns_ids = src_trns_ids || '" + src_trnsID + ",'"
                        + ", crncy_id = " + currID + " "
                        + " WHERE (to_timestamp(as_at_date,'YYYY-MM-DD') >=  to_timestamp('" + balsDate
                        + "','YYYY-MM-DD') and accnt_id = " + accntID + ")";
            }
            Global.updateDataNoParams(updtSQL);
        } catch (ParseException ex) {
        }
    }

    public static void undoPostAccntCurrTransaction(int accntid, double dbtAmnt,
            double crdtAmnt, double netAmnt, String trnsDate, long src_trsID, int currID) {
        if (dbtAmnt == 0 && crdtAmnt == 0 && netAmnt == 0) {
            double acntCurrAmnt = Double.parseDouble(Global.getGnrlRecNm(
                    "accb.accb_trnsctn_details", "transctn_id", "accnt_crncy_amnt", src_trsID));
            String dbtCrdt = Global.getGnrlRecNm(
                    "accb.accb_trnsctn_details", "transctn_id", "dbt_or_crdt", src_trsID);
            String incrdcrs = "";
            if (dbtCrdt.equals("C")) {
                incrdcrs = Global.incrsOrDcrsAccnt(accntid, "Credit");
                dbtAmnt = 0;
                crdtAmnt = acntCurrAmnt;
                netAmnt = (double) Global.dbtOrCrdtAccntMultiplier(accntid,
                        incrdcrs.substring(0, 1)) * acntCurrAmnt;
            } else {
                incrdcrs = Global.incrsOrDcrsAccnt(accntid, "Debit");
                dbtAmnt = acntCurrAmnt;
                crdtAmnt = 0;
                netAmnt = (double) Global.dbtOrCrdtAccntMultiplier(accntid,
                        incrdcrs.substring(0, 1)) * acntCurrAmnt;
            }
        }
        long dailybalID = Global.getAccntDailyCurrBalsID(accntid, trnsDate);
        //Get dailybalid for accnt on this date
        //if doesn't exist get last accnt bals be4 this date
        //subtract new amount from it and insert record
        if (dailybalID <= 0) {
            //double lstNetBals = Global.getAccntLstDailyNetBals(accntid, trnsDate);
            //double lstDbtBals = Global.getAccntLstDailyDbtBals(accntid, trnsDate);
            //double lstCrdtBals = Global.getAccntLstDailyCrdtBals(accntid, trnsDate);
            //Global.createDailyBals(accntid, lstNetBals, lstDbtBals, lstCrdtBals, trnsDate);
            //Global.updtAccntDailyBals(trnsDate, accntid, dbtAmnt,
            //  crdtAmnt, netAmnt, src_trsID, "Undo");
        } else {
            Global.updtAccntDailyCurrBals(trnsDate, accntid, dbtAmnt,
                    crdtAmnt, netAmnt, src_trsID, "Undo", currID);
        }
    }

    public static double get_Accnt_Net_Bals(int accntID) {
        try {
            String strSql = "SELECT a.net_balance "
                    + "FROM accb.accb_chart_of_accnts a "
                    + "WHERE(a.accnt_id = " + accntID + ")";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        }
    }

    public static double get_Accnt_Bls_Bals(int accntID, long blsID) {
        try {
            String strSql = "SELECT a.net_balance "
                    + "FROM accb.accb_balsheet_details a "
                    + "WHERE(a.accnt_id = " + accntID + " and a.balsheet_header_id = " + blsID + ")";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        }
    }

    public static long getTodaysGLBatchID(String batchnm, int orgid) {
        try {
            String strSql = "SELECT a.batch_id "
                    + "FROM accb.accb_trnsctn_batches a "
                    + "WHERE(a.batch_name ilike '%" + batchnm.replace("'", "''")
                    + "%' and org_id = " + orgid + " and batch_status = '0')";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static double getAccntDailyNetBals(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String strSql = "SELECT a.net_balance "
                    + "FROM accb.accb_accnt_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') =  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID + ")";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        } catch (ParseException ex) {
            return 0.00;
        }
    }

    public static String[] getAccntLstDailyBalsInfo(int accntID, String balsDate) {
        String dateStr = balsDate;
        String[] rslt = {"0", "0", "0", dateStr};
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String strSql = "SELECT a.dbt_bal, a.crdt_bal, a.net_balance, "
                    + "to_char(to_timestamp(a.as_at_date,'YYYY-MM-DD HH24:MI:SS'),'DD-Mon-YYYY HH24:MI:SS') "
                    + "FROM accb.accb_accnt_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') <=  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID
                    + ") ORDER BY to_timestamp(a.as_at_date,'YYYY-MM-DD') DESC LIMIT 1 OFFSET 0";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                rslt[0] = dtst.getString(1);
                rslt[1] = dtst.getString(2);
                rslt[2] = dtst.getString(3);
                rslt[3] = dtst.getString(4);
                return rslt;
            }
            return rslt;
        } catch (SQLException ex) {
            return rslt;
        } catch (ParseException ex) {
            return rslt;
        }
    }

    public static double getAccntLstDailyNetBals(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);
            String strSql = "SELECT a.net_balance "
                    + "FROM accb.accb_accnt_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') <=  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID
                    + ") ORDER BY to_timestamp(a.as_at_date,'YYYY-MM-DD') DESC LIMIT 1 OFFSET 0";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        } catch (ParseException ex) {
            return 0.00;
        }
    }

    public static long getAccntDailyBalsID(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);
            String strSql = "SELECT a.daily_bals_id "
                    + "FROM accb.accb_accnt_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') =  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID + ")";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        } catch (ParseException ex) {
            return -1;
        }
    }

    public static double getAccntLstDailyCrdtBals(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String strSql = "SELECT a.crdt_bal "
                    + "FROM accb.accb_accnt_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') <=  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID
                    + ") ORDER BY to_timestamp(a.as_at_date,'YYYY-MM-DD') DESC LIMIT 1 OFFSET 0";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        } catch (ParseException ex) {
            return 0.00;
        }
    }

    public static double getAccntLstDailyDbtBals(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String strSql = "SELECT a.dbt_bal "
                    + "FROM accb.accb_accnt_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') <=  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID + ") ORDER BY to_timestamp(a.as_at_date,'YYYY-MM-DD') DESC LIMIT 1 OFFSET 0";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        } catch (ParseException ex) {
            return 0.00;
        }
    }

    public static double getAccntDailyDbtBals(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String strSql = "SELECT a.dbt_bal "
                    + "FROM accb.accb_accnt_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') =  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID + ")";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        } catch (ParseException ex) {
            return 0.00;
        }
    }

    public static double getAccntDailyCrdtBals(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);
            String strSql = "SELECT a.crdt_bal "
                    + "FROM accb.accb_accnt_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') =  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID + ")";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        } catch (ParseException ex) {
            return 0.00;
        }
    }

    public static ResultSet get_Bals_Prnt_Accnts(int prntAccntID) {
        String strSql = "WITH RECURSIVE subaccnt(accnt_id, prnt_accnt_id, accnt_num, accnt_name, debit_balance, credit_balance, net_balance, depth, path, cycle, space) AS "
                + "( "
                + "   SELECT e.accnt_id, e.prnt_accnt_id, e.accnt_num, e.accnt_name, e.debit_balance, e.credit_balance, e.net_balance, 1, ARRAY[e.accnt_id], false, '' FROM accb.accb_chart_of_accnts e WHERE e.prnt_accnt_id = " + prntAccntID
                + "   UNION ALL "
                + "  SELECT d.accnt_id, d.prnt_accnt_id, d.accnt_num, d.accnt_name, d.debit_balance, d.credit_balance, d.net_balance, sd.depth + 1, "
                + "        path || d.accnt_id, "
                + "        d.accnt_id = ANY(path), space || '.' "
                + " FROM "
                + "    accb.accb_chart_of_accnts AS d, "
                + "   subaccnt AS sd "
                + "  WHERE d.prnt_accnt_id = sd.accnt_id AND NOT cycle "
                + ") "
                + "SELECT SUM(debit_balance), SUM(credit_balance), SUM(net_balance) "
                + "FROM subaccnt "
                + "WHERE accnt_num ilike '%'";
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static long getAccntDailyCurrBalsID(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String strSql = "SELECT a.daily_cbals_id "
                    + "FROM accb.accb_accnt_crncy_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') =  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID + ")";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        } catch (ParseException ex) {
            return -1;
        }
    }

    public static double getAccntLstDailyNetCurrBals(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String strSql = "SELECT a.net_balance "
                    + "FROM accb.accb_accnt_crncy_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') <=  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID
                    + ") ORDER BY to_timestamp(a.as_at_date,'YYYY-MM-DD') DESC LIMIT 1 OFFSET 0";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        } catch (ParseException ex) {
            return 0.00;
        }
    }

    public static double getAccntLstDailyCrdtCurrBals(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String strSql = "SELECT a.crdt_bal "
                    + "FROM accb.accb_accnt_crncy_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') <=  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID + ") ORDER BY to_timestamp(a.as_at_date,'YYYY-MM-DD') DESC LIMIT 1 OFFSET 0";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        } catch (ParseException ex) {
            return 0.00;
        }
    }

    public static double getAccntLstDailyDbtCurrBals(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String strSql = "SELECT a.dbt_bal "
                    + "FROM accb.accb_accnt_crncy_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') <=  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID + ") ORDER BY to_timestamp(a.as_at_date,'YYYY-MM-DD') DESC LIMIT 1 OFFSET 0";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }
            return 0.00;
        } catch (SQLException ex) {
            return 0.00;
        } catch (ParseException ex) {
            return 0.00;
        }
    }

    public static double getAccntDailyDbtCurrBals(int accntID, String balsDate) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            balsDate = frmtr1.format(frmtr.parse(balsDate));
            balsDate = balsDate.substring(0, 10);

            String strSql = "SELECT a.dbt_bal "
                    + "FROM accb.accb_accnt_crncy_daily_bals a "
                    + "WHERE(to_timestamp(a.as_at_date,'YYYY-MM-DD') =  to_timestamp('" + balsDate
                    + "','YYYY-MM-DD') and a.accnt_id = " + accntID + ")";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        } catch (ParseException ex) {
            return -1;
        }
    }

    public static ResultSet get_CurrBals_Prnt_Accnts(int prntAccntID, int CurrID) {
        String dtestr = Global.getDB_Date_time();
        String strSql = "select SUM(g.dbt_bal), SUM(g.crdt_bal), SUM(g.net_balance) "
                + "from accb.accb_accnt_crncy_daily_bals g, accb.accb_chart_of_accnts h, "
                + "(SELECT MAX(a.as_at_date) dte1, a.accnt_id accnt1 "
                + "from accb.accb_accnt_crncy_daily_bals a, accb.accb_chart_of_accnts b "
                + "where a.accnt_id = b.accnt_id and a.crncy_id = " + CurrID
                + " and b.prnt_accnt_id = " + prntAccntID
                + " and to_timestamp(a.as_at_date,'YYYY-MM-DD') <= to_timestamp('"
                + dtestr.substring(0, 10) + "','YYYY-MM-DD') GROUP BY a.accnt_id) tbl1 "
                + "where g.accnt_id = h.accnt_id and g.crncy_id = " + CurrID
                + " and h.prnt_accnt_id = " + prntAccntID + " and g.as_at_date = tbl1.dte1 "
                + "and g.accnt_id = tbl1.accnt1";
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static ResultSet get_CurrBals_Cntrl_Accnts(int cntrlAccntID, int CurrID) {
        String dtestr = Global.getDB_Date_time();
        String strSql = "select SUM(g.dbt_bal), SUM(g.crdt_bal), SUM(g.net_balance) "
                + "from accb.accb_accnt_crncy_daily_bals g, accb.accb_chart_of_accnts h, "
                + "(SELECT MAX(a.as_at_date) dte1, a.accnt_id accnt1 "
                + "from accb.accb_accnt_crncy_daily_bals a, accb.accb_chart_of_accnts b "
                + "where a.accnt_id = b.accnt_id and a.crncy_id = " + CurrID
                + " and b.control_account_id = " + cntrlAccntID
                + " and to_timestamp(a.as_at_date,'YYYY-MM-DD') <= to_timestamp('"
                + dtestr.substring(0, 10) + "','YYYY-MM-DD') "
                + "GROUP BY a.accnt_id) tbl1 where g.accnt_id = h.accnt_id and g.crncy_id = " + CurrID
                + " and h.control_account_id = " + cntrlAccntID + " and g.as_at_date = tbl1.dte1 "
                + "and g.accnt_id = tbl1.accnt1";
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static ResultSet get_CurrBals_Accnts(int accntID) {
        String dtestr = Global.getDB_Date_time();
        String strSql = "select a.dbt_bal, a.crdt_bal, a.net_balance, "
                + "to_char(to_timestamp(a.as_at_date,'YYYY-MM-DD'),'DD-Mon-YYYY') "
                + "from accb.accb_accnt_crncy_daily_bals a where a.accnt_id = " + accntID
                + " and to_timestamp(a.as_at_date,'YYYY-MM-DD') <= to_timestamp('" + dtestr.substring(0, 10) + "','YYYY-MM-DD') "
                + "ORDER BY to_timestamp(a.as_at_date,'YYYY-MM-DD') DESC LIMIT 1 OFFSET 0";
        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static double get_COA_CRLSum(int orgID) {
        double sumRes = 0.00;
        try {
            String strSql = "SELECT SUM(a.net_balance) "
                    + "FROM accb.accb_chart_of_accnts a "
                    + "WHERE ((a.org_id = " + orgID + ") and "
                    + "(a.is_net_income = '0') and (a.control_account_id <=0) "
                    + "and (a.accnt_type IN ('EQ','R', 'L')))";
            //(a.is_retained_earnings = '0') and 
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                sumRes = dtst.getDouble(1);
                return (double) (Math.round(sumRes * 100) / 100);
            }
            return sumRes;
        } catch (SQLException ex) {
            return sumRes;
        }
    }

    public static double get_COA_AESum(int orgID) {
        double sumRes = 0.00;
        try {
            String strSql = "";
            strSql = "SELECT SUM(a.net_balance) "
                    + "FROM accb.accb_chart_of_accnts a "
                    + "WHERE ((a.org_id = " + orgID + ") and "
                    + "(a.is_net_income = '0') and (a.control_account_id <=0) "
                    + "and (a.accnt_type IN ('A','EX')))";
            //(a.is_retained_earnings = '0') 
            ResultSet dtst = Global.selectDataNoParams(strSql);

            while (dtst.next()) {
                sumRes = dtst.getDouble(1);
                return (double) (Math.round(sumRes * 100) / 100);
            }
            return sumRes;
        } catch (SQLException ex) {
            return sumRes;
        }
    }

    public static void chngeTrnsStatus(long trnsid, String status) {
        String dateStr = Global.getDB_Date_time();
        String updtSQL = "UPDATE accb.accb_trnsctn_details "
                + "SET last_update_by = " + Global.rnUser_ID + ", last_update_date = '" + dateStr
                + "', trns_status = '" + status + "'"
                + " WHERE transctn_id = " + trnsid;
        Global.updateDataNoParams(updtSQL);
    }

    public static void changeReconciledStatus(long trnsID, String nwStatus) {
        if (trnsID <= 0) {
            return;
        }
        //Global.Extra_Adt_Trl_Info = "";
        String updtSQL = "UPDATE accb.accb_trnsctn_details SET is_reconciled = '"
                + nwStatus.replace("'", "''") + "' WHERE transctn_id=" + trnsID + " or src_trns_id_reconciled = " + trnsID;
        Global.updateDataNoParams(updtSQL);
    }

    public static String incrsOrDcrsAccnt(int accntid, String dbtOrCrdt) {
        String accntType = Global.getAccntType(accntid);
        String isContra = Global.isAccntContra(accntid);
        if (isContra == "0") {
            if ((accntType == "A" || accntType == "EX") && dbtOrCrdt == "Debit") {
                return "INCREASE";
            } else if ((accntType == "A" || accntType == "EX") && dbtOrCrdt == "Credit") {
                return "DECREASE";
            } else if ((accntType == "EQ" || accntType == "R" || accntType == "L") && dbtOrCrdt == "Credit") {
                return "INCREASE";
            } else if ((accntType == "EQ" || accntType == "R" || accntType == "L") && dbtOrCrdt == "Debit") {
                return "DECREASE";
            }
        } else if ((accntType == "A" || accntType == "EX") && dbtOrCrdt == "Debit") {
            return "DECREASE";
        } else if ((accntType == "A" || accntType == "EX") && dbtOrCrdt == "Credit") {
            return "INCREASE";
        } else if ((accntType == "EQ" || accntType == "R" || accntType == "L") && dbtOrCrdt == "Credit") {
            return "DECREASE";
        } else if ((accntType == "EQ" || accntType == "R" || accntType == "L") && dbtOrCrdt == "Debit") {
            return "INCREASE";
        }
        return "";
    }

    public static String dbtOrCrdtAccnt(int accntid, String incrsDcrse) {
        String accntType = Global.getAccntType(accntid);
        String isContra = Global.isAccntContra(accntid);
        if (isContra.equals("0")) {
            if ((accntType.equals("A") || accntType.equals("EX")) && incrsDcrse.equals("I")) {
                return "Debit";
            } else if ((accntType.equals("A") || accntType.equals("EX")) && incrsDcrse.equals("D")) {
                return "Credit";
            } else if ((accntType.equals("EQ") || accntType.equals("R") || accntType.equals("L")) && incrsDcrse.equals("I")) {
                return "Credit";
            } else if ((accntType.equals("EQ") || accntType.equals("R") || accntType.equals("L")) && incrsDcrse.equals("D")) {
                return "Debit";
            }
        } else if ((accntType.equals("A") || accntType.equals("EX")) && incrsDcrse.equals("I")) {
            return "Credit";
        } else if ((accntType.equals("A") || accntType.equals("EX")) && incrsDcrse.equals("D")) {
            return "Debit";
        } else if ((accntType.equals("EQ") || accntType.equals("R")) || accntType.equals("L") && incrsDcrse.equals("I")) {
            return "Debit";
        } else if ((accntType.equals("EQ") || accntType.equals("R")) || accntType.equals("L") && incrsDcrse.equals("D")) {
            return "Credit";
        }
        return "";
    }

    public static int dbtOrCrdtAccntMultiplier(int accntid, String incrsDcrse) {
        String accntType = Global.getAccntType(accntid);
        String isContra = Global.isAccntContra(accntid);
        if (isContra.equals("0")) {
            if ((accntType.equals("A") || accntType.equals("EX")) && incrsDcrse.equals("I")) {
                return 1;
            } else if ((accntType.equals("A") || accntType.equals("EX")) && incrsDcrse.equals("D")) {
                return -1;
            } else if ((accntType.equals("EQ") || accntType.equals("R")) || accntType.equals("L") && incrsDcrse.equals("I")) {
                return 1;
            } else if ((accntType.equals("EQ") || accntType.equals("R")) || accntType.equals("L") && incrsDcrse.equals("D")) {
                return -1;
            }
        } else if ((accntType.equals("A") || accntType.equals("EX")) && incrsDcrse.equals("I")) {
            return -1;
        } else if ((accntType.equals("A") || accntType.equals("EX")) && incrsDcrse.equals("D")) {
            return 1;
        } else if ((accntType.equals("EQ") || accntType.equals("R")) || accntType.equals("L") && incrsDcrse.equals("I")) {
            return -1;
        } else if ((accntType.equals("EQ") || accntType.equals("R")) || accntType.equals("L") && incrsDcrse.equals("D")) {
            return 1;
        }
        return 1;
    }

    public static int getAccntID(String accntname, int orgid) {
        //Example username 'admin'
        try {
            String sqlStr = "select accnt_id from accb.accb_chart_of_accnts where ((lower(accnt_name) = '"
                    + accntname.replace("'", "''").toLowerCase() + "' or lower(accnt_num) = '"
                    + accntname.replace("'", "''").toLowerCase() + "') and org_id = " + orgid + ")";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static String getAccntName(int accntid) {
        //Example username 'admin'
        try {
            String sqlStr = "select accnt_name from accb.accb_chart_of_accnts where accnt_id = "
                    + accntid + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String getAccntNum(int accntid) {
        try {
            //Example username 'admin'
            String sqlStr = "select accnt_num from accb.accb_chart_of_accnts where accnt_id = "
                    + accntid + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String getAccntType(int accntid) {
        try {
            //Example username 'admin'
            String sqlStr = "select accnt_type from accb.accb_chart_of_accnts where accnt_id = "
                    + accntid + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static String isAccntContra(int accntid) {
        //Example username 'admin'
        try {
            String sqlStr = "select is_contra from accb.accb_chart_of_accnts where accnt_id = "
                    + accntid + "";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static void createTodaysGLBatch(int orgid, String batchnm,
            String batchdesc, String batchsource) {
        String dateStr = Global.getDB_Date_time();
        String insSQL = "INSERT INTO accb.accb_trnsctn_batches("
                + "batch_name, batch_description, created_by, creation_date, "
                + "org_id, batch_status, last_update_by, last_update_date, batch_source) "
                + "VALUES ('" + batchnm.replace("'", "''") + "', '" + batchdesc.replace("'", "''")
                + "', " + Global.rnUser_ID + ", '" + dateStr + "', " + orgid + ", '0', "
                + Global.rnUser_ID + ", '" + dateStr + "', '"
                + batchsource.replace("'", "''") + "')";
        Global.insertDataNoParams(insSQL);
    }

    public static int get_Suspns_Accnt(int orgid) {
        try {
            String strSql = "SELECT a.accnt_id "
                    + "FROM accb.accb_chart_of_accnts a "
                    + "WHERE(a.is_suspens_accnt = '1' and a.org_id = " + orgid + ")";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static void createTransaction(int accntid, String trnsDesc,
            double dbtAmnt, String trnsDate, int crncyid,
            long batchid, double crdtamnt, double netAmnt,
            double entrdAmt, int entrdCurrID, double acntAmnt, int acntCurrID,
            double funcExchRate, double acntExchRate, String dbtOrCrdt) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trnsDate = frmtr1.format(frmtr.parse(trnsDate));

            if (trnsDesc.length() > 500) {
                trnsDesc = trnsDesc.substring(0, 500);
            }
            String dateStr = Global.getDB_Date_time();
            String insSQL = "INSERT INTO accb.accb_trnsctn_details("
                    + "accnt_id, transaction_desc, dbt_amount, trnsctn_date, "
                    + "func_cur_id, created_by, creation_date, batch_id, crdt_amount, "
                    + "last_update_by, last_update_date, net_amount, "
                    + "entered_amnt, entered_amt_crncy_id, accnt_crncy_amnt, accnt_crncy_id, "
                    + "func_cur_exchng_rate, accnt_cur_exchng_rate, dbt_or_crdt) "
                    + "VALUES (" + accntid + ", '" + trnsDesc.replace("'", "''") + "', " + dbtAmnt
                    + ", '" + trnsDate + "', " + crncyid + ", " + Global.rnUser_ID + ", '" + dateStr
                    + "', " + batchid + ", " + crdtamnt + ", " + Global.rnUser_ID
                    + ", '" + dateStr + "'," + netAmnt + ", " + entrdAmt
                    + ", " + entrdCurrID + ", " + acntAmnt
                    + ", " + acntCurrID + ", " + funcExchRate
                    + ", " + acntExchRate + ", '" + dbtOrCrdt + "')";
            Global.insertDataNoParams(insSQL);
        } catch (ParseException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String get_GLBatch_Nm(long batchID) {
        try {
            String strSql = "SELECT a.batch_name "
                    + "FROM accb.accb_trnsctn_batches a "
                    + "WHERE(a.batch_id = " + batchID + ")";

            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getString(1);
            }
            return "";
        } catch (SQLException ex) {
            return "";
        }
    }

    public static void deleteBatch(long batchid, String batchNm) {
        String delSql = "DELETE FROM accb.accb_trnsctn_batches WHERE(batch_id = " + batchid + ")";
        Global.deleteDataNoParams(delSql);
    }

    public static void deleteBatchTrns(long batchid) {
        String delSql = "DELETE FROM accb.accb_trnsctn_details WHERE(batch_id = " + batchid + ")";
        Global.deleteDataNoParams(delSql);
    }

    public static String getGLIntrfcIDs(int accntid, String trns_date, int crncy_id, String tblNme) {
        String infc_ids = ",";
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trns_date = frmtr1.format(frmtr.parse(trns_date));
            String strSql = "select distinct a.interface_id from " + tblNme + " a "
                    + "where a.accnt_id = " + accntid + " and a.trnsctn_date = '" + trns_date
                    + "' and a.func_cur_id = " + crncy_id + " and a.gl_batch_id = -1  "
                    + "ORDER BY a.interface_id";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                infc_ids = infc_ids + dtst.getString(1) + ",";
            }
            return infc_ids;
        } catch (SQLException ex) {
            return infc_ids;
        } catch (ParseException ex) {
            return infc_ids;
        }
    }

    public static double[] getGLIntrfcIDAmntSum(String intrfcids, String tblNme, int accntID) {
        double[] res = {0, 0};
        try {
            String strSql = "SELECT COALESCE(SUM(a.dbt_amount),0), COALESCE(SUM(a.crdt_amount),0) FROM " + tblNme
                    + " a WHERE (a.accnt_id = " + accntID + " and '" + intrfcids + "'  like '%,' || a.interface_id || ',%') ";
            ResultSet dtst = Global.selectDataNoParams(strSql);

            while (dtst.next()) {
                res[0] = dtst.getDouble(1);
                res[1] = dtst.getDouble(2);
            }
            return res;
        } catch (SQLException ex) {
            return res;
        }
    }

    public static double get_LtstExchRate(int fromCurrID, int toCurrID, String asAtDte) {
        try {
            int fnccurid = Global.getOrgFuncCurID(Global.UsrsOrg_ID);
            //this.curCode = Global.getPssblValNm(this.curid);
            if (fromCurrID == toCurrID) {
                return 1;
            }
            String strSql = "SELECT CASE WHEN a.currency_from_id=" + fromCurrID
                    + " THEN a.multiply_from_by ELSE (1/a.multiply_from_by) END "
                    + "FROM accb.accb_exchange_rates a WHERE((a.currency_from_id =" + fromCurrID
                    + " and a.currency_to_id=" + toCurrID
                    + ") or (a.currency_to_id=" + fromCurrID
                    + " and a.currency_from_id=" + toCurrID
                    + ")) and to_timestamp(a.conversion_date,'YYYY-MM-DD') <= to_timestamp('" + asAtDte
                    + "','DD-Mon-YYYY HH24:MI:SS') ORDER BY to_timestamp(a.conversion_date,'YYYY-MM-DD') DESC LIMIT 1 OFFSET 0";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getDouble(1);
            }

            if (fromCurrID != fnccurid && toCurrID != fnccurid) {
                double a = Global.get_LtstExchRate(fromCurrID, fnccurid, asAtDte);
                double b = Global.get_LtstExchRate(toCurrID, fnccurid, asAtDte);
                if (a != 0 && b != 0) {
                    return a / b;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } catch (SQLException ex) {
            return 1;
        }
    }

    public static void createPymntGLLine(int accntid, String trnsdesc, double dbtamnt,
            String trnsdte, int crncyid, long batchid, double crdtamnt, double netamnt,
            String srcids, String dateStr,
            double entrdAmt, int entrdCurrID, double acntAmnt, int acntCurrID,
            double funcExchRate, double acntExchRate, String dbtOrCrdt) {
        try {
            if (accntid <= 0) {
                return;
            }
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trnsdte = frmtr1.format(frmtr.parse(trnsdte));
            dateStr = frmtr1.format(frmtr.parse(dateStr));

            String insSQL = "INSERT INTO accb.accb_trnsctn_details("
                    + "accnt_id, transaction_desc, dbt_amount, trnsctn_date, "
                    + "func_cur_id, created_by, creation_date, batch_id, crdt_amount, "
                    + "last_update_by, last_update_date, net_amount, trns_status, source_trns_ids, "
                    + "entered_amnt, entered_amt_crncy_id, accnt_crncy_amnt, accnt_crncy_id, "
                    + "func_cur_exchng_rate, accnt_cur_exchng_rate, dbt_or_crdt) "
                    + "VALUES (" + accntid + ", '" + trnsdesc.replace("'", "''") + "', " + dbtamnt
                    + ", '" + trnsdte.replace("'", "''") + "', " + crncyid + ", " + Global.rnUser_ID
                    + ", '" + dateStr + "', " + batchid + ", " + crdtamnt + ", "
                    + Global.rnUser_ID + ", '" + dateStr + "', " + netamnt
                    + ", '0', '" + srcids + "', " + entrdAmt
                    + ", " + entrdCurrID + ", " + acntAmnt
                    + ", " + acntCurrID + ", " + funcExchRate
                    + ", " + acntExchRate + ", '" + dbtOrCrdt + "')";
            Global.insertDataNoParams(insSQL);
        } catch (ParseException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updtGLIntrfcLnSpclOrg(int orgID, String tblNme, String btchPrfx) {
        //Used to update batch ids of interface lines that have gone to GL already
        String dateStr = Global.getDB_Date_time();
        String updtSQL = "UPDATE " + tblNme + " a "
                + "SET gl_batch_id = (select f.batch_id from accb.accb_trnsctn_details f, accb.accb_chart_of_accnts h "
                + "where f.batch_id IN (select g.batch_id from accb.accb_trnsctn_batches g "
                + "where g.batch_name ilike '%" + btchPrfx.replace(" ", "%") + "%' and "
                + "to_timestamp(g.creation_date,'YYYY-MM-DD HH24:MI:SS') between "
                + "(to_timestamp(a.trnsctn_date,'YYYY-MM-DD HH24:MI:SS') - interval '6 months') "
                + "and (to_timestamp(a.trnsctn_date,'YYYY-MM-DD HH24:MI:SS') + interval '6 months')) and "
                + "f.source_trns_ids like '%,' || a.interface_id || ',%' and "
                + "f.trnsctn_date=a.trnsctn_date and f.accnt_id= a.accnt_id and f.accnt_id= h.accnt_id and h.org_id = " + orgID + ")"
                + ", last_update_by=" + Global.rnUser_ID + ", "
                + "last_update_date='" + dateStr + "' "
                + "WHERE a.gl_batch_id = -1 and EXISTS(select 1 from accb.accb_chart_of_accnts"
                + " m where a.accnt_id= m.accnt_id and m.org_id =" + orgID + ")";
        Global.updateDataNoParams(updtSQL);
    }

    public static void updtPymntAllGLIntrfcLnOrg(long glbatchid, int orgID, String tblNme) {
        String dateStr = Global.getDB_Date_time();
        String updtSQL = "UPDATE " + tblNme + " a "
                + "SET gl_batch_id = " + glbatchid
                + ", last_update_by=" + Global.rnUser_ID + ", "
                + "last_update_date='" + dateStr + "' "
                + "WHERE a.gl_batch_id = -1 and EXISTS(select f.transctn_id "
                + "from accb.accb_trnsctn_details f, accb.accb_chart_of_accnts g "
                + "where f.batch_id = " + glbatchid + " "
                + "and f.source_trns_ids like '%,' || a.interface_id || ',%' and "
                + "f.trnsctn_date=a.trnsctn_date and f.accnt_id= a.accnt_id and f.accnt_id= g.accnt_id and g.org_id = " + orgID + ") ";
        Global.updateDataNoParams(updtSQL);
    }

    public static void updtTodaysGLBatchPstngAvlblty(long batchid, String avlblty) {
        String dateStr = Global.getDB_Date_time();
        String insSQL = "UPDATE accb.accb_trnsctn_batches SET avlbl_for_postng='" + avlblty
                + "', last_update_by=" + Global.rnUser_ID
                + ", last_update_date='" + dateStr
                + "' WHERE batch_id = " + batchid;
        Global.updateDataNoParams(insSQL);
    }

    public static void createRate(String rate_dte, String curFrom,
            int curFrmID, String curTo, int curToID, double scalefactor) {
        try {
            SimpleDateFormat frmtr = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat frmtr1 = new SimpleDateFormat("yyyy-MM-dd");
            rate_dte = frmtr1.format(frmtr.parse(rate_dte));

            String dateStr = Global.getDB_Date_time();
            String insSQL = "INSERT INTO accb.accb_exchange_rates("
                    + "conversion_date, currency_from, currency_from_id, currency_to, "
                    + "currency_to_id, multiply_from_by, created_by, creation_date, "
                    + "last_update_by, last_update_date) "
                    + "VALUES ('" + rate_dte.replace("'", "''")
                    + "', '" + curFrom.replace("'", "''")
                    + "', " + curFrmID
                    + ", '" + curTo.replace("'", "''")
                    + "', " + curToID
                    + ", " + scalefactor
                    + ", " + Global.rnUser_ID + ", '" + dateStr
                    + "', " + Global.rnUser_ID + ", '" + dateStr
                    + "')";
            Global.insertDataNoParams(insSQL);
        } catch (ParseException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updtRate(long rateID, String rate_dte, String curFrom,
            int curFrmID, String curTo, int curToID, double scalefactor) {

        String dateStr = Global.getDB_Date_time();
        String insSQL = "UPDATE accb.accb_exchange_rates SET "
                + "conversion_date ='" + rate_dte.replace("'", " ''")
                + "', currency_from='" + curFrom.replace("'", "''")
                + "', currency_from_id=" + curFrmID
                + ", last_update_by=" + Global.rnUser_ID + ", last_update_date='" + dateStr
                + "', currency_to='" + curTo.replace("'", "''")
                + "', currency_to_id=" + curToID
                + ", multiply_from_by = " + scalefactor
                + " WHERE rate_id = " + rateID;
        Global.updateDataNoParams(insSQL);
    }

    public static void updtRateValue(long rateID, double scalefactor) {
        //Global.Extra_Adt_Trl_Info = "";
        String dateStr = Global.getDB_Date_time();
        String insSQL = "UPDATE accb.accb_exchange_rates SET "
                + "last_update_by =" + Global.rnUser_ID
                + ", last_update_date='" + dateStr
                + "', multiply_from_by = " + scalefactor
                + " WHERE rate_id = " + rateID;
        Global.updateDataNoParams(insSQL);
    }

    public static ResultSet get_Currencies(String funcCurCode) {
        String strSql = "SELECT pssbl_value_id, pssbl_value, pssbl_value_desc, is_enabled"
                + ", allowed_org_ids FROM gst.gen_stp_lov_values WHERE pssbl_value != '"
                + funcCurCode.replace("'", "''") + "' and is_enabled='1' and value_list_id=" + Global.getLovID("Currencies");

        ResultSet dtst = Global.selectDataNoParams(strSql);
        return dtst;
    }

    public static int getPssblValID(String pssblVal, int lovID) {
        try {
            String sqlStr = "SELECT pssbl_value_id from gst.gen_stp_lov_values "
                    + "where ((pssbl_value = '"
                    + pssblVal.replace("'", "''") + "') AND (value_list_id = " + lovID + ")) ORDER BY pssbl_value_id LIMIT 1";
            ResultSet dtst = Global.selectDataNoParams(sqlStr);
            //this.showSQLNoPermsn(sqlStr);
            while (dtst.next()) {
                return dtst.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static long doesRateExst(String rateDte, String fromCur, String toCur) {
        try {
            //   rateDte = DateTime.ParseExact(rateDte, "dd-MMM-yyyy",
            //System.Globalization.CultureInfo.InvariantCulture).ToString("yyyy-MM-dd");
            String strSql = "SELECT rate_id "
                    + "FROM accb.accb_exchange_rates WHERE currency_from='" + fromCur.replace("'", "''")
                    + "' and currency_to='" + toCur.replace("'", "''")
                    + "' and conversion_date='" + rateDte.replace("'", "''")
                    + "'";
            ResultSet dtst = Global.selectDataNoParams(strSql);
            while (dtst.next()) {
                return dtst.getLong(1);
            }
            return -1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static void exprtDtStToCSV(ResultSet dtst, String csvfileNm,
            boolean isfirst, boolean islast, boolean shdAppnd, String rptdlmtr) {
        try {
            if (isfirst) {

            }
            dtst.last();
            int totl = dtst.getRow();
            dtst.beforeFirst();
            ResultSetMetaData dtstmd = dtst.getMetaData();
            String hdrNms = "";
            String lineVals = "";
            String dlmtr = "";
            if (isfirst) {

            }
            /*None
             Comma (,)
             Semi-Colon(;)
             Pipe(|)
             Tab
             Tilde(~)*/
            if (rptdlmtr.equals("None") || rptdlmtr.equals("Pipe(|)")) {
                dlmtr = "|";
            } else if (rptdlmtr.equals("Comma (,)")) {
                dlmtr = ",";
            } else if (rptdlmtr.equals("Semi-Colon(;)")) {
                dlmtr = ";";
            } else if (rptdlmtr.equals("Tab")) {
                dlmtr = "\t";
            } else if (rptdlmtr.equals("Tilde(~)")) {
                dlmtr = "~";
            } else {
                dlmtr = "|";
            }

            int collen = 0;
            int colcnt = dtstmd.getColumnCount();
            for (int a = 0; a < colcnt; a++) {
                collen = dtstmd.getColumnName(a + 1).length();
                if (collen >= 3) {
                    hdrNms += dtstmd.getColumnName(a + 1) + dlmtr;
                }
            }

            if (hdrNms.length() > 0) {
                Global.strSB.append(hdrNms.substring(0, hdrNms.length() - 1)).append(System.getProperty("line.separator"));
            }
            //Global.strSB.append(hdrNms);
            for (int i = 0; i < totl; i++) {
                dtst.next();
                lineVals = "";
                for (int a = 0; a < colcnt; a++) {
                    collen = dtstmd.getColumnName(a + 1).length();
                    if (collen >= 3) {
                        lineVals += dtst.getString(a + 1) + dlmtr;
                    }
                }
                if (lineVals.length() > 0) {
                    Global.strSB.append(lineVals.substring(0, lineVals.length() - 1)).append(System.getProperty("line.separator"));
                }
            }
            if (islast) {
                File file = new File(csvfileNm);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(Global.strSB.toString());
                bw.close();
                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/" + String.valueOf(Global.runID) + ".csv");
                }
            }
        } catch (SQLException ex) {
        } catch (IOException ex) {
        }
    }

    public static void exprtToHTMLTblr(
            ResultSet dtst, String fileNm, String rptTitle, String[] colsToGrp, String[] colsToCnt,
            String[] colsToSum, String[] colsToAvrg, String[] colsToFrmt, boolean isfirst, boolean islast, boolean shdAppnd) {
        try {
            System.out.println(fileNm);
            DecimalFormat myFormatter = new DecimalFormat("###,##0.00");
            DecimalFormat myFormatter2 = new DecimalFormat("###,##0");
            dtst.last();
            int totlRows = dtst.getRow();
            dtst.beforeFirst();
            ResultSetMetaData dtstmd = dtst.getMetaData();
            int colCnt = dtstmd.getColumnCount();
            long totlLen = 0;
            for (int d = 0; d < colCnt; d++) {
                totlLen += dtstmd.getColumnName(d + 1).length();
            }
            long[] colcntVals = new long[colCnt];
            double[] colsumVals = new double[colCnt];
            double[] colavrgVals = new double[colCnt];
            String cption = "";
            if (isfirst) {
                cption = "<caption align=\"top\">" + rptTitle + "</caption>";
                Global.strSB.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
                        + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"[]><html xmlns=\"http://www.w3.org/1999/xhtml\" dir=\"ltr\" lang=\"en-US\" xml:lang=\"en\"><head><meta http-equiv=\"Content-Type\" "
                        + "content=\"text/html; charset=utf-8\">" + System.getProperty("line.separator") + "<title>" + rptTitle + "</title>" + System.getProperty("line.separator")
                        + "<link rel=\"stylesheet\" href=\"../amcharts/rpt.css\" type=\"text/css\"></head><body>");

                Files.copy(new File(Global.getOrgImgsDrctry() + "/" + String.valueOf(Global.UsrsOrg_ID) + ".png").toPath(),
                        new File(Global.getRptDrctry() + "/amcharts_2100/images/" + String.valueOf(Global.UsrsOrg_ID) + ".png").toPath(),
                        StandardCopyOption.REPLACE_EXISTING);

                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/amcharts_2100/images/" + String.valueOf(Global.UsrsOrg_ID) + ".png");
                }
                //Org Name
                String orgNm = Global.getOrgName(Global.UsrsOrg_ID);
                String pstl = Global.getOrgPstlAddrs(Global.UsrsOrg_ID);
                //Contacts Nos
                String cntcts = Global.getOrgContactNos(Global.UsrsOrg_ID);
                //Email Address
                String email = Global.getOrgEmailAddrs(Global.UsrsOrg_ID);

                Global.strSB.append("<p><img src=\"../images/" + String.valueOf(Global.UsrsOrg_ID) + ".png\">"
                        + orgNm + "<br/>" + pstl + "<br/>" + cntcts + "<br/>" + email + "<br/>" + "</p>").append(System.getProperty("line.separator"));
            }

            Global.strSB.append("<table style=\"margin-top:5px;\">" + cption + "<thead>").append(System.getProperty("line.separator"));

            int wdth = 0;
            String finalStr = " ";
            for (int d = 0; d < colCnt; d++) {
                String algn = "left";
                int colLen = dtstmd.getColumnName(d + 1).length();
                wdth = (int) Math.round(((double) colLen / (double) totlLen) * 100);
                if (colLen >= 3) {
                    if (Global.mustColBeFrmtd(String.valueOf(d), colsToFrmt) == true) {
                        algn = "right";
                        finalStr = StringUtils.leftPad(dtstmd.getColumnName(d + 1).trim(), colLen, ' ');
                    } else {
                        finalStr = dtstmd.getColumnName(d + 1).trim() + " ";
                    }
                    Global.strSB.append("<th align=\"" + algn + "\" width=\"" + wdth
                            + "%\">" + finalStr.replace(" ", "&nbsp;") + "</th>").append(System.getProperty("line.separator"));
                }
            }

            Global.strSB.append("</thead><tbody>").append(System.getProperty("line.separator"));

            String[][] prevRowVal = new String[totlRows][colCnt];
            dtst.beforeFirst();
            System.out.println(Global.strSB.toString());
            for (int a = 0; a < totlRows; a++) {
                dtst.next();
                Global.strSB.append("<tr>").append(System.getProperty("line.separator"));
                for (int d = 0; d < colCnt; d++) {
                    String algn = "left";
                    double nwval = 0;
                    boolean mstgrp = Global.mustColBeGrpd(String.valueOf(d), colsToGrp);
                    if (Global.mustColBeCntd(String.valueOf(d), colsToCnt) == true) {
                        if ((a > 0) && (mstgrp == true)) {
                            if ((prevRowVal[a - 1][d].equals(dtst.getString(d + 1)))) {

                            } else {
                                colcntVals[d] += 1;
                            }
                        } else {
                            colcntVals[d] += 1;
                        }
                    } else if (Global.mustColBeSumd(String.valueOf(d), colsToSum) == true) {
                        nwval = Double.parseDouble(dtst.getString(d + 1));
                        if ((a > 0) && (mstgrp == true)) {
                            if ((prevRowVal[a - 1][d].equals(dtst.getString(d + 1)))) {

                            } else {
                                colsumVals[d] += nwval;
                            }
                        } else {
                            colsumVals[d] += nwval;
                        }
                    } else if (Global.mustColBeAvrgd(String.valueOf(d), colsToAvrg) == true) {
                        nwval = Double.parseDouble(dtst.getString(d + 1));
                        if ((a > 0) && (mstgrp == true)) {
                            if (prevRowVal[a - 1][d].equals(dtst.getString(d + 1))) {

                            } else {
                                colcntVals[d] += 1;
                                colsumVals[d] += nwval;
                            }
                        } else {
                            colcntVals[d] += 1;
                            colsumVals[d] += nwval;
                        }
                    }

                    int colLen = dtstmd.getColumnName(d + 1).length();
                    if (colLen >= 3) {
                        if ((a > 0) && (Global.mustColBeGrpd(String.valueOf(d), colsToGrp) == true)) {
                            if (prevRowVal[a - 1][d].equals(dtst.getString(d + 1))) {
                                wdth = (int) Math.round(((double) colLen / (double) totlLen) * 100);
                                Global.strSB.append("<td align=\"" + algn + "\"  width=\"" + wdth + "%\">" + " ".replace(" ", "&nbsp;") + "</td>").append(System.getProperty("line.separator"));
                            } else {
                                wdth = (int) Math.round(((double) colLen / (double) totlLen) * 100);
                                String frsh = " ";
                                if (Global.mustColBeFrmtd(String.valueOf(d), colsToFrmt) == true) {
                                    algn = "right";
                                    double num = Double.parseDouble(dtst.getString(d + 1).trim());
                                    if (!dtst.getString(d + 1).equals("")) {
                                        frsh = myFormatter.format(num);//.Trim().PadRight(60, ' ')
                                    } else {
                                        frsh = dtst.getString(d + 1) + " ";
                                    }
                                } else {
                                    frsh = dtst.getString(d + 1) + " ";
                                }
                                Global.strSB.append("<td align=\"" + algn + "\" width=\"" + wdth + "%\">" + Global.breakTxtDownHTML(frsh,
                                        dtstmd.getColumnName(d + 1).length()).replace(" ", "&nbsp;") + "</td>").append(System.getProperty("line.separator"));//.replace(" ", "&nbsp;")
                            }
                        } else {
                            wdth = (int) Math.round(((double) colLen / (double) totlLen) * 100);
                            String frsh = " ";
                            if (Global.mustColBeFrmtd(String.valueOf(d), colsToFrmt) == true) {
                                algn = "right";
                                double num = Double.parseDouble(dtst.getString(d + 1).trim());
                                if (!dtst.getString(d + 1).equals("")) {
                                    frsh = myFormatter.format(num);//.Trim().PadRight(60, ' ')
                                } else {
                                    frsh = dtst.getString(d + 1) + " ";
                                }
                            } else {
                                frsh = dtst.getString(d + 1) + " ";
                            }
                            Global.strSB.append("<td align=\"" + algn + "\" width=\"" + wdth + "%\">" + Global.breakTxtDownHTML(frsh,
                                    dtstmd.getColumnName(d + 1).length()).replace(" ", "&nbsp;") + "</td>").append(System.getProperty("line.separator"));//.replace(" ", "&nbsp;")
                        }
                    }
                }
                Global.strSB.append("</tr>").append(System.getProperty("line.separator"));
            }
            //Populate Counts/Sums/Averages
            Global.strSB.append("<tr>").append(System.getProperty("line.separator"));

            for (int f = 0; f < colCnt; f++) {
                String algn = "left";
                int colLen = dtstmd.getColumnName(f + 1).length();
                finalStr = " ";
                if (colLen >= 3) {
                    if (Global.mustColBeCntd(String.valueOf(f), colsToCnt) == true) {
                        if (Global.mustColBeFrmtd(String.valueOf(f), colsToFrmt) == true) {
                            algn = "right";
                            finalStr = ("Count = " + myFormatter2.format(colcntVals[f]));
                        } else {
                            finalStr = ("Count = " + String.valueOf(colcntVals[f]));
                        }
                    } else if (Global.mustColBeSumd(String.valueOf(f), colsToSum) == true) {
                        if (Global.mustColBeFrmtd(String.valueOf(f), colsToFrmt) == true) {
                            algn = "right";
                            finalStr = ("Sum = " + myFormatter.format(colsumVals[f]));
                        } else {
                            finalStr = ("Sum = " + String.valueOf(colcntVals[f]));
                        }
                    } else if (Global.mustColBeAvrgd(String.valueOf(f), colsToAvrg) == true) {
                        if (Global.mustColBeFrmtd(String.valueOf(f), colsToFrmt) == true) {
                            algn = "right";
                            finalStr = ("Average = " + myFormatter.format(colsumVals[f] / colcntVals[f]));
                        } else {
                            finalStr = ("Average = " + String.valueOf(colsumVals[f] / colcntVals[f]));
                        }
                    } else {
                        finalStr = " ";
                    }
                    Global.strSB.append("<td align=\"" + algn + "\" width=\"" + wdth + "%\">" + Global.breakTxtDownHTML(finalStr,
                            dtstmd.getColumnName(f + 1).length()).replace(" ", "&nbsp;") + "</td>").append(System.getProperty("line.separator"));//.replace(" ", "&nbsp;")
                }
            }
            Global.strSB.append("</tr>").append(System.getProperty("line.separator"));
            Global.strSB.append("</tbody></table>").append(System.getProperty("line.separator"));
            if (islast) {
                Global.strSB.append("</body></html>");

                File file = new File(fileNm);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(Global.strSB.toString());
                bw.close();

                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/amcharts_2100/samples/" + String.valueOf(Global.runID) + ".html");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n\r\n");
            Global.errorLog += ex.getMessage() + "\r\n\r\n" + Arrays.toString(ex.getStackTrace()) + "\r\n\r\n";
            Global.writeToLog();
        }
    }

    public static void exprtToHTMLDet(ResultSet recsdtst, ResultSet grpsdtst, String fileNm, String rptTitle, boolean isfirst, boolean islast, boolean shdAppnd, String orntnUsd, String imgCols) {
        try {
            imgCols = "," + StringUtils.strip(imgCols, ",") + ",";
            String cption = "";
            if (isfirst) {
                cption = "<caption align=\"top\">" + rptTitle + "</caption>";
                Global.strSB.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
                        + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"[]><html xmlns=\"http://www.w3.org/1999/xhtml\" dir=\"ltr\" lang=\"en-US\" xml:lang=\"en\"><head><meta http-equiv=\"Content-Type\" "
                        + "content=\"text/html; charset=utf-8\">" + System.getProperty("line.separator") + "<title>" + rptTitle + "</title>" + System.getProperty("line.separator")
                        + "<link rel=\"stylesheet\" href=\"../amcharts/rpt.css\" type=\"text/css\"></head><body>");

                Files.copy(new File(Global.getOrgImgsDrctry() + "/" + String.valueOf(Global.UsrsOrg_ID) + ".png").toPath(),
                        new File(Global.getRptDrctry() + "/amcharts_2100/images/" + String.valueOf(Global.UsrsOrg_ID) + ".png").toPath(),
                        StandardCopyOption.REPLACE_EXISTING);

                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/amcharts_2100/images/" + String.valueOf(Global.UsrsOrg_ID) + ".png");
                }
                //Org Name
                String orgNm = Global.getOrgName(Global.UsrsOrg_ID);
                String pstl = Global.getOrgPstlAddrs(Global.UsrsOrg_ID);
                //Contacts Nos
                String cntcts = Global.getOrgContactNos(Global.UsrsOrg_ID);
                //Email Address
                String email = Global.getOrgEmailAddrs(Global.UsrsOrg_ID);
                Global.strSB.append("<p><img src=\"../images/" + String.valueOf(Global.UsrsOrg_ID) + ".png\">"
                        + orgNm + "<br/>" + pstl + "<br/>" + cntcts + "<br/>" + email + "<br/>" + "</p>").append(System.getProperty("line.separator"));
            }

            int fullPgWdthVal = 800;
            if (orntnUsd.equals("Portrait")) {
                fullPgWdthVal = 700;
            }

            int wdth = 0;
            String finalStr = " ";
            String algn = "left";
            String[] rptGrpVals = {"Group Title", "Group Page Width Type", "Group Min-Height",
                "Show Group Border", "Group Display Type", "No of Vertical Divs In Group",
                "Comma Separated Col Nos", "Data Label Max Width%",
                "Comma Separated Hdr Nms", "Column Delimiter", "Row Delimiter"};

            String grpTitle = "";
            String grpPgWdth = "";
            int grpMinHght = 0;
            String shwBrdr = "Show";
            String grpDsplyTyp = "Details";
            int grpColDvsns = 4;//Use 1 for Images others 2 or 4
            String colnums = "";
            String lblmaxwdthprcnt = "35";
            String tblrHdrs = "";
            String clmDlmtrs = "";
            String rwDlmtrs = "";

            int divwdth = 0;

            /* 1. For each detail group create a div and fieldset with legend & border based on group settings
             * 2a. if detail display then create required no of td in tr1 of a table, create new tr if no of columns is not exhausted
             *      i.e if no of vertical divs=4 no rows=math.ceil(no cols*0.5)/
             *      else no rows=no cols
             *      for each col display label and data if vrtcl divs is 2 or 4 else display only data
             * 2b. if tabular create table with headers according to defined headers
             *      split data according to rows and cols and display them in this table
             * 2. Get all column nos within the group and create their labels and data using settings
             * 3. if col nos is image then use full defined page width else create no of defined columns count
             * 4. if 
             * 
             */
            grpsdtst.last();
            recsdtst.last();
            int grpdtcnt = grpsdtst.getRow();
            int rowsdtcnt = recsdtst.getRow();
            grpsdtst.beforeFirst();
            recsdtst.beforeFirst();
            ResultSetMetaData recsdtstmd = recsdtst.getMetaData();
            ResultSetMetaData grpsdtstmd = grpsdtst.getMetaData();

            for (int a = 0; a < rowsdtcnt; a++) {
                recsdtst.next();
                Global.strSB.append("<table style=\"margin-top:5px;min-width:" + String.valueOf(fullPgWdthVal + 50) + "px;\">" + cption + "<tbody>").append(System.getProperty("line.separator"));
                Global.strSB.append("<tr><td>").append(System.getProperty("line.separator"));
                for (int d = 0; d < grpdtcnt; d++) {
                    grpsdtst.next();
                    wdth = 35;
                    grpTitle = grpsdtst.getString(1);
                    grpPgWdth = grpsdtst.getString(2);
                    grpMinHght = Integer.parseInt(grpsdtst.getString(3));
                    shwBrdr = grpsdtst.getString(4);
                    grpDsplyTyp = grpsdtst.getString(5);
                    grpColDvsns = Integer.parseInt(grpsdtst.getString(6));//Use 1 for Images others 2 or 4
                    colnums = grpsdtst.getString(7);
                    lblmaxwdthprcnt = grpsdtst.getString(8);
                    tblrHdrs = grpsdtst.getString(9);
                    clmDlmtrs = grpsdtst.getString(10);
                    rwDlmtrs = grpsdtst.getString(11);
                    wdth = Integer.parseInt(lblmaxwdthprcnt);

                    if (grpPgWdth.equals("Half Page Width")) {
                        divwdth = (int) (fullPgWdthVal / 2);
                    } else {
                        divwdth = (int) (fullPgWdthVal / 1);
                    }

                    Global.strSB.append("<div style=\"float:left;min-width:" + String.valueOf(divwdth - 50) + "px;padding:10px;\">").append(System.getProperty("line.separator"));//min-height:" + (grpMinHght + 20).ToString() + "px;
                    if (shwBrdr.equals("Show")) {
                        Global.strSB.append("<fieldset style=\"min-width:" + String.valueOf(divwdth - 80) + "px;\">").append(System.getProperty("line.separator"));//min-height:" + (grpMinHght).ToString() + "px;
                        Global.strSB.append("<legend>" + grpTitle + "</legend>").append(System.getProperty("line.separator"));
                    }
                    String w = "\\,";
                    String[] colNumbers = colnums.split(w);
                    int noofRws = 1;
                    wdth = ((divwdth - 90) * wdth) / 100;
                    if (grpDsplyTyp.equals("DETAIL")) {
                        if (grpColDvsns == 4) {
                            noofRws = (int) Math.ceil((double) colNumbers.length / (double) 2);
                        } else {
                            noofRws = colNumbers.length;
                        }
                        Global.strSB.append("<table style=\"min-width:" + String.valueOf(divwdth - 90) + "px;margin-top:5px;border:none;\" border=\"0\"><tbody>").append(System.getProperty("line.separator"));
                        if (grpColDvsns == 4) {
                            for (int h = 0; h < colNumbers.length; h++) {
                                if ((h % 2) == 0) {
                                    Global.strSB.append("<tr>").append(System.getProperty("line.separator"));
                                }
                                int clnm = -1;
                                clnm = Integer.parseInt(colNumbers[h]);
                                if (clnm >= 0) {
                                    String frsh = "";
                                    Global.strSB.append("<td style=\"border-bottom:none;border-left:none;font-weight:bolder;\" align=\"" + algn + "\" width=\"" + wdth + "px\">").append(System.getProperty("line.separator"));
                                    frsh = recsdtstmd.getColumnName(clnm + 1).trim() + ": ";
                                    Global.strSB.append(Global.breakTxtDownHTML(frsh, (wdth / 7)).replace(" ", "&nbsp;"));
                                    Global.strSB.append("</td>").append(System.getProperty("line.separator"));

                                    Global.strSB.append("<td style=\"border-bottom:none;border-left:none;\" align=\"" + algn + "\" width=\"" + (divwdth - 90 - wdth) + "px\">").append(System.getProperty("line.separator"));
                                    if (imgCols.contains("," + clnm + ",")) {
                                        frsh = recsdtst.getString(clnm + 1).trim();
                                        File file = new File(Global.dataBasDir + frsh);
                                        // if file doesnt exists, then create it
                                        if (!file.exists()) {
                                            String extnsn = FilenameUtils.getExtension(Global.dataBasDir + frsh);

                                            Files.copy(new File(Global.dataBasDir + frsh).toPath(),
                                                    new File(Global.getRptDrctry() + "/amcharts_2100/images/" + String.valueOf(Global.runID) + "_" + String.valueOf(a) + String.valueOf(clnm) + extnsn).toPath(),
                                                    StandardCopyOption.REPLACE_EXISTING);

                                            Global.strSB.append("<p><img src=\"../images/" + String.valueOf(Global.runID) + "_" + String.valueOf(a) + String.valueOf(clnm) + extnsn + "\" style=\"width:auto;height::" + grpMinHght + "px;\">" + "</p>").append(System.getProperty("line.separator"));
                                        }
                                    } else {
                                        frsh = recsdtst.getString(clnm + 1).trim() + " ";
                                        Global.strSB.append(Global.breakTxtDownHTML(frsh,
                                                ((divwdth - 90 - wdth) / 7)).replace(" ", "&nbsp;"));
                                    }
                                    Global.strSB.append("</td>").append(System.getProperty("line.separator"));
                                }

                                if ((h % 2) == 1) {
                                    Global.strSB.append("</tr>").append(System.getProperty("line.separator"));
                                }

                            }

                        } else if (grpColDvsns == 2) {
                            for (int h = 0; h < colNumbers.length; h++) {
                                Global.strSB.append("<tr>").append(System.getProperty("line.separator"));
                                int clnm = -1;
                                clnm = Integer.parseInt(colNumbers[h]);
                                if (clnm >= 0) {
                                    String frsh = "";
                                    Global.strSB.append("<td style=\"border-bottom:none;border-left:none;font-weight:bold;\" align=\"" + algn + "\" width=\"" + wdth + "px\">").append(System.getProperty("line.separator"));
                                    frsh = recsdtstmd.getColumnName(clnm + 1).trim() + ": ";
                                    Global.strSB.append(Global.breakTxtDownHTML(frsh,
                                            ((wdth) / 7)).replace(" ", "&nbsp;"));
                                    Global.strSB.append("</td>").append(System.getProperty("line.separator"));

                                    Global.strSB.append("<td style=\"border-bottom:none;border-left:none;\" align=\"" + algn + "\" width=\"" + (divwdth - 90 - wdth) + "px\">").append(System.getProperty("line.separator"));
                                    if (imgCols.contains("," + clnm + ",")) {
                                        frsh = recsdtst.getString(clnm + 1).trim();
                                        File file = new File(Global.dataBasDir + frsh);
                                        // if file doesnt exists, then create it
                                        if (!file.exists()) {
                                            String extnsn = FilenameUtils.getExtension(Global.dataBasDir + frsh);

                                            Files.copy(new File(Global.dataBasDir + frsh).toPath(),
                                                    new File(Global.getRptDrctry() + "/amcharts_2100/images/" + String.valueOf(Global.runID) + "_" + String.valueOf(a) + String.valueOf(clnm) + extnsn).toPath(),
                                                    StandardCopyOption.REPLACE_EXISTING);

                                            Global.strSB.append("<p><img src=\"../images/" + String.valueOf(Global.runID) + "_" + String.valueOf(a) + String.valueOf(clnm) + extnsn + "\" style=\"width:auto;height:" + grpMinHght + "px;\">" + "</p>").append(System.getProperty("line.separator"));
                                        }
                                    } else {
                                        frsh = recsdtst.getString(clnm + 1).trim() + " ";
                                        Global.strSB.append(Global.breakTxtDownHTML(frsh,
                                                ((divwdth - 90 - wdth) / 7)).replace(" ", "&nbsp;"));
                                    }
                                    Global.strSB.append("</td>");
                                }
                                Global.strSB.append("</tr>");
                            }
                        } else if (grpColDvsns == 1) {
                            for (int h = 0; h < colNumbers.length; h++) {
                                Global.strSB.append("<tr>");
                                int clnm = -1;
                                clnm = Integer.parseInt(colNumbers[h]);
                                if (clnm >= 0) {
                                    String frsh = "";
                                    Global.strSB.append("<td style=\"border-bottom:none;border-left:none;\" align=\"" + algn + "\" width=\"" + (divwdth - 90) + "px\">").append(System.getProperty("line.separator"));
                                    if (imgCols.contains("," + clnm + ",")) {
                                        frsh = recsdtst.getString(clnm + 1).trim();
                                        File file = new File(Global.dataBasDir + frsh);
                                        // if file doesnt exists, then create it
                                        if (!file.exists()) {
                                            String extnsn = FilenameUtils.getExtension(Global.dataBasDir + frsh);

                                            Files.copy(new File(Global.dataBasDir + frsh).toPath(),
                                                    new File(Global.getRptDrctry() + "/amcharts_2100/images/" + String.valueOf(Global.runID) + "_" + String.valueOf(a) + String.valueOf(clnm) + extnsn).toPath(),
                                                    StandardCopyOption.REPLACE_EXISTING);

                                            Global.strSB.append("<p><img src=\"../images/" + String.valueOf(Global.runID) + "_" + String.valueOf(a) + String.valueOf(clnm) + extnsn + "\" style=\"width:auto;height:" + grpMinHght + "px;\">" + "</p>").append(System.getProperty("line.separator"));
                                        }
                                    } else {
                                        frsh = recsdtst.getString(clnm + 1).trim() + " ";
                                        Global.strSB.append(Global.breakTxtDownHTML(frsh,
                                                ((divwdth - 90) / 7)).replace(" ", "&nbsp;"));
                                    }
                                    Global.strSB.append("</td>");
                                }
                                Global.strSB.append("</tr>");

                            }
                        }

                        Global.strSB.append("</tbody></table>");

                    } else {
                    }
                    if (shwBrdr.equals("Show")) {
                        Global.strSB.append("</fieldset>");
                    }

                    Global.strSB.append("</div>");
                }
                Global.strSB.append("</td></tr>");
                Global.strSB.append("</tbody></table><br/><br/>").append(System.getProperty("line.separator"));
            }

            if (islast) {
                Global.strSB.append("</body></html>");

                File file = new File(fileNm);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(Global.strSB.toString());
                bw.close();
                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/amcharts_2100/samples/" + String.valueOf(Global.runID) + ".html");
                }
            }
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (NumberFormatException ex) {
        }
    }

    public static void exprtToHTMLSCC(ResultSet dtst, String fileNm,
            String rptTitle, String[] colsToGrp, String[] colsToUse, boolean isfirst, boolean islast, boolean shdAppnd) {
        try {
            //Simple Column Chart
            dtst.last();
            int totlRows = dtst.getRow();
            dtst.beforeFirst();
            ResultSetMetaData dtstmd = dtst.getMetaData();
            int colCnt = dtstmd.getColumnCount();

            String cption = "";
            if (isfirst) {
                cption = "<caption align=\"top\">" + rptTitle + "</caption>";
                Global.strSB.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
                        + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"[]><html xmlns=\"http://www.w3.org/1999/xhtml\" dir=\"ltr\" lang=\"en-US\" xml:lang=\"en\"><head><meta http-equiv=\"Content-Type\" "
                        + "content=\"text/html; charset=utf-8\">" + System.getProperty("line.separator") + "<title>" + rptTitle + "</title>" + System.getProperty("line.separator"));
                Global.strSB.append("<link rel=\"stylesheet\" href=\"../amcharts/rpt.css\" type=\"text/css\">" + System.getProperty("line.separator"));
                Global.strSB.append("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">" + System.getProperty("line.separator"));
                Global.strSB.append("<script src=\"../amcharts/amcharts.js\" type=\"text/javascript\"></script>" + System.getProperty("line.separator"));
                Global.strSB.append("</head><body>");

                Files.copy(new File(Global.getOrgImgsDrctry() + "/" + String.valueOf(Global.UsrsOrg_ID) + ".png").toPath(),
                        new File(Global.getRptDrctry() + "/amcharts_2100/images/" + String.valueOf(Global.UsrsOrg_ID) + ".png").toPath(),
                        StandardCopyOption.REPLACE_EXISTING);

                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/amcharts_2100/images/" + String.valueOf(Global.UsrsOrg_ID) + ".png");
                }

                //Org Name
                String orgNm = Global.getOrgName(Global.UsrsOrg_ID);
                String pstl = Global.getOrgPstlAddrs(Global.UsrsOrg_ID);
                //Contacts Nos
                String cntcts = Global.getOrgContactNos(Global.UsrsOrg_ID);
                //Email Address
                String email = Global.getOrgEmailAddrs(Global.UsrsOrg_ID);

                Global.strSB.append("<p><img src=\"../images/" + String.valueOf(Global.UsrsOrg_ID) + ".png\">"
                        + orgNm + "<br/>" + pstl + "<br/>" + cntcts + "<br/>" + email + "<br/>" + "</p>");
            }

            Global.strSB.append("<script type = \"text / javascript\"> " + System.getProperty("line.separator")
                    + "var chart;" + System.getProperty("line.separator")
                    + "var chartData = [");

            for (int a = 0; a < totlRows; a++) {
                dtst.next();
                if (a < totlRows - 1) {
                    Global.strSB.append("{"
                            + "ctgry:\"" + dtst.getString(Integer.parseInt(colsToUse[0]) + 1) + "\","
                            + "vals:" + dtst.getString(Integer.parseInt(colsToUse[1]) + 1) + ", color: \"#0D52D1\"},")
                            .append(System.getProperty("line.separator"));
                } else {
                    Global.strSB.append("{"
                            + "ctgry:\"" + dtst.getString(Integer.parseInt(colsToUse[0]) + 1) + "\","
                            + "vals:" + dtst.getString(Integer.parseInt(colsToUse[1]) + 1) + ", color:\"#0D52D1\"}];")
                            .append(System.getProperty("line.separator"));
                }
            }
            Global.strSB.append("AmCharts.ready(function () {" + System.getProperty("line.separator")
                    + "// SERIAL CHART " + System.getProperty("line.separator")
                    + "chart = new AmCharts.AmSerialChart(); " + System.getProperty("line.separator")
                    + "chart.dataProvider = chartData; " + System.getProperty("line.separator")
                    + "chart.categoryField = \"ctgry\"; " + System.getProperty("line.separator")
                    + "chart.depth3D = 0; " + System.getProperty("line.separator")
                    + "chart.angle = 0; " + System.getProperty("line.separator")
                    + "//chart.startDuration = 1;" + System.getProperty("line.separator")
                    + "// AXES " + System.getProperty("line.separator")
                    + "// category " + System.getProperty("line.separator")
                    + "var categoryAxis = chart.categoryAxis; " + System.getProperty("line.separator")
                    + "categoryAxis.labelRotation = 90; " + System.getProperty("line.separator")
                    + "categoryAxis.title = \"" + dtstmd.getColumnName(Integer.parseInt(colsToUse[0]) + 1) + "\"; " + System.getProperty("line.separator")
                    + "categoryAxis.gridPosition = \"start\";" + System.getProperty("line.separator")
                    + "// value" + System.getProperty("line.separator")
                    + "// in case you don't want to change default settings of value axis," + System.getProperty("line.separator")
                    + "// you don't need to create it, as one value axis is created automatically. " + System.getProperty("line.separator")
                    + "var valueAxis = new AmCharts.ValueAxis(); " + System.getProperty("line.separator")
                    + "valueAxis.title = \"" + dtstmd.getColumnName(Integer.parseInt(colsToUse[1]) + 1) + "\"; " + System.getProperty("line.separator")
                    + "valueAxis.dashLength = 5; " + System.getProperty("line.separator")
                    + "chart.addValueAxis(valueAxis);" + System.getProperty("line.separator")
                    + " // GRAPH " + System.getProperty("line.separator")
                    + "var graph = new AmCharts.AmGraph(); " + System.getProperty("line.separator")
                    + "graph.valueField = \"vals\"; " + System.getProperty("line.separator")
                    + "graph.colorField = \"color\"; " + System.getProperty("line.separator")
                    + "graph.balloonText = \"[[category]]: [[value]]\"; " + System.getProperty("line.separator")
                    + "graph.type = \"column\"; " + System.getProperty("line.separator")
                    + "graph.lineAlpha = 0; " + System.getProperty("line.separator")
                    + "graph.fillAlphas = 1; " + System.getProperty("line.separator")
                    + "chart.addGraph(graph);" + System.getProperty("line.separator")
                    + "chart.write(\"chartdiv\");" + System.getProperty("line.separator")
                    + "});" + System.getProperty("line.separator")
                    + " </script>" + System.getProperty("line.separator"));

            Global.strSB.append("<h2>" + rptTitle + "</h2>").append(System.getProperty("line.separator"));
            Global.strSB.append("<div id=\"chartdiv\" style=\"width: " + colsToGrp[0] + "px; height: " + colsToGrp[1] + "px;\"></div>");
            if (islast) {
                Global.strSB.append("</body></html>");

                File file = new File(fileNm);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(Global.strSB.length());
                bw.close();

                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/amcharts_2100/samples/" + String.valueOf(Global.runID) + ".html");
                }
            }
        } catch (SQLException ex) {
        } catch (IOException ex) {
        } catch (NumberFormatException ex) {
        }
    }

    public static void exprtToHTMLPC(ResultSet dtst, String fileNm,
            String rptTitle, String[] colsToGrp, String[] colsToUse, boolean isfirst, boolean islast, boolean shdAppnd) {
        //Pie Chart
        //int colCnt = dtst.Tables[0].Columns.Count;
        //for (int p = 0; p < colsToGrp.length; p++)
        //{
        //  Global.errorLog = "colsToGrp[" + p + "] = " + colsToGrp[p];
        //}
        //for (int p = 0; p < colsToUse.length; p++)
        //{
        //  Global.errorLog = "colsToUse[" + p + "] = " + colsToUse[p];
        //}
        //Global.writeToLog();
        try {
            dtst.last();
            int totlRows = dtst.getRow();
            dtst.beforeFirst();
            ResultSetMetaData dtstmd = dtst.getMetaData();
            int colCnt = dtstmd.getColumnCount();
            String cption = "";
            if (isfirst) {
                cption = "<caption align=\"top\">" + rptTitle + "</caption>";
                Global.strSB.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
                        + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"[]><html xmlns=\"http://www.w3.org/1999/xhtml\" dir=\"ltr\" lang=\"en-US\" xml:lang=\"en\"><head><meta http-equiv=\"Content-Type\" "
                        + "content=\"text/html; charset=utf-8\"><title>" + rptTitle + "</title>")
                        .append(System.getProperty("line.separator"))
                        .append("<link rel=\"stylesheet\" href=\"../amcharts/rpt.css\" type=\"text/css\">")
                        .append(System.getProperty("line.separator"));

                Global.strSB.append("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">")
                        .append(System.getProperty("line.separator"))
                        .append("<script src = \"../amcharts / amcharts.js\" type = \"text / javascript\"></script > ")
                        .append(System.getProperty("line.separator"));

                Global.strSB.append("</head><body>")
                        .append(System.getProperty("line.separator"));

                Files.copy(new File(Global.getOrgImgsDrctry() + "/" + String.valueOf(Global.UsrsOrg_ID) + ".png").toPath(),
                        new File(Global.getRptDrctry() + "/amcharts_2100/images/" + String.valueOf(Global.UsrsOrg_ID) + ".png").toPath(),
                        StandardCopyOption.REPLACE_EXISTING);

                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/amcharts_2100/images/" + String.valueOf(Global.UsrsOrg_ID) + ".png");
                }

                //Org Name
                String orgNm = Global.getOrgName(Global.UsrsOrg_ID);
                String pstl = Global.getOrgPstlAddrs(Global.UsrsOrg_ID);
                //Contacts Nos
                String cntcts = Global.getOrgContactNos(Global.UsrsOrg_ID);
                //Email Address
                String email = Global.getOrgEmailAddrs(Global.UsrsOrg_ID);

                Global.strSB.append("<p><img src=\"../images/" + String.valueOf(Global.UsrsOrg_ID) + ".png\">"
                        + orgNm + "<br/>" + pstl + "<br/>" + cntcts + "<br/>" + email + "<br/>" + "</p>")
                        .append(System.getProperty("line.separator"));
            }
            Global.strSB.append("<script type=\"text/javascript\">")
                    .append(System.getProperty("line.separator"))
                    .append("var chart;")
                    .append(System.getProperty("line.separator"))
                    .append("var chartData = [");

            for (int a = 0; a < totlRows; a++) {
                dtst.next();
                if (a < totlRows - 1) {
                    Global.strSB.append("{ctgry:\"" + dtst.getString(Integer.parseInt(colsToUse[0]) + 1) + "\", "
                            + "vals:" + dtst.getString(Integer.parseInt(colsToUse[1]) + 1) + "},")
                            .append(System.getProperty("line.separator"));
                } else {
                    Global.strSB.append("{ctgry:\"" + dtst.getString(Integer.parseInt(colsToUse[0]) + 1) + "\", "
                            + "vals:" + dtst.getString(Integer.parseInt(colsToUse[1]) + 1) + "}];")
                            .append(System.getProperty("line.separator"));
                }
            }

            Global.strSB.append("AmCharts.ready(function () {")
                    .append(System.getProperty("line.separator"))
                    .append("// PIE CHART")
                    .append(System.getProperty("line.separator"))
                    .append("chart = new AmCharts.AmPieChart();")
                    .append(System.getProperty("line.separator"))
                    .append("chart.dataProvider = chartData;")
                    .append(System.getProperty("line.separator"))
                    .append("chart.titleField = \"ctgry\";")
                    .append(System.getProperty("line.separator"))
                    .append("chart.valueField = \"vals\";")
                    .append(System.getProperty("line.separator"))
                    .append("chart.outlineColor = \"#FFFFFF\";")
                    .append(System.getProperty("line.separator"))
                    .append("chart.outlineAlpha = 0.8;")
                    .append(System.getProperty("line.separator"))
                    .append("chart.outlineThickness = 2;")
                    .append(System.getProperty("line.separator"))
                    .append("// this makes the chart 3D")
                    .append(System.getProperty("line.separator"))
                    .append("chart.depth3D = 15;")
                    .append(System.getProperty("line.separator"))
                    .append("chart.angle = 30;")
                    .append(System.getProperty("line.separator"))
                    .append("chart.write(\"chartdiv\");")
                    .append(System.getProperty("line.separator"))
                    .append("});")
                    .append(System.getProperty("line.separator"))
                    .append("</script>")
                    .append(System.getProperty("line.separator"));

            Global.strSB.append("<h2>" + rptTitle + "</h2>")
                    .append(System.getProperty("line.separator"));
            Global.strSB.append("<div id=\"chartdiv\" style=\"width: " + colsToGrp[0]
                    + "px; height: " + colsToGrp[1] + "px;\"></div>")
                    .append(System.getProperty("line.separator"));
            if (islast) {
                Global.strSB.append("</body></html>");

                File file = new File(fileNm);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(Global.strSB.toString());
                bw.close();

                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/amcharts_2100/samples/" + String.valueOf(Global.runID) + ".html");
                }
            }
        } catch (SQLException ex) {
        } catch (IOException ex) {
        } catch (NumberFormatException ex) {
        }
    }

    public static void exprtToHTMLLC(ResultSet dtst, String fileNm,
            String rptTitle, String[] colsToGrp, String[] colsToUse, boolean isfirst, boolean islast, boolean shdAppnd) {
        try {
            //Line Chart
            dtst.last();
            int totlRows = dtst.getRow();
            dtst.beforeFirst();
            ResultSetMetaData dtstmd = dtst.getMetaData();
            //int colCnt = dtstmd.getColumnCount();
            int colCnt = colsToUse.length;

            String cption = "";
            if (isfirst) {
                cption = "<caption align=\"top\">" + rptTitle + "</caption>";
                Global.strSB.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
                        + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"[]><html xmlns=\"http://www.w3.org/1999/xhtml\" dir=\"ltr\" lang=\"en-US\" xml:lang=\"en\"><head><meta http-equiv=\"Content-Type\" "
                        + "content=\"text/html; charset=utf-8\"><title>" + rptTitle + "</title>")
                        .append(System.getProperty("line.separator"))
                        .append("<link rel=\"stylesheet\" href=\"../amcharts/rpt.css\" type=\"text/css\">")
                        .append(System.getProperty("line.separator"));
                Global.strSB.append("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">")
                        .append(System.getProperty("line.separator"))
                        .append("<script src = \"../amcharts / amcharts.js\" type = \"text / javascript\">")
                        .append(System.getProperty("line.separator"))
                        .append("</script>")
                        .append(System.getProperty("line.separator"));
                Global.strSB.append("</head><body>")
                        .append(System.getProperty("line.separator"));

                Files.copy(new File(Global.getOrgImgsDrctry() + "/" + String.valueOf(Global.UsrsOrg_ID) + ".png").toPath(),
                        new File(Global.getRptDrctry() + "/amcharts_2100/images/" + String.valueOf(Global.UsrsOrg_ID) + ".png").toPath(),
                        StandardCopyOption.REPLACE_EXISTING);

                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/amcharts_2100/images/" + String.valueOf(Global.UsrsOrg_ID) + ".png");
                }
                //Org Name
                String orgNm = Global.getOrgName(Global.UsrsOrg_ID);
                String pstl = Global.getOrgPstlAddrs(Global.UsrsOrg_ID);
                //Contacts Nos
                String cntcts = Global.getOrgContactNos(Global.UsrsOrg_ID);
                //Email Address
                String email = Global.getOrgEmailAddrs(Global.UsrsOrg_ID);

                Global.strSB.append("<p><img src=\"../images/" + String.valueOf(Global.UsrsOrg_ID) + ".png\">"
                        + orgNm + "<br/>" + pstl + "<br/>" + cntcts + "<br/>" + email + "<br/>" + "</p>")
                        .append(System.getProperty("line.separator"));
            }
            Global.strSB.append("<script type=\"text/javascript\">")
                    .append(System.getProperty("line.separator"))
                    .append("var chart;")
                    .append(System.getProperty("line.separator"))
                    .append("var chartData = [")
                    .append(System.getProperty("line.separator"));

            for (int a = 0; a < totlRows; a++) {
                dtst.next();
                if (a < totlRows - 1) {
                    Global.strSB.append("{"
                            + "ctgry:\"" + dtst.getString(Integer.parseInt(colsToUse[0]) + 1) + "\", "
                            + "value: " + dtst.getString(Integer.parseInt(colsToUse[1]) + 1) + "},")
                            .append(System.getProperty("line.separator"));
                } else {
                    Global.strSB.append("{"
                            + "ctgry:\"" + dtst.getString(Integer.parseInt(colsToUse[0]) + 1) + "\", "
                            + "value:" + dtst.getString(Integer.parseInt(colsToUse[1]) + 1) + "}];")
                            .append(System.getProperty("line.separator"));
                }
            }

            Global.strSB.append("AmCharts.ready(function () {")
                    .append(System.getProperty("line.separator"))
                    .append("// SERIAL CHART")
                    .append(System.getProperty("line.separator"))
                    .append("chart = new AmCharts.AmSerialChart();")
                    .append(System.getProperty("line.separator"))
                    .append("chart.pathToImages = \"../amcharts/images/\";")
                    .append(System.getProperty("line.separator"))
                    .append("chart.dataProvider = chartData;")
                    .append(System.getProperty("line.separator"))
                    .append("chart.marginLeft = 10;")
                    .append(System.getProperty("line.separator"))
                    .append("chart.categoryField = \"ctgry\";")
                    .append(System.getProperty("line.separator"))
                    .append("chart.zoomOutButton = {")
                    .append(System.getProperty("line.separator"))
                    .append("backgroundColor: '#000000',")
                    .append("backgroundAlpha: 0.15};")
                    .append(System.getProperty("line.separator"))
                    .append("// listen for dataUpdated event (fired when chart is inited) and call zoomChart method when it happens")
                    .append(System.getProperty("line.separator"))
                    .append("chart.addListener(\"dataUpdated\", zoomChart);")
                    .append(System.getProperty("line.separator"))
                    .append("// AXES")
                    .append(System.getProperty("line.separator"))
                    .append("// category")
                    .append(System.getProperty("line.separator"))
                    .append("var categoryAxis = chart.categoryAxis;")
                    .append(System.getProperty("line.separator"))
                    .append("//categoryAxis.parseDates = true; // as our data is date-based, we set parseDates to true")
                    .append(System.getProperty("line.separator"))
                    .append("//categoryAxis.minPeriod = DD; // our data is ctgryly, so we set minPeriod to YYYY")
                    .append(System.getProperty("line.separator"))
                    .append("categoryAxis.title = \"" + dtstmd.getColumnName(Integer.parseInt(colsToUse[0]) + 1) + "\";")
                    .append(System.getProperty("line.separator"))
                    .append("categoryAxis.gridAlpha = 0.5;")
                    .append(System.getProperty("line.separator"))
                    .append("categoryAxis.labelRotation = 90;")
                    .append(System.getProperty("line.separator"))
                    .append("// value")
                    .append(System.getProperty("line.separator"))
                    .append("var valueAxis = new AmCharts.ValueAxis();")
                    .append(System.getProperty("line.separator"))
                    .append("valueAxis.axisAlpha = 0.5;")
                    .append(System.getProperty("line.separator"))
                    .append("valueAxis.title = \"" + dtstmd.getColumnName(Integer.parseInt(colsToUse[1]) + 1) + "\";")
                    .append(System.getProperty("line.separator"))
                    .append("valueAxis.inside = true;")
                    .append(System.getProperty("line.separator"))
                    .append("chart.addValueAxis(valueAxis);")
                    .append(System.getProperty("line.separator"))
                    .append("// GRAPH ")
                    .append(System.getProperty("line.separator"))
                    .append("graph = new AmCharts.AmGraph();")
                    .append(System.getProperty("line.separator"))
                    .append("graph.type = \"line\"; // this line makes the graph smoothed line.")
                    .append(System.getProperty("line.separator"))
                    .append("graph.lineColor = \"#0000FF\";")
                    .append(System.getProperty("line.separator"))
                    .append("graph.negativeLineColor = \"#637bb6\"; // this line makes the graph to change color when it drops below 0")
                    .append(System.getProperty("line.separator"))
                    .append("graph.bullet = \"round\";")
                    .append(System.getProperty("line.separator"))
                    .append("graph.bulletSize = 5;")
                    .append("graph.lineThickness = 1;")
                    .append(System.getProperty("line.separator"))
                    .append("graph.valueField = \"value\";")
                    .append(System.getProperty("line.separator"))
                    .append("chart.addGraph(graph);")
                    .append(System.getProperty("line.separator"))
                    .append("// CURSOR ")
                    .append(System.getProperty("line.separator"))
                    .append("var chartCursor = new AmCharts.ChartCursor();")
                    .append(System.getProperty("line.separator"))
                    .append("chartCursor.cursorAlpha = 0;")
                    .append(System.getProperty("line.separator"))
                    .append("chartCursor.cursorPosition = \"mouse\";")
                    .append(System.getProperty("line.separator"))
                    .append("//chartCursor.categoryBalloonDateFormat = \"YYYY\";")
                    .append(System.getProperty("line.separator"))
                    .append("chart.addChartCursor(chartCursor);")
                    .append(System.getProperty("line.separator"))
                    .append("// SCROLLBAR ")
                    .append(System.getProperty("line.separator"))
                    .append("var chartScrollbar = new AmCharts.ChartScrollbar();")
                    .append(System.getProperty("line.separator"))
                    .append("chartScrollbar.graph = graph;")
                    .append(System.getProperty("line.separator"))
                    .append("chartScrollbar.backgroundColor = \"#DDDDDD\";")
                    .append(System.getProperty("line.separator"))
                    .append("chartScrollbar.scrollbarHeight = 15;")
                    .append(System.getProperty("line.separator"))
                    .append("chartScrollbar.selectedBackgroundColor = \"#FFFFFF\";")
                    .append(System.getProperty("line.separator"))
                    .append("chart.addChartScrollbar(chartScrollbar);")
                    .append(System.getProperty("line.separator"))
                    .append("// WRITE")
                    .append(System.getProperty("line.separator"))
                    .append("chart.write(\"chartdiv\");")
                    .append(System.getProperty("line.separator"))
                    .append("});")
                    .append(System.getProperty("line.separator"))
                    .append("// this method is called when chart is first inited as we listen for \"dataUpdated\" event")
                    .append(System.getProperty("line.separator"))
                    .append("function zoomChart() {")
                    .append(System.getProperty("line.separator"))
                    .append("// different zoom methods can be used - zoomToIndexes, zoomToDates, zoomToCategoryValues")
                    .append(System.getProperty("line.separator"))
                    .append("//chart.zoomToDates(new Date(1972, 0), new Date(1984, 0));")
                    .append(System.getProperty("line.separator"))
                    .append("chart.zoomToIndexes(0,100);")
                    .append(System.getProperty("line.separator"))
                    .append("}")
                    .append(System.getProperty("line.separator"))
                    .append("</script>")
                    .append(System.getProperty("line.separator"));
            Global.strSB.append("<h2>" + rptTitle + "</h2>").append(System.getProperty("line.separator"));
            Global.strSB.append("<div id=\"chartdiv\" style=\"width: " + colsToGrp[0] + "px; height: " + colsToGrp[1] + "px;\"></div>").append(System.getProperty("line.separator"));
            if (islast) {
                Global.strSB.append("</body></html>");

                File file = new File(fileNm);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(Global.strSB.toString());
                bw.close();

                if (Global.callngAppType.equals("DESKTOP")) {
                    Global.upldImgsFTP(9, Global.getRptDrctry(), "/amcharts_2100/samples/" + String.valueOf(Global.runID) + ".html");
                }
            }
        } catch (SQLException ex) {
        } catch (IOException ex) {
        } catch (NumberFormatException ex) {
        }
    }

}
