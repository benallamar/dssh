package com.bbles.automator.node.kernel.task;

import java.time.Instant;
import java.util.Date;

public class TaskContextBuilder {
    private Date startDate = null;
    private Date endDate = null;
    private boolean isScheduled = false;
    private boolean retryInError = false;
    private int maxRetry = 0;

    public static TaskContextBuilder newBuild() {
        return new TaskContextBuilder();
    }

    public TaskContextBuilder withStartDate(String startDate) {
        this.startDate = Date.from(Instant.parse(startDate));
        return this;
    }

    public TaskContextBuilder withEndDate(String endDate) {
        this.endDate = Date.from(Instant.parse(endDate));
        return this;
    }

    public TaskContextBuilder isScheduled(boolean isScheduled) {
        this.isScheduled = isScheduled;
        return this;
    }

    public TaskContextBuilder retryInError(boolean retryInError) {
        this.retryInError = retryInError;
        return this;
    }

    public TaskContextBuilder withMaxRetry(int maxRetry) {
        if (retryInError) {
            this.maxRetry = maxRetry;
            return this;
        }
        /**
         * Should we keep it like this or not ?
         */
        throw new IllegalArgumentException("Please set retryInError to true before setting maxRetryValue");
    }

    public TaskContext build() {
        return new TaskContext(startDate, endDate, isScheduled, retryInError, maxRetry);
    }
}
