package com.andy.web_task.controller.command;

public enum CompanyType {
    STO{public String SQL_REQUEST = "SELECT * FROM company WHERE company.id > ? AND company.id < ? AND type = STO";},
    autowash{public String SQL_REQUEST = "SELECT * FROM company WHERE company.id > ? AND company.id < ? AND type = autowash";},
    ALL{public String SQL_REQUEST = "SELECT * FROM company WHERE company.id > ? AND company.id < ?";},
    USER;

    public static String getSqlRequestByType(CompanyType type) {
        switch (type){
            case ALL:
                return "SELECT * FROM company LIMIT = ?, ?";
            case autowash:
                return "SELECT * FROM company WHERE type = autowash LIMIT = ?, ?";
            case STO:
                return "SELECT * FROM company WHERE type = STO LIMIT = ?, ?";
            case USER:
                return "SELECT * FROM company WHERE user_id = ? LIMIT = ?, ?";
        }
        return null;
    }
}
