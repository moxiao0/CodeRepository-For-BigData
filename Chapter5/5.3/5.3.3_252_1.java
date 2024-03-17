@Data
public class ReportDashboardWidgetDto implements Serializable {

    /**
     * 组件类型参考字典DASHBOARD_PANEL_TYPE
     */
    private String type;

    /**
     * value
     */
    private ReportDashboardWidgetValueDto value;

    /**
     * options
     */
    private JSONObject options;

}
