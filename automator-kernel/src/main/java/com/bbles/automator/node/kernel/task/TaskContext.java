package com.bbles.automator.node.kernel.task;

import com.bbles.automator.node.protobuf.GeneralProtocol;
import com.bbles.automator.node.utils.AutomatorUtils;

import java.util.Date;

public class TaskContext {
    private Date startDate;
    private Date endDate;
    private boolean isScheduled;
    private boolean retryInError;
    private int maxRetry;

    public String getStartDateTime() {
        return startDate.toString();
    }

    public String getEndDateTime() {
        return endDate.toString();

    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public boolean getRetryInError() {
        return retryInError;
    }

    public int getMaxRetry() {
        return maxRetry;
    }

    public TaskContext(Date startDate, Date endDate, boolean isScheduled, boolean retryInError, int maxRetry) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isScheduled = isScheduled;
        this.retryInError = retryInError;
        this.maxRetry = maxRetry;
    }

    private TaskContext(String startDate, String endDate, boolean isScheduled, boolean retryInError, int maxRetry) {
        this.startDate = AutomatorUtils.parseStringDate(startDate);
        this.endDate = AutomatorUtils.parseStringDate(endDate);
        this.isScheduled = isScheduled;
        this.retryInError = retryInError;
        this.maxRetry = maxRetry;
    }

    public static TaskContext fromProtobuf(GeneralProtocol.TaskContext ctx) {
        return new TaskContext(ctx.getStartDate(), ctx.getEndDate(), ctx.getIsScheduled(), ctx.getRetryInError(), ctx.getMaxRetry());
    }

    public static GeneralProtocol.TaskContext toProtobuf(TaskContext ctx) {
        return GeneralProtocol.TaskContext.newBuilder()
                .setStartDate(ctx.getStartDateTime())
                .setEndDate(ctx.getEndDateTime())
                .setIsScheduled(ctx.isScheduled())
                .setMaxRetry(ctx.getMaxRetry())
                .setRetryInError(ctx.getRetryInError())
                .build();
    }
}
