package com.andy.web_task.controller.command;

import javax.servlet.ServletException;
import java.io.IOException;

public class UnknownCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        request.setAttribute("description", "Unknown Command");
        forward("/view/error_response.jsp");
    }
}
