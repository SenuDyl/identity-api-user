/*
 * Copyright (c) 2025, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.rest.api.user.push.v1.impl;

import org.wso2.carbon.identity.rest.api.user.push.v1.DiscoveryDataApiService;
import org.wso2.carbon.identity.rest.api.user.push.v1.core.PushDeviceManagementService;
import org.wso2.carbon.identity.rest.api.user.push.v1.factories.PushDeviceManagementServiceFactory;
import org.wso2.carbon.identity.rest.api.user.push.v1.model.DiscoveryDataDTO;

import javax.ws.rs.core.Response;

/**
 * Implementation class of Push device Handler User APIs.
 */
public class DiscoveryDataApiServiceImpl implements DiscoveryDataApiService {

    private final PushDeviceManagementService pushDeviceManagementService;

    public DiscoveryDataApiServiceImpl() {

        try {
            this.pushDeviceManagementService = PushDeviceManagementServiceFactory.getPushDeviceManagementService();
        } catch (IllegalStateException e) {
            throw new RuntimeException("Error occurred while initiating PushDeviceManagementService.", e);
        }
    }

    @Override
    public Response getRegistrationDiscoveryData() {

        DiscoveryDataDTO discoveryDataDTO = pushDeviceManagementService.getRegistrationDiscoveryData();
        return Response.ok().entity(discoveryDataDTO).build();
    }
}
