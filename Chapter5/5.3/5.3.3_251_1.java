@TableName(keepGlobalPrefix=true, value="gaea_report_dashboard_widget")
@Data
public class ReportDashboardWidget extends GaeaBaseEntity {
    @ApiModelProperty(value = "报表编码")
    private String reportCode;

    @ApiModelProperty(value = "组件类型参考字典DASHBOARD_PANEL_TYPE")
    private String type;

    @ApiModelProperty(value = "组件的渲染属性json")
    private String setup;

    @ApiModelProperty(value = "组件的数据属性json")
    private String data;

    @ApiModelProperty(value = "组件的配置属性json")
    private String collapse;

    @ApiModelProperty(value = "组件的大小位置属性json")
    private String position;

    private String options;

    @ApiModelProperty(value = "自动刷新间隔秒")
    private Integer refreshSeconds;

    @ApiModelProperty(value = "0--已禁用1--已启用  DIC_NAME=ENABLE_FLAG")
    private Integer enableFlag;

    @ApiModelProperty(value = " 0--未删除1--已删除DIC_NAME=DEL_FLAG")
    private Integer deleteFlag;

    @ApiModelProperty(value = "排序，图层的概念")
    private Long sort;

}
