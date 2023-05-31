package cn.edu.guet.service.Impl;

import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.PlanDesignDao;
import cn.edu.guet.dao.RouteCableDao;
import cn.edu.guet.dao.impl.BaseDaoImpl;
import cn.edu.guet.service.PlanDesignService;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class PlanDesignServiceImpl implements PlanDesignService {

    private RouteCableDao routeCableDao;
    private PlanDesignDao planDesignDao;

    public void setPlanDesignDao(PlanDesignDao planDesignDao) {
        this.planDesignDao = planDesignDao;
    }

    public void setRouteCableDao(RouteCableDao routeCableDao) {
        this.routeCableDao = routeCableDao;
    }

    @Override
    public ResponseData selectRouteCableList() {

        return ResponseData.ok(routeCableDao.getObjectById());
    }

    @Override
    public ResponseData creatBill(PlanDesignInfo planDesignInfo) {
        try {
            int save =planDesignDao.save(planDesignInfo);
            if (save==1){
                return new ResponseData("工单创建成功！");
            }
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
       return ResponseData.fail("工单创建失败！");
    }


}
