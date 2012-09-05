package view;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import commons.Commons;
import controller.DataController;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DataModel;
import model.DataRecord;

/**
 *
 * @author 221388
 */
@WebServlet(name = "convert", urlPatterns = {"/convert"})
public class convert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition",
                "attachment;filename=output.txt");
        PrintWriter out = response.getWriter();
        try {
            String inputDelimter = null;
            String outputDelimiter = null;
            ArrayList<DataModel> dataInputModel = new ArrayList<DataModel>();
            if (request.getParameter("isInDel") != null) {
                int isInputDel = Commons.toInt(request.getParameter("isInDel"));
                if (isInputDel == 1) {
                    inputDelimter = request.getParameter("inDelimter");
                } else {
                    int fieldsNumber = Commons.toInt(request.getParameter("inFldlen"));
                    for (int i = 0; i < fieldsNumber; i++) {
                        String fieldName = "inFldLenN_" + i;
                        int length = Commons.toInt(request.getParameter(fieldName));
                        DataModel dataModel = new DataModel();
                        dataModel.setLength(length);
                        dataInputModel.add(dataModel);
                    }
                }
                if (request.getParameter("outFldlen") != null) {
                    int outputFieldsNumber = Commons.toInt(request.getParameter("outFldlen"));
                    int isDelimited = Commons.toInt(request.getParameter("isOutDel"));
                    if (isDelimited == 1) {
                        outputDelimiter = request.getParameter("outDelimter");
                    }
                    ArrayList<DataModel> dataOutputModel = new ArrayList<DataModel>();
                    for (int i = 0; i < outputFieldsNumber; i++) {
                        String fieldName = "outFldLenN_" + i;
                        int length = Commons.toInt(request.getParameter(fieldName));
                        fieldName = "isHsOldFld_" + i;
                        int isOldOne = Commons.toInt(request.getParameter(fieldName));
                        int oldPosition = -1;
                        if (isOldOne == 1) {
                            fieldName = "outOldFld_" + i;
                            oldPosition = Commons.toInt(request.getParameter(fieldName));
                        }

                        DataModel dataModel = new DataModel();
                        dataModel.setLength(length);
                        //dataModel.setValue(defaultValue);
                        dataModel.setPosition(i + 1);
                        dataModel.setOldPostion(oldPosition);
                        //dataModel.setName(name);
                        dataOutputModel.add(dataModel);
                    }
                    DataRecord outputRecordDetails = new DataRecord(dataOutputModel);
                    DataRecord inputRecordDetails = new DataRecord(dataInputModel);
                    
                    FileInputStream fileInputStream=new  FileInputStream(new File("intput.txt"));
                    DataController controller = new DataController(inputDelimter, outputDelimiter, fileInputStream, inputRecordDetails, outputRecordDetails);
                    Scanner outputFile = new Scanner(new File(controller.getOutputBuffer()));
                    System.out.println(controller.getOutputBuffer());
                    while (outputFile.hasNextLine()) {
                        String sss=outputFile.nextLine();
                        out.println(sss);
                    }
                } else {
                    response.sendRedirect("upload.jsp");
                }
            } else {
                response.sendRedirect("upload.jsp");
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
