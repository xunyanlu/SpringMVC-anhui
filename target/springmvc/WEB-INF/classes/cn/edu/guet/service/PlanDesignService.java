package cn.edu.guet.service;

import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.common.ResponseData;

public interface PlanDesignService  {


    ResponseData selectRouteCableList();

    ResponseData creatBill(PlanDesignInfo planDesignInfo);
}
