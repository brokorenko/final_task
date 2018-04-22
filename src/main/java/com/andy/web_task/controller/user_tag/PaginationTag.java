package com.andy.web_task.controller.user_tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class PaginationTag extends TagSupport {

    private int pageCount;
    private String command;
    private String type;

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        for (int i = 0; i < pageCount; i++) {
            try {
                //out.write("<div class=\"pagination\">");
                out.write("<a href=\"/FrontController?command=" + command);
                out.write("&currentPage=" + (i+1));

                if (type != null) {
                    out.write("&type=" + type);
                }

                out.write("\">" + (i+1) + "</a>");
                //out.write("</div>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SKIP_BODY;
    }
}

