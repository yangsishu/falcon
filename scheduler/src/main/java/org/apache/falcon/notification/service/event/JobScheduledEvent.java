/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.falcon.notification.service.event;

import org.apache.falcon.state.ID;
import org.joda.time.DateTime;

/**
 * An event generated by {@link org.apache.falcon.notification.service.impl.SchedulerService}
 * indicating if an instance was scheduled for execution.
 */
public class JobScheduledEvent extends Event {
    private final ID callbackID;
    private String externalID;
    private STATUS status;
    private DateTime startTime;

    public JobScheduledEvent(ID callbackID, STATUS status) {
        this.callbackID = callbackID;
        this.status = status;
        this.type = EventType.JOB_SCHEDULED;
    }

    public String getExternalID() {
        return externalID;
    }

    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    @Override
    public ID getTarget() {
        return callbackID;
    }

    /**
     * @return - The status of the scheduled DAG/Job.
     */
    public STATUS getStatus() {
        return status;
    }


    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Enumeration of possible statuses of a DAG/Job.
     */
    public enum STATUS {
        FAILED,
        SUCCESSFUL
    }
}
