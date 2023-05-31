package cn.edu.guet.controller;


import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.bean.PlanDesignRouteCable;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.PlanDesignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
public class PlanDesignController {

    private PlanDesignService planDesignService;
    private static Logger logger=LoggerFactory.getLogger(PlanDesignController.class);

    public void setPlanDesignService(PlanDesignService planDesignService) {
        this.planDesignService = planDesignService;
    }

    @RequestMapping("/selectRouteCableList")
    public ResponseData selectRouteCableList(){
        return planDesignService.selectRouteCableList();
    }
    @RequestMapping("/creatBill")
    public ResponseData creatBill(PlanDesignInfo planDesignInfo){
        logger.info("创建工单：{}",planDesignInfo);
        return planDesignService.creatBill(planDesignInfo);

    }

}
