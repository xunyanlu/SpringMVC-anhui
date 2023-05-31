package cn.edu.guet.bean;





public class PlanDesignInfo {
    private Long id;
    private String plan_bill_no;//规划工单编号
    private String plan_design_name;//规划设计名称
    private String design_company;//设计单位
    private String spec_id;//业务类型
    private String project_director;//项目总负责人
    private String spec_leader;//专业负责人
    private String designer;//设计人
    private String reviewer;//校审人

    public String getPlan_bill_no() {
        return plan_bill_no;
    }

    public void setPlan_bill_no(String plan_bill_no) {
        this.plan_bill_no = plan_bill_no;
    }

    public String getPlan_design_name() {
        return plan_design_name;
    }

    public void setPlan_design_name(String plan_design_name) {
        this.plan_design_name = plan_design_name;
    }

    public String getDesign_company() {
        return design_company;
    }

    public void setDesign_company(String design_company) {
        this.design_company = design_company;
    }

    public String getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(String spec_id) {
        this.spec_id = spec_id;
    }

    public String getProject_director() {
        return project_director;
    }

    public void setProject_director(String project_director) {
        this.project_director = project_director;
    }

    public String getSpec_leader() {
        return spec_leader;
    }

    public void setSpec_leader(String spec_leader) {
        this.spec_leader = spec_leader;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PlanDesignInfo{" +
                "id=" + id +
                ", plan_bill_no='" + plan_bill_no + '\'' +
                ", plan_design_name='" + plan_design_name + '\'' +
                ", design_company='" + design_company + '\'' +
                ", spec_id='" + spec_id + '\'' +
                ", project_director='" + project_director + '\'' +
                ", spec_leader='" + spec_leader + '\'' +
                ", designer='" + designer + '\'' +
                ", reviewer='" + reviewer + '\'' +
                '}';
    }
}
